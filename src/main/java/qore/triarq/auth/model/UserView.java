package qore.triarq.auth.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authdetails")
public class UserView {
	
	@Override
	public String toString() {
		return "UserView [id=" + id + ", personid=" + personid + ", username=" + username + ", applicationname="
				+ applicationname + ", password=" + password + ", userrights=" + userrights + "]";
	}
	@Id
	private String id;
	private String personid;
	private String username;
	private String applicationname;
	private String password;
	private String userrights;
	public UserView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserView(String id, String personid, String username, String applicationname, String password,
			String userrights) {
		super();
		this.id = id;
		this.personid = personid;
		this.username = username;
		this.applicationname = applicationname;
		this.password = password;
		this.userrights = userrights;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPersonid() {
		return personid;
	}
	public void setPersonid(String personid) {
		this.personid = personid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getApplicationname() {
		return applicationname;
	}
	public void setApplicationname(String applicationname) {
		this.applicationname = applicationname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserrights() {
		return userrights;
	}
	public void setUserrights(String userrights) {
		this.userrights = userrights;
	}
	
	

}
