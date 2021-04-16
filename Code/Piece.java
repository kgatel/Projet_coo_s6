public class Piece{
	
	//attributs
	private Couleur couleur;
	private boolean vivant;
	
	//constructeurs
	public Piece(Couleur bn){
		couleur=bn;
	}
	
	//accesseur
	public Couleur getCouleur(){
		return this.couleur;
	}
	
	public void setCouleur(Couleur bn){
		this.couleur=bn;
	}
	
	//méthodes
	public void deplacer(Direction d){
	//faire un case avec les quatres déplacements possibles	
	}
	
}
