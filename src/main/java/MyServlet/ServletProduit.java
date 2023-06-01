package MyServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GestionProduit;

import modele.produit;

@WebServlet("*.dao")
public class ServletProduit extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("AjoutProduit.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println("nabdew fi dopost");

// Ajouter
		if (path.equals("/ajouter.dao")) {
			System.out.println("ajout");
			int idp = Integer.parseInt(request.getParameter("id"));
			String nomP = request.getParameter("np");
			float prix = Float.parseFloat(request.getParameter("p"));
			String fournisseur = request.getParameter("f");
			produit pr = new produit(idp, nomP, prix, fournisseur);
			System.out.println("saret ");
			GestionProduit gestionproduit = new GestionProduit();
			produit P = gestionproduit.save(pr);
			System.out.println("save");
			List<produit> res = gestionproduit.findall();
			System.out.println(res);
			request.setAttribute("res", res);
			request.setAttribute("resultat", "produit ajouté avec succès");
			request.getRequestDispatcher("Res.jsp").forward(request, response);
		}

		// Chercher

		else if (path.equals("/chercher.dao")) {
			System.out.println("chercher");
			String MC = request.getParameter("rechercher");
			System.out.println(MC);
			GestionProduit gestionproduit = new GestionProduit();
			List<produit> resultat = gestionproduit.produitsParMC(MC);
			System.out.println(resultat);
			request.setAttribute("resultat", resultat);

			request.getRequestDispatcher("resultat_rechercher.jsp").forward(request, response);
		}

		// Supprimer
		else if (path.equals("/supprimer.dao")) {
			System.out.println("supprimer");
			String idp = request.getParameter("id");
			System.out.println(idp);
			GestionProduit gestionproduit = new GestionProduit();
			gestionproduit.deleteProduit(Integer.parseInt(idp));
			System.out.println("saret parsint");
			List<produit> res = gestionproduit.findall();
			request.setAttribute("res", res);

			request.getRequestDispatcher("Res.jsp").forward(request, response);
		}

		// modifier
		else if (path.equals("/modifier.dao")) {
			System.out.println("modifier");
			String idp = request.getParameter("id");
			System.out.println(idp);

			String nomP = request.getParameter("np");
			float prix = Float.parseFloat(request.getParameter("p"));
			String fournisseur = request.getParameter("f");
			GestionProduit gestionproduit = new GestionProduit();
			produit produit = gestionproduit.getProduit(idp);

			produit.setIdp(Integer.parseInt(idp));
			produit.setFournisseur(fournisseur);
			produit.setPrix(prix);
			produit.setNomP(nomP);
			produit p = gestionproduit.updateProduit(produit);
			List<produit> res = gestionproduit.findall();
			request.setAttribute("res", res);
			request.getRequestDispatcher("Res.jsp").forward(request, response);
		}

		// lister
		else if (path.equals("/lister.dao")) {
			GestionProduit gestionproduit = new GestionProduit();
			List<produit> res = gestionproduit.findall();
			System.out.println(res);
			request.setAttribute("res", res);
			request.setAttribute("resultat", "produit ajouté avec succès");
			request.getRequestDispatcher("Res.jsp").forward(request, response);

		}

	}

}