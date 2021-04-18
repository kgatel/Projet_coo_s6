import java.awt.*;
import javax.swing.*;

public class Case {

	private Couleur couleur;
	private Piece piece;
	private boolean clique;
	
	public Case(Couleur couleur) {
		super();
		this.couleur=couleur;
		piece = null;
	}
	
	public Case(Couleur couleurCase, Couleur couleurPiece) {
		super();
		this.couleur=couleurCase;
		piece = new Piece(couleurPiece);
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public boolean getClique() {
		return clique;
	}
	
	public void setCouleur(Couleur couleur) {
		this.couleur=couleur;
	}
	
	public void setPiece(Piece piece) {
		this.piece=piece;
	}
	
	public void dessinerCase(Graphics g, int x, int y,int TAILLE,int taille) {
		switch(couleur) {
		case Blanc : 
			g.setColor(Color.WHITE);
			break;
		case Noir :
			g.setColor(Color.GRAY);
			break;
		}
		g.fillRect(x,y,TAILLE/taille,TAILLE/taille);
	}
		
	
}
