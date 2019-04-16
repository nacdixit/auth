package qore.triarq.auth.model;
public class Permissions {
	
	
	private String View;
	private String Add;
	private String Edit;
	private String Delete;
	private String Print;
	public Permissions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Permissions(String view, String add, String edit, String delete, String print) {
		super();
		View = view;
		Add = add;
		Edit = edit;
		Delete = delete;
		Print = print;
	}
	public String getView() {
		return View;
	}
	public void setView(String view) {
		View = view;
	}
	public String getAdd() {
		return Add;
	}
	public void setAdd(String add) {
		Add = add;
	}
	public String getEdit() {
		return Edit;
	}
	public void setEdit(String edit) {
		Edit = edit;
	}
	public String getDelete() {
		return Delete;
	}
	public void setDelete(String delete) {
		Delete = delete;
	}
	public String getPrint() {
		return Print;
	}
	public void setPrint(String print) {
		Print = print;
	}
	
	
	
	
}
