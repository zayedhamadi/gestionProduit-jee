package modele;

public class produit {
    private int idp;
    private float prix;
    private String nomP;
    private String fournisseur;


    public produit(int idp, String nomP, float prix, String fournisseur) {
        this.idp = idp;
        this.nomP = nomP;
        this.prix = prix;
        this.fournisseur = fournisseur;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return "Produit [idp=" + idp + ", prix=" + prix + ", nomP=" + nomP + ", fournisseur=" + fournisseur + "]";
    }
}
