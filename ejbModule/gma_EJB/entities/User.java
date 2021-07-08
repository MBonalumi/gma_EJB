package gma_EJB.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="user", schema="gma_db")
//TODO: @NamedQuery
@NamedQueries({
	@NamedQuery(name="User.checkCredentials", query="SELECT x FROM User x WHERE x.username = ?1 AND x.psw = ?2") ,
	@NamedQuery(name="User.getUser", query="SELECT x FROM User x WHERE x.username = ?1"),
	@NamedQuery(name="User.getUsers", query="SELECT x FROM User x"),
	@NamedQuery(name="User.getUsersRanking",query="SELECT x FROM User x ORDER BY x.points DESC")
})
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//table attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idU;
	@Column(name="username", nullable=false, unique=true)
	private String username;
	@Column(name="email", nullable=false, unique=true)
	private String email;
	@Column(name="psw", nullable=false)
	private String psw;
	@Column(name="ban", nullable=false)
	private Boolean ban=false;
	private int points=0;
	
	@Transient
	private Date ts; 
	@Transient
	private Boolean hasAnsweredToday=false;
	
	//TODO: MUST IMPLEMENT addLogin(LoginHistory l), removeLogin(LoginHistory l) et cetera
	
	//other attributes
	@OneToMany(mappedBy="idU", cascade=CascadeType.ALL, orphanRemoval=true)	//TODO: maybe need extra parameters --> cascade=CascadeType.ALL, orphanRemoval=true
	Collection<LoginHistory> logins;
	@OneToMany(mappedBy="idU", cascade=CascadeType.ALL, orphanRemoval=true)	//TODO: maybe need extra parameters --> cascade=CascadeType.ALL, orphanRemoval=true
	Collection<MktAnswer> mktAnswers;
	@OneToMany(mappedBy="idU", cascade=CascadeType.ALL, orphanRemoval=true)	//TODO: maybe need extra parameters --> cascade=CascadeType.ALL, orphanRemoval=true
	Collection<StatAnswers> statAnswers;
	
	
	
	//constructor
	public User() {	}

	
	//getters&setters
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public Boolean getBan() {
		return ban;
	}
	public void setBan(Boolean ban) {
		this.ban = ban;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void addLogin() {
		this.ts = new Date();
	}
	
	public Date getLogin() {
		return ts;
	}
	public Boolean getHasAnsweredToday() {
		return hasAnsweredToday;
	}
	public void setHasAnsweredToday(Boolean hasAnsweredToday) {
		this.hasAnsweredToday = hasAnsweredToday;
	}
}