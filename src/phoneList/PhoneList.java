package phoneList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Phone List
 * 
 * You'll be using an ArrayList of Contact objects
 * to crate a digital address book.
 * 
 * You MUST
 *   - Use an ArrayList
 *   - Keep list in alphabetical order
 *   - Complete the given methods
 *   
 * You May
 *   - Add methods as you see fit
 *   - Change method parameters and return types
 *   
 * You May NOT
 *   - change the menu method
 *        unless you're changing what methods it calls
 * 
 */


public class PhoneList {

	/*
	 * Instance Variables
	 */
	private Contact name;
	private Contact number;
	ArrayList<Contact> PhoneList;
	
	
	//Constructor
	public PhoneList() {
		//initialize instance variables
		PhoneList = new ArrayList<Contact>();
		
		
	}
	
	
	/*
	 * This should do the following
	 * (whatever order you feel is best)
	 *   - ask the user for contact's name and number--done
	 *   - create a new Contact object with that input--done
	 *   - add that object to the phone list
	 *        in alphabetical order
	 *        Hint: compareTo(String other)
	 *   - tell the user what the new contact is and that 
	 *        it's been added
	 */
	public void addContact() {
		
		Scanner inKey = new Scanner (System.in);
		System.out.print("What is the contact name: ");
		String userName = inKey.nextLine();
		System.out.print("What is their phone number: ");
		Long userNum = inKey.nextLong();
		
		PhoneList.add(new Contact(userName, userNum));
		
		for(int i = 0; i<PhoneList.size(); i++) {
			
			for (int j = i +1; j < PhoneList.size(); j++) {
				int num = PhoneList.get(i).getName().compareToIgnoreCase(PhoneList.get(j).getName());//compare to get a value
				
				if (num > 0) {
					Contact holder = PhoneList.get(i);
					Contact holder1 = PhoneList.get(j);
					
					PhoneList.set(i, holder);
					PhoneList.set(j, holder1);
					
				}
			}
		}
		
		if (PhoneList.size()>=1) {
			
		}
		
		
	}
	
	public int compare (String s1, String s2) {
		
		return s1.compareTo(s2);
	}
	
	
	/*
	 * This should do the following
	 * (whatever order you feel is best)
	 *   - ask the user for the contact's name--done
	 *   - search through the list for that contact
	 *   - if the contact is not found
	 *        tell the user and end the method
	 *   - if the contact is found
	 *        Remove the item from the list
	 *        Print the contact's name and number
	 *        Say that contact has been removed
	 *        Remove the item from the list
	 *        
	 */
	public void removeContact() {
		Scanner inKey = new Scanner (System.in);
		System.out.print("What is the contact you wish to remove: ");
		String takeThis = inKey.nextLine();
		
		boolean there = false;
		int theNum;
		
		for (int i = 0; i < PhoneList.size(); i++) {
			if (takeThis.equalsIgnoreCase(PhoneList.get(i).getName())) {
				there = true;
				System.out.println(PhoneList.get(i) + " has been removed");
				PhoneList.remove(i);
				break;
			}
			else {
				there = false;
				
			}
		}
		
		if (there = false) {
			System.out.println("This contact is not in your contacts");
		}
	}
	
	
	/*
	 * This should
	 *   - Print all items in list
	 *   - Must be headers for all columns
	 *   - print in alphabetical order
	 *   - print line of something to "box" the list
	 *       Examples:
	 *          *****************
	 *          -----------------
	 *          #################
	 */
	public void printList() {
		
		System.out.println("Name          Number");
		System.out.println("--------------------");
		
		for(int i = 0; i < PhoneList.size(); i++) {
			
			System.out.println(PhoneList.get(i) + "\n");//prints in order
		}
		
		System.out.println("--------------------");
	}

	
	
	/*
	 * GET FAMILIAR WITH THIS MENU!!!!
	 * 
	 * I will be asking you to create programs with menus.
	 * You may do them however you like.  But here is an example
	 * of how to manage them.
	 * 
	 */
	public void menu() {
		
		int input = 0;
		
		String menu = "-----------------------\n"
				    + "     Contacts Menu     \n"
				    + "-----------------------\n"
				    + "  1 - Add Contact      \n"
				    + "  2 - Remove Contact   \n"
				    + "  3 - Print List       \n"
				    + "  4 - Quit             \n\n"
				    + "Enter Choice: ";
		
		while (input != 4) {  //keep looping till user want's to quit
			
			//try getting an input
			try {
				String inputString = getString("\n" + menu);  //get input
				input = Integer.valueOf(inputString);  //try converting to int
			}
			catch (Exception e) {
				//if bad input, set input to 0
				input = 0;  
			}
		
			switch (input) {
			case 1:
				//handle menu line 1: Add Contact
				addContact();
				break;
			case 2:
				//handle menu line 2: Remove Contact
				removeContact();
				break;
			case 3:
				//handle menu line 3: Print List
				printList();
				break;
			case 4:
				//handle menu line 4: Quit
				System.out.println("\nGoodbye!");
				break;
			default:
				System.out.println("\nNot a valid input.\n"
								 + "Please try again.");
			}
			
			
		
		}
		
	}
	
	public String getString(String str) {
		
		Scanner inKey = new Scanner(System.in);
		System.out.print(str);  //notice it's NOT a print line.  This way input is next to question.
		return inKey.nextLine();
		
	}
	
	
	public static void main(String[] args) {
		PhoneList app = new PhoneList();
		app.menu();
	}
}
