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

	int count = 0;
	
	ImageIcon oneChip;
	ImageIcon twoChip;

	Chip play1;
	Chip play2;

	int one,two,three,four,five,six,seven;
	
	boolean playTwo = false;
	
	private Color blue = Color.BLUE;
	private Color red = Color.RED;
	private Color pink = Color.pink;
	private Color cyan = Color.cyan;

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

		play1 = new Chip();
		play2 = new Chip();

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

		
		  one = ROWS - 1; two = ROWS - 1; three = ROWS - 1; four = ROWS - 1;
		  five = ROWS - 1; six = ROWS - 1; seven = ROWS - 1; count = 0;
		 
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

	/*/
	  private void declareWinner(int i, int j) {
	  
	  Color color = button[i][j].getBackground();
	  
	  if (color == pink) {
	  
	  JOptionPane.showMessageDialog(null, name1 + " wins!");
	  
	  } else if (color == cyan) {
	  
	  JOptionPane.showMessageDialog(null, name2 + " wins!");
	  
	  }
	  
	  }
	 /*/

	public boolean playerOneTurn() {
		
		boolean playTwoTurn = false;
	
		if (count % 2 == 0) {
			return playTwoTurn;
		} else {
			return playTwoTurn = true;
		}
	}
	
	public void updateBoard() {

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
		int x = 6; int y = 0;
		
		public void actionPerformed(ActionEvent event) {

	
			  if (event.getSource() == btnOne && one != 0) {
				  
				  if ( playTwo && one > 1) {
				  (button[one][0]).setBackground(Color.pink);
				  (button[one][0]).setDisabledIcon(oneChip);
				  (button[one][0]).setIcon((button[one][0]).getDisabledIcon());
				  one--; count++;
				  
				  /*if (checkWinner()) {
				  
				  updateBoard();
				  
				  }*/
				  
				  } else if (!playTwo && one > 1) {
				  (button[one][0]).setBackground(Color.cyan);
				  (button[one][0]).setDisabledIcon(twoChip);
				  (button[one][0]).setIcon((button[one][0]).getDisabledIcon());
				  one--; count++;
				  
				  /*if (checkWinner()) {
				  
				  updateBoard();
				  
				  }*/
				  
				  } else if ( playTwo && one == 1) {
				  
				  (button[one][0]).setBackground(Color.pink);
				  (button[one][0]).setDisabledIcon(oneChip);
				  (button[one][0]).setIcon((button[one][0]).getDisabledIcon());
				  count++;
				  btnOne.setEnabled(false);
				  btnOne.setBackground(Color.WHITE);
				  
				 /* if (checkWinner()) {
				  
				  updateBoard();
				  
				  }*/
				  
				  } else if (!playTwo && one == 1) {
				  
				  (button[one][0]).setBackground(Color.cyan);
				  (button[one][0]).setDisabledIcon(twoChip);
				  (button[one][0]).setIcon((button[one][0]).getDisabledIcon());
				  count++;btnOne.setEnabled(false);
				  btnOne.setBackground(Color.WHITE);
				  
				 /* if (checkWinner()) {
				  
				  updateBoard();
				  
				  }*/
				  
				  }  
				  playTwo = playerOneTurn();
				  System.out.println(count);
				 
			  }

			
			  
			  else if (event.getSource() == btnTwo && two != 0) {
			  
			  if ( playTwo && two > 1) {
			  (button[two][1]).setBackground(Color.pink);
			  (button[two][1]).setDisabledIcon(oneChip);
			  (button[two][1]).setIcon((button[two][1]).getDisabledIcon());
			  two--; count++;
			  
			  /*if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if (!playTwo && two > 1) {
			  (button[two][1]).setBackground(Color.cyan);
			  (button[two][1]).setDisabledIcon(twoChip);
			  (button[two][1]).setIcon((button[two][1]).getDisabledIcon());
			  two--; count++;
			  
			  /*if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if ( playTwo && two == 1) {
			  
			  (button[two][1]).setBackground(Color.pink);
			  (button[two][1]).setDisabledIcon(oneChip);
			  (button[two][1]).setIcon((button[two][1]).getDisabledIcon());
			  count++; btnTwo.setEnabled(false);
			  btnTwo.setBackground(Color.WHITE);
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if (!playTwo && two == 1) {
			  
			  (button[two][1]).setBackground(Color.cyan);
			  (button[two][1]).setDisabledIcon(twoChip);
			  (button[two][1]).setIcon((button[two][1]).getDisabledIcon());
			  count++; btnTwo.setEnabled(false);
			  btnTwo.setBackground(Color.WHITE);
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  }
			  
			  playTwo = playerOneTurn();
			  } else if (event.getSource() == btnThree && three != 0) {
			  
			  if ( playTwo && three > 1) {
			  
			  (button[three][2]).setBackground(Color.pink);
			  (button[three][2]).setDisabledIcon(oneChip);
			  (button[three][2]).setIcon((button[three][2]).getDisabledIcon());
			  three--; count++;
			  
			  /*if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if (!playTwo && three > 1) {
			  
			  (button[three][2]).setBackground(Color.cyan);
			  (button[three][2]).setDisabledIcon(twoChip);
			  (button[three][2]).setIcon((button[three][2]).getDisabledIcon());
			  three--; count++;
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if ( playTwo && three == 1) {
			  
			  (button[three][2]).setBackground(Color.pink);
			  (button[three][2]).setDisabledIcon(oneChip);
			  (button[three][2]).setIcon((button[three][2]).getDisabledIcon());
			  
			  count++; btnThree.setEnabled(false);
			  btnThree.setBackground(Color.WHITE);
			  
			  /*if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if (!playTwo && three == 1) {
			  
			  (button[three][2]).setBackground(Color.cyan);
			  (button[three][2]).setDisabledIcon(twoChip);
			  (button[three][2]).setIcon((button[three][2]).getDisabledIcon());
			  
			  count++; btnThree.setEnabled(false);
			  btnThree.setBackground(Color.WHITE);
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  }
			  playTwo = playerOneTurn();
			  } else if (event.getSource() == btnFour && four != 0) {
			  
			  if ( playTwo && four > 1) {
			  
			  (button[four][3]).setBackground(Color.pink);
			  (button[four][3]).setDisabledIcon(oneChip);
			  (button[four][3]).setIcon((button[four][3]).getDisabledIcon());
			  four--; count++;
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if (!playTwo && four > 1) {
			  
			  (button[four][3]).setBackground(Color.cyan);
			  (button[four][3]).setDisabledIcon(twoChip);
			  (button[four][3]).setIcon((button[four][3]).getDisabledIcon());
			  four--; count++;
			  
			  /*if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if ( playTwo && four == 1) {
			  
			  (button[four][3]).setBackground(Color.pink);
			  (button[four][3]).setDisabledIcon(oneChip);
			  (button[four][3]).setIcon((button[four][3]).getDisabledIcon());
			  count++; btnFour.setEnabled(false);
			  btnFour.setBackground(Color.WHITE);
			  
			  /*if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if (!playTwo && four == 1) {
			  
			  (button[four][3]).setBackground(Color.cyan);
			  (button[four][3]).setDisabledIcon(twoChip);
			  (button[four][3]).setIcon((button[four][3]).getDisabledIcon());
			  count++; btnFour.setEnabled(false);
			  btnFour.setBackground(Color.WHITE);
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  }
			  
			  playTwo = playerOneTurn();
			  } else if (event.getSource() == btnFive && five != 0) {
			  
			  if ( playTwo && five > 1) {
			  
			  (button[five][4]).setBackground(Color.pink);
			  (button[five][4]).setDisabledIcon(oneChip);
			  (button[five][4]).setIcon((button[five][4]).getDisabledIcon());
			  five--; count++;
			  
			  /*if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if (!playTwo && five > 1) {
			  
			  (button[five][4]).setBackground(Color.cyan);
			  (button[five][4]).setDisabledIcon(twoChip);
			  (button[five][4]).setIcon((button[five][4]).getDisabledIcon());
			  five--; count++;
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if ( playTwo && five == 1) {
			  
			  (button[five][4]).setBackground(Color.pink);
			  (button[five][4]).setDisabledIcon(oneChip);
			  (button[five][4]).setIcon((button[five][4]).getDisabledIcon());
			  count++; btnFive.setEnabled(false);
			  btnFive.setBackground(Color.WHITE);
			  
			  /*if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if (!playTwo && five == 1) {
			  
			  (button[five][4]).setBackground(Color.cyan);
			  (button[five][4]).setDisabledIcon(twoChip);
			  (button[five][4]).setIcon((button[five][4]).getDisabledIcon());
			  count++; btnFive.setEnabled(false);
			  btnFive.setBackground(Color.WHITE);
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  }
			  playTwo = playerOneTurn(); 
			  } else if (event.getSource() == btnSix && six != 0) {
			  
			  if ( playTwo && six > 1) {
			  
			  (button[six][5]).setBackground(Color.pink);
			  (button[six][5]).setDisabledIcon(oneChip);
			  (button[six][5]).setIcon((button[six][5]).getDisabledIcon());
			  six--; count++;
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if (!playTwo && six > 1) {
			  
			  (button[six][5]).setBackground(Color.cyan);
			  (button[six][5]).setDisabledIcon(twoChip);
			  (button[six][5]).setIcon((button[six][5]).getDisabledIcon());
			  six--; count++;
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if ( playTwo && six == 1) {
			  
			  (button[six][5]).setBackground(Color.pink);
			  (button[six][5]).setDisabledIcon(oneChip);
			  (button[six][5]).setIcon((button[six][5]).getDisabledIcon());
			  count++; btnSix.setEnabled(false);
			  btnSix.setBackground(Color.WHITE);
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if (!playTwo && six == 1) {
			  
			  (button[six][5]).setBackground(Color.cyan);
			  (button[six][5]).setDisabledIcon(twoChip);
			  (button[six][5]).setIcon((button[six][5]).getDisabledIcon());
			  count++; btnSix.setEnabled(false);
			  btnSix.setBackground(Color.WHITE);
			  
			  /*if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  }
			  playTwo = playerOneTurn();  
			  } else if (event.getSource() == btnSeven && seven != 0) {
			  
			  if ( playTwo && seven > 1) {
			  
			  (button[seven][6]).setBackground(Color.pink);
			  (button[seven][6]).setDisabledIcon(oneChip);
			  (button[seven][6]).setIcon((button[seven][6]).getDisabledIcon());
			  seven--; count++;
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if (!playTwo && seven > 1) {
			  
			  (button[seven][6]).setBackground(Color.cyan);
			  (button[seven][6]).setDisabledIcon(twoChip);
			  (button[seven][6]).setIcon((button[seven][6]).getDisabledIcon());
			  seven--; count++;
			  
			  /*if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if ( playTwo && seven == 1) {
			  
			  (button[seven][6]).setBackground(Color.pink);
			  (button[seven][6]).setDisabledIcon(oneChip);
			  (button[seven][6]).setIcon((button[seven][6]).getDisabledIcon());
			  count++; btnSeven.setEnabled(false);
			  btnSeven.setBackground(Color.WHITE);
			  
			  /*if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  } else if (!playTwo && seven == 1) {
			  
			  (button[seven][6]).setBackground(Color.cyan);
			  (button[seven][6]).setDisabledIcon(twoChip);
			  (button[seven][6]).setIcon((button[seven][6]).getDisabledIcon());
			  count++; btnSeven.setEnabled(false);
			  btnSeven.setBackground(Color.WHITE);
			  
			 /* if (checkWinner()) {
			  
			  updateBoard();
			  
			  }*/
			  
			  }
			  playTwo = playerOneTurn();
			  }
			  
			  }
			 
		}

	}
