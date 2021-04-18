import javax.swing.JFrame;

public class Lanceur extends JFrame{

	private static final int TAILLE=800;	//taille de la fenêtre

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Jeu de Dames");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(TAILLE+8,TAILLE+37);  //le +37 est nécessaire à l'affichage de la dernière ligne
		Damier damier = new Damier(TAILLE,10); //10 par 10 pour l'original
		f.add(damier);
		f.setVisible(true);
		
		
	}
	
}
