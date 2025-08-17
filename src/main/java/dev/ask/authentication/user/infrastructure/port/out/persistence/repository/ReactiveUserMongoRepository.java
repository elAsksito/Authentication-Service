package dev.ask.authentication.user.infrastructure.port.out.persistence.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.authentication.user.infrastructure.port.out.persistence.document.UserDocument;
import reactor.core.publisher.Mono;

public interface ReactiveUserMongoRepository extends ReactiveMongoRepository<UserDocument, String> {
    Mono<Boolean> existsByEmail(String email);
    Mono<Boolean> existsByPhoneNumber(String phoneNumber);
    Mono<UserDocument> findByEmail(String email);
    Mono<UserDocument> findByPhoneNumber(String phoneNumber);
}