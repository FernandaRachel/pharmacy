package org.com.pharmacy.infrastructure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableMethodSecurity // 👈 allows @PreAuthorize, @Secured, @RolesAllowed
class SecurityConfig {

    @Bean
    fun users(): UserDetailsService {
        val admin: UserDetails = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("secret")
            .roles("ADMIN")
            .build()

        val user: UserDetails = User.withDefaultPasswordEncoder()
            .username("user")
            .password("secret")
            .roles("USER")
            .build()

        return InMemoryUserDetailsManager(admin, user)
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { auth ->
                auth
                    .anyRequest().authenticated() // all endpoints require auth
            }
            .httpBasic { } // enable Basic Auth
            .csrf { it.disable() } // disable CSRF for APIs
        return http.build()
    }
}

