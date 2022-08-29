import java.util.ArrayList;
class Battleship{

	private ArrayList<String> locationCells;
	private String name;

	public void setLocationCells(ArrayList<String> loc){
		locationCells = loc;
	}

	public ArrayList<String> getLocationCells(){
		return locationCells;
	}

	public void setName (String n){
		name = n;
	}

	public String checkYourself(String userInput){
		String result = "miss";
		// Find out if the user guess is in teh ArrayList, by asking for its index.
		// if it's not in the list indexOf() returns a -1
		int index = locationCells.indexOf(userInput);
		//if the index is greater than or equal to zero, the user guess is definitely in the list, so remove it
		if (index >= 0){
			locationCells.remove(index);

			// if the list is empty, this was a killing blow.
			if (locationCells.isEmpty()){
				result = "kill";
				System.out.println("You sunk a "+name+" : (");
			} else {
				result = "hit";
				}
			}
		return result;
	}
}