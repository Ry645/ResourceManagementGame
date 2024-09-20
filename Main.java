import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hit enter to start game!");
		sc.nextLine();
		
		System.out.print("Enter the name of your character: ");
		String name = sc.nextLine();
		
		Player player = new Player(name, 10, 0, 10, 10, 0, 10);
		
		System.out.printf("New Character: %s\nHealth: %d\nHunger: %d\n\n", player.name,
			player.healthSystem.health, player.hungerSystem.hunger
		);
		
		Action[] actions = {
			new Action("collect sticks"),
			new Action("collect loose rocks"),
			new Action("forage for food"),
			new Action("wait")
		};
		System.out.println("You're in a forest. What do you do?");
		for (int i = 0; i < actions.length; i++) {
			System.out.println(actions[i].name + " " + i);
		}
		
		int actionIndex = sc.nextInt();
		
		System.out.printf("You %s.", actions[actionIndex].name);
		
		sc.close();
	}
}
