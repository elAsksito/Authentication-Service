package dev.ask.authentication.user.application.service.create;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.ask.authentication.user.application.vo.Email;
import dev.ask.authentication.user.application.vo.Password;
import dev.ask.authentication.user.domain.model.User;
import dev.ask.authentication.user.domain.repository.UserRepository;
import dev.ask.authentication.user.domain.service.create.CreateUserWithEmailAndPassword;
import dev.ask.authentication.utils.exceptions.auth_exceptions.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CreateUserWithEmailAndPasswordImpl implements CreateUserWithEmailAndPassword {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    
    @Override
    public Mono<User> createUserWithEmailAndPassword(String email, String password, String ipAddress, String userAgent) {
        Email userEmail = new Email(email);
        Password userPassword = new Password(password);

        return userRepository.findUserByEmail(email)
            .flatMap(existing -> Mono.<User>error(new UserAlreadyExistException()))
            .switchIfEmpty(Mono.defer(() -> {
                User user = User.builder()
                    .email(userEmail.value())
                    .phoneNumber("")
                    .password(passwordEncoder.encode(userPassword.value()))
                    .isEmailVerified(false)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .version(1)
                    .build();
                return userRepository.save(user);
            }));
    }
    
}