package dev.ask.authentication.password_history.domain.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasswordHistory {
    private String id;
    private String userId;
    private String passwordHash;
    private Instant changedAt;
}