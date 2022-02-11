package projects;
import java.util.Scanner;
import java.lang.Math;

public class AdventureGame {
	
	private static int defense;
	private static int offense;
	private static int health;
	private static String character;
	private static String villian;
	
	private static void duel() throws InterruptedException {
		Scanner console = new Scanner (System.in);
		System.out.println(ConsoleColors.PURPLE_BOLD + "\n--------------------THE DUEL--------------------" + ConsoleColors.RESET);
		System.out.println("You have entered a duel with the " + villian);
		Thread.sleep(1000);
		System.out.println(ConsoleColors.BLACK_UNDERLINED + "Rules:" + ConsoleColors.RESET);
		Thread.sleep(1000);
		System.out.println("\nBoth players will take turns shooting at the opponent");
		Thread.sleep(1500);
		System.out.println("You can either choose to defend yourself or attack");
		Thread.sleep(1500);
		System.out.println("If you don't enter a valid input, you will do nothing for that turn");
		Thread.sleep(1500);
		System.out.println("As a " + character + ", you can cause " + offense + " damage to the opponent");
		Thread.sleep(1500);
		System.out.println("If the villian attacks you, you will be able to prevent " + defense + " amount of damage");
		Thread.sleep(1500);
		System.out.println("If Player 1 attacks Player 2 more than they can defend, Player 2's health will be deduced");
		Thread.sleep(1500);
		System.out.println("By as much as they couldn't defend themselves");
		Thread.sleep(1500);
		System.out.println("If both players attack, then both players will get the damage that they were meant to get");
		Thread.sleep(1500);
		System.out.println("You are trying to reduce " + villian + "'s health to 0 while making sure your's doesn't");
		Thread.sleep(1500);
		System.out.println("If both of you have 0 life at the end (with a tie), then you would have lost the game");
		Thread.sleep(1500);
		System.out.println("Remember, if you want to see how much life you have, you can always type " + ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "\"profile\"" + ConsoleColors.RESET + " into the answer choice spot");
		Thread.sleep(1500);
		System.out.println("Before we get started, this is your profile just as a reminder: ");
		profile();
		
		System.out.print(ConsoleColors.CYAN_BOLD + "Ready to get started? " + ConsoleColors.CYAN);
		String answer = console.next();
		exit(answer);
		profile(answer);
		
		System.out.println(ConsoleColors.RESET + "Ready or not, here we begin...");
		Thread.sleep(2000);
		
		int counter = 1;
		int villianHealth = 35;
		while (villianHealth > 0 && health > 0) {
			System.out.println(ConsoleColors.BLACK_BOLD + "\nROUND " + counter);
			System.out.println(ConsoleColors.RESET + ConsoleColors.BLACK_UNDERLINED + "~Your Turn~\n" + ConsoleColors.RESET);
			System.out.print(ConsoleColors.CYAN_BOLD + "Do you want to attack or defend? " + ConsoleColors.CYAN);
			answer = console.next();
			exit(answer);
			profile(answer);
			while (answer.equalsIgnoreCase("profile")) {
				System.out.print(ConsoleColors.CYAN_BOLD + "Do you want to attack or defend? " + ConsoleColors.CYAN);
				answer = console.next();
				exit(answer);
				profile(answer);
			}
			int option = 0;
			System.out.println(ConsoleColors.RESET);
			if (answer.equalsIgnoreCase("attack") || answer.equalsIgnoreCase("a")) {
				System.out.println("You will attack " + offense + " onto your opponent");
				option = 1;
			} else if (answer.equalsIgnoreCase("defend") || answer.equalsIgnoreCase("d")) {
				System.out.println("You will defend " + defense + " amount of your opponent's attacks");
				option = 2;
			} else {
				System.out.println("Because you didn't attack or defend, you will not be able to do anything this round");
			}
			
			System.out.println(ConsoleColors.BLACK_UNDERLINED + "\n~Opponent's Turn~");
			int villianChoice = (int) (Math.random() * 2);
			System.out.println(ConsoleColors.RESET);
			if (villianChoice == 0) {
				System.out.println("The villian has decided to attack");
				int attack = (int)(Math.random() * 6) + 1;
				if (option == 1) {
					System.out.println("Villian attacked with " + attack + " and you attacked with " + offense);
					System.out.println("You have lost " + attack + " health.");
					System.out.println("Villian has lost " + offense + " health.");
					
					health -= attack;
					villianHealth -= offense;
					
					if (health < 0) {
						health = 0;
					}
					
					if (villianHealth < 0) {
						villianHealth = 0;
					}
					
					System.out.println("\nYou have " + health + " health left.");
					System.out.println("Your opponent has " + villianHealth + " health left.");
				} else if (option == 2) {
					System.out.println("You have lost " + attack + " health");
					System.out.println("But defended yourself with " + defense + " health.");
					int remain;
					if (defense - attack <= 0) {
						remain = attack - defense;
					} else {
						remain = 0;
					}
					
					if (villianHealth < 0) {
						villianHealth = 0;
					}
					if (health < 0) {
						health = 0;
					}
					
					System.out.println("Meaning that you have took " + remain + " damage.");
					
					health -= remain;
					
					if (health < 0) {
						health = 0;
					}
					
					if (villianHealth < 0) {
						villianHealth = 0;
					}
					
					System.out.println("\nYou have " + health + " health left.");
					System.out.println("Your opponent has " + villianHealth + " health left.");
					
				} else {
					System.out.println("You have lost " + attack + " health.");
					
					health -= attack;
					
					if (health < 0) {
						health = 0;
					}
					
					if (villianHealth < 0) {
						villianHealth = 0;
					}
										
					System.out.println("\nYou have " + health + " health left.");
					System.out.println("Your opponent has " + villianHealth + " health left.");
				}
			} else {
				System.out.println("The villian has decided to defend themself.");
				int defend = (int)(Math.random() * 12) + 1;
				if (option == 1) {					
					System.out.println("Villian has lost " + offense + " health.");
					System.out.println("But defended itself with " + defend + " health.");
					int remain;
					if (defend - offense <= 0) {
						remain = offense - defend;
					} else {
						remain = 0;
					}
					System.out.println("Meaning that they have took " + remain + " damage.");
					
					villianHealth -= remain;
					
					if (villianHealth < 0) {
						villianHealth = 0;
					}
					
					System.out.println("\nYou have " + health + " health left.");
					System.out.println("Your opponent has " + villianHealth + " health left.");
				} else {
					System.out.println("Nothing happens this round.");
				}
			}
			
			counter++;
		}
		if (villianHealth <= 0) {
			endGame(true);
		} else {
			endGame(false);
		}
	}
	
