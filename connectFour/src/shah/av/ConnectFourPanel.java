package shah.av;
/**
 * Graphics for connect four multiplayer mode.
 * @authors Vraj Shah, Archit Shah
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
public class ConnectFourPanel extends JPanel {

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

	private String name1, name2;

	/**
	 * Initialize an empty grid board of connect four with buttons
	 * while assigning each player with a chip.
	 */
	public ConnectFourPanel() {

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

		boolean valid = true;

		while (valid) {

			name1 = JOptionPane.showInputDialog(null, "Name of Player 1: ");
			if (name1 == null || name1.equals("")) {

				JOptionPane.showMessageDialog(null, "No name entered.");

			} else {

				JOptionPane.showMessageDialog(null, name1 + " will be pink. Pink goes first.");
				valid = false;

			}

		}

		valid = true;

		while (valid) {

			name2 = JOptionPane.showInputDialog(null, "Name of Player 2: ");
			if (name2 == null || name2.equals("")) {

				JOptionPane.showMessageDialog(null, "No name entered.");

			} else {

				JOptionPane.showMessageDialog(null, name2 + " will be cyan. Cyan goes second.");
				valid = false;

			}

		}

	}

	/**
	 * Return the image of a colored chip that is unique to each player.
	 * @param color - Chip color
	 * @return
	 */
	public ImageIcon chipIm(String color) {

		ImageIcon chipImg = new ImageIcon(color + ".png");

		return chipImg;

	}

	/**
	 * Alternate between the player 1 and 2 by checking for player 2's turn.
	 * @return true -  if it's player two's turn
	 */
	public boolean playerTwoTurn() {

		boolean playTwoTurn = true;

		if (count % 2 == 0) {

			return playTwoTurn;

		} else {

			return playTwoTurn = false;

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
		 * Display a player's chip in the column corresponding to the button while executing 
		 * functions that each button is responsible for.
		 */
		public void actionPerformed(ActionEvent event) {
			//Sentinel to check if button selected is button one and if column is not full
			if (event.getSource() == btnChoice[0] && emptySpace[0] != 0) {
				//If its player 1's turn and there is more than one empty space in column one
				if (!playerTwoTurn() && emptySpace[0] > 1) {

					(button[emptySpace[0]][0]).setBackground(Color.pink);
					(button[emptySpace[0]][0]).setDisabledIcon(oneChip);
					(button[emptySpace[0]][0]).setIcon((button[emptySpace[0]][0]).getDisabledIcon());
					board.updateBoard(emptySpace[0], 0, ChipState.PLAYER1);
					emptySpace[0]--;
					count++;
					isOver();
				//If its player 2's turn and there is more than one empty space in column one
				} else if (playerTwoTurn() && emptySpace[0] > 1) {

					(button[emptySpace[0]][0]).setBackground(Color.cyan);
					(button[emptySpace[0]][0]).setDisabledIcon(twoChip);
					(button[emptySpace[0]][0]).setIcon((button[emptySpace[0]][0]).getDisabledIcon());
					board.updateBoard(emptySpace[0], 0, ChipState.PLAYER2);
					emptySpace[0]--;
					count++;
					isOver();
				//If its player 1's turn and there is only one empty space in column one
				} else if (!playerTwoTurn() && emptySpace[0] == 1) {

					(button[emptySpace[0]][0]).setBackground(Color.pink);
					(button[emptySpace[0]][0]).setDisabledIcon(oneChip);
					(button[emptySpace[0]][0]).setIcon((button[emptySpace[0]][0]).getDisabledIcon());
					board.updateBoard(emptySpace[0], 0, ChipState.PLAYER1);
					emptySpace[0]--;
					count++;
					btnChoice[0].setEnabled(false);
					board.updateBoard(0, 0, ChipState.FULL);
					btnChoice[0].setBackground(Color.WHITE);
					isOver();
				//If its player 2's turn and there is only one empty space in column one
				} else if (playerTwoTurn() && emptySpace[0] == 1) {

					(button[emptySpace[0]][0]).setBackground(Color.cyan);
					(button[emptySpace[0]][0]).setDisabledIcon(twoChip);
					(button[emptySpace[0]][0]).setIcon((button[emptySpace[0]][0]).getDisabledIcon());
					board.updateBoard(emptySpace[0], 0, ChipState.PLAYER2);
					emptySpace[0]--;
					count++;
					btnChoice[0].setEnabled(false);
					board.updateBoard(0, 0, ChipState.FULL);
					btnChoice[0].setBackground(Color.WHITE);
					isOver();

				}

			} else if (event.getSource() == btnChoice[1] && emptySpace[1] != 0) {

				if (!playerTwoTurn() && emptySpace[1] > 1) {

					(button[emptySpace[1]][1]).setBackground(Color.pink);
					(button[emptySpace[1]][1]).setDisabledIcon(oneChip);
					(button[emptySpace[1]][1]).setIcon((button[emptySpace[1]][1]).getDisabledIcon());
					board.updateBoard(emptySpace[1], 1, ChipState.PLAYER1);
					emptySpace[1]--;
					count++;
					isOver();

				} else if (playerTwoTurn() && emptySpace[1] > 1) {

					(button[emptySpace[1]][1]).setBackground(Color.cyan);
					(button[emptySpace[1]][1]).setDisabledIcon(twoChip);
					(button[emptySpace[1]][1]).setIcon((button[emptySpace[1]][1]).getDisabledIcon());
					board.updateBoard(emptySpace[1], 1, ChipState.PLAYER2);
					emptySpace[1]--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && emptySpace[1] == 1) {

					(button[emptySpace[1]][1]).setBackground(Color.pink);
					(button[emptySpace[1]][1]).setDisabledIcon(oneChip);
					(button[emptySpace[1]][1]).setIcon((button[emptySpace[1]][1]).getDisabledIcon());
					board.updateBoard(emptySpace[1], 1, ChipState.PLAYER1);
					emptySpace[1]--;
					count++;
					btnChoice[1].setEnabled(false);
					board.updateBoard(0, 1, ChipState.FULL);
					btnChoice[1].setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && emptySpace[1] == 1) {

					(button[emptySpace[1]][1]).setBackground(Color.cyan);
					(button[emptySpace[1]][1]).setDisabledIcon(twoChip);
					(button[emptySpace[1]][1]).setIcon((button[emptySpace[1]][1]).getDisabledIcon());
					board.updateBoard(emptySpace[1], 1, ChipState.PLAYER2);
					emptySpace[1]--;
					count++;
					btnChoice[1].setEnabled(false);
					board.updateBoard(0, 1, ChipState.FULL);
					btnChoice[1].setBackground(Color.WHITE);
					isOver();

				}

			} else if (event.getSource() == btnChoice[2] && emptySpace[2] != 0) {

				if (!playerTwoTurn() && emptySpace[2] > 1) {

					(button[emptySpace[2]][2]).setBackground(Color.pink);
					(button[emptySpace[2]][2]).setDisabledIcon(oneChip);
					(button[emptySpace[2]][2]).setIcon((button[emptySpace[2]][2]).getDisabledIcon());
					board.updateBoard(emptySpace[2], 2, ChipState.PLAYER1);
					emptySpace[2]--;
					count++;
					isOver();

				} else if (playerTwoTurn() && emptySpace[2] > 1) {

					(button[emptySpace[2]][2]).setBackground(Color.cyan);
					(button[emptySpace[2]][2]).setDisabledIcon(twoChip);
					(button[emptySpace[2]][2]).setIcon((button[emptySpace[2]][2]).getDisabledIcon());
					board.updateBoard(emptySpace[2], 2, ChipState.PLAYER2);
					emptySpace[2]--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && emptySpace[2] == 1) {

					(button[emptySpace[2]][2]).setBackground(Color.pink);
					(button[emptySpace[2]][2]).setDisabledIcon(oneChip);
					(button[emptySpace[2]][2]).setIcon((button[emptySpace[2]][2]).getDisabledIcon());
					board.updateBoard(emptySpace[2], 2, ChipState.PLAYER1);
					emptySpace[2]--;
					count++;
					btnChoice[2].setEnabled(false);
					board.updateBoard(0, 2, ChipState.FULL);
					btnChoice[2].setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && emptySpace[2] == 1) {

					(button[emptySpace[2]][2]).setBackground(Color.cyan);
					(button[emptySpace[2]][2]).setDisabledIcon(twoChip);
					(button[emptySpace[2]][2]).setIcon((button[emptySpace[2]][2]).getDisabledIcon());
					board.updateBoard(emptySpace[2], 2, ChipState.PLAYER2);
					emptySpace[2]--;
					count++;
					btnChoice[2].setEnabled(false);
					board.updateBoard(0, 2, ChipState.FULL);
					btnChoice[2].setBackground(Color.WHITE);
					isOver();

				}

			} else if (event.getSource() == btnChoice[3] && emptySpace[3] != 0) {

				if (!playerTwoTurn() && emptySpace[3] > 1) {

					(button[emptySpace[3]][3]).setBackground(Color.pink);
					(button[emptySpace[3]][3]).setDisabledIcon(oneChip);
					(button[emptySpace[3]][3]).setIcon((button[emptySpace[3]][3]).getDisabledIcon());
					board.updateBoard(emptySpace[3], 3, ChipState.PLAYER1);
					emptySpace[3]--;
					count++;
					isOver();

				} else if (playerTwoTurn() && emptySpace[3] > 1) {

					(button[emptySpace[3]][3]).setBackground(Color.cyan);
					(button[emptySpace[3]][3]).setDisabledIcon(twoChip);
					(button[emptySpace[3]][3]).setIcon((button[emptySpace[3]][3]).getDisabledIcon());
					board.updateBoard(emptySpace[3], 3, ChipState.PLAYER2);
					emptySpace[3]--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && emptySpace[3] == 1) {

					(button[emptySpace[3]][3]).setBackground(Color.pink);
					(button[emptySpace[3]][3]).setDisabledIcon(oneChip);
					(button[emptySpace[3]][3]).setIcon((button[emptySpace[3]][3]).getDisabledIcon());
					board.updateBoard(emptySpace[3], 3, ChipState.PLAYER1);
					emptySpace[3]--;
					count++;
					btnChoice[3].setEnabled(false);
					board.updateBoard(0, 3, ChipState.FULL);
					btnChoice[3].setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && emptySpace[3] == 1) {

					(button[emptySpace[3]][3]).setBackground(Color.cyan);
					(button[emptySpace[3]][3]).setDisabledIcon(twoChip);
					(button[emptySpace[3]][3]).setIcon((button[emptySpace[3]][3]).getDisabledIcon());
					board.updateBoard(emptySpace[3], 3, ChipState.PLAYER2);
					emptySpace[3]--;
					count++;
					btnChoice[3].setEnabled(false);
					board.updateBoard(0, 3, ChipState.FULL);
					btnChoice[3].setBackground(Color.WHITE);
					isOver();

				}

			} else if (event.getSource() == btnChoice[4] && emptySpace[4] != 0) {

				if (!playerTwoTurn() && emptySpace[4] > 1) {

					(button[emptySpace[4]][4]).setBackground(Color.pink);
					(button[emptySpace[4]][4]).setDisabledIcon(oneChip);
					(button[emptySpace[4]][4]).setIcon((button[emptySpace[4]][4]).getDisabledIcon());
					board.updateBoard(emptySpace[4], 4, ChipState.PLAYER1);
					emptySpace[4]--;
					count++;
					isOver();

				} else if (playerTwoTurn() && emptySpace[4] > 1) {

					(button[emptySpace[4]][4]).setBackground(Color.cyan);
					(button[emptySpace[4]][4]).setDisabledIcon(twoChip);
					(button[emptySpace[4]][4]).setIcon((button[emptySpace[4]][4]).getDisabledIcon());
					board.updateBoard(emptySpace[4], 4, ChipState.PLAYER2);
					emptySpace[4]--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && emptySpace[4] == 1) {

					(button[emptySpace[4]][4]).setBackground(Color.pink);
					(button[emptySpace[4]][4]).setDisabledIcon(oneChip);
					(button[emptySpace[4]][4]).setIcon((button[emptySpace[4]][4]).getDisabledIcon());
					board.updateBoard(emptySpace[4], 4, ChipState.PLAYER1);
					emptySpace[4]--;
					count++;
					btnChoice[4].setEnabled(false);
					board.updateBoard(0, 4, ChipState.FULL);
					btnChoice[4].setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && emptySpace[4] == 1) {

					(button[emptySpace[4]][4]).setBackground(Color.cyan);
					(button[emptySpace[4]][4]).setDisabledIcon(twoChip);
					(button[emptySpace[4]][4]).setIcon((button[emptySpace[4]][4]).getDisabledIcon());
					board.updateBoard(emptySpace[4], 4, ChipState.PLAYER2);
					emptySpace[4]--;
					count++;
					btnChoice[4].setEnabled(false);
					board.updateBoard(0, 4, ChipState.FULL);
					btnChoice[4].setBackground(Color.WHITE);
					isOver();

				}

			} else if (event.getSource() == btnChoice[5] && emptySpace[5] != 0) {

				if (!playerTwoTurn() && emptySpace[5] > 1) {

					(button[emptySpace[5]][5]).setBackground(Color.pink);
					(button[emptySpace[5]][5]).setDisabledIcon(oneChip);
					(button[emptySpace[5]][5]).setIcon((button[emptySpace[5]][5]).getDisabledIcon());
					board.updateBoard(emptySpace[5], 5, ChipState.PLAYER1);
					emptySpace[5]--;
					count++;
					isOver();

				} else if (playerTwoTurn() && emptySpace[5] > 1) {

					(button[emptySpace[5]][5]).setBackground(Color.cyan);
					(button[emptySpace[5]][5]).setDisabledIcon(twoChip);
					(button[emptySpace[5]][5]).setIcon((button[emptySpace[5]][5]).getDisabledIcon());
					board.updateBoard(emptySpace[5], 5, ChipState.PLAYER2);
					emptySpace[5]--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && emptySpace[5] == 1) {

					(button[emptySpace[5]][5]).setBackground(Color.pink);
					(button[emptySpace[5]][5]).setDisabledIcon(oneChip);
					(button[emptySpace[5]][5]).setIcon((button[emptySpace[5]][5]).getDisabledIcon());
					board.updateBoard(emptySpace[5], 5, ChipState.PLAYER1);
					emptySpace[5]--;
					count++;
					btnChoice[5].setEnabled(false);
					board.updateBoard(0, 5, ChipState.FULL);
					btnChoice[5].setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && emptySpace[5] == 1) {

					(button[emptySpace[5]][5]).setBackground(Color.cyan);
					(button[emptySpace[5]][5]).setDisabledIcon(twoChip);
					(button[emptySpace[5]][5]).setIcon((button[emptySpace[5]][5]).getDisabledIcon());
					board.updateBoard(emptySpace[5], 5, ChipState.PLAYER2);
					emptySpace[5]--;
					count++;
					btnChoice[5].setEnabled(false);
					board.updateBoard(0, 5, ChipState.FULL);
					btnChoice[5].setBackground(Color.WHITE);
					isOver();

				}

			} else if (event.getSource() == btnChoice[6] && emptySpace[6] != 0) {

				if (!playerTwoTurn() && emptySpace[6] > 1) {

					(button[emptySpace[6]][6]).setBackground(Color.pink);
					(button[emptySpace[6]][6]).setDisabledIcon(oneChip);
					(button[emptySpace[6]][6]).setIcon((button[emptySpace[6]][6]).getDisabledIcon());
					board.updateBoard(emptySpace[6], 6, ChipState.PLAYER1);
					emptySpace[6]--;
					count++;
					isOver();

				} else if (playerTwoTurn() && emptySpace[6] > 1) {

					(button[emptySpace[6]][6]).setBackground(Color.cyan);
					(button[emptySpace[6]][6]).setDisabledIcon(twoChip);
					(button[emptySpace[6]][6]).setIcon((button[emptySpace[6]][6]).getDisabledIcon());
					board.updateBoard(emptySpace[6], 6, ChipState.PLAYER2);
					emptySpace[6]--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && emptySpace[6] == 1) {

					(button[emptySpace[6]][6]).setBackground(Color.pink);
					(button[emptySpace[6]][6]).setDisabledIcon(oneChip);
					(button[emptySpace[6]][6]).setIcon((button[emptySpace[6]][6]).getDisabledIcon());
					board.updateBoard(emptySpace[6], 6, ChipState.PLAYER1);
					emptySpace[6]--;
					count++;
					btnChoice[6].setEnabled(false);
					board.updateBoard(0, 6, ChipState.FULL);
					btnChoice[6].setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && emptySpace[6] == 1) {

					(button[emptySpace[6]][6]).setBackground(Color.cyan);
					(button[emptySpace[6]][6]).setDisabledIcon(twoChip);
					(button[emptySpace[6]][6]).setIcon((button[emptySpace[6]][6]).getDisabledIcon());
					board.updateBoard(emptySpace[6], 6, ChipState.PLAYER2);
					emptySpace[6]--;
					count++;
					btnChoice[6].setEnabled(false);
					board.updateBoard(0, 6, ChipState.FULL);
					btnChoice[6].setBackground(Color.WHITE);
					isOver();

				}

			}

		}

		/**
		 * Display the game result; who wins the game or tie game.
		 */
		private void isOver() {

			if (board.isDraw()) {

				JOptionPane.showMessageDialog(null, "It's a draw!");
				endPanel();

			} else {

				winner = board.whoWin();
				if (winner != ChipState.EMPTY) {

					if (winner == ChipState.PLAYER1) {

						JOptionPane.showMessageDialog(null, name1 + " wins!");
						endPanel();

					} else {

						JOptionPane.showMessageDialog(null, name2 + " wins!");
						endPanel();

					}

				}

			}

		}

	}

}