package mybank.project.webservice.security;


import mybank.project.loansdao.service.MyBankCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomerSecureConfiguration {
    @Autowired
    MyBankCustomersService service;
    AuthenticationManager authenticationManager;
    @Autowired
    CustomersFailureHandler customersFailureHandler;
    @Autowired
    CustomersSuccesshandler customersSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //cors config
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        //configuration.setAllowedOriginPatterns(Arrays.asList("http://127.0.0.1:5500"));
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));

        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();
        httpSecurity.cors();
        httpSecurity.authorizeRequests().antMatchers("/profile/register").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/v3/api-docs").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/mybank/weblogin/**").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/images/**").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/styles/**").permitAll();

        httpSecurity.formLogin().loginPage("/mybank/weblogin/").
                usernameParameter("username").
                failureHandler(customersFailureHandler).
                successHandler(customersSuccessHandler);
        httpSecurity.csrf().disable();

        httpSecurity.authorizeRequests().anyRequest().authenticated();
        AuthenticationManagerBuilder builder=httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(service);
        authenticationManager=builder.build();
        httpSecurity.authenticationManager(authenticationManager);
        return httpSecurity.build();
    }
}