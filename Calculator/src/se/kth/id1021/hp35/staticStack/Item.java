package se.kth.id1021.hp35.staticStack;

class Item {
	private final ItemType type;
	private int value;

	Item( ItemType itemType, int value ) {
		this.type = itemType;
		this.value = value;
	}

	public ItemType getItemType() {
		return type;
	}

	public int getValue() {
		return value;
	}

	enum ItemType {
		ADD, SUB, MUL, DIV, MOD10, SMU, VAL
	}
}
