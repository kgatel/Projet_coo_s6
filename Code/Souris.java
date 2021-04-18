import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Souris implements MouseListener {

	private Case case0;
	private Plateau plateau;
	
	public Souris(Case case0,Plateau plateau) {
		super();
		this.case0 = case0;
		this.plateau = plateau;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Point pt = arg0.getPoint();
		System.out.print(pt.x);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
