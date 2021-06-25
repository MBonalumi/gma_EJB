package gma_EJB.entities;

import java.io.Serializable;
import java.util.Base64;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="product", schema="gma_db")
//TODO: @NamedQuery
@NamedQuery(name="Product.getTodayProduct", query="SELECT x FROM Product x WHERE x.idP = ?1")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;

	//table attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idP;
	private String name;
	private String descr;
	@Lob
	private byte[] image;
	
	
	//other attributes (jpa, FK)
	@OneToMany(mappedBy="idP", cascade=CascadeType.ALL, orphanRemoval=true)	//TODO: maybe need extra parameters --> cascade=CascadeType.ALL, orphanRemoval=true
	Collection<Review> reviews;
	@OneToMany(mappedBy="idP", cascade=CascadeType.ALL, orphanRemoval=true)	//TODO: maybe need extra parameters --> cascade=CascadeType.ALL, orphanRemoval=true
	Collection<Questionnaire> questionnaires;
	
	
	//constructor
	public Product() {}
	
	
	//getters&setters
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	
	public byte[] getImage() {
		return image;
	}
	public String getImageData() {
		return Base64.getMimeEncoder().encodeToString(image);
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
}
