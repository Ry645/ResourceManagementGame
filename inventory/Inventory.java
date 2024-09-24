package inventory;

import java.util.ArrayList;

import item.ItemStruct;

public class Inventory {
	public int maxSize = 32;
	public ArrayList<ItemStruct> contentsArray = new ArrayList<ItemStruct>();
	
	public Inventory(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public Inventory() {
		this.maxSize = 32;
	}
	
	//FINISH stick 3 stick 3 stick 3 ---> stick 9
	public void collect(ItemStruct item) {
		if (contentsArray.size() < maxSize) {
			contentsArray.add(item);
		}
	}
	
	public String toString() {
		String temp = "";
		for (int i = 0; i < contentsArray.size(); i++) {
			temp += contentsArray.get(i).name + " " + contentsArray.get(i).count + " ";
		}
		return temp;
	}
	
	public void update() {
		System.out.println("not implemented yet");
	}
}
