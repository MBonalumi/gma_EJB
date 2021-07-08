package gma_EJB.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="admin", schema="gma_db")
@NamedQueries({
	@NamedQuery(name="Admin.checkCredentials", query="SELECT x FROM Admin x WHERE x.username = ?1 AND x.psw = ?2")
})
public class Admin  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idA;
	@Column(name="username", nullable=false, unique=true)
	private String username;
	@Column(name="psw", nullable=false)
	private String psw;
	
	public Admin() {}
	
	//getters/setters
	public int getIdA() {
		return idA;
	}
	public void setIdA(int idA) {
		this.idA = idA;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
}
