package actions;

import player.Player;

/**
 * represents an action that can be performed.
 *
 * @author Ryan Sexton
 * @version 1.0
 */
public abstract class Action {
    //TODO will eventually slowly introduce actions to the player as progression increases
    /**
     * generates actions for the player to use.
     *
     * @param player the player that will perform all of these actions
     */
    public static Action[] generateActions(Player player) {
        
		Action[] actions = {
            new CollectSticks(player),
            new CollectLooseRocks(player),
            new FoodForage(player),
            new PrintInventory(player),
        };
        
        return actions;
    }
    
    /**
     * a reference to the player the action can call methods on.
     */
    Player player;
    
    /**
     * the name of the action.
     */
    String name;
    
    /**
     * performs an arbitrary action.
     */
    public abstract void doAction();
    
    /**
     * represents the contruction of an action object.
     *
     * @param player the action name
     * @param name the action name
     */
	public Action(Player player, String name) {
        this.player = player;
        this.name = name;
	}

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
