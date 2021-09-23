package springsequirity.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import springsequirity.entity.Student;

public class studentDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private List<String> studentRols;

	public studentDetails(Student student, List<String> studentRoles) {
		super();
		this.studentRols = studentRoles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles = StringUtils.collectionToCommaDelimitedString(studentRols);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);

	}

	@Override
	public String getPassword() {

		return toString();
	}

	@Override
	public String getUsername() {

		return toString();
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
