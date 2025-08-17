package dev.ask.authentication.user.infrastructure.port.in.api.router;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import dev.ask.authentication.user.infrastructure.port.in.api.handler.RegisterHandler;

@Configuration
public class RegisterRouter {

    @Bean
    RouterFunction<ServerResponse> registerRoutes(RegisterHandler handler) {
        return RouterFunctions.route()
                .POST("/api/v1/auth/register", handler::registerWithEmailAndPassword)
                .build();
    }
}
