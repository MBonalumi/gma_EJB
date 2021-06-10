package gma_EJB.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="review", schema="gma_db")
//TODO: @NamedQuery

public class Review implements Serializable{
	private static final long serialVersionUID = 1L;

	//table attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idR;
	private String text;
	@ManyToOne
	@JoinColumn(name="idP")
	private int idP;
	
	
	//constructor
	public Review() {}


	//getters & setters
	public int getIdR() {
		return idR;
	}
	public void setIdR(int idR) {
		this.idR = idR;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
}
