package gma_EJB.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="stat_answers", schema="gma_db")
@IdClass(value=StatAnswersID.class)
public class StatAnswers implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	//attr
	@Id
	@ManyToOne
	@JoinColumn(name="idU")
	private int idU;
	@Id
	@ManyToOne
	@JoinColumn(name="idQ")
	private int idQ;
	private int age;
	private int sex;		//TODO: html must transalte enum-->int
	private int expertise;		//TODO: html must transalte enum-->int
	
	
	//constructor
	public StatAnswers() {}
	
	
	//getters setters
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public int getIdQ() {
		return idQ;
	}
	public void setIdQ(int idQ) {
		this.idQ = idQ;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getExpertise() {
		return expertise;
	}
	public void setExpertise(int expertise) {
		this.expertise = expertise;
	}
	
	
}
