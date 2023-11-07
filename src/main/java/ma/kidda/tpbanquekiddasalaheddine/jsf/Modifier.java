/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.kidda.tpbanquekiddasalaheddine.jsf;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import ma.kidda.tpbanquekiddasalaheddine.entity.CompteBancaire;
import ma.kidda.tpbanquekiddasalaheddine.service.GestionnaireCompte;
import ma.kidda.tpbanquekiddasalaheddine.util.Util;


@Named(value = "modifier")
@ViewScoped
public class Modifier implements Serializable {

    private Long id;
    private CompteBancaire compte;
    private String nom;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void loadCompte() {
        compte = gestionnaireCompte.getCompte(id);
    }

    public String enregistrerModification() {
        Util.addFlashInfoMessage("Nom " + compte.getNom() + " changé en " + nom);
        compte.setNom(nom);
        gestionnaireCompte.update(compte);
        return "listeComptes?faces-redirect=true";
    }

}
