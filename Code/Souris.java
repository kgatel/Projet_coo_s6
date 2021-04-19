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

		if ((damier.getGrille()[x][y].getPossibleClique()==false)&&(damier.getGrille()[x][y].getSaut()==false) ) {  //selection de la pièce à bouger
			
			for (int j=0;j<damier.getTaille();j++) {   //permet d'effacer l'ancien clique
				for (int i=0;i<damier.getTaille();i++) {
					if (damier.getGrille()[i][j].getPossibleClique()==true) {
						damier.getGrille()[i][j].setPossibleClique(false);
					}
					if (damier.getGrille()[i][j].getClique()==true){
						damier.getGrille()[i][j].click();
					}
				}
			}
			this.damier.getGrille()[x][y].click();			
			this.damier.afficherDeplacement();
		}
		
		else {
			if (damier.getGrille()[x][y].getSaut()==true) {
				damier.getGrille()[x][y].setSaut(true);
			}
			this.damier.deplacer(x,y,damier.getTourBlanc());   //selection de la case où la pièce veut bouger
		}
		this.damier.repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println("released");
	}

}
