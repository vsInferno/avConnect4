package shah.av;

import javax.swing.JFrame;

public class ConnectFourGUIDriver {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Connect Four");
		frame.setSize(900, 900);
		frame.getContentPane().add(new ConnectFourPanel());
		frame.pack();
		frame.setVisible(true);
		frame.setFocusable(false);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}