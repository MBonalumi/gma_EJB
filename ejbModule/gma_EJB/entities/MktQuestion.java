package gma_EJB.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="mkt_question", schema="gma_db")
public class MktQuestion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	//table attr
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idM;
	@Column(name="text", nullable=false)
	String text;
	@ManyToOne
	@JoinColumn(name="idQ")
	private int idQ;
	
	
	//other attr
	@OneToMany(mappedBy="idM")
	Collection<MktAnswer> answers;
	
	
	//constructor
	public MktQuestion() {
		super();
	}
	
	
	//getters setters
	public int getIdM() {
		return idM;
	}
	public void setIdM(int idM) {
		this.idM = idM;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getIdQ() {
		return idQ;
	}
	public void setIdQ(int idQ) {
		this.idQ = idQ;
	}
	

}
