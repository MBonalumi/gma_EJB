package gma_EJB.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class LoginHistoryID implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idU;
	private Timestamp ts;
	
	public LoginHistoryID() {}
	public LoginHistoryID(int idU, Timestamp ts) {
		this.idU = idU;
		this.ts = ts;
	}
	
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	
	//TODO: capire se è indispensabile fare questi override, mi sembra di sì
	@Override
	public int hashCode() {		return super.hashCode();	}
	@Override
	public boolean equals(Object obj) {		return super.equals(obj);	}
}
