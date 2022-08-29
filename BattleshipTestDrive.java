import java.util.*;
class BattleshipTestDrive {
	public 	static void main (String [] args){
		// This is the test class for the battleship game.

		// Create three battleship objects
		Battleship bs01 = new Battleship();
		Battleship bs02 = new Battleship();
		Battleship bs03 = new Battleship();

		// Declare three String arrays, assign them three locations each.

		ArrayList<String> testLoc01 = new ArrayList<String>(Arrays.asList("A1","A2","A3"));
		ArrayList<String> testLoc02 = new ArrayList<String>(Arrays.asList("B1","B2","B3"));
		ArrayList<String> testLoc03 = new ArrayList<String>(Arrays.asList("C1","C2","C3"));

		// Invoke setLocations() method and pass in the test locations
		bs01.setLocationCells(testLoc01);
		bs02.setLocationCells(testLoc02);
		bs03.setLocationCells(testLoc03);
		System.out.println("Battleship one cells : "+bs01.getLocationCells());
		System.out.println("Battleship two cells : "+bs02.getLocationCells());
		System.out.println("Battleship three cells : "+bs03.getLocationCells());

		// Create Strings to represent guesses
		String userGuess01 = "A3";
		String userGuess02 = "B2";
		String userGuess03 = "C3";

		// Invoke the checkYoursel() method passing the guesses
		String result01 = bs01.checkYourself(userGuess01);
		String result02 = bs02.checkYourself(userGuess02);
		String result03 = bs03.checkYourself(userGuess03);

		String testResult = "failed";

		// if the guesses all return a hit the code is working
		if(result01.equals("hit")&& result02.equals("hit")&& result03.equals("hit")){
			testResult = "passed";
		}

		// Print test result.
		System.out.println(testResult);
	}
}