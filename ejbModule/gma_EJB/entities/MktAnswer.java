package gma_EJB.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="mkt_answer", schema="gma_db")
@IdClass(value = MktAnswerID.class)
public class MktAnswer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	//table attr
	@Id
	@ManyToOne
	@JoinColumn(name="idM")
	private int idM;		//TODO: may need @Column(nullable=false)
	@Id
	@ManyToOne
	@JoinColumn(name="idU")
	private int idU;		//TODO: may need @Column(nullable=false)
	@Column(name="text", nullable=false)
	private String text;
	
	
	//constructor
	public MktAnswer() {}
	
	
	//getters setters
	public int getIdM() {
		return idM;
	}
	public void setIdM(int idM) {
		this.idM = idM;
	}
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	

}
