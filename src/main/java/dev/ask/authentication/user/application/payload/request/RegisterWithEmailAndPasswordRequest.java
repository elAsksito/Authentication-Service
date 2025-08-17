package dev.ask.authentication.user.application.payload.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterWithEmailAndPasswordRequest {
    String email;
    String password;
}