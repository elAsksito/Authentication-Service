package dev.ask.authentication.password_history.infrastructure.port.out.persistence.document;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "password_history")
public class PasswordHistoryDocument {
    @Id
    private String id;
    private String userId;
    private String passwordHash;
    private Instant changedAt;
}