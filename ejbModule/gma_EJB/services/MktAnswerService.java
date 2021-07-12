package gma_EJB.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.MktAnswer;
import gma_EJB.entities.MktQuestion;
import gma_EJB.entities.User;

@Stateless
public class MktAnswerService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;

	public MktAnswerService() {}
	
	/*
	 * adds a new answer of a marketing question
	 */
	public void addMktAnswer(MktQuestion q, User u, String text) {
		MktAnswer ans = new MktAnswer();
		ans.setIdM(q);
		ans.setIdU(u);
		ans.setText(text);
		em.persist(ans);
	}
	
	public MktAnswer getMktAnswer(MktQuestion m, User u) throws Exception {
		MktAnswer a = null;
		try {
			a = em.createNamedQuery("MktAnswer.getFromQuestionAndUser", MktAnswer.class).setParameter(1, m).setParameter(2, u)
					.getSingleResult();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't retrieve mkt answer! Can be that two values for mktquestion and user exist in the database");
		}
		
		return a;
	}
	
	/*
	 * all answers for a question
	 */
	public List<MktAnswer> getMktAnswers(MktQuestion m) throws Exception {
		List<MktAnswer> a = null;
		try {
			a = em.createNamedQuery("MktAnswer.getAllFromQuestion", MktAnswer.class).setParameter(1, m)
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't retrieve mkt answers for the given questionnaire! ");
		}
		
		return a;
	}
}
