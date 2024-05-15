import entites.*;
import services.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GestionClasses gestionClasses = new GestionClasses();
    private static final GestionCours gestionCours = new GestionCours();
    private static final GestionSeances gestionSeances = new GestionSeances();

    public static void main(String[] args) {
        boolean continuer = true;

        while (continuer) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine();  

            switch (choix) {
                case 1:
                    creerClasse();
                    break;
                case 2:
                    creerCours();
                    break;
                case 3:
                    creerSeance();
                    break;
                case 4:
                    listerClasses();
                    break;
                case 5:
                    listerCours();
                    break;
                case 6:
                    listerSeances();
                    break;
                case 7:
                    continuer = false;
                    System.out.println("Merci d'avoir utilise notre application !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\nMenu :");
        System.out.println("1. Creer une classe");
        System.out.println("2. Creer un cours");
        System.out.println("3. Creer une seance");
        System.out.println("4. Lister les classes");
        System.out.println("5. Lister les cours");
        System.out.println("6. Lister les seances");
        System.out.println("7. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void creerClasse() {
        System.out.print("Nom de la classe : ");
        String nomClasse = scanner.nextLine();

        System.out.print("Filière (IAGE ou MAE) : ");
        String filiereString = scanner.nextLine();
        Filliere filliere = Filliere.valueOf(filiereString.toUpperCase());

        System.out.print("Niveau (L1, L2, L3, M1, M2) : ");
        String niveauString = scanner.nextLine();
        Niveau niveau = Niveau.valueOf(niveauString.toUpperCase());

        gestionClasses.creerClasse(nomClasse, filliere, niveau);
        System.out.println("Classe creee avec succès !");
    }

    private static void creerCours() {
        System.out.print("Nom du cours : ");
        String nomCours = scanner.nextLine();

        // Demander les classes associees au cours
        System.out.println("Combien de classes associees a ce cours ?");
        int nombreClasses = scanner.nextInt();
        scanner.nextLine();  

        String[] classesAssociees = new String[nombreClasses];
        for (int i = 0; i < nombreClasses; i++) {
            System.out.print("Nom de la classe associee " + (i + 1) + " : ");
            classesAssociees[i] = scanner.nextLine();
        }

        gestionCours.creerCours(nomCours, classesAssociees);
        System.out.println("Cours cree avec succès !");
    }

    private static void creerSeance() {
        System.out.print("Date de la seance (Annee-Mois-Jour) : ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr);

        System.out.print("Heure de debut de la seance (H:M) : ");
        String heureDebutStr = scanner.nextLine();
        LocalTime heureDebut = LocalTime.parse(heureDebutStr);

        System.out.print("Heure de fin de la seance (H:M) : ");
        String heureFinStr = scanner.nextLine();
        LocalTime heureFin = LocalTime.parse(heureFinStr);

        System.out.print("Nom du cours de la seance : ");
        String nomCours = scanner.nextLine();

        gestionSeances.creerSeance(date, heureDebut, heureFin, nomCours);
        System.out.println("Seance creee avec succès !");
    }

    private static void listerClasses() {
        System.out.println("Liste des classes :");
        gestionClasses.listerClasses();
    }

    private static void listerCours() {
        System.out.println("Liste des cours :");
        gestionCours.listerCours();
    }

    private static void listerSeances() {
        System.out.println("Liste des seances :");
        gestionSeances.listerSeances();
    }
}
