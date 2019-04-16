package qore.triarq.auth.model;

public class USERRIGHTS 
{
	
	private String screenname;
	private Permissions permissions;
	public USERRIGHTS() {
		permissions=new Permissions();
	}
	public USERRIGHTS(String screenname, Permissions permissions) {
		super();
		this.screenname = screenname;
		this.permissions = permissions;
	}
	public String getScreenname() {
		return screenname;
	}
	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}
	public Permissions getPermissions() {
		return permissions;
	}
	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}
	
	
	


}
