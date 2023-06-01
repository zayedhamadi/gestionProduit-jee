package dao;

import java.util.List;

import modele.utilisateur;

public interface IUtilisateur {
	public boolean checkUser(utilisateur u);

	public utilisateur ajouterUtilisateur(utilisateur u);

	public utilisateur updateUtil(utilisateur u);

	public void deleteUtil(String u);

	public utilisateur getUtil(String u);

	public List<utilisateur> FindAllUtil();
}
