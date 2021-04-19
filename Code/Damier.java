import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Damier extends JPanel{
	
	private int TAILLE; //taille de la fenêtre
	private int taille; //taille=8 pour un plateau 8*8 par exemple
	private Case[][] grille;  //tableau de cases
	private boolean tourBlanc;  //savoir à qui est le tour
	private int nombre;


	public Damier(int TAILLE,int taille) {
		this.TAILLE=TAILLE;
		this.taille=taille;
		this.tourBlanc=true;
		this.grille = new Case[taille][taille];
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				if ( (i+j)%2==0 ) {
					grille[i][j]= new Case(Couleur.Blanc);
				}
				else {
					if (j<=(taille-2)/2-1) {
						grille[i][j]= new Case(Couleur.Noir,Couleur.Noir);
					}
					else {
						if (j>=taille/2+1) {
							grille[i][j]= new Case(Couleur.Noir,Couleur.Blanc);
						}
						else {
							grille[i][j]= new Case(Couleur.Noir);
						}
					}
				}
			}
		}
	}
	
	public int getTaille() {
		return taille;
	}
	
	public int getTAILLE() {
		return TAILLE;
	}
	
	public Case[][] getGrille(){
		return grille;
	}
	
	public boolean getTourBlanc() {
		return tourBlanc;
	}

	public void setTourBlanc(boolean tourBlanc) {
		this.tourBlanc = tourBlanc;
	}

	public void afficherSaut(int x, int y) {
		
	}
		
	public void afficherDeplacement() {
		for (int i=0;i<this.taille;i++) {
			for (int j=0;j<this.taille;j++) {
				if (grille[i][j].getClique()&&(grille[i][j].getPiece()!=null)) {  //repère la case cliquée
					if ((tourBlanc)&&(grille[i][j].getPiece().getCouleur()==Couleur.Blanc)) {	//tour au blanc
						if ((i<taille-1)&&(j>0)) {
							if (grille[i+1][j-1].getPiece()==null) {	//
								grille[i+1][j-1].setPossibleClique(true);
							}
							else{
								if (grille[i+1][j-1].getPiece().getCouleur()==Couleur.Noir) {
									if ((i<taille-2)&&(j>1)) {
										if (grille[i+2][j-2].getPiece()==null) {  //saut de pion
											grille[i+2][j-2].setPossibleClique(true);
										}
									}
								}
							}
						}
						if ((i>0)&&(j>0)) {
							if (grille[i-1][j-1].getPiece()==null) {
								grille[i-1][j-1].setPossibleClique(true);
							}
							else {
								if (grille[i-1][j-1].getPiece().getCouleur()==Couleur.Noir) {
									if ((i>1)&&(j>1)) {
										if (grille[i-2][j-2].getPiece()==null) {
											grille[i-2][j-2].setPossibleClique(true);
										}
									}
								}
							}
						}
					}
					if ((!tourBlanc)&&(grille[i][j].getPiece().getCouleur()==Couleur.Noir)) {  //tour noir
						if ((i<taille-1)&&(j<taille-1)) {
							if (grille[i+1][j+1].getPiece()==null) {
								grille[i+1][j+1].setPossibleClique(true);
							}
							else{
								if (grille[i+1][j+1].getPiece().getCouleur()==Couleur.Blanc) {
									if ((i<taille-2)&&(j<taille-2)) {
										if (grille[i+2][j+2].getPiece()==null) {
											grille[i+2][j+2].setPossibleClique(true);
										}
									}
								}
							}
						}
						if ((i>0)&&(j<taille-1)) {
							if (grille[i-1][j+1].getPiece()==null) {
								grille[i-1][j+1].setPossibleClique(true);
							}
							else{
								if (grille[i-1][j+1].getPiece().getCouleur()==Couleur.Blanc) {
									if ((i>1)&&(j<taille-2)) {
										if (grille[i-2][j+2].getPiece()==null) {
											grille[i-2][j+2].setPossibleClique(true);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void deplacer(int x, int y, boolean tourBlanc) {
		Coordonnees c = new Coordonnees(); //coordonnées de la pièce sautée
		Coordonnees c2 = new Coordonnees(); 
		
		if (tourBlanc) {	//piece blanche
			grille[x][y].setPiece(new Piece(Couleur.Blanc));
		}
		else {	//piece noire
			grille[x][y].setPiece(new Piece(Couleur.Noir));
		}
		
		for (int i=0;i<this.taille;i++) {	//enlever le premier clique (choix de la pièce)
			for (int j=0;j<this.taille;j++) {
				grille[i][j].setSaut(false);
				if (grille[i][j].getClique()) {  //i et j sont les coordonnées de la pièce avant d'etre déplacée
					grille[i][j].click();
					grille[i][j].setPiece(null);
					c=pieceMangee(x,y,i,j,tourBlanc);
					if (c.getX()!=-1) {		//il y a eu une pièce mangée
						grille[c.getX()][c.getY()].setPiece(null);  //enlever la pièce mangée
						System.out.println(c.getX()+" "+c.getY());
						c2 =  sautPossible(x,y);
					}
					
				}
				if (grille[i][j].getPossibleClique()) {		//rénitialiser
					grille[i][j].setPossibleClique(false);
				}
			}
		}
		
		if (c2.getSaut()) {
			//ne pas changer de tour
		}
		else {
		changementTour();
		}
		
	}
	
	public Coordonnees sautPossible(int x, int y) {
		Coordonnees c2 = new Coordonnees();
		if ( (x-2>=0) && (y-2>=0) ) {	//diagonale haute gauche
			if ( (grille[x-2][y-2].getPiece()==null) && (grille[x-1][y-1].getPiece()!=null) ) {
				if ( grille[x-1][y-1].getPiece().getCouleur()!=grille[x][y].getPiece().getCouleur() ) {
					grille[x-2][y-2].setPossibleClique(true);
					grille[x-2][y-2].setSaut(true);
					grille[x][y].click();
					c2.setSaut(true);
				}
			}
		}
		if ( (x+2<taille) && (y-2>=0) ) {	//diagonale haute droite
			if ( (grille[x+2][y-2].getPiece()==null) && (grille[x+1][y-1].getPiece()!=null) ) {
				if ( grille[x+1][y-1].getPiece().getCouleur()!=grille[x][y].getPiece().getCouleur() ) {
					grille[x+2][y-2].setPossibleClique(true);
					grille[x+2][y-2].setSaut(true);
					grille[x][y].click();
					c2.setSaut(true);
				}
			}
		}
		if ( (x+2<taille) && (y+2<taille) ) {	//diagonale basse droite
			if ( (grille[x+2][y+2].getPiece()==null) && (grille[x+1][y+1].getPiece()!=null) ) {
				if ( grille[x+1][y+1].getPiece().getCouleur()!=grille[x][y].getPiece().getCouleur() ) {
					grille[x+2][y+2].setPossibleClique(true);
					grille[x+2][y+2].setSaut(true);
					grille[x][y].click();
					c2.setSaut(true);
				}
			}
		}
		if ( (x-2>=0) && (y+2<taille) ) {	//diagonale basse gauche
			if ( (grille[x-2][y+2].getPiece()==null) && (grille[x-1][y+1].getPiece()!=null) ) {
				if ( grille[x-1][y+1].getPiece().getCouleur()!=grille[x][y].getPiece().getCouleur() ) {
					grille[x-2][y+2].setPossibleClique(true);
					grille[x-2][y+2].setSaut(true);
					grille[x][y].click();
					c2.setSaut(true);
				}
			}
		}
		
		return c2;
	}	
		
	
	public Coordonnees pieceMangee(int x, int y,int i,int j,boolean tourBlanc) { //donne les coordonnées de la pièce mangée
		Coordonnees c = new Coordonnees();
		int delta=abs(y-j);
		if (delta==2) {	//il y a eu une pièce mangée
			if (y-j<0) {
				if (x-i>0) {		//diagonale haute droite
					int k=1;
					while ( (grille[i+k][j-k].getPiece()==null) && (i+k<taille-1)&&(j-k>=0) ) {
						k++;
					}
					c.setX(i+k);
					c.setY(j-k);
				}
				if (x-i<0)	{		//diagonale haute gauche
					int k=1;
					while ( (grille[i-k][j-k].getPiece()==null) && (i-k>=0)&&(j-k>=0) ) {
						k++;
					}
					c.setX(i-k);
					c.setY(j-k);
				}
			}
			else {  //y-j>0
				if (x-i>0) {		//diagonale basse droite
					int k=1;
					while ( (grille[i+k][j+k].getPiece()==null) && (i+k<taille-1)&&(j+k<taille-1) ) {
						k++;
					}
					c.setX(i+k);
					c.setY(j+k);
				}
				if (x-i<0)	{		//diagonale basse gauche
					int k=1;
					while ( (grille[i-k][j+k].getPiece()==null) && (i-k>=0)&&(j+k<taille-1) ) {
						k++;
					}
					c.setX(i-k);
					c.setY(j+k);
				}
			}
		}
		
		return c;
	}
	
	public void changementTour() {
		this.tourBlanc=!tourBlanc;
	}
	
	public int abs(int a) {
		if (a>=0) {
			return a;
		}
		else {
			return -a;
		}
	}
	
	
	public void paint(Graphics g) {
	//cases
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				grille[i][j].dessinerCase(g,i*TAILLE/taille,j*TAILLE/taille,TAILLE,taille);
				if (grille[i][j].getPiece()!=null) {
					grille[i][j].getPiece().dessinerPiece(g, i*TAILLE/taille,j*TAILLE/taille,TAILLE,taille);
				}
			//	damier[i][j].
			}
		}
		//&& ( (j<=(taille-2)/2-1) || (j>=taille/2) )
	}
	
	
	
}
