package gma_EJB.entities;

import java.io.Serializable;

public class StatAnswersID implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private int idU;
	private int idQ;
	
	
	public StatAnswersID() {}
	public StatAnswersID(int idU, int idQ) {
		super();
		this.idU = idU;
		this.idQ = idQ;
	}
	
	
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public int getIdQ() {
		return idQ;
	}
	public void setIdQ(int idQ) {
		this.idQ = idQ;
	}
	
	
	//TODO: capire se è indispensabile fare questi override, mi sembra di sì
	@Override
	public int hashCode() {		return super.hashCode();	}
	@Override
	public boolean equals(Object obj) {		return super.equals(obj);	}

}
