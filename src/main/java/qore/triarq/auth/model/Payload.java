package qore.triarq.auth.model;

public class Payload {
	
	private String iss;
	private String iat;
	private String aud;
	private String exp;
	private String sub;
	public Payload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payload(String iss, String iat, String aud, String exp, String sub) {
		super();
		this.iss = iss;
		this.iat = iat;
		this.aud = aud;
		this.exp = exp;
		this.sub = sub;
	}
	public String getIss() {
		return iss;
	}
	public void setIss(String iss) {
		this.iss = iss;
	}
	public String getIat() {
		return iat;
	}
	public void setIat(String iat) {
		this.iat = iat;
	}
	public String getAud() {
		return aud;
	}
	public void setAud(String aud) {
		this.aud = aud;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	
	

}
