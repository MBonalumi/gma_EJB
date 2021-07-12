package gma_EJB.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="mkt_question", schema="gma_db")
@NamedQuery(name="MktQuestion.getQuestionsFromQuestionnaire", query="SELECT x FROM MktQuestion x WHERE x.idQ=?1")
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
	private Questionnaire idQ;
	
	
	//other attr
	/*
	@OneToMany(mappedBy="idM", cascade=CascadeType.ALL, orphanRemoval=true)
	Collection<MktAnswer> answers;
	*/
	
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
	public Questionnaire getIdQ() {
		return idQ;
	}
	public void setIdQ(Questionnaire idQ) {
		this.idQ = idQ;
	}
	

}
