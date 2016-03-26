package shah.av;

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

	private static final int ROWS = 7;
	private static final int COLS = 7;

	Board board;

	int count = 0;

	ImageIcon oneChip;
	ImageIcon twoChip;

	ChipState winner;

	int one, two, three, four, five, six, seven;

	private JButton[][] button = new JButton[ROWS][COLS];

	JButton btnOne;
	JButton btnTwo;
	JButton btnThree;
	JButton btnFour;
	JButton btnFive;
	JButton btnSix;
	JButton btnSeven;

	Border thickBorder;

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

		one = ROWS - 1;
		two = ROWS - 1;
		three = ROWS - 1;
		four = ROWS - 1;
		five = ROWS - 1;
		six = ROWS - 1;
		seven = ROWS - 1;
		count = 0;

		btnOne = button[0][0];
		btnOne.setBackground(Color.BLACK);
		btnOne.setBorder(thickBorder);

		btnTwo = button[0][1];
		btnTwo.setBackground(Color.BLACK);
		btnTwo.setBorder(thickBorder);

		btnThree = button[0][2];
		btnThree.setBackground(Color.BLACK);
		btnThree.setBorder(thickBorder);

		btnFour = button[0][3];
		btnFour.setBackground(Color.BLACK);
		btnFour.setBorder(thickBorder);

		btnFive = button[0][4];
		btnFive.setBackground(Color.BLACK);
		btnFive.setBorder(thickBorder);

		btnSix = button[0][5];
		btnSix.setBackground(Color.BLACK);
		btnSix.setBorder(thickBorder);

		btnSeven = button[0][6];
		btnSeven.setBackground(Color.BLACK);
		btnSeven.setBorder(thickBorder);

	}

	private ImageIcon chipIm(String color) {

		ImageIcon chipImg = new ImageIcon(color + ".png");

		return chipImg;

	}

	public boolean playerTwoTurn() {

		boolean playTwoTurn = true;

		if (count % 2 == 0) {

			return playTwoTurn;

		} else {

			return playTwoTurn = false;

		}

	}

	public void endPanel() {

		btnOne.setEnabled(false);
		btnOne.setBackground(Color.WHITE);
		btnOne.setText("T");
		btnOne.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		btnTwo.setEnabled(false);
		btnTwo.setBackground(Color.WHITE);
		btnTwo.setText("H");
		btnTwo.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		btnThree.setEnabled(false);
		btnThree.setBackground(Color.WHITE);
		btnThree.setText("E");
		btnThree.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		btnFour.setEnabled(false);
		btnFour.setBackground(Color.WHITE);
		btnFive.setEnabled(false);
		btnFive.setBackground(Color.WHITE);
		btnFive.setText("E");
		btnFive.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		btnSix.setEnabled(false);
		btnSix.setBackground(Color.WHITE);
		btnSix.setText("N");
		btnSix.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		btnSeven.setEnabled(false);
		btnSeven.setBackground(Color.WHITE);
		btnSeven.setText("D");
		btnSeven.setFont(new Font("Comic Sans MS", Font.BOLD, 35));

	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == btnOne && one != 0) {

				if (!playerTwoTurn() && one > 1) {

					(button[one][0]).setBackground(Color.pink);
					(button[one][0]).setDisabledIcon(oneChip);
					(button[one][0]).setIcon((button[one][0]).getDisabledIcon());
					board.updateBoard(one, 0, ChipState.PLAYER1);
					one--;
					count++;
					isOver();

				} else if (playerTwoTurn() && one > 1) {

					(button[one][0]).setBackground(Color.cyan);
					(button[one][0]).setDisabledIcon(twoChip);
					(button[one][0]).setIcon((button[one][0]).getDisabledIcon());
					board.updateBoard(one, 0, ChipState.PLAYER2);
					one--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && one == 1) {

					(button[one][0]).setBackground(Color.pink);
					(button[one][0]).setDisabledIcon(oneChip);
					(button[one][0]).setIcon((button[one][0]).getDisabledIcon());
					count++;
					btnOne.setEnabled(false);
					board.updateBoard(0, 0, ChipState.FULL);
					btnOne.setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && one == 1) {

					(button[one][0]).setBackground(Color.cyan);
					(button[one][0]).setDisabledIcon(twoChip);
					(button[one][0]).setIcon((button[one][0]).getDisabledIcon());
					count++;
					btnOne.setEnabled(false);
					board.updateBoard(0, 0, ChipState.FULL);
					btnOne.setBackground(Color.WHITE);
					isOver();

				}

			}

			else if (event.getSource() == btnTwo && two != 0) {

				if (!playerTwoTurn() && two > 1) {

					(button[two][1]).setBackground(Color.pink);
					(button[two][1]).setDisabledIcon(oneChip);
					(button[two][1]).setIcon((button[two][1]).getDisabledIcon());
					board.updateBoard(two, 1, ChipState.PLAYER1);
					two--;
					count++;
					isOver();

				} else if (playerTwoTurn() && two > 1) {

					(button[two][1]).setBackground(Color.cyan);
					(button[two][1]).setDisabledIcon(twoChip);
					(button[two][1]).setIcon((button[two][1]).getDisabledIcon());
					board.updateBoard(two, 1, ChipState.PLAYER2);
					two--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && two == 1) {

					(button[two][1]).setBackground(Color.pink);
					(button[two][1]).setDisabledIcon(oneChip);
					(button[two][1]).setIcon((button[two][1]).getDisabledIcon());
					count++;
					btnTwo.setEnabled(false);
					board.updateBoard(0, 1, ChipState.FULL);
					btnTwo.setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && two == 1) {

					(button[two][1]).setBackground(Color.cyan);
					(button[two][1]).setDisabledIcon(twoChip);
					(button[two][1]).setIcon((button[two][1]).getDisabledIcon());
					count++;
					btnTwo.setEnabled(false);
					board.updateBoard(0, 1, ChipState.FULL);
					btnTwo.setBackground(Color.WHITE);
					isOver();

				}

			} else if (event.getSource() == btnThree && three != 0) {

				if (!playerTwoTurn() && three > 1) {

					(button[three][2]).setBackground(Color.pink);
					(button[three][2]).setDisabledIcon(oneChip);
					(button[three][2]).setIcon((button[three][2]).getDisabledIcon());
					board.updateBoard(three, 2, ChipState.PLAYER1);
					three--;
					count++;
					isOver();

				} else if (playerTwoTurn() && three > 1) {

					(button[three][2]).setBackground(Color.cyan);
					(button[three][2]).setDisabledIcon(twoChip);
					(button[three][2]).setIcon((button[three][2]).getDisabledIcon());
					board.updateBoard(three, 2, ChipState.PLAYER2);
					three--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && three == 1) {

					(button[three][2]).setBackground(Color.pink);
					(button[three][2]).setDisabledIcon(oneChip);
					(button[three][2]).setIcon((button[three][2]).getDisabledIcon());
					count++;
					btnThree.setEnabled(false);
					board.updateBoard(0, 2, ChipState.FULL);
					btnThree.setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && three == 1) {

					(button[three][2]).setBackground(Color.cyan);
					(button[three][2]).setDisabledIcon(twoChip);
					(button[three][2]).setIcon((button[three][2]).getDisabledIcon());
					count++;
					btnThree.setEnabled(false);
					board.updateBoard(0, 2, ChipState.FULL);
					btnThree.setBackground(Color.WHITE);
					isOver();

				}

			} else if (event.getSource() == btnFour && four != 0) {

				if (!playerTwoTurn() && four > 1) {

					(button[four][3]).setBackground(Color.pink);
					(button[four][3]).setDisabledIcon(oneChip);
					(button[four][3]).setIcon((button[four][3]).getDisabledIcon());
					board.updateBoard(four, 3, ChipState.PLAYER1);
					four--;
					count++;
					isOver();

				} else if (playerTwoTurn() && four > 1) {

					(button[four][3]).setBackground(Color.cyan);
					(button[four][3]).setDisabledIcon(twoChip);
					(button[four][3]).setIcon((button[four][3]).getDisabledIcon());
					board.updateBoard(four, 3, ChipState.PLAYER2);
					four--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && four == 1) {

					(button[four][3]).setBackground(Color.pink);
					(button[four][3]).setDisabledIcon(oneChip);
					(button[four][3]).setIcon((button[four][3]).getDisabledIcon());
					count++;
					btnFour.setEnabled(false);
					board.updateBoard(0, 3, ChipState.FULL);
					btnFour.setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && four == 1) {

					(button[four][3]).setBackground(Color.cyan);
					(button[four][3]).setDisabledIcon(twoChip);
					(button[four][3]).setIcon((button[four][3]).getDisabledIcon());
					count++;
					btnFour.setEnabled(false);
					board.updateBoard(0, 3, ChipState.FULL);
					btnFour.setBackground(Color.WHITE);
					isOver();

				}

			} else if (event.getSource() == btnFive && five != 0) {

				if (!playerTwoTurn() && five > 1) {

					(button[five][4]).setBackground(Color.pink);
					(button[five][4]).setDisabledIcon(oneChip);
					(button[five][4]).setIcon((button[five][4]).getDisabledIcon());
					board.updateBoard(five, 4, ChipState.PLAYER1);
					five--;
					count++;
					isOver();

				} else if (playerTwoTurn() && five > 1) {

					(button[five][4]).setBackground(Color.cyan);
					(button[five][4]).setDisabledIcon(twoChip);
					(button[five][4]).setIcon((button[five][4]).getDisabledIcon());
					board.updateBoard(five, 4, ChipState.PLAYER2);
					five--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && five == 1) {

					(button[five][4]).setBackground(Color.pink);
					(button[five][4]).setDisabledIcon(oneChip);
					(button[five][4]).setIcon((button[five][4]).getDisabledIcon());
					count++;
					btnFive.setEnabled(false);
					board.updateBoard(0, 4, ChipState.FULL);
					btnFive.setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && five == 1) {

					(button[five][4]).setBackground(Color.cyan);
					(button[five][4]).setDisabledIcon(twoChip);
					(button[five][4]).setIcon((button[five][4]).getDisabledIcon());
					count++;
					btnFive.setEnabled(false);
					board.updateBoard(0, 4, ChipState.FULL);
					btnFive.setBackground(Color.WHITE);
					isOver();

				}

			} else if (event.getSource() == btnSix && six != 0) {

				if (!playerTwoTurn() && six > 1) {

					(button[six][5]).setBackground(Color.pink);
					(button[six][5]).setDisabledIcon(oneChip);
					(button[six][5]).setIcon((button[six][5]).getDisabledIcon());
					board.updateBoard(six, 5, ChipState.PLAYER1);
					six--;
					count++;
					isOver();

				} else if (playerTwoTurn() && six > 1) {

					(button[six][5]).setBackground(Color.cyan);
					(button[six][5]).setDisabledIcon(twoChip);
					(button[six][5]).setIcon((button[six][5]).getDisabledIcon());
					board.updateBoard(six, 5, ChipState.PLAYER2);
					six--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && six == 1) {

					(button[six][5]).setBackground(Color.pink);
					(button[six][5]).setDisabledIcon(oneChip);
					(button[six][5]).setIcon((button[six][5]).getDisabledIcon());
					count++;
					btnSix.setEnabled(false);
					board.updateBoard(0, 5, ChipState.FULL);
					btnSix.setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && six == 1) {

					(button[six][5]).setBackground(Color.cyan);
					(button[six][5]).setDisabledIcon(twoChip);
					(button[six][5]).setIcon((button[six][5]).getDisabledIcon());
					count++;
					btnSix.setEnabled(false);
					board.updateBoard(0, 5, ChipState.FULL);
					btnSix.setBackground(Color.WHITE);
					isOver();

				}

			} else if (event.getSource() == btnSeven && seven != 0) {

				if (!playerTwoTurn() && seven > 1) {

					(button[seven][6]).setBackground(Color.pink);
					(button[seven][6]).setDisabledIcon(oneChip);
					(button[seven][6]).setIcon((button[seven][6]).getDisabledIcon());
					board.updateBoard(seven, 6, ChipState.PLAYER1);
					seven--;
					count++;
					isOver();

				} else if (playerTwoTurn() && seven > 1) {

					(button[seven][6]).setBackground(Color.cyan);
					(button[seven][6]).setDisabledIcon(twoChip);
					(button[seven][6]).setIcon((button[seven][6]).getDisabledIcon());
					board.updateBoard(seven, 6, ChipState.PLAYER2);
					seven--;
					count++;
					isOver();

				} else if (!playerTwoTurn() && seven == 1) {

					(button[seven][6]).setBackground(Color.pink);
					(button[seven][6]).setDisabledIcon(oneChip);
					(button[seven][6]).setIcon((button[seven][6]).getDisabledIcon());
					count++;
					btnSeven.setEnabled(false);
					board.updateBoard(0, 6, ChipState.FULL);
					btnSeven.setBackground(Color.WHITE);
					isOver();

				} else if (playerTwoTurn() && seven == 1) {

					(button[seven][6]).setBackground(Color.cyan);
					(button[seven][6]).setDisabledIcon(twoChip);
					(button[seven][6]).setIcon((button[seven][6]).getDisabledIcon());
					count++;
					btnSeven.setEnabled(false);
					board.updateBoard(0, 6, ChipState.FULL);
					btnSeven.setBackground(Color.WHITE);
					isOver();

				}

			}

		}

		private void isOver() {

			if (board.isDraw()) {

				JOptionPane.showMessageDialog(null, "It's a draw!");
				endPanel();

			} else {

				winner = board.whoWin();
				if (winner != ChipState.EMPTY) {

					JOptionPane.showMessageDialog(null, winner + " wins!");
					endPanel();

				}

			}

		}

	}

}