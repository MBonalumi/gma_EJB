package gma_EJB.services;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.MktQuestion;
import gma_EJB.entities.Product;
import gma_EJB.entities.Questionnaire;
import gma_EJB.entities.User;
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
	 * gets questionnaire by date
	 * must be called with year, month, day
	 */
	public Questionnaire getByDate(int year, int month, int day) throws NoQuestionnaireTodayException {
		return getByDate(new Date(year-1900, month-1, day));
	}
	public Questionnaire getByDate(Date date) throws NoQuestionnaireTodayException {
		Questionnaire q = null;
		
		try {
			q = em.createNamedQuery("Questionnaire.getByDate", Questionnaire.class)
					.setParameter(1, date)
					.getSingleResult();
		}catch(PersistenceException e) {
			throw new NoQuestionnaireTodayException("No questionnaires happened on the provided date.");
		}
		em.refresh(q);
		return q;
	}
	
	/*
	 * get questions from questionnaire
	 */
	/*
	public List<MktQuestion> getMktQuestions(Questionnaire q) {
		Questionnaire q1 = em.find(Questionnaire.class, q.getIdQ());
		return q1.getMktQuestions();
	}
	*/
	
	
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
