import java.awt.Color;
import java.awt.Font;
enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{	
	private GemType type;
	private int points;
	
	public Gem() {
		int n = (int) (Math.random() * 3 + 1);
		if (n == 1) { type = GemType.GREEN; } 
		else if (n == 2) { type = GemType.BLUE; } 
		else { type = GemType.ORANGE; }
		
		int[] pointOptions = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
		points = pointOptions[(int) (Math.random() * 10 + 1)];
	}
	
	public Gem(GemType type, int points) {
		this.type = type;
		this.points = points;
	}
	
	public String toString() {
		if (type == GemType.GREEN) { return "GREEN " + points; }
		else if (type == GemType.BLUE) { return "BLUE " + points; }
		else { return "ORANGE " + points; } 
	}
	
	public GemType getType() {
		return type;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void draw(double x, double y) {
		if (type == GemType.GREEN) { StdDraw.picture(x, y, "gem_green.png"); }
		if (type == GemType.BLUE) { StdDraw.picture(x, y, "gem_blue.png"); }
		if (type == GemType.ORANGE) { StdDraw.picture(x, y, "gem_orange.png"); }
		StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
		StdDraw.setPenColor(Color.WHITE);
		String pointStr = "" + points;
		StdDraw.text(x, y, pointStr);
	}
	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;
		
		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		
		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
