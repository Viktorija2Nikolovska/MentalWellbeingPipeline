
package com.ukim.finki.mentalwellbeing.model.enumerations;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Enumerated;


public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    @Override
    public String getAuthority() {

        return name();
    }
}
