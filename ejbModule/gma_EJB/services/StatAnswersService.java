package gma_EJB.services;

import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.Questionnaire;
import gma_EJB.entities.StatAnswers;
import gma_EJB.entities.User;

@Stateless
public class StatAnswersService {
	@PersistenceContext(unitName="gma_EJB")
	EntityManager em;
	
	public StatAnswersService() {}
	
	/*
	 * 
	 */
//	public StatAnswers getLastAnswers(User u) throws Exception {
//		StatAnswers statA = null;
//		try {
//			statA = em.createNamedQuery("StatAnswers.getLastFromUser", StatAnswers.class).setParameter(1, u)
//					.getSingleResult();
//		}catch(PersistenceException e) {
//			throw new Exception("Database error! Can't retrieve last stat answers");
//		}
//		
//		return statA;
//	}
	
	/*
	 * 
	 */
	public void addStatAnswers(User u, Questionnaire q, int sex, int age, int expertise) {
		StatAnswers statA = new StatAnswers();
		statA.setIdQ(q);
		statA.setIdU(u);
		statA.setSex(sex);
		statA.setAge(age);
		statA.setExpertise(expertise);
		em.persist(statA);
	}
	
}
