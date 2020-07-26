package domain;

public class Users {
	String id;
	String password;
	public Users(String id,String p){
		this.id=id;
		password=p;
	}
	
	public void setID(String id){
		this.id=id;
	}
	public String getID(){
		return id;
	}
	
	public void setPassword(String p){
		this.password=p;
	}
	public String getPassword(){
		return password;
	}
}
