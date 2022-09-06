package se.kth.id1021.hp35.staticStack;

import java.util.EmptyStackException;

public class Calculator {
	Item[] mathExpression;
	int instructionPointer = 0;
	Stack stack;

	public Calculator(  ) {
		this.stack = new Stack();
	}

	public int run( Item[] mathExpression ) {
		this.mathExpression = mathExpression;

		while ( instructionPointer < mathExpression.length ) {
			step();
		}
		instructionPointer = 0;
		return stack.pop();
	}

	public void step() {
		Item nextItem = mathExpression[ instructionPointer++ ];

		switch ( nextItem.getItemType() ) {
			case ADD -> {
				int x = stack.pop();
				int y = stack.pop();
				stack.push( x + y );
			}
			case SUB -> {
				int x = stack.pop();
				int y = stack.pop();
				stack.push( x - y );
			}
			case MUL -> {
				int x = stack.pop();
				int y = stack.pop();
				stack.push( x * y );
			}
			case SMU -> {
				int x = stack.pop();
				int y = stack.pop();
				int z = x * y;
				int sumOfDigits = 0;

				while ( z != 0 ) {
					sumOfDigits += z % 10;
					z /= 10;
				}

				stack.push( sumOfDigits );
			}
			case DIV -> {
				int x = stack.pop();
				int y = stack.pop();
				stack.push( x / y );
			}
			case MOD10 -> {
				int x = stack.pop();
				stack.push( x % 10 );
			}
			case VAL -> {
				stack.push( nextItem.getValue() );
			}
		}
	}

	protected static class Stack {
		private final int[] array;
		private final int STACK_SIZE = 8;
		int stackPointer;

		protected Stack() {
			this.array = new int[ STACK_SIZE ];
			this.stackPointer = -1;
		}

		protected void push( int valueToPush ) {
			if ( isFull() ) {
				throw new StackOverflowError();
			}

			else {
				array[ ++stackPointer ] = valueToPush;
			}
		}

		private boolean isFull() {
			return stackPointer == STACK_SIZE - 1;
		}

		protected int pop() {
			if ( isEmpty() ) {
				throw new EmptyStackException();
			}

			return array[ stackPointer-- ];
		}

		private boolean isEmpty() {
			return stackPointer == -1;
		}
	}
}

