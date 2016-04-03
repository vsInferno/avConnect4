package shah.av;

public class Chip {

	private ChipState state;

	public Chip() {

		this.state = ChipState.EMPTY;

	}

	public void setChip(ChipState player) {

		this.state = player;

	}

	public ChipState getChip() {

		return state;

	}

	public boolean isFull() {

		if (state == ChipState.FULL) {

			return true;

		} else {

			return false;

		}

	}

	public boolean isEmpty() {

		if (state == ChipState.EMPTY) {

			return true;

		} else {

			return false;

		}

	}

}