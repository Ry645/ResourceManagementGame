#include <iostream>
#include <string>
using namespace std;

int main()
{
	string playerName;
	cout << "Hit enter to start game!\n";
	cin >> playerName;
	
	cout << "Enter the name of your character: ";
	scanf("%s", playerName);
	
	cout << playerName;
	
	printf("New Character: %s\nHealth: %d\nHunger: %d\n\n", playerName, 10, 10);
	
	return 0;
}

/*
public class Main {
	public static void main(String[] args) {
		
		Action[] actions = generateActions(player);
		
		System.out.println("You're in a forest. What do you do?");
		for (int i = 0; i < actions.length; i++) {
			System.out.println(actions[i].name + " " + i);
		}
		
		int actionIndex = sc.nextInt();
		
		System.out.printf("You %s.", actions[actionIndex].name);
		
		sc.close();
	}
	
	public static Action[] generateActions(Player player) {
		String[] allActionNames = Action.allActionNames;
		Action[] actionObjects = new Action[allActionNames.length];
		for (int i = 0; i < allActionNames.length; i++) {
			actionObjects[i] = new Action(allActionNames[i], player);
		}
		return actionObjects;
	}
}

*/
