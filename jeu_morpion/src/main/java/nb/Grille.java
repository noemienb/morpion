package nb;

import java.util.Random;

public class Grille {
    //la grille peut avoir 3 etats :
      // 0= vide
    // 1=  X
    // 2 = O
    public int[][] grille= new int[3][3];


    //instruire la grille pour voir ou se trouve les nb 

    public void instructionGrille(){
        System.out.println("| - | - | - |");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("| - | - | - |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| - | - | - |");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("| - | - | - |");
    }


    //afficher la grille du jeu

    public void afficherGrille(){
        System.out.println("| - | - | - |");
        System.out.println(printGrilleLigne(0));
        System.out.println("| - | - | - |");
        System.out.println(printGrilleLigne(1));
        System.out.println("| - | - | - |");
        System.out.println(printGrilleLigne(2));
        System.out.println("| - | - | - |");
    }

    //imprimer la grille 
    private String printGrilleLigne(int ligne){ 

        StringBuilder ligneBuilder = new StringBuilder("| ");
        for(int i=0;i<grille[0].length;i++){
            if(grille[ligne][i] == 0) ligneBuilder.append(" ");
            if(grille[ligne][i] == 1) ligneBuilder.append("X");
            if(grille[ligne][i] == 2) ligneBuilder.append("O");
            ligneBuilder.append(" | ");
        }
        ligneBuilder.deleteCharAt(ligneBuilder.lastIndexOf(" "));
        return ligneBuilder.toString();
    }

    //placer un pion 

    public boolean placePion(int position, String pionType){ 
        int ligne = (position-1)/3;
        int colonne = (position - (ligne*3))-1;
        if(grille[ligne][colonne] == 0) {
            if (pionType.equals("X")) grille[ligne][colonne] = 1;
            if (pionType.equals("O")) grille[ligne][colonne] = 2;
            return true;
        }
        return false;
    
    }
//placer un pion aleatoire
    public boolean placePionRandom(String pionType){ 
        int ligne = new Random().nextInt(3);
        int colonne = new Random().nextInt(3);
        boolean pionPlace = false;
        while(!pionPlace && !isPlein()) {
            if(grille[ligne][colonne]==0) {
                pionPlace=true;
                if (pionType.equals("X")) grille[ligne][colonne] = 1;
                if (pionType.equals("O")) grille[ligne][colonne] = 2;
            }else{
                ligne = new Random().nextInt(3);
                colonne = new Random().nextInt(3);
            
            }
        }
        return pionPlace= false;
    }
        
    //remplir la grille

    public boolean isPlein(){ 
        for(int ligne=0;ligne<grille.length;ligne++){
            for(int colonne=0;colonne<grille[0].length;colonne++){
                if (grille[ligne][colonne]==0) return false;
            }
        }
        return true;
    }

    
    public int[][] getGrille(){
        return grille;
    }

    public static class Cell{
        public int ligne;
        public int colonne;

        public Cell(int ligne, int colonne){
            this.ligne = ligne;
            this.colonne = colonne;
        }
    }
}