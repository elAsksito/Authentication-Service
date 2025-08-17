package dev.ask.authentication.audit_log.infrastructure.port.out.persistence.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ask.authentication.audit_log.infrastructure.port.out.persistence.document.AuditLogDocument;

public interface ReactiveAuditLogMongoRepository extends ReactiveMongoRepository<AuditLogDocument, String> {
}