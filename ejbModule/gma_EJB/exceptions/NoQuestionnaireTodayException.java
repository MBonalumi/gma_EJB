package gma_EJB.exceptions;


public class NoQuestionnaireTodayException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoQuestionnaireTodayException(String message) {
		super(message);
	}
}
