package com.ciecc.fire.personal.portal.sercurity.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrincipalRepository extends JpaRepository<UserPrincipal, Long> {

	UserPrincipal findByUsername(String username);
}
