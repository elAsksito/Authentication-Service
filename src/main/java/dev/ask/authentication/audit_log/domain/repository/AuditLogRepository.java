package dev.ask.authentication.audit_log.domain.repository;

import dev.ask.authentication.audit_log.domain.model.AuditLog;
import reactor.core.publisher.Mono;

public interface AuditLogRepository {
    Mono<AuditLog> save(AuditLog auditLog);
}