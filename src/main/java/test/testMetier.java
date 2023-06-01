package test;
import dao.IUtilisateur;
import dao.GestionProduit;
import modele.produit;
import dao.UTIL;
import java.util.List;
import modele.utilisateur;
public class testMetier {

    public static void main(String[] args) {
       /* GestionProduit gestionProduit = new GestionProduit();
        produit produit = new produit(15, "acer", 69.69f, "zayedh");

        System.err.println(" ---------------------ajouterProduit-----------------------------");
        gestionProduit.save(produit);

        System.out.println("");

        // Test the getProduitById method
        System.err.println(" ---------------------getProduitById-----------------------------");

        produit produitById = gestionProduit.getProduit("15");
        if (produitById == null) {
            System.out.println("Erreur ");
        } else {
            System.out.println(produitById.toString());
        }

        produit p1 = new produit(15, "achref", 16.69f, "DEL");
        System.out.println("");
        System.err.println(" ---------------------updateProduit-----------------------------");
        // Test the updateProduit method
        gestionProduit.updateProduit(p1);

        System.out.println("");
        System.err.println(" ---------------------deleteProduit-----------------------------");
        // Test the deleteProduit method
        gestionProduit.deleteProduit(15);

        System.out.println("");
        System.err.println(" ---------------------find all-----------------------------");
        // Test the findall method
        List<produit> productList = gestionProduit.findall();
        for (produit p : productList) {
            System.out.println(p.toString());*/
    	
    	//utilisateur ut=new utilisateur("zayedhamadi80@gmail.com","123456");
    	UTIL u=new UTIL();
    	//u.ajouterUtilisateur(ut);
    	/*utilisateur a=u.getUtil("zayedhamadi80@gmail.com");
    	
    	System.out.println(a.toString());
    	
    	System.err.println("update");
    	utilisateur ut=new utilisateur("zayedhamadi80@gmail.com","1919");

    	u.updateUtil(ut);
    	System.out.println(ut.toString());
    	System.err.println("delete ");
    	u.deleteUtil("zayedh80@gmail.com");*/
    	
    System.out.println(u.FindAllUtil());

    	
    	
        }}
    
    
    

