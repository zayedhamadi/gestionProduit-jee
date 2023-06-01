package dao;

import java.util.List;

import modele.produit;


public interface IProduitDao {
	public produit save(produit p);
	public  List<produit>  produitsParMC(String  mc);
	public produit getProduit(String Réf); 
	public  produit  updateProduit(produit  p); 
	public  void  deleteProduit(int Réf);
	public List<produit> findall();

}
