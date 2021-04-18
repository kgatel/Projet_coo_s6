import javax.swing.JFrame;
import javax.swing.UIManager;


public class Lanceur {

	
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e){}
		
		JFrame f = new JFrame();
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Plateau(8));
		f.setVisible(true);

	}

}
