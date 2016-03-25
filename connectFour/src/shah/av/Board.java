package shah.av;

public class Board {

	private Chip[][] chip = new Chip[7][7];
//	private ChipState state;

	public Board() {
		for (int row = 0; row < 7 ; row++) {
			for (int col = 0; col < 7; col++) {
				chip[row][col] = new Chip();
			}

		}
	}

	public void updateBoard(int row, int col, ChipState player) {

		chip[row][col] = new Chip(player);
	
	}
	
	

	/*public ChipState isWin() {

	}

	public boolean isDraw() {

	}

	public boolean isEmpty() {

	}*/

}
