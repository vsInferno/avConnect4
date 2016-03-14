package shah.av;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class ConnectFourPanel extends JPanel {
	
	Chip redChip;
	Chip blueChip;

	public ConnectFourPanel() {

		setPreferredSize(new Dimension(600, 500));
		setBackground(Color.YELLOW);

		setLayout(new GridLayout(6, 7));
		
		//redChip.setSize(80);
		//blueChip.setSize(80);
		
		//redChip.setColor(Color.RED);
		//blueChip.setColor(Color.BLUE);

		
	}

}