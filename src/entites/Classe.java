package entites;

public class Classe {
    private static int prochainId = 1;

    private int id;
    private String nomClasse;
    private Filliere filliere;
    private Niveau niveau;

    public Classe(Filliere filliere, Niveau niveau) {
        this.id = prochainId++;
        this.filliere = filliere;
        this.niveau = niveau;
        this.nomClasse = generateNomClasse(filliere, niveau);
    }

    private String generateNomClasse(Filliere filliere, Niveau niveau) {
        return niveau.name() + "-" + filliere.name();
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public Filliere getFilliere() {
        return filliere;
    }

    public void setFilliere(Filliere filliere) {
        this.filliere = filliere;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
