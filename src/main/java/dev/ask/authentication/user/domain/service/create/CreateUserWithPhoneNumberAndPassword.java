package dev.ask.authentication.user.domain.service.create;

import dev.ask.authentication.user.domain.model.User;
import reactor.core.publisher.Mono;

public interface CreateUserWithPhoneNumberAndPassword {
    Mono<User> createUserWithPhoneNumberAndPassword(String phoneNumber, String password);
}