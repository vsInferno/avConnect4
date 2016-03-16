package shah.av;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectFourPanel extends JPanel {

	final int ROWS = 7;
	final int COLS = 7;

	Chip redChip;
	Chip blueChip;

	int x;
	int y;
	int one;
	int two;
	int three;
	int four;
	int five;
	int six;
	int seven;
	int count;

	private Color blue = Color.BLUE;
	private Color red = Color.RED;
	private JButton[][] button = new JButton[ROWS][COLS];

	JButton btnOne;
	JButton btnTwo;
	JButton btnThree;
	JButton btnFour;
	JButton btnFive;
	JButton btnSix;
	JButton btnSeven;
	JLabel lblOne;

	Graphics g;

	public ConnectFourPanel() {

		setPreferredSize(new Dimension(600, 500));

		setBackground(Color.YELLOW);

		setLayout(new GridLayout(7, 7));

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

		btnTwo = button[0][1];

		btnThree = button[0][2];

		btnFour = button[0][3];

		btnFive = button[0][4];

		btnSix = button[0][5];

		btnSeven = button[0][6];

	}

	public boolean checkWinner() {

		boolean win = false;

		for (int i = ROWS - 1; i > 0; i--) {

			for (int j = 0; j < COLS; j++) {

				if (j < 4) {

					if ((button[i][j].getBackground() == red || button[i][j].getBackground() == blue)
							&& button[i][j].getBackground() == button[i][j + 1].getBackground()
							&& button[i][j].getBackground() == button[i][j + 2].getBackground()
							&& button[i][j].getBackground() == button[i][j + 3].getBackground()) {

						win = true;
						declareWinner(i, j);
						return win;

					}

				}

				if (i > 3) {

					if ((button[i][j].getBackground() == red || button[i][j].getBackground() == blue)
							&& button[i][j].getBackground() == button[i - 1][j].getBackground()
							&& button[i][j].getBackground() == button[i - 2][j].getBackground()
							&& button[i][j].getBackground() == button[i - 3][j].getBackground()) {

						win = true;
						declareWinner(i, j);
						return win;

					}

				}

				if (i > 3 && j < 4) {

					if ((button[i][j].getBackground() == red || button[i][j].getBackground() == blue)
							&& button[i][j].getBackground() == button[i - 1][j + 1].getBackground()
							&& button[i][j].getBackground() == button[i - 2][j + 2].getBackground()
							&& button[i][j].getBackground() == button[i - 3][j + 3].getBackground()) {

						win = true;
						declareWinner(i, j);
						return win;

					}

				}

				if (i > 3 && j > 2) {

					if ((button[i][j].getBackground() == red || button[i][j].getBackground() == blue)
							&& button[i][j].getBackground() == button[i - 1][j - 1].getBackground()
							&& button[i][j].getBackground() == button[i - 2][j - 2].getBackground()
							&& button[i][j].getBackground() == button[i - 3][j - 3].getBackground()) {

						win = true;
						declareWinner(i, j);
						return win;

					}

				}

			}

		}

		return win;

	}

	private void declareWinner(int i, int j) {

		Color color = button[i][j].getBackground();

		if (color == blue) {

			JOptionPane.showMessageDialog(null, "Blue wins!");

		} else if (color == red) {

			JOptionPane.showMessageDialog(null, "Red wins!");

		}

	}

	public void updateBoard() {

		btnOne.setEnabled(false);
		btnTwo.setEnabled(false);
		btnThree.setEnabled(false);
		btnFour.setEnabled(false);
		btnFive.setEnabled(false);
		btnSix.setEnabled(false);
		btnSeven.setEnabled(false);

	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == btnOne && one != 0) {

				if (count % 2 == 0 && one > 1) {

					(button[one][0]).setBackground(blue);
					one--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && one > 1) {

					(button[one][0]).setBackground(red);
					one--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 == 0 && one == 1) {

					(button[one][0]).setBackground(blue);
					count++;
					btnOne.setEnabled(false);
					btnOne.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && one == 1) {

					(button[one][0]).setBackground(red);
					count++;
					btnOne.setEnabled(false);
					btnOne.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				}

			} else if (event.getSource() == btnTwo && two != 0) {

				if (count % 2 == 0 && two > 1) {

					(button[two][1]).setBackground(blue);
					two--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && two > 1) {

					(button[two][1]).setBackground(red);
					two--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 == 0 && two == 1) {

					(button[two][1]).setBackground(blue);
					count++;
					btnTwo.setEnabled(false);
					btnTwo.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && two == 1) {

					(button[two][1]).setBackground(red);
					count++;
					btnTwo.setEnabled(false);
					btnTwo.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				}

			} else if (event.getSource() == btnThree && three != 0) {

				if (count % 2 == 0 && three > 1) {

					(button[three][2]).setBackground(blue);
					three--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && three > 1) {

					(button[three][2]).setBackground(red);
					three--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 == 0 && three == 1) {

					(button[three][2]).setBackground(blue);
					count++;
					btnThree.setEnabled(false);
					btnThree.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && three == 1) {

					(button[three][2]).setBackground(red);
					count++;
					btnThree.setEnabled(false);
					btnThree.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				}

			} else if (event.getSource() == btnFour && four != 0) {

				if (count % 2 == 0 && four > 1) {

					(button[four][3]).setBackground(blue);
					four--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && four > 1) {

					(button[four][3]).setBackground(red);
					four--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 == 0 && four == 1) {

					(button[four][3]).setBackground(blue);
					count++;
					btnFour.setEnabled(false);
					btnFour.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && four == 1) {

					(button[four][3]).setBackground(red);
					count++;
					btnFour.setEnabled(false);
					btnFour.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				}

			} else if (event.getSource() == btnFive && five != 0) {

				if (count % 2 == 0 && five > 1) {

					(button[five][4]).setBackground(blue);
					five--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && five > 1) {

					(button[five][4]).setBackground(red);
					five--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 == 0 && five == 1) {

					(button[five][4]).setBackground(blue);
					count++;
					btnFive.setEnabled(false);
					btnFive.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && five == 1) {

					(button[five][4]).setBackground(red);
					count++;
					btnFive.setEnabled(false);
					btnFive.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				}

			} else if (event.getSource() == btnSix && six != 0) {

				if (count % 2 == 0 && six > 1) {

					(button[six][5]).setBackground(blue);
					six--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && six > 1) {

					(button[six][5]).setBackground(red);
					six--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 == 0 && six == 1) {

					(button[six][5]).setBackground(blue);
					count++;
					btnSix.setEnabled(false);
					btnSix.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && six == 1) {

					(button[six][5]).setBackground(red);
					count++;
					btnSix.setEnabled(false);
					btnSix.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				}

			} else if (event.getSource() == btnSeven && seven != 0) {

				if (count % 2 == 0 && seven > 1) {

					(button[seven][6]).setBackground(blue);
					seven--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && seven > 1) {

					(button[seven][6]).setBackground(red);
					seven--;
					count++;

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 == 0 && seven == 1) {

					(button[seven][6]).setBackground(blue);
					count++;
					btnSeven.setEnabled(false);
					btnSeven.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				} else if (count % 2 != 0 && seven == 1) {

					(button[seven][6]).setBackground(red);
					count++;
					btnSeven.setEnabled(false);
					btnSeven.setBackground(Color.BLACK);

					if (checkWinner()) {

						updateBoard();

					}

				}

			}

		}

	}
}