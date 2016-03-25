package shah.av;

public class Chip {
	private ChipState state;

	public Chip() {
		state = ChipState.EMPTY;
	}

	public void setChip(ChipState player) {
		state = player;

	}

	public ChipState getChip() {
		return state;

	}

}