package exp.vis.javademo.persistence;

import java.util.Collection;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * JavaSpringDemo - exp.vis.javademo.persistence
 *
 * @author Viswanath L
 *
 * Jan 10, 2015
 */

@Entity
@Table(name="user")
public class User implements UserDetails {

	private static final long serialVersionUID = -6872105731247386644L;

	private Long id;

	private String username;

	private String password;

	private UserRole role;
	
	public User() {

	}

	@Id @GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USERNAME", length = 100)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", length = 100)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToOne
	@JoinColumn(name="ROLEID")
	public UserRole getRoleId() {
		return role;
	}
	public void setRoleId(UserRole role) {
		this.role = role;
	}

	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> auth = new Vector<GrantedAuthority>();
		auth.add(new GrantedAuthorityImpl(role.getRoleType()));
		return auth;
	}

	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	public boolean isEnabled() {
		return true;
	}

}

