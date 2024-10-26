package actions;

import player.Player;

public class PrintInventory extends Action {
    public PrintInventory(Player player) {
        super(player, "show inventory");
    }
    
    @Override
    public void doAction() {
        printInventory();
    }
    
    /**
     * prints the inventory of the player.
     */
    public void printInventory() {
		System.out.println(player.inventory);
	}
}
