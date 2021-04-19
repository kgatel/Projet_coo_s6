
public class Coordonnees {

	private int x,y;
	private boolean saut;
	
	public Coordonnees() {
		x=-1;
		y=-1;
		saut=false;
	}

	public int getX() {
		return x;
	}

	public boolean getSaut(){
		return saut;
	}
	
	public void setSaut(boolean b){
		this.saut=b;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
