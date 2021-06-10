package gma_EJB.entities;

import java.io.Serializable;

public class MktAnswerID implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idM;
	private int idU;
		
	
	public MktAnswerID() {}
	public MktAnswerID(int idM, int idU) {
		this.idM = idM;
		this.idU = idU;
	}
	
	
	public int getIdM() {
		return idM;
	}
	public void setIdM(int idM) {
		this.idM = idM;
	}
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	
	
	//TODO: capire se è indispensabile fare questi override, mi sembra di sì
	@Override
	public int hashCode() {		return super.hashCode();	}
	@Override
	public boolean equals(Object obj) {		return super.equals(obj);	}
}
