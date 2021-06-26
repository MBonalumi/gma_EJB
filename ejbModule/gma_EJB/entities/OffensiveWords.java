package gma_EJB.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="offensive_words", schema="gma_db")
@NamedQuery(name="OffensiveWords.getWords", query="SELECT x FROM OffensiveWords x")
public class OffensiveWords implements Serializable{
	private static final long serialVersionUID = 1L;

	//attr
	@Id
	private String word;

	
	//constr
	public OffensiveWords() {}


	//getter setter
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
}
