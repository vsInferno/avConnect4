package shah.av;

public class Chip {
	private ChipState state;

	public Chip() {
		this.state = ChipState.EMPTY;
	}
	public Chip(ChipState state) {
		this.state = state;
	}

	public void setChip(ChipState player) {
		this.state = player;
	}

	public ChipState getChip() {
		return state;

	}
	public java.lang.String toString() {
		return "(" + state + ")";

	}

}