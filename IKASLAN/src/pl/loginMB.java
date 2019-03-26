package pl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named

public class loginMB {
	
	private String usernameLog;
	private String pasahitzaLog;
	private int a;

	
	public loginMB(){
		
	}
	
	public loginMB(String usernameLog,String pasahitzaLog){
		this.usernameLog=usernameLog;
		this.pasahitzaLog=pasahitzaLog;
		
	}

	public String getUsernameLog() {
		return usernameLog;
	}

	public void setUsernameLog(String usernameLog) {
		this.usernameLog = usernameLog;
	}

	public String getPasahitzaLog() {
		return pasahitzaLog;
	}

	public void setPasahitzaLog(String pasahitzaLog) {
		this.pasahitzaLog = pasahitzaLog;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	

}
