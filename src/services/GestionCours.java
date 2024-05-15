package services;

import entites.Cours;

import java.util.ArrayList;

public class GestionCours {
    private ArrayList<Cours> cours;

    public GestionCours() {
        cours = new ArrayList<>();
    }

    public void creerCours(String nomCours, String[] classesAssociees) {
        Cours nouveauCours = new Cours(nomCours, classesAssociees);
        cours.add(nouveauCours);
    }

    public void listerCours() {
        if (cours.isEmpty()) {
            System.out.println("Aucun cours n'a ete cree.");
        } else {
            System.out.println("Liste des cours :");
            for (Cours cours : cours) {
                System.out.println("Nom : " + cours.getNom() + ", Statut : " + cours.getStatut());
                System.out.println("Classes associées : ");
                String[] classesAssociees = cours.getClassesAssociees();
                if (classesAssociees != null && classesAssociees.length > 0) {
                    for (String classe : classesAssociees) {
                        System.out.println(classe);
                    }
                } else {
                    System.out.println("Aucune classe associee.");
                }
                System.out.println("--------------");
            }
        }
    }
}
