package ma.kidda.tpbanquekiddasalaheddine.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import ma.kidda.tpbanquekiddasalaheddine.entity.CompteBancaire;
import ma.kidda.tpbanquekiddasalaheddine.service.GestionnaireCompte;
import ma.kidda.tpbanquekiddasalaheddine.util.Util;

/**
 * Contrôleur JSF pour la création d'un nouveau compte bancaire.
 */
@Named(value = "ajoutCompte")
@ViewScoped
public class AjoutCompte implements Serializable {

    private String nom;
    @PositiveOrZero
    private int montant;
    
    @Inject
    private GestionnaireCompte gc;

    /**
     * Obtient le nom du compte.
     *
     * @return Le nom du compte.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du compte.
     *
     * @param nom Le nom du compte.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le montant initial du compte.
     *
     * @return Le montant initial du compte.
     */
    public int getMontant() {
        return montant;
    }

    /**
     * Définit le montant initial du compte.
     *
     * @param montant Le montant initial du compte.
     */
    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    /**
     * Ajoute un nouveau compte bancaire avec les informations fournies.
     *
     * @return La page de la liste des comptes après la création du compte.
     */
    @Transactional
    public String ajouter() {
        gc.creerCompte(new CompteBancaire(nom, montant));
        Util.addFlashInfoMessage("Compte créé avec succès");
        return "listeComptes?faces-redirect=true";
    }
    
    /**
     * Crée une nouvelle instance de la classe AjoutCompte.
     */
    public AjoutCompte() {
    }
}
