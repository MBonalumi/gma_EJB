package gma_EJB.services;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import gma_EJB.entities.Questionnaire;

@Stateless
public class QuestionnaireService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;

	public QuestionnaireService() {}
	
	/*
	 * 
	 */
	public Questionnaire getToday() throws Exception {
		Questionnaire quest = null;

		if(em == null)
			System.out.println("bo");
		
		try {
			quest = em.createNamedQuery("Questionnaire.getToday", Questionnaire.class)
					.getSingleResult();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't retrieve product information");
		}
		
		if(quest == null)
			throw new Exception("Error! No questionnaire on this date");
		
		return quest;
	}
	
}
