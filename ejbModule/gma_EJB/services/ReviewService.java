package gma_EJB.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.Review;

@Stateless
public class ReviewService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;

	public ReviewService() {}
	
	/*
	 * 
	 */
	public List<Review> getReviews(int idP) {
		return null;
	}
	

}
