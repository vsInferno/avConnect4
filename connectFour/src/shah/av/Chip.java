package shah.av;

import java.awt.Color;

public class Chip {
	private ChipState state;
	
	public Chip() {

		state = ChipState.EMPTY; 

	}

	public void setChip(ChipState player) {
		state = player;

	}

	public ChipState getState() {

		return state;

	}

}