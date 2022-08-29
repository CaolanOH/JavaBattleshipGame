import java.util.*;
class BattleshipGame {
	private GameHelper helper = new GameHelper();
	private ArrayList<Battleship> battleshipList = new ArrayList<Battleship>();
	private int numOfGuesses = 0;

	/*
	The setUpGame() is a private method with a return type of void. The purpose of this method 
	is to start the game. Three Battle ship objects are created, names are set and added to the 
	battleship ArrayList. Instructions for the user are printed. Locations for each Battleship are 
	created by iterating through the battleshipList ArrayList, calling the helper class method 
	placeBattleship() assigning the result to a new ArrayList called newLocation. the newLocation
	ArrayList is passed into the setLocationCells method for each battleship.
	*/ 
	private void setUpGame(){
		// First make some Battleships and give them locations
		// Battleship 1
		Battleship one = new Battleship();
		one.setName("Battleship");
		// Battleship 2
		Battleship two = new Battleship();
		two.setName("Carrier");
		// Battleship 3
		Battleship three = new Battleship();
		three.setName("Destroyer");

		// Add Battleship one to the battleshipList ArrayList
		battleshipList.add(one);
		// Add Battleship two to the battleshipList ArrayList
		battleshipList.add(two);
		// Add Battleship two to the battleshipList ArrayList
		battleshipList.add(three);

		// Print brief instructions to for the user
		System.out.println("Your goal is to sink three battleships.");
		System.out.println("A Battleship, Carrier, and Destroyer.");
		System.out.println("Try sink them in the fewest number of guesses");

		// Give every battleship in the battleshipList their locations. 
		for (Battleship ship: battleshipList){
			ArrayList<String> newLocation = helper.placeBattleship(3);
			ship.setLocationCells(newLocation);
		}
	}
	/*
	The startPlaying() is a private method with a return type of void. WHILE the battleshipList ArrayList is NOT empty 
	it asks for the users guess. The while statement is the game loop. The checkUserGuess method is called and the which 
	prints the result of the guess. When the battleshipList array list is empty the finishGame() method is called to stop 
	the game.  
	*/
	private void startPlaying(){

		while(!battleshipList.isEmpty()){
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	/*
	The finishGame() method is a private method with a return type of void. It prints the end game message with the
	users number of guesses.
	*/

	private void checkUserGuess(String userGuess){
		numOfGuesses++;
		String result = "miss";

		for (int x = 0; x < battleshipList.size(); x++){
			result = battleshipList.get(x).checkYourself(userGuess);
			if (result.equals("hit")){
				break;
			}
			if (result.equals("kill")){
				battleshipList.remove(x);
				break;
			}
		}
		System.out.println(result);
	}

	private void finishGame(){
		System.out.println("All the ships are destroyed ! You've won the battle.");
		if (numOfGuesses <= 18){
			System.out.println("It only took you "+numOfGuesses+" guesses.");
			System.out.println("Swift and deadly like a true admiral.");
		} else {
			System.out.println("Took you long enough. "+" guesses");
			System.out.println("It's no Hunt for Red October but you got there...eventually.");
		}
	}

	/*
	Main method to start off Battleship Game
	*/
	public static void main (String[] args){
		BattleshipGame game = new BattleshipGame();
		game.setUpGame();
		game.startPlaying();
	}

}