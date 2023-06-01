package modele;

public class User {
	
    private String user;
    private String pw;

    public User(String user, String pw) {
	
		this.user = user;
		this.pw = pw;
	}

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

    public boolean check() {
        if (this.user.equals("zayedh80@gmail.com") && this.pw.equals("zayed123")) {
        	System.out.println("connected");
            return true;
        }
        return false;
    }
}
