import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Souris implements MouseListener {

//	private Case case0;
	private Damier damier;
	
//	public Souris(Case case0,Damier damier) {
	public Souris(Damier damier) {
		super();
//		this.case0 = case0;
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
		//System.out.println("clique on x:"+arg0.getX()*damier.getTaille()/damier.getTAILLE()+", y: "+(arg0.getY()-39)*damier.getTaille()/damier.getTAILLE());
			
		int x = arg0.getX()*damier.getTaille()/damier.getTAILLE();
		int y = (arg0.getY()-39)*damier.getTaille()/damier.getTAILLE();
		
		if (damier.getSautMultiple()&&(!damier.getGrille()[x][y].getSaut())) {
			//ne rien faire tant que le pion ne mange pas l'autre pion
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
				}
				else {
					damier.setSautObligatoire(false);
					for (int j=0;j<damier.getTaille();j++) {   //renitialise tous les sauts
						for (int i=0;i<damier.getTaille();i++) {
							if (damier.getGrille()[i][j].getSaut()==true) {
								damier.getGrille()[i][j].setSaut(false);
							}
						}
					}
					
					this.damier.deplacer(x,y);   //selection de la case où la pièce veut bouger
				}
			}
			
		}
		this.damier.repaint();
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println("released");
	}

}
