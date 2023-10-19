package springweb.firstapiinjava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    @Autowired
    private SecurityDataBaseService securityService;

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/login/user/**").hasRole("USERS");
                    auth.requestMatchers("/login/admin/**").hasRole("MANAGERS");
                    auth.requestMatchers(HttpMethod.GET,"/db").hasRole("MANAGERS");
                    auth.requestMatchers(HttpMethod.GET,"/db/{usuario}").hasRole("MANAGERS");
                    auth.requestMatchers(HttpMethod.DELETE,"/db/{id}").hasRole("MANAGERS");
                    auth.requestMatchers(HttpMethod.POST,"/db").hasRole("MANAGERS");
                    auth.requestMatchers(HttpMethod.PUT,"/db").hasRole("MANAGERS");
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }


//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        List<UserDetails> users = new ArrayList<UserDetails>();
//        users.add(User.withDefaultPasswordEncoder().
//                username("user").
//                password("user123").
//                roles("USER").
//                build()
//        );
//        users.add(User.withDefaultPasswordEncoder().
//                username("admin").
//                password("master123").
//                roles("ADMIN").
//                build()
//        );
//        return new InMemoryUserDetailsManager(users);
//    }
}
