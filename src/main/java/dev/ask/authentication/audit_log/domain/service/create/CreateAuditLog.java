package dev.ask.authentication.audit_log.domain.service.create;

import dev.ask.authentication.audit_log.domain.model.AuditLog;
import reactor.core.publisher.Mono;

public interface CreateAuditLog {
    Mono<AuditLog> createAuditLog(AuditLog auditLog);
}