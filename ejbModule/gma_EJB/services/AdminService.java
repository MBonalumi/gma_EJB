package gma_EJB.services;


import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.Admin;

@Stateless
public class AdminService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;

	public AdminService() {}
	
	public Admin checkCredentials(String user, String psw) throws Exception {
		Admin admin = null;
		try {
			admin = em.createNamedQuery("Admin.checkCredentials", Admin.class)
					.setParameter(1, user).setParameter(2, psw)
					.getSingleResult();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't check admin credentials");
		}
		
		return admin;
	}
	
}
