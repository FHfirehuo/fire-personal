package com.ciecc.fire.personal.backstage.security;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class UserPrincipal implements UserDetails , CredentialsContainer, Cloneable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private String username;
	private byte[] hashedPassword;
	private String name;
	private Set<UserAuthority> authorities = new HashSet<>();
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "HashedPassword")
	public byte[] getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(byte[] hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void eraseCredentials() {
		this.hashedPassword = null ;
		
	}
	@Override
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "UserPrincipal_Authority", joinColumns = { 
			@JoinColumn( name = "UserId", referencedColumnName = "UserId")
	})
	public Set<UserAuthority> getAuthorities() {
		return authorities;
		
	}
	
	public void setAuthorities(Set<UserAuthority> authorities) {
		this.authorities = authorities;
	}
	
	@Transient
	@Override
	public String getPassword() {
		return this.getHashedPassword() == null ? null : 
			new String(this.getHashedPassword(), StandardCharsets.UTF_8);
		
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	@XmlElement @JsonProperty
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	
	@Override
	@XmlElement @JsonProperty
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	
	
	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	@Override
	@XmlElement @JsonProperty
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
