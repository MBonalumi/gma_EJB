package gma_EJB.services;

import java.sql.Date;

import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.Product;

@Stateless
public class ProductService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;
	
	public ProductService() {}
	
	public Product getProduct(Date date) throws Exception {
		Product product = null;
		
		try {
			product = em.createNamedQuery("Product.getProduct", Product.class).setParameter(1, date)
					.getSingleResult();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't retrieve product information");
		}
		
		if(product == null)
			return null;	//no Product today!
		
		return product;
	}
}
