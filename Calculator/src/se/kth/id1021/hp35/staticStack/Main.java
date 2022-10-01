package se.kth.id1021.hp35.staticStack;

public class Main {
	public static void main( String[] args ) {

		Item[] calculateLastDigit =
				{ new Item( Item.ItemType.VAL, 9 ), new Item( Item.ItemType.VAL, 2 ), new Item( Item.ItemType.SMU, 0 ),
				  new Item( Item.ItemType.VAL, 3 ), new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.VAL, 0 ),
				  new Item( Item.ItemType.VAL, 2 ), new Item( Item.ItemType.SMU, 0 ), new Item( Item.ItemType.ADD, 0 ),
				  new Item( Item.ItemType.VAL, 4 ), new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.VAL, 0 ),
				  new Item( Item.ItemType.VAL, 2 ), new Item( Item.ItemType.SMU, 0 ), new Item( Item.ItemType.ADD, 0 ),
				  new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.VAL, 5 ),
				  new Item( Item.ItemType.VAL, 2 ), new Item( Item.ItemType.SMU, 0 ), new Item( Item.ItemType.ADD, 0 ),
				  new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.VAL, 9 ),
				  new Item( Item.ItemType.VAL, 2 ), new Item( Item.ItemType.SMU, 0 ), new Item( Item.ItemType.ADD, 0 ),
				  new Item( Item.ItemType.MOD10, 0 ), new Item( Item.ItemType.VAL, 10 ),
				  new Item( Item.ItemType.SUB, 0 ) };


		Item[] benchmark =
				{ new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.VAL, 5 ),
				  new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.ADD, 0 ),
				  new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.VAL, 5 ),
				  new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.ADD, 0 ),
				  new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.VAL, 5 ),
				  new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.ADD, 0 ),
				  new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.VAL, 5 ),
				  new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.ADD, 0 ),
				  new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.VAL, 5 ),
				  new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.ADD, 0 ),
				  new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.VAL, 5 ),
				  new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.ADD, 0 ),
				  new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.VAL, 5 ),
				  new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.ADD, 0 ),
				  new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.VAL, 5 ),
				  new Item( Item.ItemType.VAL, 5 ), new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.ADD, 0 ),
				  new Item( Item.ItemType.ADD, 0 ), new Item( Item.ItemType.VAL, 5 ),
				  new Item( Item.ItemType.ADD, 0 ) };

		Calculator hp35 = new Calculator();

		for ( int i = 0; i < 100_000; i++ ) {
			hp35.run( benchmark );
		}

		long t0 = System.nanoTime();
		for ( int i = 0; i < 1_000_000; i++ ) {
			hp35.run( benchmark );
		}
		long t1 = System.nanoTime();

		// System.out.println( "Result: " + result );
		System.out.println( "Time: " + ( double ) ( t1 - t0 ) / 1_000_000 );
	}
}
