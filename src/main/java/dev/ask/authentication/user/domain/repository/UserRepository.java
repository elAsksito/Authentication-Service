package dev.ask.authentication.user.domain.repository;

import dev.ask.authentication.user.domain.model.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> save(User user);
    Mono<Boolean> existsUserByEmail(String email);
    Mono<Boolean> existsUserByPhoneNumber(String phoneNumber);
    Mono<User> findUserByEmail(String email);
    Mono<User> findUserById(String userId);
    Mono<User> findUserByPhoneNumber(String phoneNumber);
    Mono<User> loginUserWithEmailAndPassword(String email, String password);
    Mono<User> loginUserWithPhoneNumberAndPassword(String phoneNumber, String password);
    Mono<User> updateUserByUserId(String userId, User userDocument);
}
