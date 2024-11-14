package mugisha.chrispin.students.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").authenticated() // Requires authentication for Swagger docs
                        .anyRequest().permitAll() // Allow other requests without authentication
                )
                .httpBasic(Customizer.withDefaults()) // Enables basic authentication
                .csrf(csrf -> csrf.disable()); // Disable CSRF for simplicity (consider your security needs)

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Define a default user to access the Swagger docs
        UserDetails user = User.builder()
                .username("kalisa") // Set your desired username
                .password(passwordEncoder().encode("71ab43e5-c87d-4700-8b8b-70d3ff46fe7b")) // Encode the password
                .roles("USER") // Assign roles as needed
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
    }
}

//package mugisha.chrispin.students.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .anyRequest().permitAll() // Allow all requests without authentication
//                )
//                .csrf(csrf -> csrf.disable()); // Disable CSRF protection for testing
//
//        return http.build();
//    }
//}