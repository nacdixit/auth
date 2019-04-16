package qore.triarq.auth.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonResponse {
	
	private String token;
	private String username;
	
	private Payload payload;
	
	@JsonIgnore
	private List<UserView> userView;
	private List<Authdetails> authdetails;
	
	public PersonResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Authdetails> getAuthdetails() {
		return authdetails;
	}

	public void setAuthdetails(List<Authdetails> authdetails) {
		this.authdetails = authdetails;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	public PersonResponse(String token, String username, Payload payload, List<UserView> userView,
			List<Authdetails> authdetails) {
		super();
		this.token = token;
		this.username = username;
		this.payload = payload;
		this.userView = userView;
		this.authdetails = authdetails;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "PersonResponse [token=" + token + ", username=" + username + ", userView=" + userView + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<UserView> getUserView() {
		return userView;
	}
	public void setUserView(List<UserView> userView) {
		this.userView = userView;
	}
	
	
	

}
