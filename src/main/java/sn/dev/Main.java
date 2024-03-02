package sn.dev;

import sn.dev.entities.Categorie;
import sn.dev.entities.Produit;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Création d'une fabrique
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        //Création d'un objet EntityManager
        EntityManager em = emf.createEntityManager();
        //Creation d'une transaction
        EntityTransaction et = em.getTransaction();

        try {
            /*Debut de la transaction
            et.begin();
            Produit produit = new Produit();
            produit.setLibelleP("Adapteur");
            produit.setQteP(4);
            produit.setPrixP(4000);
            produit.setCategorieByIdCategorie(em.find(Categorie.class, 1));
            //Persister
            em.persist(produit);
            //Valider la transaction
            et.commit();*/

            /*TypedQuery query = em.createNamedQuery("prodInfo", Produit.class);
            query.setParameter("libelle", "Informatique");
            List<Produit> produits = query.getResultList();
            for (Produit p : produits){
                System.out.println(p);
            }*/

            /*TypedQuery query = em.createNamedQuery("prodInfoPrix", Produit.class);
            query.setParameter(1, "Informatique");
            query.setParameter(2, 20000);
            List<Produit> produits = query.getResultList();
            for (Produit p : produits){
                System.out.println(p);
            }*/

            /*TypedQuery query = em.createNamedQuery("produit", Produit.class);
            query.setParameter("id", 1);
            Produit produit = (Produit) query.getSingleResult();
            System.out.println(produit);*/

            String sql = "SELECT * FROM produit p WHERE p.idCategorie = ?1 AND p.prixP > ?2";
            Query query = em.createNativeQuery(sql, Produit.class);
            query.setParameter(1, 1);
            query.setParameter(2, 2500);
            List<Produit> produits = query.getResultList();
            for (Produit p : produits){
                System.out.println(p);
            }

        }catch (Exception e){
            if(et.isActive())
                et.rollback();
        }

        em.close();
        emf.close();
    }
}