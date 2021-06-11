package gma_EJB.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;
import gma_EJB.entities.User;

@Stateless
public class UserService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;
	
	public UserService() {}
	
	public User checkCredentials(String user, String psw) throws Exception {	//TODO: throws exceptions?
		List<User> users = null;
		try {
			users = em.createNamedQuery("User.checkCredentials", User.class).setParameter(1, user).setParameter(2, psw)
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't check credentials");
		}
		
		if(users.isEmpty())
			return null;
		//NB: in Album Example he checked for the user to be unique but field username is unique in our DB, so useless
		
		return users.get(0);
	}
	
	public int createUser(String user, String psw, String email) throws Exception {
		//check if user already exists
		Query checkUser = em.createQuery("SELECT x FROM User x WHERE x.username = :username")
					.setParameter("username", user);
		List<User> users = null;
		try {
			users = checkUser.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't check credentials");
		}
		
		if(users != null)
			return -1;	//returns -1 as error === user already exists!
		
		//add user and return 1, i.e. success
		User u = new User();
		u.setUsername(user);
		u.setPsw(psw);
		u.setEmail(email);
		em.persist(u);
		
		return 1;
	}
}
