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
	private MktQuestion idM;		//TODO: may need @Column(nullable=false)
	@Id
	@ManyToOne
	@JoinColumn(name="idU")
	private User idU;		//TODO: may need @Column(nullable=false)
	@Column(name="text", nullable=false)
	private String text;
	
	
	//constructor
	public MktAnswer() {}
	
	
	//getters setters
	public MktQuestion getIdM() {
		return idM;
	}
	public void setIdM(MktQuestion idM) {
		this.idM = idM;
	}
	public User getIdU() {
		return idU;
	}
	public void setIdU(User idU) {
		this.idU = idU;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	

}
