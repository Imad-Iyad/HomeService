package com.demo99.backend.config;

import com.demo99.backend.filters.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.boot.devtools.restart.Restarter.disable;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
            .csrf(csrf -> disable())  // ✅ السماح بالـ CORS
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth

                    // مسارات مفتوحة للجميع (تسجيل، تسجيل دخول، Swagger)
                    .requestMatchers(
                            "/api/auth/**",
                            "/swagger-ui/**",
                            "/v3/api-docs/**",
                            "/swagger-resources/**",
                            "/webjars/**"
                    ).permitAll()

                    // CUSTOMER فقط
                    .requestMatchers(
                            "/api/v1/appointments/book",
                            "/api/v1/appointments/by-customer/*",
                            "/api/v1/appointments/delete/*",
                            "/api/v1/availabilities/get-by-provider/",
                            "/api/v1/reviews/add",
                            "/api/v1/reviews/get/*",
                            "/api/v1/services/get-all",
                            "/api/v1/services/get/*"
                    ).hasAuthority("CUSTOMER")

                    // PROVIDER فقط
                    .requestMatchers(
                            "/api/v1/appointments/by-provider/*",
                            "/api/v1/appointments/update-status/*",
                            "/api/v1/availabilities/creat",
                            "/api/v1/availabilities/update/*",
                            "/api/v1/availabilities/delete/*",
                            "/api/v1/availabilities/get-by-provider/*",
                            "/api/v1/reviews/*",
                            "/api/v1/services/get-all",
                            "/api/v1/services/get/*"
                    ).hasAuthority("PROVIDER")

                    // ADMIN فقط
                    .requestMatchers(
                            "/api/v1/reviews/*",
                            "/api/v1/services/creat",
                            "/api/v1/services/get-all",
                            "/api/v1/services/get/*",
                            "/api/v1/services/update/*",
                            "/api/v1/services/delete/*",
                            "/api/v1/users/**"
                    ).hasAuthority("ADMIN")

                    // أي مسار آخر يتطلب تسجيل دخول
                    .anyRequest().authenticated()
            );
        http
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .userDetailsService(userDetailsService);

       return http.build();
    }



    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*")); // يمكنك تغيير "*" إلى رابط الـ frontend أو Swagger
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
