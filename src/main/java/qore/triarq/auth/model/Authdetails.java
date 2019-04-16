package qore.triarq.auth.model;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Entity
@Table(name="authdetails")
public class Authdetails {
	
	
	@JsonIgnore
	@Id
	private String id;
	
	
	@JsonIgnore
	private String personid;
	
	@JsonIgnore
	private String username;
	
	@JsonIgnore
	private String password;
	
	private String applicationname;
	
	@JsonIgnore
	private String userrights;
	
	@Transient
	private List<USERRIGHTS> userright;
	
	
	@Transient
	Gson gsonObj;
	

	
	
	public Authdetails() {
		
		gsonObj = new GsonBuilder().create();
		userright=new ArrayList<USERRIGHTS>();
	}

	public List<USERRIGHTS> getUserright() {
		return  Arrays.asList(gsonObj.fromJson(userrights, USERRIGHTS[].class));
	}

	public void setUserright(List<USERRIGHTS> userright) {
		this.userright = userright;
	}

	public Authdetails(String personid, String applicationname,String userrights,String username,String password) {
		super();
		this.personid = personid;
		this.applicationname = applicationname;
		this.userrights=userrights;
		this.username=username;
		this.password=password;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public String getApplicationname() {
		return applicationname;
	}

	public void setApplicationname(String applicationname) {
		this.applicationname = applicationname;
	}

//	public USERRIGHTS getUserright() {
//		return gsonObj.fromJson(userrights, USERRIGHTS.class);
//	}
//
//	public void setUserright(USERRIGHTS userright) {
//		this.userright = userright;
//	}
//



	
	
	
	

}
