package dev.ask.authentication.user.domain.service.read;

import dev.ask.authentication.user.domain.model.User;
import reactor.core.publisher.Mono;

public interface FindUserByPhoneNumber {
    Mono<User> findUserByPhoneNumber(String phoneNumber);
}