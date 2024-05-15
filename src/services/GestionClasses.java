package services;

import entites.Classe;
import entites.Filliere;
import entites.Niveau;

import java.util.ArrayList;

public class GestionClasses {
    private ArrayList<Classe> classes;

    public GestionClasses() {
        classes = new ArrayList<>();
    }

    public void creerClasse(String nomClasse, Filliere filliere, Niveau niveau) {
        Classe classe = new Classe(nomClasse, filliere, niveau);
        classes.add(classe);
    }

    public void listerClasses() {
        if (classes.isEmpty()) {
            System.out.println("Aucune classe n'a ete creee.");
        } else {
            System.out.println("Liste des classes :");
            for (Classe classe : classes) {
                System.out.println("Nom : " + classe.getNomClasse() + ", Filière : " + classe.getFilliere() + ", Niveau : " + classe.getNiveau());
            }
        }
    }
}
