package shah.av;
/**
 * Contains panels for single and multiplayer game mode. 
 */
import javax.swing.*;

@SuppressWarnings("serial")
public class SelectionPanel extends JPanel {

	/**
	 * Allows the user to select the game mode the user wishes to play.
	 */
	public SelectionPanel() {

		Object options[] = { "Single Player", "Multiplayer", "Cancel" };

		int selection = 2;

		while (selection == 2) {

			selection = JOptionPane.showOptionDialog(null, "How would you like to play?", "CONNECT FOUR",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

		}

		if (selection == 0) {

			JFrame optionFrame = new JFrame("Connect Four");
			optionFrame.getContentPane().add(new AIPanel());
			optionFrame.setSize(900, 900);
			optionFrame.pack();
			optionFrame.setVisible(true);
			optionFrame.setFocusable(false);
			optionFrame.setResizable(false);
			optionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} else if (selection == 1) {

			JFrame optionFrame = new JFrame("Connect Four");
			optionFrame.getContentPane().add(new ConnectFourPanel());
			optionFrame.setSize(900, 900);
			optionFrame.pack();
			optionFrame.setVisible(true);
			optionFrame.setFocusable(false);
			optionFrame.setResizable(false);
			optionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

	}

}