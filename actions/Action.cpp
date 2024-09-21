#include <string>
#include <Action.h>

class Action {
	public:
		Action(string name);
		~Action();
};

Action::Action(string name)
{
}

Action::~Action()
{
}


/*

public class Action {
	public static String[] allActionNames = {
		"collect sticks",
		"collect loose rocks",
		"forage for food",
		"wait",
	};
	
	public String name;
	public Player player;
	
	public Action(String name, Player player) {
		this.name = name;
		this.player = player;
	}
	
	public void doAction() {
		switch ("true") {
			case "value":
				
				break;
		
			default:
				break;
		}
	}
}
*/
