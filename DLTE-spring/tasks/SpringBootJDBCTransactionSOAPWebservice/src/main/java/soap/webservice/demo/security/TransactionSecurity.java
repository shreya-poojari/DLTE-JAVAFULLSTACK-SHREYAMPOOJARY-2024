package soap.webservice.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TransactionSecurity {
    @Autowired
    private MybankOfficialservice mybankOfficialservice;

    AuthenticationManager authenticationManager;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails userDetails1= User.withDefaultPasswordEncoder().username("shreya").password("poojary").roles("admin").build();
//        UserDetails userDetails2= User.withDefaultPasswordEncoder().username("kavya").password("naik").roles("customer").build();
//        UserDetails userDetails3= User.withDefaultPasswordEncoder().username("anith").password("suvarna").roles("manager").build();
//        List<UserDetails> userDetailsList= Stream.of(userDetails1,userDetails2,userDetails3).collect(Collectors.toList());
//        return new InMemoryUserDetailsManager(userDetailsList);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager manager) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.httpBasic();
        httpSecurity.formLogin();

        httpSecurity.authorizeRequests().antMatchers("/profile/register").permitAll();
        httpSecurity.authorizeRequests().anyRequest().authenticated();


        // 3rd layer
        AuthenticationManagerBuilder builder=httpSecurity.
                getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(mybankOfficialservice);
        manager=builder.build();
        httpSecurity.authenticationManager(manager);

        return httpSecurity.build();
    }
}
