package dev.ask.authentication.user.domain.service.update;

import dev.ask.authentication.user.domain.model.User;
import reactor.core.publisher.Mono;

public interface UpdateUserByUserId {
    Mono<User> updateUserByUserId(String userId, User userDocument);
}