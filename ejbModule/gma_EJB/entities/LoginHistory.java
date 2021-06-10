package gma_EJB.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="login_history", schema="gma_db")
//TODO: @NamedQuery
@IdClass(value = LoginHistoryID.class)
public class LoginHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//attributes
	@Id
	@ManyToOne
	@JoinColumn(name="idU")
	private int idU;
	@Id
	@Column(name="ts", nullable=false)
	private Timestamp ts;
	
	
	//constructor
	public LoginHistory() {
		super();
	}
	
	
	//getters setters
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
}
