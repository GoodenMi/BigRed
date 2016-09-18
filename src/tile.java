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
	 * @return String object summary of the tile
     */
	public String generateDescription() {
		String description = "";
		if (this.npc != null && this.inanimateObject != null) { // both exist
			description += "There is a"; // TODO How to determine relationship between npc and item
		} else if (this.npc != null) { // npc exists
			if (this.npc instanceof npc.enemy) {
				description += "There is a " + this.npc.description + " named " + this.npc.name + "."; // TODO Specify for enemy
//			} else if (this.npc instanceof npc.Shopkeeper) {
//				description += "There is a " + this.npc.description + " named " + this.npc.name + "."; // TODO specify for shopkeeper
			} else {
				description += "There is a " + this.npc.description + " named " + this.npc.name + ".";
			}
		} else if (this.inanimateObject != null) { // item exists
			description += "There lies a " + this.inanimateObject.name;
		} else { // neither exist
			description += "There is nothing there.";
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
