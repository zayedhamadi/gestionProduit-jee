package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.produit;
import dao.IProduitDao;
import java.util.List;
import modele.produit;

public class GestionProduit implements IProduitDao {
    private ArrayList<produit> listeProduit;

    public GestionProduit() {
        setListeProduit(new ArrayList<>());
    }

    @Override
    public produit save(produit p) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO produit VALUES(?,?,?,?)");
            ps.setLong(1, p.getIdp());
            ps.setNString(2, p.getNomP());
            ps.setDouble(3, p.getPrix());
            ps.setString(4, p.getFournisseur());
            ps.executeUpdate();

            ps.close();
            System.out.println("done add");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<produit> produitsParMC(String mc) {
        Connection conn = SingletonConnection.getConnection();
        List<produit> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM produit WHERE nom_Produit LIKE ?");
            ps.setString(1, "%" + mc + "%");
            ResultSet result = ps.executeQuery();
            
            System.out.println("result set: " + result);
            while (result.next()) {
                produit p = new produit(Integer.parseInt(result.getString(1)),result.getString(2),result.getFloat(3),result.getString(4));
               

                list.add(p);
            }
            ps.close();
            System.out.println("Done produitsParMC");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public produit getProduit(String Réf) {
        Connection conn = SingletonConnection.getConnection();
        produit p = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM produit WHERE id_Produit=?");
            ps.setString(1, Réf);
            ResultSet set = ps.executeQuery();
            if (set.next()) {
                p = new produit(set.getInt("id_Produit"), set.getString("nom_Produit"),
                        Float.parseFloat(set.getString("prix")), set.getString("fornisseur"));
                return p;
            }
            ps.close();
            System.out.println("done getProduit");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public produit updateProduit(produit p) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE produit  SET nom_Produit = ?, fornisseur = ?, prix = ? WHERE id_Produit = ?");
            ps.setString(1, p.getNomP());
            ps.setString(2, p.getFournisseur());
            ps.setFloat(3, p.getPrix());
            ps.setInt(4, p.getIdp());
            int update = ps.executeUpdate();
            if (update > 0)
                System.out.println("update avec succès");
            else
                System.out.println("failed to update");
            ps.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return p;
    }

    @Override
    public void deleteProduit(int  Réf) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM produit  WHERE id_Produit = ?");
            ps.setInt(1, Réf);
            int update = ps.executeUpdate();
            if (update > 0)
                System.out.println("delete avec succès");
            else
                System.out.println("failed to delete");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<produit> findall() {
    	 Connection conn = SingletonConnection.getConnection();
    	
    	 listeProduit=new ArrayList<>();

        try {
        	 PreparedStatement ps = conn.prepareStatement("SELECT * FROM produit");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                produit p = new produit(rs.getInt("id_Produit"), rs.getString("nom_Produit"), rs.getFloat("prix"),
                        rs.getString("fornisseur"));
                listeProduit.add(p);
            }

            ps.close();
            rs.close();
            System.out.println("done find all");
        }catch (SQLException e) {
         System.out.println("probleme ta3 find all");   e.printStackTrace();
        }

        return listeProduit;
    }

	public ArrayList<produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(ArrayList<produit> listeProduit) {
		this.listeProduit = listeProduit;
	}
}
