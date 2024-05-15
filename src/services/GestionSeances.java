package services;

import entites.Seance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GestionSeances {
    private ArrayList<Seance> seances;

    public GestionSeances() {
        seances = new ArrayList<>();
    }

    public void creerSeance(LocalDate date, LocalTime heureDebut, LocalTime heureFin, String nomCours) {
        Seance seance = new Seance(date, heureDebut, heureFin, nomCours);
        seances.add(seance);
    }

    public void listerSeances() {
        if (seances.isEmpty()) {
            System.out.println("Aucune seance n'a ete creee.");
        } else {
            for (Seance seance : seances) {
                System.out.println(seance.getDate() + " - " + seance.getHeureDebut() + " à " + seance.getHeureFin() + " : " + seance.getNomCours());
            }
        }
    }
}
    