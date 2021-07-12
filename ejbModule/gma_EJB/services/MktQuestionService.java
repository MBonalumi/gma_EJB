package gma_EJB.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.MktQuestion;
import gma_EJB.entities.Questionnaire;

@Stateless
public class MktQuestionService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;
	
	public MktQuestionService() {}
	
	/*
	 * returns list of MktQuestions from a given Questionnaire
	 */
	public List<MktQuestion> getMktQuestions(Questionnaire q) throws Exception {
		List<MktQuestion> questions = null;
		
		try {
			questions = em.createNamedQuery("MktQuestion.getQuestionsFromQuestionnaire", MktQuestion.class).setParameter(1, q)
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't get marketing questions");
		}
		
		return questions;
	}
	
	public MktQuestion findMktQuestion(int id) {
		MktQuestion q = em.find(MktQuestion.class, id);
		return q;
	}
	/*
	 * adds a new question specifying the Questionnaire
	 */
	public void addMktQuestion(Questionnaire q, String text) {
		MktQuestion mktQ = new MktQuestion();
		mktQ.setIdQ(q);
		mktQ.setText(text);
		em.persist(mktQ);
	}
}
