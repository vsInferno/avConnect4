package shah.av;

public class Board {

	private Chip[][] chip = new Chip[7][7];

	public Board() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				chip[row][col] = new Chip();
			}

		}
	}

	public void updateBoard(int row, int col, ChipState player) {
	/*	chip.
		//chip[row][col] = 
*/	}

	/*public ChipState isWin() {

	}

	public boolean isDraw() {

	}

	public boolean isEmpty() {

	}*/

}
