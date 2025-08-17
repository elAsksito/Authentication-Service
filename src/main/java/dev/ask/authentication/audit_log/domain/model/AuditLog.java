package dev.ask.authentication.audit_log.domain.model;

import java.time.Instant;
import java.util.Map;

import dev.ask.authentication.audit_log.domain.enums.Actions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditLog {
    private String id;
    private String userId;
    private Actions action;
    private Map<String, Object> metadata;
    private String ipAddress;
    private String userAgent;
    private Instant createdAt;
}