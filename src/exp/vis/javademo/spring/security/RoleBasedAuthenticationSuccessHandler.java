package exp.vis.javademo.spring.security;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 *
 * JavaSpringDemo : package exp.vis.demo.security;
 *
 * @author viswanath.l
 *
 * Jan 08, 2015
 *
 **/

public class RoleBasedAuthenticationSuccessHandler
extends SimpleUrlAuthenticationSuccessHandler
{
	private Map<String, String> roleToUrlMap = new Hashtable<String, String>();

	/**
	 * Determine's target url
	 */
	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Vector<GrantedAuthority> authorities = new Vector<GrantedAuthority>(authentication.getAuthorities());
		
		GrantedAuthority authority = authorities.get(0);
		return roleToUrlMap.get(authority.getAuthority());
	}

	/**
	 * Set role to url map
	 */
	public void setRoleToUrlMap(Map<String, String> roleToUrlMap)
	{
		this.roleToUrlMap = roleToUrlMap;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
					throws IOException, ServletException {
		super.onAuthenticationSuccess(request, response, authentication);
	}

}