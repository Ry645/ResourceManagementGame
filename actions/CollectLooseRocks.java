package actions;

import item.ItemStruct;
import player.Player;

public class CollectLooseRocks extends Action {
    public CollectLooseRocks(Player player) {
        super(player, "collect loose rocks");
    }
    
    @Override
    public void doAction() {
        collectLooseRocks();
    }
    
    /**
     * makes the player collect loose rocks and adds them to their inventory.
     */
    public void collectLooseRocks() {
		player.getInventory().collect(new ItemStruct("rock", 4));
	}
}
