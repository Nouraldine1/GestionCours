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
        for (Seance seance : seances) {
            System.out.println(seance.getDate() + " - " + seance.getHeureDebut() + " a " + seance.getHeureFin() + " : " + seance.getNomCours());
        }
    }
}
