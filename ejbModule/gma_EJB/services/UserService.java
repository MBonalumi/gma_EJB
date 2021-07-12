package gma_EJB.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.Admin;
import gma_EJB.entities.Questionnaire;
import gma_EJB.entities.User;

@Stateless
public class UserService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;
	
	@EJB(name="gma_EJB.services/LoginHistoryService")
	LoginHistoryService lServ;
	
	public UserService() {}
	
	/*
	 * -----DEBUG-----
	 */
//	@EJB(name="gma_EJB.services/ReviewService")
//	ReviewService rServ;
//	@EJB(name="gma_EJB.services/QuestionnaireService")
//	QuestionnaireService qServ;
//	@EJB(name="gma_EJB.services/ProductService")
//	ProductService pServ;
//	@EJB(name="gma_EJB.services/OffensiveWordsService")
//	OffensiveWordsService wServ;
//	@EJB(name="gma_EJB.services/StatAnswersService")
//	StatAnswersService sServ;	
	
	/*
	 * RETURN:
	 * 		User	if checked correctly
	 * 		null	otherwises
	 */
	public User checkCredentials(String user, String psw) throws Exception {	//TODO: throws exceptions?
	
		/*
		 * -----DEBUG-----
		 */
//		Questionnaire q1 = null;
		// ---------------
		
		List<User> users = null;
		try {
			users = em.createNamedQuery("User.checkCredentials", User.class).setParameter(1, user).setParameter(2, psw)
					.getResultList();
//			q1 = em.createNamedQuery("Questionnaire.getByDate", Questionnaire.class)
//					.setParameter(1, new Date(121, 6, 8))
//					.getSingleResult();
			
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't check credentials");
		}
		
		if(users.isEmpty())
			return null;
		//NB: in Album Example he checked for the user to be unique but field username is unique in our DB, so useless
		
		return users.get(0);
	}
	
	/*
	 * RETURN:
	 * 		1		user has been created
	 * 		-1		username already taken
	 */
	public int createUser(String username, String psw, String email) throws Exception {
		List<User> users = null;
		try {
			users = em.createNamedQuery("User.getUser", User.class)
					.setParameter(1, username)
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't check credentials");
		}
		
		if(!users.isEmpty())
			return -1;	//returns -1 as error === user already exists!
		
		//add user and return 1, i.e. success
		User u = new User();
		u.setUsername(username);
		u.setPsw(psw);
		u.setEmail(email);
		em.persist(u);
		
		return 1;
	}
	
	/*
	 * RETURN:
	 * 		1		user has been banned
	 * 		0		user is not banned
	 * 	exception	checked ban on non-existing user
	 */
	public int checkBan(String username) throws Exception {
		List<User> users = null;
		try {
			users = em.createNamedQuery("User.getUser", User.class)
					.setParameter(1, username)
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't check credentials");
		}
		
		if(users.isEmpty()) {
			throw new Exception("Error! Ban check on non-registered users shouldn't be asked");
		}
		
		if(users.get(0).getBan() == true)
			return 1;
		
		return 0;
	}
	
	/*
	 * at the end user _username_ is banned
	 */
	/*public void ban(String username) throws Exception{
		List<User> users = null;
		try {
			users = em.createNamedQuery("User.getUser", User.class)
					.setParameter(1, username)
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't check credentials");
		}
		
		if(users.isEmpty()) {
			throw new Exception("Error! Trying to ban non-existing user");
		}
		
		users.get(0).setBan(true);
	}*/
	public void ban(User u) {
		u.setBan(true);
		em.merge(u);
	}
	
	/*
	 * 
	 */
	public List<User> getUsers() throws Exception {
		List<User> users = null;
		try {
			users = em.createNamedQuery("User.getUsers", User.class)
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't get users");
		}
		
		return users;
	}
	public List<User> getUsersRanking() throws Exception {
		List<User> users = null;
		try {
			users = em.createNamedQuery("User.getUsersRanking", User.class)
					.setHint("javax.persistence.cache.storeMode", "REFRESH")
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't get rankings");
		}
		//em.refresh(users);
		
		return users;
	}
}


