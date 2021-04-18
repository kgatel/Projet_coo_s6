import java.awt.Color;
import java.awt.Graphics;

public class Piece {

	private Couleur couleur;
	
	public Piece(Couleur couleur) {
		super();
		this.couleur=couleur;
	}
	
	public void dessinerPiece(Graphics g, int x, int y,int TAILLE,int taille) {
		switch(couleur) {
		case Blanc : 
			g.setColor(new Color(255,255,220));
			break;
		case Noir :
			g.setColor(Color.BLACK);
			break;
		}
		g.fillOval(x+TAILLE/taille/20,y+TAILLE/taille/20,TAILLE/taille*9/10,TAILLE/taille*9/10);   //fois 9/10 pour que la taille de la pièce soit un peu plus petite que la case
	}
}
