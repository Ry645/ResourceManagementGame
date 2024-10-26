package actions;

import item.ItemStruct;
import minigames.StickMinigame;
import player.Player;

public class CollectSticks extends Action {
    public CollectSticks(Player player) {
        super(player, "collect sticks");
    }
    
    public void doAction() {
        collectSticks();
    }
    
    //TODO make stick minigame method
    /**
     * makes the player collect sticks through a minigame.
     */
    public void collectSticks() {
		StickMinigame stickMinigame = new StickMinigame();
		System.out.println(stickMinigame);
		
		player.getInventory().collect(new ItemStruct("stick", 3));
	}
}
