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
	public Questionnaire findQuestionnaire(int id) {
		Questionnaire q = em.find(Questionnaire.class, id);
		return q;
	}
	public Questionnaire getToday() throws NoQuestionnaireTodayException {
		Questionnaire quest = null;

		
		try {
			quest = em.createNamedQuery("Questionnaire.getToday", Questionnaire.class).setHint("javax.persistence.cache.storeMode", "REFRESH")
					.getSingleResult();
		}catch(PersistenceException e) {
			throw new NoQuestionnaireTodayException("No questionnaires for today.");
		}
		
		
		return quest;
	}
	
	/*
	 * adds new questionnaire
	 */
	public Questionnaire addQuestionnaire(Date date, String title, Product p) {
		Questionnaire q = new Questionnaire();
		q.setDate(date);
		q.setIdP(p);
		q.setTitle(title);
		em.persist(q);
		return q;
	}
	
	public List<Questionnaire> getQuestionnaires() throws Exception {
		List<Questionnaire> quest = null;
		try {
			quest = em.createNamedQuery("Questionnaire.getQuestionnaires", Questionnaire.class)
					.setHint("javax.persistence.cache.storeMode", "REFRESH")
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't get questionnaires");
		}
		//em.refresh(quest);
		
		return quest;
	}
	
	public Questionnaire deleteQuestionnaire(int id) {
		Questionnaire q = em.find(Questionnaire.class, id);
		if (q == null)
			return null;
		em.remove(q);
		return q;
	}	
}
