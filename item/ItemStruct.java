package item;
public class ItemStruct {
	public static final String[] ITEM_IDS = {
		"stick",
		"rock",
		"berry",
	};
	
	public String name = "ITEM_NAME_NOT_INIT";
	public int count;
	
	public ItemStruct(String name, int count) {
		boolean itemFound = false;
		for (int i = 0; i < ITEM_IDS.length; i++) {
			//TEMP implement better searching algorithm
			//also i might have to use .equals instead but we'll see
			//TEST
			if (name == ITEM_IDS[i]) {
				itemFound = true;
				break;
			}
		}
		if (!itemFound) {
			//TEMP later use exceptions
			System.out.println("ERROR1 : item id not found");
		}
		this.name = name;
		this.count = count;
	}
	
	//WARNING faster but more risky
	//used for generating large sets of items quickly
	//MAKE SURE the item is in the ITEM_IDS array
	//will call no matter if boolean is true or false if boolean is inputted
	public ItemStruct(String name, int count, boolean skipCheck) {
		this.name = name;
		this.count = count;
	}
}
