package dev.ask.authentication.user.domain.service.create;

import dev.ask.authentication.user.domain.model.User;
import reactor.core.publisher.Mono;

public interface CreateUserWithEmailAndPassword {
    Mono<User> createUserWithEmailAndPassword(String email, String password, String ipAddress, String userAgent);
}