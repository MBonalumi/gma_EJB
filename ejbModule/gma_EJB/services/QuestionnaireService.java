package gma_EJB.services;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.Product;
import gma_EJB.entities.Questionnaire;
import gma_EJB.exceptions.NoQuestionnaireTodayException;

@Stateless
public class QuestionnaireService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;

	public QuestionnaireService() {}
	
	/*
	 * retrieves today's quest.
	 */
	public Questionnaire getToday() throws NoQuestionnaireTodayException {
		Questionnaire quest = null;

		
		try {
			quest = em.createNamedQuery("Questionnaire.getToday", Questionnaire.class)
					.getSingleResult();
		}catch(PersistenceException e) {
			throw new NoQuestionnaireTodayException("No questionnaires for today.");
		}
		
		
		return quest;
	}
	
	/*
	 * adds new questionnaire
	 */
	public void addQuestionnaire(Date date, String title, Product p) {
		Questionnaire q = new Questionnaire();
		q.setDate(date);
		q.setIdP(p);
		q.setTitle(title);
		em.persist(q);
	}
}
