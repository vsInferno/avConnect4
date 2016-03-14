package shah.av;

import java.awt.Color;

public class Chip {

	private static Color chipColor;
	private static int chipDiameter;
	
	public Chip(Color color, int chipDiameter) {
		
		this.chipColor = color;
		this.chipDiameter = chipDiameter;
		
	}
	
	public void setColor(Color color) {
		
		this.chipColor = color;
		
	}
	
	public void setSize(int size) {
		
		this.chipDiameter = size;
		
	}
	
}