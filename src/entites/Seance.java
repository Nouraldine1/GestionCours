package entites;

import java.time.LocalDate;
import java.time.LocalTime;

public class Seance {
    private static int prochainId = 1;

    private int id;
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private String nomCours;
    private Statut statut;

    public Seance(LocalDate date, LocalTime heureDebut, LocalTime heureFin, String nomCours) {
        this.id = prochainId++;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.nomCours = nomCours;
        this.statut = Statut.PLANIFIE;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
}
