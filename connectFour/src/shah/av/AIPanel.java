package shah.av;
/**
 * Graphics for connect four single player mode.
 * @authors Archit Shah, Vraj Shah
 * @version 1.0
 */
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AIPanel extends JPanel {

	private final int ROWS = 7;
	private final int COLS = 7;

	private Board board;

	private int count = 0;

	private ImageIcon oneChip;
	private ImageIcon twoChip;

	private ChipState winner;

	private int[] emptySpace = new int[7];

	private JButton[][] button = new JButton[ROWS][COLS];

	private JButton[] btnChoice = new JButton[7];

	private Border thickBorder;

	/**
	 * Initialize an empty grid board of connect four with buttons.
	 */
	public AIPanel() {

		setPreferredSize(new Dimension(600, 500));

		setBackground(Color.YELLOW);

		setLayout(new GridLayout(7, 7));

		board = new Board();

		oneChip = chipIm("red");
		twoChip = chipIm("blue");

		thickBorder = new LineBorder(Color.WHITE, 4);

		for (int i = 0; i < ROWS; i++) {

			for (int j = 0; j < COLS; j++) {

				if (i == 0) {

					button[i][j] = new JButton();
					button[i][j].setEnabled(true);
					button[i][j].addActionListener(new ButtonListener());
					add(button[i][j]);

				} else {

					button[i][j] = new JButton();
					button[i][j].setEnabled(false);
					button[i][j].setBackground(Color.YELLOW);
					button[i][j].setBorder(thickBorder);
					add(button[i][j]);

				}

			}

		}

		for (int i = 0; i < emptySpace.length; i++) {
			emptySpace[i] = ROWS - 1;
		}

		count = 1;

		btnChoice[0] = button[0][0];
		btnChoice[0].setBackground(Color.BLACK);
		btnChoice[0].setBorder(thickBorder);

		btnChoice[1] = button[0][1];
		btnChoice[1].setBackground(Color.BLACK);
		btnChoice[1].setBorder(thickBorder);

		btnChoice[2] = button[0][2];
		btnChoice[2].setBackground(Color.BLACK);
		btnChoice[2].setBorder(thickBorder);

		btnChoice[3] = button[0][3];
		btnChoice[3].setBackground(Color.BLACK);
		btnChoice[3].setBorder(thickBorder);

		btnChoice[4] = button[0][4];
		btnChoice[4].setBackground(Color.BLACK);
		btnChoice[4].setBorder(thickBorder);

		btnChoice[5] = button[0][5];
		btnChoice[5].setBackground(Color.BLACK);
		btnChoice[5].setBorder(thickBorder);

		btnChoice[6] = button[0][6];
		btnChoice[6].setBackground(Color.BLACK);
		btnChoice[6].setBorder(thickBorder);

	}
	
	/**
	 * Return the image of a colored chip that is unique to each player.
	 * @param color - Chip color
	 * @return
	 */
	private ImageIcon chipIm(String color) {

		ImageIcon chipImg = new ImageIcon(color + ".png");

		return chipImg;

	}

	/**
	 * Keep an ongoing track of whose turn it is to alternate between the player and computer.
	 * @return true - If its the computer's turn
	 */
	public boolean computerTurn() {
		
		boolean compT = true;
		
		if (count % 2 == 0) {
			return compT;
		} else {
			return compT = false;
		}
	}
	
	/**
	 * Display a game over message and start a new game if the user wises to play again.
	 */
	public void endPanel() {

		btnChoice[0].setEnabled(false);
		btnChoice[0].setBackground(Color.WHITE);
		btnChoice[0].setText("T");
		btnChoice[0].setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		btnChoice[1].setEnabled(false);
		btnChoice[1].setBackground(Color.WHITE);
		btnChoice[1].setText("H");
		btnChoice[1].setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		btnChoice[2].setEnabled(false);
		btnChoice[2].setBackground(Color.WHITE);
		btnChoice[2].setText("E");
		btnChoice[2].setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		btnChoice[3].setEnabled(false);
		btnChoice[3].setBackground(Color.WHITE);
		btnChoice[4].setEnabled(false);
		btnChoice[4].setBackground(Color.WHITE);
		btnChoice[4].setText("E");
		btnChoice[4].setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		btnChoice[5].setEnabled(false);
		btnChoice[5].setBackground(Color.WHITE);
		btnChoice[5].setText("N");
		btnChoice[5].setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		btnChoice[6].setEnabled(false);
		btnChoice[6].setBackground(Color.WHITE);
		btnChoice[6].setText("D");
		btnChoice[6].setFont(new Font("Comic Sans MS", Font.BOLD, 35));

		int result = JOptionPane.showConfirmDialog(null, "Do you wish to play again?");
		
		if (result == JOptionPane.YES_OPTION) {
			new SelectionPanel();
		}

	}
	
	private class ButtonListener implements ActionListener {
		
		/**
		 * Display a chip in the column corresponding to the button while executing 
		 * functions that each button is responsible for.
		 */
		public void actionPerformed(ActionEvent event) {
			//Sentinel to check if button selected is button one and if column is not full
			if (event.getSource() == btnChoice[0] && emptySpace[0] != 0) {

				//If its player's turn and there's more than one empty space in column one
				if (!computerTurn() && emptySpace[0] > 1) {

					(button[emptySpace[0]][0]).setBackground(Color.pink);
					(button[emptySpace[0]][0]).setDisabledIcon(oneChip);
					(button[emptySpace[0]][0]).setIcon((button[emptySpace[0]][0]).getDisabledIcon());
					board.updateBoard(emptySpace[0], 0, ChipState.PLAYER1);
					emptySpace[0]--;
					count++;
				
				//If its player's turn and there's only one empty space in column one	
				} else if (!computerTurn() && emptySpace[0] == 1) {

					(button[emptySpace[0]][0]).setBackground(Color.pink);
					(button[emptySpace[0]][0]).setDisabledIcon(oneChip);
					(button[emptySpace[0]][0]).setIcon((button[emptySpace[0]][0]).getDisabledIcon());
					board.updateBoard(emptySpace[0], 0, ChipState.PLAYER1);
					emptySpace[0]--;
					count++;
					btnChoice[0].setEnabled(false);
					board.updateBoard(0, 0, ChipState.FULL);
					btnChoice[0].setBackground(Color.WHITE);

				}
				
				//If the game is not over, then, AI makes a move. 
				if (!isOver()) {
					ai();
				}

			} else if (event.getSource() == btnChoice[1] && emptySpace[1] != 0) {

				if (!computerTurn() && emptySpace[1] > 1) {

					(button[emptySpace[1]][1]).setBackground(Color.pink);
					(button[emptySpace[1]][1]).setDisabledIcon(oneChip);
					(button[emptySpace[1]][1]).setIcon((button[emptySpace[1]][1]).getDisabledIcon());
					board.updateBoard(emptySpace[1], 1, ChipState.PLAYER1);
					emptySpace[1]--;
					count++;

				} else if (!computerTurn() && emptySpace[1] == 1) {

					(button[emptySpace[1]][1]).setBackground(Color.pink);
					(button[emptySpace[1]][1]).setDisabledIcon(oneChip);
					(button[emptySpace[1]][1]).setIcon((button[emptySpace[1]][1]).getDisabledIcon());
					board.updateBoard(emptySpace[1], 1, ChipState.PLAYER1);
					emptySpace[1]--;
					count++;
					btnChoice[1].setEnabled(false);
					board.updateBoard(0, 1, ChipState.FULL);
					btnChoice[1].setBackground(Color.WHITE);

				}

				if (!isOver()) {
					ai();
				}

			} else if (event.getSource() == btnChoice[2] && emptySpace[2] != 0) {

				if (!computerTurn() && emptySpace[2] > 1) {

					(button[emptySpace[2]][2]).setBackground(Color.pink);
					(button[emptySpace[2]][2]).setDisabledIcon(oneChip);
					(button[emptySpace[2]][2]).setIcon((button[emptySpace[2]][2]).getDisabledIcon());
					board.updateBoard(emptySpace[2], 2, ChipState.PLAYER1);
					emptySpace[2]--;
					count++;

				} else if (!computerTurn() && emptySpace[2] == 1) {

					(button[emptySpace[2]][2]).setBackground(Color.pink);
					(button[emptySpace[2]][2]).setDisabledIcon(oneChip);
					(button[emptySpace[2]][2]).setIcon((button[emptySpace[2]][2]).getDisabledIcon());
					board.updateBoard(emptySpace[2], 2, ChipState.PLAYER1);
					emptySpace[2]--;
					count++;
					btnChoice[2].setEnabled(false);
					board.updateBoard(0, 2, ChipState.FULL);
					btnChoice[2].setBackground(Color.WHITE);

				}

				if (!isOver()) {
					ai();
				}

			} else if (event.getSource() == btnChoice[3] && emptySpace[3] != 0) {

				if (!computerTurn() && emptySpace[3] > 1) {

					(button[emptySpace[3]][3]).setBackground(Color.pink);
					(button[emptySpace[3]][3]).setDisabledIcon(oneChip);
					(button[emptySpace[3]][3]).setIcon((button[emptySpace[3]][3]).getDisabledIcon());
					board.updateBoard(emptySpace[3], 3, ChipState.PLAYER1);
					emptySpace[3]--;
					count++;

				} else if (!computerTurn() && emptySpace[3] == 1) {

					(button[emptySpace[3]][3]).setBackground(Color.pink);
					(button[emptySpace[3]][3]).setDisabledIcon(oneChip);
					(button[emptySpace[3]][3]).setIcon((button[emptySpace[3]][3]).getDisabledIcon());
					board.updateBoard(emptySpace[3], 3, ChipState.PLAYER1);
					emptySpace[3]--;
					count++;
					btnChoice[3].setEnabled(false);
					board.updateBoard(0, 3, ChipState.FULL);
					btnChoice[3].setBackground(Color.WHITE);

				}

				if (!isOver()) {
					ai();
				}

			} else if (event.getSource() == btnChoice[4] && emptySpace[4] != 0) {

				if (!computerTurn() && emptySpace[4] > 1) {

					(button[emptySpace[4]][4]).setBackground(Color.pink);
					(button[emptySpace[4]][4]).setDisabledIcon(oneChip);
					(button[emptySpace[4]][4]).setIcon((button[emptySpace[4]][4]).getDisabledIcon());
					board.updateBoard(emptySpace[4], 4, ChipState.PLAYER1);
					emptySpace[4]--;
					count++;

				} else if (!computerTurn() && emptySpace[4] == 1) {

					(button[emptySpace[4]][4]).setBackground(Color.pink);
					(button[emptySpace[4]][4]).setDisabledIcon(oneChip);
					(button[emptySpace[4]][4]).setIcon((button[emptySpace[4]][4]).getDisabledIcon());
					board.updateBoard(emptySpace[4], 4, ChipState.PLAYER1);
					emptySpace[4]--;
					count++;
					btnChoice[4].setEnabled(false);
					board.updateBoard(0, 4, ChipState.FULL);
					btnChoice[4].setBackground(Color.WHITE);

				}

				if (!isOver()) {
					ai();
				}

			} else if (event.getSource() == btnChoice[5] && emptySpace[5] != 0) {

				if (!computerTurn() && emptySpace[5] > 1) {

					(button[emptySpace[5]][5]).setBackground(Color.pink);
					(button[emptySpace[5]][5]).setDisabledIcon(oneChip);
					(button[emptySpace[5]][5]).setIcon((button[emptySpace[5]][5]).getDisabledIcon());
					board.updateBoard(emptySpace[5], 5, ChipState.PLAYER1);
					emptySpace[5]--;
					count++;

				} else if (!computerTurn() && emptySpace[5] == 1) {

					(button[emptySpace[5]][5]).setBackground(Color.pink);
					(button[emptySpace[5]][5]).setDisabledIcon(oneChip);
					(button[emptySpace[5]][5]).setIcon((button[emptySpace[5]][5]).getDisabledIcon());
					board.updateBoard(emptySpace[5], 5, ChipState.PLAYER1);
					emptySpace[5]--;
					count++;
					btnChoice[5].setEnabled(false);
					board.updateBoard(0, 5, ChipState.FULL);
					btnChoice[5].setBackground(Color.WHITE);

				}

				if (!isOver()) {
					ai();
				}

			} else if (event.getSource() == btnChoice[6] && emptySpace[6] != 0) {

				if (!computerTurn() && emptySpace[6] > 1) {

					(button[emptySpace[6]][6]).setBackground(Color.pink);
					(button[emptySpace[6]][6]).setDisabledIcon(oneChip);
					(button[emptySpace[6]][6]).setIcon((button[emptySpace[6]][6]).getDisabledIcon());
					board.updateBoard(emptySpace[6], 6, ChipState.PLAYER1);
					emptySpace[6]--;
					count++;

				} else if (!computerTurn() && emptySpace[6] == 1) {

					(button[emptySpace[6]][6]).setBackground(Color.pink);
					(button[emptySpace[6]][6]).setDisabledIcon(oneChip);
					(button[emptySpace[6]][6]).setIcon((button[emptySpace[6]][6]).getDisabledIcon());
					board.updateBoard(emptySpace[6], 6, ChipState.PLAYER1);
					emptySpace[6]--;
					count++;
					btnChoice[6].setEnabled(false);
					board.updateBoard(0, 6, ChipState.FULL);
					btnChoice[6].setBackground(Color.WHITE);

				}

				if (!isOver()) {
					ai();
				}

			}

		}

		/**
		 * Places Ai player chip after receiving the best location from the board class.
		 */
		public void ai() {

			int[] location = new int[2];
			location = board.aiMove(emptySpace);

			if (emptySpace[location[1]] > 1) {

				(button[location[0]][location[1]]).setBackground(Color.cyan);
				(button[location[0]][location[1]]).setDisabledIcon(twoChip);
				(button[location[0]][location[1]]).setIcon((button[location[0]][location[1]]).getDisabledIcon());
				board.updateBoard(location[0], location[1], ChipState.PLAYER2);
				emptySpace[location[1]]--;
				count++;

			} else if (emptySpace[location[1]] == 1) {

				(button[location[0]][location[1]]).setBackground(Color.cyan);
				(button[location[0]][location[1]]).setDisabledIcon(twoChip);
				(button[location[0]][location[1]]).setIcon((button[location[0]][location[1]]).getDisabledIcon());
				board.updateBoard(location[0], location[1], ChipState.PLAYER2);
				emptySpace[location[1]]--;
				count++;
				btnChoice[location[1]].setEnabled(false);
				board.updateBoard(0, location[1], ChipState.FULL);
				btnChoice[location[1]].setBackground(Color.WHITE);

			}

			isOver();

		}

		/**
		 * Display the game result; who wins the game or tie game.
		 * @return 
		 */
		private boolean isOver() {

			if (board.isDraw()) {

				JOptionPane.showMessageDialog(null, "It's a draw!");
				endPanel();
				return true;

			} else {

				winner = board.whoWin();
				if (winner != ChipState.EMPTY) {

					if (winner == ChipState.PLAYER1) {
						JOptionPane.showMessageDialog(null, "You win!");
						endPanel();
					} else {
						JOptionPane.showMessageDialog(null, "You lost!");
						endPanel();
					}

					return true;
				}

			}

			return false;
		}

	}

}