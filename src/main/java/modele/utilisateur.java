package modele;

public class utilisateur {

    private String user;
    private String pw;
    
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public utilisateur( String user, String pw) {
		
		
		this.user = user;
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "utilisateur [ user=" + user + ", pw=" + pw + "]\n";
	}

	
	
}
