package gma_EJB.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="user", schema="gma_db")
//TODO: @NamedQuery

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//attributes
	@Id
	int idU;
	String username;
	String email;
	String psw;
	Boolean ban;
	
	//constructor
	public User() {	}
	
	//getters & setters
	public String getUsername() {		return username;	}
	public void setUsername(String username) {		this.username = username;	}

	public String getPassword() {		return psw;	}
	public void setPassword(String psw) {		this.psw = psw;	}
	
	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	}

	public Boolean getAdmin() {		return ban;	}
	public void setAdmin(Boolean ban) {		this.ban = ban;	}
	
}