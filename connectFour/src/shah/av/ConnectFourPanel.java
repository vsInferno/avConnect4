package shah.av;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class ConnectFourPanel extends JPanel {

	public ConnectFourPanel() {

		setPreferredSize(new Dimension(600, 500));

		setLayout(new GridLayout(8, 7));
		
	}

}