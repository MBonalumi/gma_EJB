package gma_EJB.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="login_history", schema="gma_db")
//TODO: @NamedQuery
@IdClass(value = LoginHistoryID.class)
@NamedQueries({
	@NamedQuery(name="LoginHistory.getHistory", query="SELECT x FROM LoginHistory x WHERE x.idU=?1 "),
	@NamedQuery(name="LoginHistory.getCancelList", query="SELECT x FROM LoginHistory x WHERE x.idQ=?1 ")
	
})
public class LoginHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//attributes
	@Id
	@ManyToOne
	@JoinColumn(name="idU")
	private User idU;
	@Id
	@Column(name="ts", nullable=false)
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date ts;
	@ManyToOne
	@JoinColumn(name="idQ")
	private Questionnaire idQ;
	
	//constructor
	public LoginHistory() {
		super();
	}
	
	
	//getters setters
	public User getIdU() {
		return idU;
	}
	public void setIdU(User idU) {
		this.idU = idU;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	public Questionnaire getIdQ() {
		return idQ;
	}
	public void setIdQ(Questionnaire idQ) {
		this.idQ = idQ;
	}
}
