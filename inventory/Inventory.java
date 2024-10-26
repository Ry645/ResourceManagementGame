package inventory;

import java.util.ArrayList;

import item.ItemStruct;

/**
 * an inventory that can hold ItemStructs.
 *
 * @author Ryan Sexton
 * @version 1.0
 */
public class Inventory {
	private int maxSize; //32
	private ArrayList<ItemStruct> contentsArray = new ArrayList<ItemStruct>();
	
    /**
     * constructs an inventory object.
     *
     * @param maxSize the maximum size
     */
	public Inventory(int maxSize) {
		this.maxSize = maxSize;
	}
	
    /**
     * constructs an inventory object with a max size of 32.
     */
	public Inventory() {
		this.maxSize = 32;
	}
	
	//TODO FINISH stick 3 stick 3 stick 3 ---> stick 9
    /**
     * adds an item into the inventory, stacking them if needed.
     *
     * @param item the item to add
     */
	public void collect(ItemStruct item) {
		if (contentsArray.size() < maxSize) {
			contentsArray.add(item);
		}
	}
	
    @Override
	public String toString() {
		String temp = "";
		for (int i = 0; i < contentsArray.size(); i++) {
			temp += contentsArray.get(i).getName() + " " + contentsArray.get(i).getCount() + " ";
		}
		return temp;
	}
}
