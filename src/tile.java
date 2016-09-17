/**
 *
 */
public class tile {
	private npc npc;
	private item inanimateObject;

	public tile(npc npc, item inanimateObject) {
		this.npc = npc;
		this.inanimateObject = inanimateObject;
	}

	/**
	 * Generates the description based on what the tile contains.
	 *
	 * @return
     */
	public String generateDescription() {
		String description = "";
		if (this.npc != null && this.inanimateObject != null) { // both exist
			description += "There is a";
		} else if (this.npc != null) { // npc exists

		} else if (this.inanimateObject != null) { // item exists

		} else { // neither exist

		}
		return description;
	}

	/** GETTERS */

	// CAN RETURN NULL
	public npc getNpc() {
		return this.npc;
	}

	// CAN RETURN NULL
	public item getInanimateObject() {
		return this.inanimateObject;
	}

	/** SETTERS */

	public void setNpc(npc npc) {
		this.npc = npc;
	}

	public void setInanimateObject(item inanimateObject) {
		this.inanimateObject = inanimateObject;
	}
}
