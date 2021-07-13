package gma_EJB.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import gma_EJB.entities.LoginHistory;
import gma_EJB.entities.Questionnaire;
import gma_EJB.entities.User;


@Stateless
public class LoginHistoryService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;
	
	public LoginHistoryService() {}
	
	/*
	 * returns a list of timestamps
	 */
	public List<Date> getLoginHistory(User u) throws Exception {
		List<LoginHistory> loginHistory = null;
		try {
			loginHistory = em.createNamedQuery("LoginHistory.getHistory", LoginHistory.class).setParameter(1, u).setHint("javax.persistence.cache.storeMode", "REFRESH")
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't get logins history");
		}
		
		List<Date> history = new ArrayList<>();
		loginHistory.forEach(x -> {history.add( ((LoginHistory) x).getTs() ); });
		
		return history;
	}
	
	/*
	 * returns a list of timestamps
	 */
	public List<LoginHistory> getCancelList(Questionnaire q) throws Exception {
		List<LoginHistory> loginHistory = null;
		try {
			loginHistory = em.createNamedQuery("LoginHistory.getCancelList", LoginHistory.class).setParameter(1, q).setHint("javax.persistence.cache.storeMode", "REFRESH")
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't get logins history");
		}
		
		return loginHistory;
	}
	
	/*
	 * adds actual timestamp as login time
	 */
	public void addLoginTimestamp(User u, Date d, Questionnaire q) {
		LoginHistory l = new LoginHistory();
		l.setIdU(u);
		l.setTs(d);
		l.setIdQ(q);
		// nope u.addLogin(l);
		em.persist(l);
	
	}	
}
