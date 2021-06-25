package gma_EJB.services;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import gma_EJB.entities.LoginHistory;


@Stateless
public class LoginHistoryService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;

	public LoginHistoryService() {}
	
	/*
	 * 
	 */
	public List<Date> getLoginHistory(int idU) {
		
		
		return null;
	}
	
}
