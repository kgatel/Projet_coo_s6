import java.awt.*;
import javax.swing.*;

public class Case extends JPanel{

	private Couleur couleur;
	private Piece piece;
	private boolean saut;
	private boolean clique;
	private boolean possibleClique;
	
	public Case(Couleur couleur) {
		super();
		this.couleur=couleur;
		piece = null;
		clique = false;
	}
	
	public Case(Couleur couleurCase, Couleur couleurPiece) {
		super();
		this.couleur=couleurCase;
		piece = new Piece(couleurPiece);
		clique = false;
		possibleClique = false;
		saut = false;
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
	
	public boolean getPossibleClique() {
		return possibleClique;
	}
	
	public boolean getSaut(){
		return saut;
	}
	
	public void setCouleur(Couleur couleur) {
		this.couleur=couleur;
	}
	
	public void setPossibleClique(boolean b) {
		this.possibleClique=b;
	}
	
	public void setPiece(Piece piece) {
		this.piece=piece;
	}
	
	public void setClique(boolean b) {
		this.clique=b;
	}
	
	public void setSaut(boolean b){
		this.saut=b;
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
		if (clique) {
			//g.setColor(Color.yellow);
		}
		if (saut) {
			g.setColor(new Color(255,150,150));
		}
		if (possibleClique) {
			g.setColor(new Color(150,150,255));
		}
		g.fillRect(x,y,TAILLE/taille,TAILLE/taille);
	}
	
	public void click() {
		clique=!clique;
	}
	
}
