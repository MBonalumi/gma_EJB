package gma_EJB.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.Product;
import gma_EJB.entities.Review;

@Stateless
public class ReviewService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;

	public ReviewService() {}
	
	/*
	 * 
	 */
	public List<Review> getReviews(int idP) throws Exception {
		List<Review> reviews = null;
		try {
			reviews = em.createNamedQuery("Review.getReviews", Review.class).setParameter(1, idP)
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't check credentials");
		}
		
		return reviews;
	}
	

}
