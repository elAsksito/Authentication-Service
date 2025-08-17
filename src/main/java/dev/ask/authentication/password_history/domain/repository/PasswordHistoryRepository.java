package dev.ask.authentication.password_history.domain.repository;

import dev.ask.authentication.password_history.domain.model.PasswordHistory;
import reactor.core.publisher.Mono;

public interface PasswordHistoryRepository {
    Mono<PasswordHistory> save (PasswordHistory passwordHistory);
    Mono<Boolean> isPasswordUsed(String userId, String passwordHash);
}