package se.kth.id1021.hp35.dynamicStack;

class Item {
	private final ItemType itemType;
	private int value;

	Item( ItemType type, int value ) {
		this.itemType = type;
		this.value = value;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public int getValue() {
		return value;
	}

	enum ItemType {
		ADD, SUB, MUL, DIV, MOD10, SMU, VAL
	}
}
