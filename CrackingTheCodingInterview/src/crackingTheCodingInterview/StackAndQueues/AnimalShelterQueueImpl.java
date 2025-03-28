package crackingTheCodingInterview.StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Animal {
	int val;

	public Animal(int val) {
		super();
		this.val = val;
	}
}

class Cat extends Animal {
	int val;

	public Cat(int val) {
		super( val );
		this.val = val;
	}
}

class Dog extends Animal {
	int val;
	
	public Dog(int val) {
		super( val );
		this.val = val;
	}
}

class ShelterQueue {
	Queue< Cat > catQueue = new LinkedList<>(); 
	Queue< Dog > dogQueue = new LinkedList<>();
	
	public void enQueue( Animal animal ) {
		
		if( animal instanceof Dog ) {
			dogQueue.add( (Dog) animal );
		} else {
			catQueue.add( (Cat) animal );
		}
	}
	
	public Animal getOldestAnimal() {
		Animal returnAnimal = null;
		Cat cat = catQueue.peek();
		Dog dog = dogQueue.peek();
		
		if( cat.val < dog.val ) {
			returnAnimal = catQueue.poll();
		} else {
			returnAnimal = dogQueue.poll();
		}
		return returnAnimal;
	}
	
	public Cat getOldestCat() {
		Cat returnAnimal = null;
		returnAnimal = catQueue.poll();
		return returnAnimal;
	}

	public Dog getOldestDog() {
		Dog returnAnimal = null;
		returnAnimal = dogQueue.poll();
		return returnAnimal;
	}
}

public class AnimalShelterQueueImpl {

	public static void main(String[] args) {
		Random random = new Random();
		ShelterQueue queue = new ShelterQueue();
		
		for( int i = 0; i < 10; i++ ) {
			int randVal = random.nextInt( 2 );
			
			if( randVal == 0 ) {
				queue.enQueue( new Dog( i ) );
				System.out.println( " Dog at >> " + i );
			} else {
				queue.enQueue( new Cat( i ) );
				System.out.println( " Cat at >> " + i );
			}
		}
		
		System.out.println( queue.getOldestAnimal().val );
		System.out.println( queue.getOldestDog().val );
		System.out.println( queue.getOldestCat().val );

	}
}
