package com.demo99.backend.config;

import com.demo99.backend.filters.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
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
                                "/api/v1/appointments",                // POST
                                "/api/v1/appointments/*",              // GET / DELETE
                                "/api/v1/reviews",                     // POST
                                "/api/v1/reviews/*"                    // DELETE
                        ).hasAuthority("CUSTOMER")

                        // PROVIDER فقط
                        .requestMatchers(
                                "/api/v1/Availabilities/*",            // كل العمليات على الأوقات المتاحة
                                "/api/v1/appointments/*/status"        // تعديل حالة الموعد
                        ).hasAuthority("PROVIDER")

                        // ADMIN فقط
                        .requestMatchers(
                                "/api/v1/users/*",                     // إدارة مستخدمين
                                                    // إضافة خدمة
                                "/api/v1/services/*"                   // تعديل/حذف خدمة
                        ).hasAuthority("ADMIN")

                        // مشترك بين كل المسجلين (GET على الخدمات والتقييمات)
                        .requestMatchers(
                                "/api/v1/services",                    // عرض كل الخدمات
                                "/api/v1/services/*",                  // خدمة واحدة
                                "/api/v1/reviews",                     // عرض كل التقييمات
                                "/api/v1/reviews/*"                    // تقييم معين
                        ).authenticated()

                        // أي مسار آخر يتطلب تسجيل دخول
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .userDetailsService(userDetailsService)
                .build();
    }



    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
