package shah.av;

public class Board {

	private Chip[][] chip = new Chip[7][7];

	public Board() {

		for (int row = 0; row < 7; row++) {

			for (int col = 0; col < 7; col++) {

				chip[row][col] = new Chip();

			}

		}

	}

	public int[] aiMove(int[] emptySpace) {

		int[] location = new int[2];

		for (int i = 0; i < 7; i++) {

			for (int j = 0; j < 7; j++) {

				if ((emptySpace[j] >= 3) && (chip[i][j].getChip() == ChipState.PLAYER2) &&(chip[i-1][j].getChip() == ChipState.EMPTY)) {

					location[0] = i - 1;
					location[1] = j;
					return location;

				}

			}

		}

		
		int column = (int) (Math.random() * emptySpace.length);
		
		location[0] = emptySpace[column];
		location[1] = column;
		
		while(chip[0][1].getChip() != ChipState.EMPTY) {
			column = (int) (Math.random() * emptySpace.length);
			
			location[0] = emptySpace[column];
			location[1] = column;
			
		}
		

		return location;

	}

	public void updateBoard(int row, int col, ChipState player) {

		chip[row][col].setChip(player);

	}

	public ChipState whoWin() {

		ChipState win = ChipState.EMPTY;

		for (int i = 7 - 1; i > 0; i--) {

			for (int j = 0; j < 7; j++) {

				if (j < 4) {

					if (!(chip[i][j].isEmpty()) && chip[i][j].getChip() == chip[i][j + 1].getChip()
							&& chip[i][j].getChip() == chip[i][j + 2].getChip()
							&& chip[i][j].getChip() == chip[i][j + 3].getChip()) {

						win = chip[i][j].getChip();

					}

				}

				if (i > 3) {

					if (!(chip[i][j].isEmpty()) && chip[i][j].getChip() == chip[i - 1][j].getChip()
							&& chip[i][j].getChip() == chip[i - 2][j].getChip()
							&& chip[i][j].getChip() == chip[i - 3][j].getChip()) {

						win = chip[i][j].getChip();

					}

				}

				if (i > 3 && j < 4) {

					if (!(chip[i][j].isEmpty()) && chip[i][j].getChip() == chip[i - 1][j + 1].getChip()
							&& chip[i][j].getChip() == chip[i - 2][j + 2].getChip()
							&& chip[i][j].getChip() == chip[i - 3][j + 3].getChip()) {

						win = chip[i][j].getChip();

					}

				}

				if (i > 3 && j > 2) {

					if (!(chip[i][j].isEmpty()) && chip[i][j].getChip() == chip[i - 1][j - 1].getChip()
							&& chip[i][j].getChip() == chip[i - 2][j - 2].getChip()
							&& chip[i][j].getChip() == chip[i - 3][j - 3].getChip()) {

						win = chip[i][j].getChip();

					}

				}

			}

		}

		return win;

	}

	public boolean isDraw() {

		boolean draw = false;

		if (chip[0][0].isFull() && chip[0][1].isFull() && chip[0][2].isFull() && chip[0][3].isFull()
				&& chip[0][4].isFull() && chip[0][5].isFull() && chip[0][6].isFull()) {

			draw = true;

		}

		return draw;

	}

}