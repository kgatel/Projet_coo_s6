import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Damier extends JPanel{
	
	private int TAILLE; //taille de la fenêtre
	private int taille; //taille=8 pour un plateau 8*8 par exemple
	private Case[][] damier;  //tableau de cases
	
	public Damier(int TAILLE,int taille) {
		this.TAILLE=TAILLE;
		this.taille=taille;
		this.damier = new Case[taille][taille];
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				if ( (i+j)%2==0 ) {
					damier[i][j]= new Case(Couleur.Blanc);
				}
				else {
					if (j<=(taille-2)/2-1) {
						damier[i][j]= new Case(Couleur.Noir,Couleur.Noir);
					}
					else {
						if (j>=taille/2+1) {
							damier[i][j]= new Case(Couleur.Noir,Couleur.Blanc);
						}
						else {
							damier[i][j]= new Case(Couleur.Noir);
						}
					}
				}
			}
		}
	}
	
	public void paint(Graphics g) {
	//cases
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				damier[i][j].dessinerCase(g,i*TAILLE/taille,j*TAILLE/taille,TAILLE,taille);
				if (damier[i][j].getPiece()!=null) {
					damier[i][j].getPiece().dessinerPiece(g, i*TAILLE/taille,j*TAILLE/taille,TAILLE,taille);
				}
			//	damier[i][j].
			}
		}
		//&& ( (j<=(taille-2)/2-1) || (j>=taille/2) )
	}
	
	
	
}
