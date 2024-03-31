package soap.webservice.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

//Perform Spring boot security authority based authorization on #1148 with considering following roles
//        user should have:
//        username, password, role, address ,contact, email
//        roles are:
//        admin,customer,manager
//        new transaction             >> admin
//        findBySender                  >> customer
//        findByReciever                >> customer
//        findByAmount                 >> customer
//        updateRemarks                >> manager, admin
//        removeTransactionBetweenDates >> start date and end date    >> admin
public class MyBankOfficials implements UserDetails {
    private String username;
    private String password;
    private String role;
    private String address;
    private Long contact;
    private String email;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authority=new ArrayList<>();
        authority.add(new SimpleGrantedAuthority(role));
        return authority;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
