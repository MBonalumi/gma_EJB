package gma_EJB.services;

import javax.ejb.Stateless;
import javax.persistence.*;
import gma_EJB.entities.Product;

@Stateless
public class ProductService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;
	
	public ProductService() {}
	
	public Product getProduct(int idP) throws Exception {
		Product product = null;

		try {
			product = em.createNamedQuery("Product.getTodayProduct", Product.class).setParameter(1, idP)
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
