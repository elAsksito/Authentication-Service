package dev.ask.authentication.user.infrastructure.port.out.persistence.adapter;

import org.springframework.stereotype.Component;

import dev.ask.authentication.user.domain.model.User;
import dev.ask.authentication.user.domain.repository.UserRepository;
import dev.ask.authentication.user.infrastructure.port.out.persistence.document.UserDocument;
import dev.ask.authentication.user.infrastructure.port.out.persistence.mapper.UserMapper;
import dev.ask.authentication.user.infrastructure.port.out.persistence.repository.ReactiveUserMongoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final ReactiveUserMongoRepository repository;

    @Override
    public Mono<User> save(User user) {
        return repository.save(UserMapper.toDocument(user))
                .map(UserMapper::toDomain);
    }

    @Override
    public Mono<Boolean> existsUserByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Mono<Boolean> existsUserByPhoneNumber(String phoneNumber) {
        return repository.existsByPhoneNumber(phoneNumber);
    }

    @Override
    public Mono<User> findUserByEmail(String email) {
        return repository.findByEmail(email).map(UserMapper::toDomain);
    }

    @Override
    public Mono<User> findUserById(String userId) {
        return repository.findById(userId).map(UserMapper::toDomain);
    }

    @Override
    public Mono<User> findUserByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber).map(UserMapper::toDomain);
    }

    @Override
    public Mono<User> loginUserWithEmailAndPassword(String email, String password) {
        return findUserByEmail(email);
    }

    @Override
    public Mono<User> loginUserWithPhoneNumberAndPassword(String phoneNumber, String password) {
        return findUserByPhoneNumber(phoneNumber);
    }

    @Override
    public Mono<User> updateUserByUserId(String userId, User userDocument) {
        return repository.findById(userId)
                .flatMap(existing -> {
                    UserDocument updated = UserMapper.toDocument(userDocument);
                    updated.setId(existing.getId());
                    return repository.save(updated);
                })
                .map(UserMapper::toDomain);
    }
}