package springjdbc.dao.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class TransactSecurity {
    @Autowired
  MyBankOfficialService myBankOfficialService;

    AuthenticationManager authenticationManager;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();
        httpSecurity.formLogin();
        httpSecurity.csrf().disable();

        httpSecurity.authorizeRequests().antMatchers("/profile/addTransaction").permitAll();

        httpSecurity.authorizeRequests().antMatchers("/transaction/Sender/*").hasAuthority("customer");
        httpSecurity.authorizeRequests().antMatchers("/transaction/Receiver/*").hasAuthority("customer");
        httpSecurity.authorizeRequests().antMatchers("/transaction/Amount/*").hasAuthority("customer");
        httpSecurity.authorizeRequests().antMatchers("/transaction/Update/*").hasAnyAuthority("manager","admin");
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST).hasAuthority("admin");
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.DELETE).hasAuthority("admin");
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.PUT).hasAnyAuthority("manager","admin");

        httpSecurity.authorizeRequests().anyRequest().authenticated();


        AuthenticationManagerBuilder builder=httpSecurity.
                getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(myBankOfficialService);
        authenticationManager=builder.build();
        httpSecurity.authenticationManager(authenticationManager);

        return httpSecurity.build();
    }
}
