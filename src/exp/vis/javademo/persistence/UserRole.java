package exp.vis.javademo.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 *
 * SpringJavaDemo : exp.vis.javademo.persistence;
 *
 * @author Viswanath L
 *
 * Jan 12, 2015
 *
 **/

@Entity
@Table(name="role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String roleType;

	@Id @GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	@Column(name = "ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	/**
     * Get role type 
     */
    @Column(name = "ROLETYPE", length = 20)
	public String getRoleType() {
		return roleType;
	}
    
    /**
     * Set role type
     */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
}
