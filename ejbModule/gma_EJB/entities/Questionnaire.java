package gma_EJB.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="questionnaire", schema="gma_db")
@NamedQueries({
	@NamedQuery(name="Questionnaire.getToday", query="SELECT x FROM Questionnaire x WHERE x.date=CURRENT_DATE"),
	@NamedQuery(name="Questionnaire.getByDate", query="SELECT x FROM Questionnaire x WHERE x.date=?1")
})
public class Questionnaire implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	//table attr
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idQ;
	@Column(name="date", nullable=false)
	@Basic
	@Temporal(TemporalType.DATE)
	private Date date;
	private String title="title";
	@ManyToOne
	@JoinColumn(name="idP")
	private Product idP;
	
	
	//other attr (jpa FK)
	@OneToMany(mappedBy="idQ", cascade=CascadeType.ALL, orphanRemoval=true)	
	Collection<MktQuestion> mktQuestions;
	@OneToMany(mappedBy="idQ", cascade=CascadeType.ALL, orphanRemoval=true)	
	Collection<StatAnswers> statAnswers;
	
	
	//constructor
	public Questionnaire() {}


	//getters & setters
	public int getIdQ() {
		return idQ;
	}
	public void setIdQ(int idQ) {
		this.idQ = idQ;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Product getIdP() {
		return idP;
	}
	public void setIdP(Product idP) {
		this.idP = idP;
	}
	
}
