package entites;

public class Cours {

    private static int prochainId = 1;
    
    private int id;
    private String nom;
    private String[] classesAssociees;
    private Statut statut;

    public Cours(String nom) {
        this.id = prochainId++;
        this.nom = nom;
        this.statut = Statut.PLANIFIE;
    }

    public Cours(String nom, String[] classesAssociees) {
        this.id = prochainId++;
        this.nom = nom;
        this.classesAssociees = classesAssociees;
        this.statut = Statut.PLANIFIE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String[] getClassesAssociees() {
        return classesAssociees;
    }

    public void setClassesAssociees(String[] classesAssociees) {
        this.classesAssociees = classesAssociees;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
}
