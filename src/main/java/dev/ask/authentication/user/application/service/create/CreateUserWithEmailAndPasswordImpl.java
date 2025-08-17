package dev.ask.authentication.user.application.service.create;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.ask.authentication.audit_log.domain.enums.Actions;
import dev.ask.authentication.audit_log.domain.model.AuditLog;
import dev.ask.authentication.audit_log.domain.service.create.CreateAuditLog;
import dev.ask.authentication.password_history.domain.service.create.CreatePasswordHistory;
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
    private final CreatePasswordHistory createPasswordHistory;
    private final CreateAuditLog createAuditLog;
    
    @Override
    public Mono<User> createUserWithEmailAndPassword(String email, String password, String ipAddress, String userAgent) {
        Email userEmail = new Email(email);
        Password userPassword = new Password(password);

        return userRepository.findUserByEmail(email)
            .flatMap(existing -> Mono.<User>error(new UserAlreadyExistException()))
            .switchIfEmpty(Mono.defer(() -> {
                String encodedPassword = passwordEncoder.encode(userPassword.value());
                User user = User.builder()
                    .email(userEmail.value())
                    .phoneNumber("")
                    .password(encodedPassword)
                    .isEmailVerified(false)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .version(1)
                    .build();
                return userRepository.save(user)
                    .flatMap(savedUser ->
                        createPasswordHistory.createPasswordHistory(savedUser.getId(), encodedPassword)
                            .then(createAuditLog.createAuditLog(
                                AuditLog.builder()
                                .userId(savedUser.getId())
                                .action(Actions.REGISTER_SUCCESS)
                                .metadata(Map.of(
                                    "email", userEmail.value(),
                                    "action", Actions.REGISTER_SUCCESS.toString(),
                                    "ipAddress", ipAddress,
                                    "userAgent", userAgent
                                ))
                                .build()
                            ))
                            .thenReturn(savedUser));
            }))
            .onErrorResume(ex ->
                createAuditLog.createAuditLog(AuditLog.builder()
                                .userId(null)
                                .action(Actions.REGISTER_FAILED)
                                .metadata(Map.of(
                                    "email", userEmail.value(),
                                    "action", Actions.REGISTER_FAILED.toString(),
                                    "ipAddress", ipAddress,
                                    "userAgent", userAgent
                                ))
                                .build()
                            ).then(Mono.error(ex))
                        );
    }
    
}