import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Souris implements MouseListener {

	private Damier damier;
	private JFrame frame;
	
	public Souris(Damier damier) {
		super();
		this.damier = damier;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println("in");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("out");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int ii=0,jj=0; //coordoonées du pion avant déplacement
		
		int x = arg0.getX()*damier.getTaille()/damier.getTAILLE();
		int y = (arg0.getY()-39)*damier.getTaille()/damier.getTAILLE();
		
		if (damier.getSautMultiple()&&(!damier.getGrille()[x][y].getSaut())) {
			//ne rien faire tant que le pion ne mange pas l'autre pion
			System.out.println("Vous devez manger le pion");
		}
		else {
			damier.setSautMultiple(false);
			if ((damier.getGrille()[x][y].getPossibleClique()==false)&&(damier.getGrille()[x][y].getSaut()==false) ) {  //selection de la pièce à bouger
				
				for (int j=0;j<damier.getTaille();j++) {   //rénitialise tout
					for (int i=0;i<damier.getTaille();i++) {
						if (damier.getGrille()[i][j].getPossibleClique()) {
							damier.getGrille()[i][j].setPossibleClique(false);
						}
						if (damier.getGrille()[i][j].getSaut()) {
							damier.getGrille()[i][j].setSaut(false);
						}
						if (damier.getGrille()[i][j].getClique()){
							ii=i;
							jj=j;
							damier.getGrille()[i][j].setClique(false);
						}
					}
				}
				this.damier.getGrille()[x][y].click();			
				this.damier.afficherDeplacement(x,y);
				
			}
			
			else {
				
				if ( (damier.getSautObligatoire())&&(!damier.getGrille()[x][y].getSaut()) ){
					//ne rien faire tant que le saut n'est pas effectué
					System.out.println("Vous avez obligation de manger");
				}
				else {
					damier.setSautObligatoire(false);
					for (int j=0;j<damier.getTaille();j++) {   //renitialise tous les sauts
						for (int i=0;i<damier.getTaille();i++) {
							if (damier.getGrille()[i][j].getSaut()==true) {
								damier.getGrille()[i][j].setSaut(false);
							}
							if (damier.getGrille()[i][j].getClique()){
								ii=i;
								jj=j;
							}
						}
					}
					
					this.damier.deplacer(x,y,this.damier.getGrille()[ii][jj].getPiece() instanceof Reine);   //selection de la case où la pièce veut bouger
				}
			}
			
		}
		this.damier.repaint();
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

}