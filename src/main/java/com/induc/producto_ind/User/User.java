package com.induc.producto_ind.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class User implements UserDetails{
    @Id
    @GeneratedValue
    int id;
    @Column(length = 50, nullable = false, unique = true)
    String username;
    @Column(length = 255, nullable = false)
    String password;
    @Column(length = 50, nullable = false)
    String nombre;
    @Column(length = 50, nullable = false)
    String apellido;
    @Column(nullable = false)
    Date fecha_registro;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

