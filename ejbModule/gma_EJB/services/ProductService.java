package gma_EJB.services;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.Product;
import gma_EJB.entities.Questionnaire;

@Stateless
public class ProductService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;
	
	public ProductService() {}
	
	@EJB(name = "gma_EJB.services/QuestionnaireService")
	QuestionnaireService questS;
	
	public Product getTodayProduct() throws Exception {
		Questionnaire quest = questS.getToday();
		Product product = null;

		try {
			product = em.createNamedQuery("Product.getTodayProduct", Product.class).setParameter(1, quest.getIdP().getIdP())
					.getSingleResult();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't retrieve product information");
		}
		
		return product;
	}
	
	public void addProduct(String name, String descr, byte[] image) throws Exception {
		Product prod = new Product();
		prod.setName(name);
		prod.setDescr(descr);
		prod.setImage(image);
		em.persist(prod);
	}
}
