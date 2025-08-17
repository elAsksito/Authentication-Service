package dev.ask.authentication.password_history.infrastructure.port.out.persistence.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.authentication.password_history.infrastructure.port.out.persistence.document.PasswordHistoryDocument;
import reactor.core.publisher.Mono;

public interface ReactivePasswordHistoryMongoRepository extends ReactiveMongoRepository<PasswordHistoryDocument, String> {
    Mono<Boolean> existsByUserIdAndPasswordHash(String userId, String passwordHash);
}