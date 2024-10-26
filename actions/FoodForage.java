package actions;

import item.ItemStruct;
import player.Player;

public class FoodForage extends Action {
    public FoodForage(Player player) {
        super(player, "forage for food");
    }
    
    @Override
    public void doAction() {
        foodForage();
    }
    
    /**
     * makes the player forage for food and puts it in their inventory.
     */
    public void foodForage() {
		player.inventory.collect(new ItemStruct("berry", 24));
	}
    
}
