
import java.util.List;
import java.util.Scanner;

import controller.KeySwitchHelper;
import model.KeySwitch;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static KeySwitchHelper ksh = new KeySwitchHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a color: ");
			String color = in.nextLine();
			System.out.print("Enter the operating force: ");
			int operatingForce = in.nextInt();
			System.out.print("Is the key clicky?: ");
			boolean clicky = in.nextBoolean();
			KeySwitch toAdd = new KeySwitch(color, operatingForce, clicky);
			ksh.insertKey(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a color: ");
			String color = in.nextLine();
			System.out.print("Enter the operating force: ");
			int operatingForce = in.nextInt();
			System.out.print("Is the key clicky?: ");
			boolean clicky = in.nextBoolean();
			KeySwitch toDelete = new KeySwitch(color, operatingForce, clicky); 
			ksh.deleteKey(toDelete);
		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Color");
			System.out.println("2 : Search by Operating Force");
			System.out.println("3 : Search by Tactile");
			int searchBy = in.nextInt();
			in.nextLine();
			List<KeySwitch> foundItems = null;
			if (searchBy == 1) {
				System.out.print("Enter the color: ");
				String keyColor = in.nextLine();
				foundItems = ksh.searchForColor(keyColor);
				} 
			else if (searchBy == 2){
					System.out.print("Enter the operating force: ");
					int keyOperatingForce = in.nextInt();
					foundItems = ksh.searchForOperatingForce(keyOperatingForce); 
				}
			else if (searchBy == 3){
				System.out.print("Enter the tactility: ");
				boolean keyTactility = in.nextBoolean();
				foundItems = ksh.searchForTactile(keyTactility); 
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (KeySwitch l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				KeySwitch toEdit = ksh.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getColor() + " from " + toEdit.getOperatingForce() + toEdit.getTactile());
				System.out.println("1 : Update Color");
				System.out.println("2 : Update Operating Force");
				System.out.println("3 : Update Tactile");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Color: ");
					String newColor = in.nextLine();
					toEdit.setColor(newColor);
				} else if (update == 2) {
					System.out.print("New Operating Force: ");
					int newOperatingForce = in.nextInt();
					toEdit.setOperatingForce(newOperatingForce);
				}
				else if (update == 3) {
					System.out.print("New Tactile: ");
					boolean newTactile = in.nextBoolean();
					toEdit.setTactile(newTactile);
				}

				ksh.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					//ksh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<KeySwitch> allSwitches = ksh.showAllKeys();
			for(KeySwitch singleItem : allSwitches){
				System.out.println(singleItem.toString());
			}

		}

	}
