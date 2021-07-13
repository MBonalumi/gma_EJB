package gma_EJB.services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

import gma_EJB.entities.OffensiveWords;


@Stateless
public class OffensiveWordsService {
	@PersistenceContext(unitName="gma_EJB")
	private EntityManager em;

	public OffensiveWordsService() {}

	
	/*
	 * returns List<String> of offensive words
	 */
	public List<String> getOffensiveWords() throws Exception {
		List<OffensiveWords> offWords = null;
		try {
			offWords = em.createNamedQuery("OffensiveWords.getWords", OffensiveWords.class).setHint("javax.persistence.cache.storeMode", "REFRESH")
					.getResultList();
		}catch(PersistenceException e) {
			throw new Exception("Database error! Can't get offensive words");
		}
		
		List<String> words = new ArrayList<>();
		offWords.forEach(x -> {words.add( ((OffensiveWords) x).getWord() );} );
		
		return words;
	}
}
