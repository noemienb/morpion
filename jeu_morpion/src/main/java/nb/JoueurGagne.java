package nb;

public class JoueurGagne{

//on va enumerer comment le joueur peut gagner 
//ily a 8 directions que l on va verifier
//creation d une variable isCellOutOfBoard pour eviter d acceder à des cellules qui sont hors du tableau

public enum EtatDuJeu {
    EN_COURS,X_GAGNE,O_GAGNE; 
  
    public static EtatDuJeu calculateEtatDuJeu(int[][] grille, Grille.Cell position){

        int pionType = grille[position.ligne][position.colonne];
        if (pionType == 0) return EtatDuJeu.EN_COURS;

        // v
        boolean isCellOutOfBoard = (position.ligne-1 < 0);
        if (!isCellOutOfBoard && (grille[position.ligne-1][position.colonne] == pionType)){
            isCellOutOfBoard = (position.ligne-2<0);
            if(!isCellOutOfBoard && (grille[position.ligne-2][position.colonne] == pionType)){
                return pionType==1?EtatDuJeu.X_GAGNE:EtatDuJeu.O_GAGNE;
            }
        }
        //diag 1
        isCellOutOfBoard = (position.ligne-1<0) || (position.colonne+1>grille[0].length-1);
        if ( !isCellOutOfBoard && (grille[position.ligne-1][position.colonne+1] == pionType)){
            isCellOutOfBoard = (position.ligne-2<0) || (position.colonne+2>grille[0].length-1);
            if(!isCellOutOfBoard && (grille[position.ligne-2][position.colonne+2] == pionType)){
                return pionType==1?EtatDuJeu.X_GAGNE:EtatDuJeu.O_GAGNE;
            }
        }
// h1
isCellOutOfBoard = (position.colonne+1>grille[0].length-1);
if ( !isCellOutOfBoard && (grille[position.ligne][position.colonne+1] == pionType)){
    isCellOutOfBoard = (position.colonne+2>grille[0].length-1);
    if(!isCellOutOfBoard && (grille[position.ligne][position.colonne+2] == pionType)){
        return pionType==1?EtatDuJeu.X_GAGNE:EtatDuJeu.O_GAGNE;
    }
}

// v2
isCellOutOfBoard =position.ligne+1>grille.length-1 || (position.colonne+1>grille[0].length-1);
if ( !isCellOutOfBoard && (grille[position.ligne+1][position.colonne+1] == pionType)){
    isCellOutOfBoard = position.ligne+2>grille.length-1 || (position.colonne+2>grille[0].length-1);
    if(!isCellOutOfBoard && (grille[position.ligne+2][position.colonne+2] == pionType)){
        return pionType==1?EtatDuJeu.X_GAGNE:EtatDuJeu.O_GAGNE;
    }
}
 // v3
 isCellOutOfBoard =position.ligne+1>grille.length-1;
 if ( !isCellOutOfBoard && (grille[position.ligne+1][position.colonne] == pionType)){
     isCellOutOfBoard = position.ligne+2>grille.length-1;
     if(!isCellOutOfBoard && (grille[position.ligne+2][position.colonne] == pionType)){
         return pionType==1?EtatDuJeu.X_GAGNE:EtatDuJeu.O_GAGNE;
     }
 }

// h2 
        isCellOutOfBoard =position.ligne+1>grille.length-1 || (position.colonne-1<0);
        if ( !isCellOutOfBoard && (grille[position.ligne+1][position.colonne] == pionType)){
            isCellOutOfBoard =position.ligne+2>grille.length-1 || (position.colonne-2<0);
            if(!isCellOutOfBoard && (grille[position.ligne+2][position.colonne-2] == pionType)){
                return pionType==1?EtatDuJeu.X_GAGNE:EtatDuJeu.O_GAGNE;
            }
        }
// h3
isCellOutOfBoard = (position.colonne-1<0);
if ( !isCellOutOfBoard && (grille[position.ligne][position.colonne-1] == pionType)){
    isCellOutOfBoard =(position.colonne-2<0);
    if(!isCellOutOfBoard && (grille[position.ligne][position.colonne-2] == pionType)){
        return pionType==1?EtatDuJeu.X_GAGNE:EtatDuJeu.O_GAGNE;
    }
}
// diag 2 
isCellOutOfBoard = (position.ligne-1<0) || (position.colonne-1<0);
if ( !isCellOutOfBoard && (grille[position.ligne-1][position.colonne-1] == pionType)){
    isCellOutOfBoard = (position.ligne-2<0) || (position.colonne-2<0);
    if(!isCellOutOfBoard && (grille[position.ligne-2][position.colonne-2] == pionType)){
        return pionType==1?EtatDuJeu.X_GAGNE:EtatDuJeu.O_GAGNE;
    }
}

return EtatDuJeu.EN_COURS;
}


public static EtatDuJeu resolve(int[][] grille) {
    for(int ligne=0;ligne<grille.length;ligne++){
        for(int colonne=0;colonne<grille[0].length;colonne++){
             EtatDuJeu etatDuJeu = calculateEtatDuJeu(grille,new Grille.Cell(ligne,colonne));
            if(etatDuJeu!=EtatDuJeu.EN_COURS){
                return etatDuJeu;
            }
        }
    }

    return EtatDuJeu.EN_COURS;
}
}

public static EtatDuJeu resolve(int[][] grille) {
	return null;
}
}

