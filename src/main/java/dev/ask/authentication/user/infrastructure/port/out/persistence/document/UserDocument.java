package dev.ask.authentication.user.infrastructure.port.out.persistence.document;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.ask.authentication.user.domain.enums.Status;
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
@Document(collection = "users")
public class UserDocument {
    @Id
    private String id;
    private String email;
    private String phoneNumber;
    private String password;
    private boolean isEmailVerified;
    private Status status;
    private int failedLoginAttempts;
    private LocalDateTime lockUntil;
    private boolean twoFaEnabled;
    private byte[] twoFaSecret;
    private LocalDateTime lastLogin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long version;
    private LocalDateTime passwordLastChanged;
    private boolean mustChangePassword;
    private List<String> roles;
}