	private static void bye() {
		System.out.print(ConsoleColors.YELLOW_BOLD);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("~~~~");
			}
			System.out.print("*");
		}
		
		System.out.println("~~~~~~~~~~~~" + ConsoleColors.RESET);
		
		System.out.println(ConsoleColors.PURPLE_BOLD + "~~~~~~~~~~~~~~~~~~~~~~THE END~~~~~~~~~~~~~~~~~~~~~~" + ConsoleColors.YELLOW_BOLD);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("~~~~");
			}
			System.out.print("*");
		}
				
		System.out.println("~~~~~~~~~~~~\n" + ConsoleColors.CYAN);
		System.out.println("Thank you so much for playing!");
		System.out.println("If you liked this game, please upvote and comment!");
		System.out.println("And don't forget to share with your friends and continue playing.");
		System.out.println("If you want me to continue updating this project, continue to comment and like!");
		System.out.println("Bye!");
	}
	
	private static void endGame(boolean win) throws InterruptedException {
		if (win) {
			System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n\nCongratulations! " + ConsoleColors.RESET + "\nYou have won the game and defeated the villian");
			Thread.sleep(1000);
			System.out.println("I knew that your bravery could defeat them!");
			Thread.sleep(1000);
			System.out.println("You can always continue playing and see whether you can beat them again!");
			Thread.sleep(1000);
			System.out.println("By just rerunning the project");
			Thread.sleep(1000);
			System.out.println("But are you brave enough to try again?");
			Thread.sleep(1000);
			System.out.println("I guess we will find out");
			Thread.sleep(1000);
			bye();
		} else {
			Thread.sleep(1000);
			System.out.println("\n\nThrough all the ups and downs");
			Thread.sleep(1000);
			System.out.println("I regret to say that you did not succeed in defeating the villian");
			Thread.sleep(1000);
			System.out.println("They are still on the loose");
			Thread.sleep(1000);
			System.out.println("But you can turn back time and retry this whole adventure");
			Thread.sleep(1000);
			System.out.println("By rerunning this project");
			Thread.sleep(1000);
			System.out.println("But are you brave enough to try again?");
			Thread.sleep(1000);
			System.out.println("I guess we will find out");
			Thread.sleep(1000);
			bye();
		}
	}
	
	private static void villianGenerator() {
		String villianNames [] = {"The Big Bad Wolf", "Beebo", "Killer Panda", "Karate Monkey", "Annabell (The Doll)"};
		int villianIndex = (int) (Math.random()*villianNames.length);
		villian = villianNames[villianIndex];
	}
	
	private static void noteIf(String answer) throws InterruptedException {
		if (answer.equalsIgnoreCase("a")) {
			System.out.println("You need to warn someone, it is the only way to protect this city");
			Thread.sleep(1000);
			System.out.println("You ponder for a moment about who would be the right person to tell");
			Thread.sleep(1000);
			System.out.println("You suddenly get an idea! You will tell the cops!");
			Thread.sleep(1000);
			System.out.println("They will defintely listen to you and act accordingly.\n");
			Thread.sleep(1000);
			System.out.println("You grab the note and run to the front door");
			Thread.sleep(1000);
			System.out.println("You put on your shoes and yank your coat off the hanger and put it on");
			Thread.sleep(1000);
			System.out.println("You lock the front door and pull out your car keys");
			Thread.sleep(1000);
			System.out.println("You get into your car and turn on the engine");
			Thread.sleep(1000);
			System.out.println("You slowly drive through the streets until you reach the police station.");
			Thread.sleep(1000);
			System.out.println("You quickly park your car into the parking lot and run into the building.");
			Thread.sleep(1000);
			System.out.println("You approach the front desk and show the police officer the note\n");
			Thread.sleep(1500);
			System.out.println(ConsoleColors.BLACK_ITALIC + "What should we do?" + ConsoleColors.RESET + " You ask.");
			Thread.sleep(1000);
			System.out.println(ConsoleColors.BLACK_ITALIC + "This seems pretty serious. We will see what we can do. You just stay on alert for now.");
			Thread.sleep(1000);
			System.out.println(ConsoleColors.RESET + "You nod your head and head back into the car");
			Thread.sleep(1000);
			System.out.println("You drive home and get into your bed. You need to have good rest for the battle tomorrow.");
			Thread.sleep(1000);
			System.out.println("You doze off and rest...\n\n");
			Thread.sleep(1000);
			System.out.println("Your alarm rings in the morning and your eyes pop open");
			Thread.sleep(1000);
			System.out.println("You quickly get ready and race outside with everything you will need for the battle");
			Thread.sleep(1000);
			System.out.println("As cannons are launched into the air, the police officers do their best to protect the city");
			Thread.sleep(1000);
			System.out.println("You slightly grin until you hear a deep voice behind you");
			Thread.sleep(1000);
			int notFindOut = (int) (Math.random() * 10);
			if (notFindOut == 0 || notFindOut == 1 || notFindOut == 3) {
				System.out.println(ConsoleColors.BLACK_ITALIC + "\"Who are you?\"" + ConsoleColors.RESET);
				Thread.sleep(1000);
				System.out.println(ConsoleColors.BLACK_ITALIC + "\"I am " + ConsoleColors.LIGHT_PINK_BACKGROUND + villian + ConsoleColors.RESET + ConsoleColors.BLACK_ITALIC + ", your greatest nightmare.");
				Thread.sleep(1000);
				System.out.println("\"Why do you want to attack this city?\"");
				Thread.sleep(1000);
				System.out.println("\"Because your mother attacked mine");
				Thread.sleep(1000);
				System.out.println("And it seems like you outsmarted me and told someone without me knowing");
				Thread.sleep(1000);
				System.out.println("But you won't beat me in a duel\"");
				Thread.sleep(1000);
				System.out.println("\"Let's see, I'm stronger then you think\"" + ConsoleColors.RESET + ", you taunt.\n");
				Thread.sleep(1000);
				duel();
			} else {
				System.out.println(ConsoleColors.BLACK_ITALIC + "\"Who are you?\"" + ConsoleColors.RESET);
				Thread.sleep(1000);
				System.out.println(ConsoleColors.BLACK_ITALIC + "\"I am " + ConsoleColors.LIGHT_PINK_BACKGROUND + villian + ConsoleColors.RESET + ConsoleColors.BLACK_ITALIC + ", your greatest nightmare.");
				Thread.sleep(1000);
				System.out.println("Do you really think that I wouldn't find out about you telling the officers?");
				Thread.sleep(1000);
				System.out.println("In fact, I counted on it. I have bigger cannons set up to destroy the city.");
				Thread.sleep(1000);
				System.out.println("They will set in an hour and only I have the remote to stop it.");
				Thread.sleep(1000);
				System.out.println("\"Why do you want to attack this city?\"");
				Thread.sleep(1000);
				System.out.println("\"Because your mother attacked mine");
				Thread.sleep(1000);
				System.out.println("And you won't beat me in a duel to stop me\"");
				Thread.sleep(1000);
				System.out.println("\"Let's see, I'm stronger then you think\"" + ConsoleColors.RESET + ", you taunt.\n");
				Thread.sleep(1000);
				duel();
			}
		} else if (answer.equalsIgnoreCase("b")) {
			System.out.println("As a " + character + ", you have decided to ignore the note");
			Thread.sleep(1000);
			System.out.println("You peacefully curl the note into a ball");
			Thread.sleep(1000);
			System.out.println("And shoot it into the trashcan as you enter your room");
			Thread.sleep(1000);
			System.out.println("You decide that you had enough of a night");
			Thread.sleep(1000);
			System.out.println("And decide to go to bed and continue studying in the morning.");
			Thread.sleep(1000);
			System.out.println("You pull the covers over your head");
			Thread.sleep(1000);
			System.out.println("And for the second time, fall alseep\n\n");
			Thread.sleep(1500);
			System.out.println(ConsoleColors.ORANGE + "KABOOM." + ConsoleColors.RESET);
			Thread.sleep(1000);
			System.out.println("A loud explosion sound wakes you up from your slumber");
			Thread.sleep(1000);
			System.out.println("And you turn towards your clock, realizing that it is already 9:30!");
			Thread.sleep(1000);
			System.out.println("Your test starts in less than half-an-hour and you haven't properly prepared yet!");
			Thread.sleep(1000);
			System.out.println("You scamper from your bed and put on your clothes");
			Thread.sleep(1000);
			System.out.println("You open the windows to let in some nice sun into your room as you work");
			Thread.sleep(1000);
			System.out.println("But instead notice explosions and the blemished view.");
			Thread.sleep(1000);
			System.out.println("Your mind flashes back to the note that you saw earlier");
			Thread.sleep(1000);
			System.out.println("Warning you that this would happen");
			Thread.sleep(1000);
			System.out.println("Adrenaline rushes to your fingertips and a humongous amount of guilt aches in your chest");
			Thread.sleep(1000);
			System.out.println("You don't even think twice and run outside, dashing through the streets to find the villian");
			Thread.sleep(1000);
			System.out.println(ConsoleColors.BLACK_ITALIC + "\"You were warned. And now, you have paided the price\"" + ConsoleColors.RESET);
			Thread.sleep(1000);
			System.out.println("A deep voice says behind you.");
			Thread.sleep(1000);
			System.out.println("You swirl around and look into the eyes of the villian who harmed your city");
			Thread.sleep(1000);
			System.out.println(ConsoleColors.BLACK_ITALIC + "\"Who are you?\"" + ConsoleColors.RESET);
			Thread.sleep(1000);
			System.out.println("You scream.");
			Thread.sleep(1000);
			System.out.println(ConsoleColors.BLACK_ITALIC + "\"I am " + ConsoleColors.LIGHT_PINK_BACKGROUND + villian + ConsoleColors.RESET + ConsoleColors.BLACK_ITALIC + ", your greatest nightmare.");
			Thread.sleep(1000);
			System.out.println("But I have already had my fun in destroying your city");
			Thread.sleep(1000);
			System.out.println("To destroy you, well, I told everyone about your selfish decision\"" + ConsoleColors.RESET);
			Thread.sleep(1000);
			System.out.println("\nThen, " + villian + " dissappears in a flash, leaving no trace");
			Thread.sleep(1000);
			System.out.println("You slowly walk back home");
			Thread.sleep(1000);
			System.out.println("And watch the stares creep up your neck");
			Thread.sleep(1000);
			System.out.println("Not facing " + villian + " was worse than any harm they could have done otherwise.");
			Thread.sleep(1000);
			System.out.println("You have learned your lesson. To stand up and protect others. And to...not procrastinate");
			Thread.sleep(1000);
			System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "For your disloyalty, you lost 5 health" + ConsoleColors.RESET);
			health -= 5;
			profile();
			endGame(false);
		} else {
			System.out.println("You have decided to go into the woods to defeat this monster before they harm anyone.");
			Thread.sleep(1500);
			System.out.println("Such a brave choice!");
			Thread.sleep(1000);
			System.out.println("You shove the note into your pocket and pack some supplies into a bag");
			Thread.sleep(1500);
			System.out.println("A flashlight, some food, water, one extra pair of clothes, rope, and other things you might need on this adventure");
			Thread.sleep(1500);
			System.out.println("You grab your car keys, your coat, and head out the door");
			Thread.sleep(1500);
			System.out.println("You slowly pull the car out of the driveway and start driving towards the forest");
			Thread.sleep(1500);
			System.out.println("No one has gone into the woods for years");
			Thread.sleep(1500);
			System.out.println("so you are scared out of your mind.");
			Thread.sleep(1500);
			System.out.println("But you convince yourself that going into the woods is the best option");
			Thread.sleep(1500);
			System.out.println("You arrive at the closest parking spot to the woods, Shevoret Mist");
			Thread.sleep(1500);
			System.out.println("You pull out the flashlight and swing your bag over your shoulders");
			Thread.sleep(1500);
			System.out.println("You turn on the flashlight and stare into the branches of the forest");
			Thread.sleep(1500);
			System.out.println("Well, there is no turning back now.");
			Thread.sleep(1500);
			System.out.println("You take a deep breath and walk into the forest, not knowing what could happen");
			Thread.sleep(1500);
			System.out.println("Or who is watching...\n\n");
			Thread.sleep(3000);
			System.out.println("You pass by mountains of trees");
			Thread.sleep(1500);
			System.out.println("The branches sticking out like they are going to attack any moment");
			Thread.sleep(1500);
			System.out.println("All life was at a pause, not even one sound but your own footsteps");
			Thread.sleep(1500);
			System.out.println("Crunching the leaves beneath your feet");
			Thread.sleep(1500);
			System.out.println("You travel for what seems like 1 hour.");
			Thread.sleep(1500);
			System.out.println("You feel anger forming within you");
			Thread.sleep(1500);
			System.out.println("You have been searching for so long, waving your flashlight around and not finding anyone");
			Thread.sleep(1500);
			System.out.println("This is completely " + ConsoleColors.BLACK_BOLD + "pointless" + ConsoleColors.RESET + ". You don't even know where to go!");
			Thread.sleep(1500);
			System.out.println("You decide that taking a break is the best option");
			Thread.sleep(1500);
			System.out.println("You sit down on one of the tree stumps and hover your flashlight over your bag as you pull out a snack");
			Thread.sleep(1500);
			System.out.println("Out of nowhere, you hear a slight crunch");
			Thread.sleep(1000);
			System.out.println("You quickly turn around and get up.");
			Thread.sleep(1000);
			System.out.println("You see a slight shadow, no a figure, in the distance");
			Thread.sleep(1000);
			System.out.println(ConsoleColors.BLACK_ITALIC + "\"Who are you?\"" + ConsoleColors.RESET);
			Thread.sleep(1000);
			System.out.println(ConsoleColors.BLACK_ITALIC + "\"I am " + ConsoleColors.LIGHT_PINK_BACKGROUND + villian + ConsoleColors.RESET + ConsoleColors.BLACK_ITALIC + ", your greatest nightmare.");
			Thread.sleep(1000);
			System.out.println("\"Why do you want to attack this city?\"");
			Thread.sleep(1000);
			System.out.println("\"Because your mother attacked mine");
			Thread.sleep(1000);
			System.out.println("And if I get you out of the way first, you won't be able to stop me! MWHAHAHA");
			Thread.sleep(1000);
			System.out.println("You won't beat me in a duel\"");
			Thread.sleep(1000);
			System.out.println("\"Let's see, I'm stronger then you think\"" + ConsoleColors.RESET + ", you taunt.\n");
			Thread.sleep(1000);
			duel();
		}
	}
	
	private static void introductionIf(String answer) throws InterruptedException {
		if (answer.equalsIgnoreCase("a")) {
			System.out.println("You decide to pick up the package");
			Thread.sleep(1000);
			System.out.println("Slowly pulling off the " + ConsoleColors.RED_BOLD + "red" + ConsoleColors.RESET +" strings wrapped around in a bow");
			Thread.sleep(1000);
			System.out.println("The strings fall to the floor and you slowly open the cap");
			Thread.sleep(1000);
			System.out.println("There is a note written on the cover\n");
			Thread.sleep(1000);
			System.out.println(ConsoleColors.BLACK_ITALIC + "Wander into the woods to face");
			Thread.sleep(1000);
			System.out.println("Your greatest nightmare...");
			Thread.sleep(1000);
			System.out.println("Or else your town will suffer");
			Thread.sleep(1000);
			System.out.println("And if you warn anyone about what is going to happen");
			Thread.sleep(1500);
			System.out.println("Everyone will pay the price.");
			Thread.sleep(1000);
			System.out.println("And I have eyes everywhere so if you spill the secret, I will know.\n" + ConsoleColors.RESET);
			Thread.sleep(1000);
		} else {
			System.out.println("You leave the package on the floor");
			Thread.sleep(1000);
			System.out.println("And walk back inside your house and up to your desk to find a note\n");
			Thread.sleep(1000);
			System.out.println(ConsoleColors.BLACK_ITALIC + "Wander into the woods to face");
			Thread.sleep(1000);
			System.out.println("Your greatest nightmare...");
			Thread.sleep(1000);
			System.out.println("Or else your town will suffer");
			Thread.sleep(1000);
			System.out.println("And if you warn anyone about what is going to happen");
			Thread.sleep(1500);
			System.out.println("Everyone will pay the price.");
			Thread.sleep(1000);
			System.out.println("And I have eyes everywhere so if you spill the secret, I will know.");
			Thread.sleep(1000);
			System.out.println("Because you didn't read my warning downstairs" + ConsoleColors.RESET);
			Thread.sleep(1000);
			System.out.println("\n...");
			Thread.sleep(1000);
			System.out.println("Something sprays into your eyes and by the time");
			Thread.sleep(1000);
			System.out.println("you get as much as you can out");
			Thread.sleep(1000);
			System.out.println("You realize that you are partially blind");
			Thread.sleep(1000);
			System.out.println("You won't be able to attack/defend yourself as well");
			Thread.sleep(1000);
			System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Therefore, you have lost both a point on defense and offense" + ConsoleColors.RESET);
			Thread.sleep(1000);
			defense--;
			offense--;
			profile();
		}
	}
	
	private static void profile() {
		profile("profile");
	}
	
	private static void profile(String answer) {
		if (answer.equalsIgnoreCase("profile")) {
			System.out.println(ConsoleColors.GREEN + "This is your current profile:");
			System.out.println("   Character: " + character);
			System.out.println("   Defense: " + defense);
			System.out.println("   Offense: " + offense);
			System.out.println("   Health: " + health + ConsoleColors.RESET);
		}
	}
	
	private static void exit(String answer) {
		if (answer.equalsIgnoreCase("exit")) {
			System.out.println(ConsoleColors.RESET + "I am so sorry that you decided not to continue.");
			System.out.println("I hope that you come back soon!");
			System.out.println("Bye!");
			System.exit(0);
		}
	}
	
	private static void options(String a, String b) {
		System.out.println(ConsoleColors.RED_BOLD + "You have two options:" + ConsoleColors.RED);
		System.out.println("a) " + a);
		System.out.println("b) " + b + ConsoleColors.RESET);
	}
	
	private static void options(String a, String b, String c) {
		System.out.println(ConsoleColors.RED_BOLD + "You have three options:" + ConsoleColors.RED);
		System.out.println("a) " + a);
		System.out.println("b) " + b);
		System.out.println("c) " + c + ConsoleColors.RESET);
	}
	
	private static void introductionToStory() throws InterruptedException {
		System.out.println("Procrastination. It always gets the best from you.");
		Thread.sleep(1000);
		System.out.println("One of the biggest tests of the year was coming up tomorrow");
		Thread.sleep(1000);
		System.out.println("And you just started studying.");
		Thread.sleep(1000);
		System.out.println("You squint, grab some coffee, and do whatever you can to stay awake");
		Thread.sleep(1000);
		System.out.println("But you give into the tiredness anyways\n\n");
		Thread.sleep(2000);
		System.out.println("Suddenly, you wake up to a pounding on the door!");
		Thread.sleep(1000);
		System.out.println("It gets louder... and louder!");
		Thread.sleep(1000);
		System.out.println("You slowly get up from your chair, chills running down your spine");
		Thread.sleep(1500);
		System.out.println("Your handle reaches towards your bedroom handle and you slowly turn it open");
		Thread.sleep(1500);
		System.out.println("You force yourself to walk downstairs, even though you are extremely scared");
		Thread.sleep(1500);
		System.out.println("The knocking stops right as you arrive in front of the front door");
		Thread.sleep(1500);
		System.out.println("You peer through the keyhole but find no one there so you open the door instead");
		Thread.sleep(1500);
		System.out.println("You stare into the darkness and come to a conclusion that no one is there");
		Thread.sleep(1500);
		System.out.println("Just as you are about to close the door, you see a package on the front door");
		Thread.sleep(1000);
	}
	
	private static void characterPick(Scanner scan) throws InterruptedException {
		System.out.println("First, time to select a character!");
		Thread.sleep(1000);
		System.out.println("You can choose to be an apprentice, fighter, or a donkey");
		Thread.sleep(1000);
		System.out.println("If you want to see the strengths/weaknesses, please type " + ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "\"bio\"" + ConsoleColors.RESET);
		Thread.sleep(1000);
		System.out.println("Else, type your character\n");
		System.out.print(ConsoleColors.CYAN_BOLD + "Please type here: " + ConsoleColors.CYAN);
		character = scan.next();
		System.out.println(ConsoleColors.RESET);
		if (character.equalsIgnoreCase("bio")) {
			bio();
			System.out.println("Now that you have seen all the character's bio, please type the character");
			System.out.println("That you want to be.");
			System.out.print(ConsoleColors.CYAN_BOLD + "Please type your character here: " + ConsoleColors.CYAN);
			character = scan.next();
		}
		System.out.println(ConsoleColors.RESET);
		exit(character);
		if (character.equalsIgnoreCase("apprentice")) {
			System.out.println("You are now an apprentice");
			defense = 10;
			offense = 6;
			health = 23;
		} else if (character.equalsIgnoreCase("fighter")) {
			System.out.println("You are now a fighter");
			defense = 6;
			offense = 10;
			health = 23;
		} else if (character.equalsIgnoreCase("donkey")) {
			System.out.println("You are now a donkey.");
			defense = 5;
			offense = 5;
			health = 33;
		} else {
			System.out.println("You seemed to have failed the test and didn't pick a character correctly.");
			System.out.println("For this reason, you will be a donkey.");
			defense = 3;
			offense = 3;
			health = 33;
		}
		
		profile();
		Thread.sleep(1000);
		System.out.println("\nThroughout the game, if you want to know your profile");
		Thread.sleep(1000);
		System.out.println("Just type " + ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "\"profile\"" + ConsoleColors.RESET + " into the answer choice place instead of your answer");
		Thread.sleep(1000);
		System.out.println("Then, it will print your profile (with your defense, offense, health, and character)");
		Thread.sleep(1000);
		System.out.println("And then allowing you to type your response");
		Thread.sleep(1000);
		System.out.println("So you can make a strategic decision");
	}
	
	private static void bio() {
		System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "Defense" + ConsoleColors.RESET + " means how well you are able to defend yourself (subtracts damage during battle)");
		System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "Offense" + ConsoleColors.RESET + " means how well you are able to attack (increases damage on opponents during battle)");
		System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "Health" + ConsoleColors.RESET + " is your current state of being that is affected during battle and other events.");
		System.out.println();
		
		System.out.println(ConsoleColors.RED_BOLD + "~~~~~Apprentice~~~~~" + ConsoleColors.RED);
		System.out.println("\tDefense: 10");
		System.out.println("\tOffense: 6");
		System.out.println("\tHealth: 23");
		
		System.out.println(ConsoleColors.RED_BOLD + "\n\n~~~~~Fighter~~~~~"+ ConsoleColors.RED);
		System.out.println("\tDefense: 6");
		System.out.println("\tOffense: 10");
		System.out.println("\tHealth: 23");
		
		System.out.println(ConsoleColors.RED_BOLD + "\n\n~~~~~Donkey~~~~~"+ ConsoleColors.RED);
		System.out.println("\tDefense: 5");
		System.out.println("\tOffense: 5");
		System.out.println("\tHealth: 33" + ConsoleColors.RESET);
	}
	
	private static void instructions() throws InterruptedException {
		System.out.println("First, you will select a character.");
		Thread.sleep(1000);
		System.out.println("Each character has different benefits and weaknesses");
		Thread.sleep(1000);
		System.out.println("You will be given options and you must respond with an a/b");
		Thread.sleep(1000);
		System.out.println("Based on your response, the game will play out!");
		Thread.sleep(1000);
		System.out.println("Additionally, if you want to exit early, just type " + ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "\"exit\"" + ConsoleColors.RESET);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		
		System.out.print(ConsoleColors.YELLOW_BOLD);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("~~~~");
			}
			System.out.print("*");
		}
		
		System.out.println("~~~~~~~~~~~~" + ConsoleColors.RESET);
		
		System.out.println(ConsoleColors.PURPLE_BOLD + "-----------WELCOME TO THIS ADVENTURE GAME-----------" + ConsoleColors.YELLOW_BOLD);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("~~~~");
			}
			System.out.print("*");
		}
				
		System.out.println("~~~~~~~~~~~~\n" + ConsoleColors.RESET);
		villianGenerator();
		instructions();
		Thread.sleep(500);
		System.out.print(ConsoleColors.CYAN_BOLD + "Ready to get started? " + ConsoleColors.CYAN);
		String answer = scan.next();
		exit(answer);
		
		System.out.println(ConsoleColors.RESET + "\nWell, anyways...we are going to begin...\n");
		characterPick(scan);
		
		System.out.print(ConsoleColors.CYAN_BOLD + "Ready to start the adventure? " + ConsoleColors.CYAN);
		answer = scan.next();
		exit(answer);
		profile(answer);
		
		System.out.println(ConsoleColors.RESET + "Well, ready or not");	
		Thread.sleep(500);
		System.out.println(ConsoleColors.BLACK_UNDERLINED + "\nTime to start your adventure..." + ConsoleColors.RESET);
		Thread.sleep(1000);
		introductionToStory();
		options("Pick up the package", "Leave it on the front door");
		System.out.print(ConsoleColors.CYAN_BOLD + "Do you pick a or b? " + ConsoleColors.CYAN);
		answer = scan.next();
		
		while (!answer.equalsIgnoreCase("a") && !answer.equalsIgnoreCase("b")) {
			exit(answer);
			profile(answer);
			System.out.print(ConsoleColors.CYAN_BOLD + "Do you pick a or b? " + ConsoleColors.CYAN);
			answer = scan.next();
		}
		System.out.println(ConsoleColors.RESET);
		introductionIf(answer);
		options("Warn someone and ignore the threat", "Ignore the entire note", "Go into the woods and stop the villian");
		
		System.out.print(ConsoleColors.CYAN_BOLD + "Do you pick a, b, or c? " + ConsoleColors.CYAN);
		answer = scan.next();
		
		while (!answer.equalsIgnoreCase("a") && !answer.equalsIgnoreCase("b") && !answer.equalsIgnoreCase("c")) {
			exit(answer);
			profile(answer);
			System.out.print(ConsoleColors.CYAN_BOLD + "Do you pick a, b, or c? " + ConsoleColors.CYAN);
			answer = scan.next();
		}
		
		System.out.println(ConsoleColors.RESET);
		
		noteIf(answer);
		
	}
}
