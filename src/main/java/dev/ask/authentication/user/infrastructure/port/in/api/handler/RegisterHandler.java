package dev.ask.authentication.user.infrastructure.port.in.api.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import dev.ask.authentication.user.application.payload.request.RegisterWithEmailAndPasswordRequest;
import dev.ask.authentication.user.domain.service.create.CreateUserWithEmailAndPassword;
import dev.ask.authentication.user.infrastructure.port.in.api.utils.ExtractClientIp;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RegisterHandler {
    private final CreateUserWithEmailAndPassword createWithEmail;

    public Mono<ServerResponse> registerWithEmailAndPassword(ServerRequest request) {
        String ipAddress = ExtractClientIp.extractClientIp(request.exchange().getRequest());
        String userAgent = request.headers().firstHeader("User-Agent");

        return request.bodyToMono(RegisterWithEmailAndPasswordRequest.class)
                .flatMap(req -> 
                    createWithEmail.createUserWithEmailAndPassword(req.getEmail(), req.getPassword(), ipAddress, userAgent))
                .flatMap(user -> 
                    ServerResponse.ok().bodyValue("Registro exitoso"))
                .onErrorResume(e -> 
                    ServerResponse.badRequest().bodyValue(e.getMessage()));
    }
}