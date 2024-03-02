package sn.dev.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQuery(query = "SELECT p FROM Produit p WHERE p.categorieByIdCategorie.nomCat = :libelle", name = "prodInfo")
@NamedQuery(query = "SELECT p FROM Produit p WHERE p.idP = :id", name = "produit")
@NamedQuery(query = "SELECT p FROM Produit p WHERE p.categorieByIdCategorie.nomCat = ?1 AND p.prixP > ?2", name = "prodInfoPrix")
public class Produit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idP")
    private int idP;
    @Basic
    @Column(name = "libelleP")
    private String libelleP;
    @Basic
    @Column(name = "qteP")
    private Integer qteP;
    @Basic
    @Column(name = "prixP")
    private Integer prixP;
    @ManyToOne
    @JoinColumn(name = "idCategorie", referencedColumnName = "idCat")
    private Categorie categorieByIdCategorie;

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getLibelleP() {
        return libelleP;
    }

    public void setLibelleP(String libelleP) {
        this.libelleP = libelleP;
    }

    public Integer getQteP() {
        return qteP;
    }

    public void setQteP(Integer qteP) {
        this.qteP = qteP;
    }

    public Integer getPrixP() {
        return prixP;
    }

    public void setPrixP(Integer prixP) {
        this.prixP = prixP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return idP == produit.idP && Objects.equals(libelleP, produit.libelleP) && Objects.equals(qteP, produit.qteP) && Objects.equals(prixP, produit.prixP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idP, libelleP, qteP, prixP);
    }

    public Categorie getCategorieByIdCategorie() {
        return categorieByIdCategorie;
    }

    public void setCategorieByIdCategorie(Categorie categorieByIdCategorie) {
        this.categorieByIdCategorie = categorieByIdCategorie;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idP=" + idP +
                ", libelleP='" + libelleP + '\'' +
                ", qteP=" + qteP +
                ", prixP=" + prixP +
                ", categorieByIdCategorie=" + categorieByIdCategorie +
                '}';
    }
}
