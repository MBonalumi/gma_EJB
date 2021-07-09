package gma_EJB.services;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.Admin;

@Stateless
public class AdminService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;

	public AdminService() {}
	
	public Admin checkCredentials(String user, String psw) throws Exception {
		List<Admin> admins = null;
		try {
			admins = em.createNamedQuery("Admin.checkCredentials", Admin.class)
					.setParameter(1, user).setParameter(2, psw)
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't check admin credentials");
		}
		
		if(admins.isEmpty())
			return null;
		
		return admins.get(0);
	}
	
}
