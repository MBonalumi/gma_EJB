package gma_EJB.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import gma_EJB.entities.LoginHistory;
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
			loginHistory = em.createNamedQuery("LoginHistory.getHistory", LoginHistory.class).setParameter(1, u)
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't get logins history");
		}
		
		List<Date> history = new ArrayList<>();
		loginHistory.forEach(x -> {history.add( ((LoginHistory) x).getTs() ); });
		
		return history;
	}
	
	/*
	 * adds actual timestamp as login time
	 */
	public void addLoginTimestamp(User u) {
		LoginHistory l = new LoginHistory();
		l.setIdU(u);
		l.setTs(new Date());
		em.persist(l);
	}	
}
