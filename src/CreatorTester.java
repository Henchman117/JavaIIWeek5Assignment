import java.util.List;

import main.java.controller.CreatorHelper;
import main.java.controller.ListDetailsHelper;
import main.java.model.Creator;
import main.java.model.ListDetails;

public class CreatorTester {
	public static void main(String[] args) {
		Creator tom = new Creator("tom");
		
		CreatorHelper ch = new CreatorHelper();
		
		ch.insertCreator(tom);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails tomList = new ListDetails("tom's List", tom);
		ldh.insertNewListDetails(tomList);
		List<ListDetails> allLists = ldh.getLists();
		
		//List<Creator> allCreators = ch.showAllCreators();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
	}
	
}
