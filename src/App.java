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
        Filliere filliere = null;
        while (filliere == null) {
            System.out.println("Choisissez la filière :");
            System.out.println("1. IAGE");
            System.out.println("2. MAE");
            int choixFiliere = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le saut de ligne
    
            switch (choixFiliere) {
                case 1:
                    filliere = Filliere.IAGE;
                    break;
                case 2:
                    filliere = Filliere.MAE;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
                    break;
            }
        }
    
        Niveau niveau = null;
        while (niveau == null) {
            System.out.println("Choisissez le niveau :");
            System.out.println("1. L1");
            System.out.println("2. L2");
            System.out.println("3. L3");
            System.out.println("4. M1");
            System.out.println("5. M2");
            int choixNiveau = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le saut de ligne
    
            switch (choixNiveau) {
                case 1:
                    niveau = Niveau.L1;
                    break;
                case 2:
                    niveau = Niveau.L2;
                    break;
                case 3:
                    niveau = Niveau.L3;
                    break;
                case 4:
                    niveau = Niveau.M1;
                    break;
                case 5:
                    niveau = Niveau.M2;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
                    break;
            }
        }
    
        gestionClasses.creerClasse(filliere, niveau);
        System.out.println("Classe créée avec succès !");
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
        System.out.println("Cours cree avec succes !");
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
        System.out.println("Seance creee avec succes !");
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
