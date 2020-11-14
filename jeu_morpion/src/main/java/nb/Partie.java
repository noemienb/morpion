package nb;

import java.util.Scanner;



/**
 * Hello world!
 */
public final class Partie {
    private Partie() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    

    public static void main(String[] args) {
        //scanner pour lire les strings
        Scanner userInputReader = new Scanner(System.in);

        Grille grille = new Grille();
        grille.instructionGrille();
        System.out.println("welcome au jeu du morpion");
        System.out.println("placer un pion");

//convertir String en entier utiliser la methode integer.parseInt
        int position = Integer.parseInt(userInputReader.nextLine());
    grille.placePion(position, "X");

       
     boolean isGameEnCours = JoueurGagne.resolve(grille.getGrille())==JoueurGagne.EtatDuJeu.EN_COURS;

        while( isGameEnCours && !grille.isPlein()){

            grille.placePionRandom("O");
            grille.afficherGrille();
            System.out.println("placer un pion");
            position = Integer.parseInt(userInputReader.nextLine());
            grille.placePion(position, "X");

            isGameEnCours = JoueurGagne.resolve(grille.getGrille())==JoueurGagne.EtatDuJeu.EN_COURS;

        }
        if(!isGameEnCours) {
            grille.afficherGrille();
            System.out.print(" perdu");
        }
       
        else grille.afficherGrille();
    }
   
}
