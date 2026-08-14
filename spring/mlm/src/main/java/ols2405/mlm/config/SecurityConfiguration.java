package ols2405.mlm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // http
        //         .csrf(csrf -> csrf.disable())
        //         .authorizeHttpRequests(auth -> auth
        //                 .requestMatchers("/", "/user/login", "/user/seedadmin")
        //                 .permitAll())
        //                 // .anyRequest().authenticated())
        //         // .formLogin(form -> form
        //         //         .usernameParameter("userId")
        //         //         .passwordParameter("password")
        //         //         .loginPage("/user/login")
        //         //         .loginProcessingUrl("/user/authenticate")
        //         //         .defaultSuccessUrl("/dashboard", true)
        //         //         .failureUrl("/login?error"))
        //         // .logout(logout -> logout
        //         //         .logoutSuccessUrl("/login?logout")
        //         //         .invalidateHttpSession(true)
        //         // )
        //         ;

        return http.build();
    }
}
