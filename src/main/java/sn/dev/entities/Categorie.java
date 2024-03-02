package sn.dev.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Categorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCat")
    private int idCat;
    @Basic
    @Column(name = "nomCat")
    private String nomCat;

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return idCat == categorie.idCat && Objects.equals(nomCat, categorie.nomCat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCat, nomCat);
    }
}
