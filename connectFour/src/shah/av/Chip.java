package shah.av;
/**
 * Defines a connect four chip and its properties and capabilities. 
 * @author Archit Shah, Vraj Shah
 * @version 1.0
 */
public class Chip {

	private ChipState state;

	/**
	 * Create an empty and unassigned chip.
	 */
	public Chip() {
		this.state = ChipState.EMPTY;
	}

	/**
	 * Assign a chip to a player.
	 * @param player
	 */
	public void setChip(ChipState player) {
		this.state = player;
	}

	/**
	 * Return a chip that is assigned to a player.
	 * @return
	 */
	public ChipState getChip() {
		return state;
	}

	/**
	 * Return true or false depending on whether a column is full.
	 * @return
	 */
	public boolean isFull() {

		if (state == ChipState.FULL) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Check for an empty and unassigned chip. 
	 * @return true -  if the chip is empty 
	 */
	public boolean isEmpty() {

		if (state == ChipState.EMPTY) {
			return true;
		} else {
			return false;
		}

	}

}