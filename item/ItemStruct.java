package item;

/**
 * an item with a unique name.
 * can be stacked.
 *
 * @author Ryan Sexton
 * @version 1.0
 */
public class ItemStruct {
	/**
     * the name of every single known item.
     */
    public static final String[] ALL_ITEM_NAMES = {
		"stick",
		"rock",
		"berry",
	};
	
	private String name = "ITEM_NAME_NOT_INIT";
	private int count;
    private boolean stackable;
    private int maxStackAmount;
	
    /**
     * makes an item.
     * will check ALL_ITEM_NAMES to see if it is valid.
     *
     * @param name item name
     * @param count amount of the item
     * @param stackable whether the item can be in a stack or not
     * @param maxStackAmount the maximum amount of items in a stack
     */
	public ItemStruct(String name, int count, boolean stackable, int maxStackAmount) {
		boolean itemFound = false;
		for (int i = 0; i < ALL_ITEM_NAMES.length; i++) {
			//TODO TEMP implement better searching algorithm
			//also i might have to use .equals instead but we'll see
			//TODO TEST
			if (name == ALL_ITEM_NAMES[i]) {
				itemFound = true;
				break;
			}
		}
		if (!itemFound) {
			//TODO TEMP later use exceptions
			System.out.println("ERROR1 : item id not found");
		}
		this.name = name;
		this.count = count;
        this.stackable = stackable;
        this.maxStackAmount = maxStackAmount;
	}
    
    /**
     * makes a stackable item with a max stack of 64.
     *
     * @param name item name
     * @param count amount of the item
     */
    public ItemStruct(String name, int count) {
        this(name, count, true, 64);
    }
    
    /**
     * makes a stackable item.
     *
     * @param name item name
     * @param count amount of the item
     * @param maxStackAmount the maximum amount of items in a stack
     */
    public ItemStruct(String name, int count, int maxStackAmount) {
        this(name, count, true, maxStackAmount);
    }
    
    /**
     * makes an unstackable item.
     *
     * @param name the item name
     */
    public ItemStruct(String name) {
        this(name, 1, false, 1);
    }
	
	//WARNING dangerous
    /**
     * makes an item without checking ALL_ITEM_NAMES.
     * faster but more dangerous.
     * used for generating large sets of items quickly.
     * will call no matter if skipCheck is true or false.
     *
     * @param name item name
     * @param count amount of the item
     * @param stackable whether the item can be in a stack or not
     * @param skipCheck will force this constructor to skip the check of this item using ALL_ITEM_NAMES
     */
	public ItemStruct(String name, int count, boolean stackable, boolean skipCheck) {
		this.name = name;
		this.count = count;
        this.stackable = stackable;
	}
    
    /**
     * checks to see if the items can be stacked together,
     * and if true, returns them as stacked.
     *
     * @param otherItem the other item to stack with
     * @return an item struct with the two item amounts added together,
     *         or null if the items can't be stacked
     */
    public ItemStruct combineItem(ItemStruct otherItem) {
        int predictedStackNumber = count + otherItem.count;
        
        boolean bothStackable = stackable && otherItem.stackable;
        boolean itemsEqual = this.equals(otherItem);
        boolean belowMaxStack = predictedStackNumber <= maxStackAmount;
        
        boolean canStack = bothStackable && itemsEqual && belowMaxStack;
        if (!canStack) {
            return null;
        }
        return new ItemStruct(name, predictedStackNumber, true, true);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ItemStruct)) {
            return false;
        }
        ItemStruct other = (ItemStruct) obj;
        return this.name == other.name
            && this.count == other.count
            && this.maxStackAmount == other.maxStackAmount
            && this.stackable == other.stackable;
    }
    
    
    public static String[] getAllItemNames() {
        return ALL_ITEM_NAMES;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isStackable() {
        return stackable;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }
}
