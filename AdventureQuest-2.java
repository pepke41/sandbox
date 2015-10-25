/**
@author Ma'ayan Doron
@author Emily Pepke
Program for Project 2 of CS 0401
It is a choose your own adventure game including elements such as riddles, and logical puzzles.
Emily wrote the main method and levels 00-05 
Ma'ayan wrote the 06-10 level and the final level
The inputs include numbers for choices and answers to riddles, as well as strings for the name of the player and riddle answers
The outputs include strings in the format of the story
*/

import java.util.*;
import java.io.*;

public class AdventureQuest
{
	/**
	Begin Emily's contribution
	*/
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		String playerName;
		boolean invalid;
		int userChoice = 0;
		int userChoice2 = 0;
		String playAgain = null;
		boolean invalid2 = true;
		String riddles[] = new String[16];
		String answers[] = new String[16];

		try{ //tries to check for a file				
			File file = new File("riddles.txt");
			Scanner fileReader = new Scanner(file);
			int i = 0;	

			while (fileReader.hasNext()){
				riddles[i] = fileReader.nextLine();
				i++;
			}
			fileReader.close();
		 }
	 	catch (FileNotFoundException fnfe) //handles non-existent file
	 	{
			System.out.println("The file cannot be found.");
	 	}

	 	try{ //tries to check for a file
			File file = new File("answers.txt");
			Scanner fileReader = new Scanner(file);
			int i = 0;	

			while (fileReader.hasNext()){
				answers[i] = fileReader.nextLine();
				i++;
			}
			fileReader.close();
		 }
	 	catch (FileNotFoundException fnfe) //handles non-existent file
	 	{
			System.out.println("The file cannot be found.");
	 	}
		
		System.out.println("Welcome to Cathedral Climber!");
		System.out.println("Instructions: ");
		System.out.println("\t*This is a text based adventure games");
		System.out.println("\t*You choices will effect your game play");
		System.out.println("\t*You will need to answer questions and complete challenges to defeat the game.");
		do{	
			System.out.print("\nPlease enter your name to begin: ");
			playerName = kb.nextLine();

			System.out.println("Let us begin. . .");
			System.out.println("It is a Thursday night and you're sitting in Hillman Library doing homework." + 
				" As the hours pass more and more students leave the library, but you remain engrossed in your work." + 
				" A light flickers and catches your attention, you look around to realize you are the only one left in the library." +
				" You begin to gather your belongings when you notice a mysterious figure in the corner coming towards you.");
			System.out.println("You have two choices you can \n\t(1) Stand your ground \n\t(2) Run");
			do{
				invalid = false;
				try{
					System.out.print("Enter 1 or 2 to make your choice: ");
					userChoice = kb.nextInt();

					while(userChoice != 1 && userChoice != 2)
					{
						System.out.print("You did not enter a valid choice please try again: ");
						userChoice = kb.nextInt();
					}
				}
				catch(InputMismatchException ime)
				{
					System.out.println("You did not enter a valid choice");
					kb.nextLine();
					invalid = true;
				}
			}while(invalid);

			if(userChoice == 1)
			{
				System.out.println("\nThe figure comes closer and closer until you notice the familiar face.");
				System.out.println("\"" + playerName + ", I'm so glad I got to you. There's not much time to explain. Take this,\"" +
					" He hands you an envelope" + " \"I'll be in contact with you soon.\"");
				System.out.println("You look down at the envelope and back up again only to realize you are alone again. " +
					"You can \n\t(1) Read it \n\t(2) Throw it in the garbage");
				do{
					invalid = false;
					try{
						System.out.print("Enter 1 or 2 to make your choice: ");
						userChoice2 = kb.nextInt();

						while(userChoice2 != 1 && userChoice2 != 2)
						{
							System.out.print("You did not enter a valid choice please try again: ");
							userChoice2 = kb.nextInt();
						}
					}
					catch(InputMismatchException ime)
					{
						System.out.println("You did not enter a valid choice");
						kb.nextLine();
						invalid = true;
					}
				}while(invalid);

				if(userChoice2 == 1)
				{
					System.out.println("\nYou open the letter and begin to read.");
					System.out.println("\"" + playerName + ", I'm sorry I couldn't talk for long, there are dangerous forces at work." +
						" They have taken over the Cathedral and plan to brain wash all of the students here, turning them into slaves." + 
						" You are the chosen one and the only one who can save the Pitt Students." + " Attached is a communicator, " + 
						"I will be in touch from time to time to give you instructions and guidance.");
					System.out.println("Please you are our only hope. Good luck.");

					level00(playerName, riddles, answers);
				}
				else if (userChoice2 == 2)
				{
					System.out.println("\nYou throw away the letter and head back to your dorm.");
					System.out.println("You wake up the next morning feeling brain washed. The evil forces have won, you failed.");
					System.out.println("GAME OVER");
				}

			}
			else if (userChoice == 2)
			{
				System.out.println("\nYou throw your belongings into your backpack and run out of the library." + 
					"You head back to your dorm and call it a night, you're freaked out, but unharmed... for the moment.");
				System.out.println("GAME OVER");
			}
			
			//Does user want to play again?
			kb.nextLine();
			System.out.println("\nWould you like to play again?");
			while(invalid2 == true){
				System.out.print("Enter y for yes, or n for no: ");
				playAgain = kb.nextLine();
				if(!playAgain.equalsIgnoreCase("y") && !playAgain.equalsIgnoreCase("n")){
					System.out.println("That is not a valid answer. Try again.");
				}
				else{
					invalid2 = false;
				}
			}
		}while(playAgain.equalsIgnoreCase("y"));
	}

	/**
	Level 00 of the game. This level includes a choice of 1 of 3 possibilities. Two of which will further game play,
	and the remaining choice will result in a game over.
	@param pn Takes in the player's name
	@param riddles Takes in the riddles array
	@param answers Takes in the answers array that mirrors the riddles array
	@exception Handles InputMismatchException if the user enters a string instead of a number for their choice
	*/
	public static void level00(String pn, String riddles[], String answers[])
	{
		boolean invalid;
		int userChoice = 0;
		Scanner kb = new Scanner(System.in);

		System.out.println("\nYou put the communicator in your pocket and head off towards the Cathedral." +  
			" You get to the ground floor entrance, but all the doors are locked.");
		System.out.println("Your communicator rings again \"" + pn + " you need to find the key somewhere hidden on " 
			+ "the Cathedral lawn. " + "There are monsters roaming the grounds, so you will only have one chance. " +
			"I'm not sure where it is, but its in one of three places.");
		System.out.println("The three places are \n\t(1) In Heinz Chapel \n\t(2) Up in a tree \n\t(3) Under a bench. " + 
			"\nGood luck and find the key!!\"");
		System.out.println("Where do you choose to look?");
		do{
			invalid = false;
			try{
				System.out.print("Enter 1, 2, or 3 to make your choice: ");
				userChoice = kb.nextInt();

				while(userChoice != 1 && userChoice != 2 && userChoice != 3)
				{
					System.out.print("You did not enter a valid choice please try again: ");
					userChoice = kb.nextInt();
				}
			}
			catch(InputMismatchException ime)
			{
				System.out.println("You did not enter a valid choice.");
				kb.nextLine();
				invalid = true;
			}
		}while(invalid);

		if(userChoice == 1)
		{
			System.out.println("\nYou head to the chapel and notice the door is open slightly. You head inside. " + 
				"You wander around and notice that the statues look... more lifelike than usual. " + 
				"Suddenly one comes to life.");
			level01(pn, riddles, answers);
		}
		else if(userChoice == 2)
		{
			System.out.println("\nYou climb up a tree, and you notice a bird's nest. " + "Of course it would be hidden in there," +
				" how obvious you think. " + "You reach your hand into the bird's nest. " + "Unfortunately you do not find a key" +
				" just an angry mother bird. " + "She pecks at you, and starts make loud noises. " + "One of the monsters " +
				"hears you and captures you. ");
			System.out.println("GAME OVER");
		}
		else if(userChoice == 3)
		{
			System.out.println("\nYou walk towards the Cathedral scanning the benches for a clue. " + "You notice one with " +
				"an inscription that reads \"KNOWLEDGE IS KEY\"" + " Knowledge is... KEY! " + "You reach under the bench " +
				"and find a big brass key. " + "You grab it and head to the closest door.");
			level02(pn, riddles, answers);
		}
	}

	/**
	Level 01 of the game. In this level the user is confronted with a riddle
	They must answer it correctly to continue on
	@param pn Takes in the player's name
	@param riddles Takes in the riddles array
	@param answers Takes in the answers array that mirrors the riddles array.
	*/
	public static void level01(String pn, String riddles[], String answers[])
	{
		Random randomRiddle = new Random();
		int riddleNumber;
		String userAnswer;
		Scanner kb = new Scanner(System.in);

		System.out.println("\nYou realize the statue is holding a key as it turns to you. It begins to speak. ");
		System.out.println("\"I am a guardian of the students at this university, I am keeping this key safe from " +
			"evil intruders.\"" + " A little late for that you think. It continues, \"I have been instructed to give " +
			"this key to the chosen one. If that is you, you will be able to answer this riddle, if not you will turn to stone.\"");
		riddleNumber = randomRiddle.nextInt(16);
		System.out.println("\"" + riddles[riddleNumber] + "\"" );
		System.out.print("Please enter your answer: ");
		userAnswer = kb.nextLine();

		if(answers[riddleNumber].equalsIgnoreCase(userAnswer))
		{
			System.out.println("\nThe statue nods, and hands you the key. \"Good luck on your journey chosen one.\"");
			System.out.println("You grab the key and hurry to the Cathedral.");
			level02(pn, riddles, answers);
		}
		else
		{
			System.out.println("\nThe statue looks disappointed. You start to feel your body start to stiffen. " +
				"The right answer was " + answers[riddleNumber] + "You have answered the riddle wrong and will be" +
				" turned into a statue. GAME OVER");
		}
	}

	/**
	Level 02 of the game. This level includes a choice of 1 of 2 possibilities. Each will continue the game.
	However, one will lead to a short cut and the other will make the game play longer.
	@param pn Takes in the player's name
	@param riddles Takes in the riddles array
	@param answers Takes in the answers array that mirrors the riddles array.
	@exception Handles InputMismatchException if the user enters a string instead of a number for their choice
	*/
	public static void level02(String pn, String riddles[], String answers[])
	{
		boolean invalid = false;
		int userChoice = 0;
		Scanner kb = new Scanner(System.in);

		System.out.println("\nYou enter the Cathedral. You walk over to elevators, and you notice a sign.");
		System.out.println("\"OUT OF ORDER. SORRY FOR THE INCONVIENCE.\"");
		System.out.println("Typical Pitt you think, you hear your communicator ring again.");
		System.out.println("\"" + pn + ", I see the elevators are out of order. You have two options now." + 
			" You can find the maintenance man, but" +
			" getting him to help you may prove difficult." + " Your other option is too take the stairs.");
		System.out.println("Do you choose to \n\t(1) Find the maintenance man \n\t(2) Take the stairs.");

		do{
			invalid = false;
			try{
				System.out.print("Enter 1 or 2 to make your choice: ");
				userChoice = kb.nextInt();

				while(userChoice != 1 && userChoice != 2)
				{
					System.out.print("You did not enter a valid choice please try again: ");
					userChoice = kb.nextInt();
					}
				}
			catch(InputMismatchException ime)
			{
				System.out.println("You did not enter a valid choice");
				kb.nextLine();
				invalid = true;
			}
		}while(invalid);

		if(userChoice == 1)
		{
			System.out.println("You chose to find the maintenance man");
			level03(pn, riddles, answers);

		}
		else if(userChoice == 2)
		{
			System.out.println("You chose to take the stairs");
			level04(pn, riddles, answers);
		}
	}

	/**
	Level 03 of the game. This level includes a choice of 1 of 3 possibilities. This is a challenge and if the user 
	guesses the correct answer they will be taken to the final level. If the user guesses wrong the game will end.
	@param pn Takes in the player's name
	@param riddles Takes in the riddles array
	@param answers Takes in the answers array that mirrors the riddles array
	@exception Handles InputMismatchException if the user enters a string instead of a number for their choice
	*/
	public static void level03(String pn, String riddles[], String answers[])
	{
		Scanner kb = new Scanner(System.in);
		int userChoice = 0;
		boolean invalid = false;

		System.out.println("\nYou head down to the ground floor to find the maintenance room. " +
		"After wandering around the dark hallways you locate the maintenance room." + " You come upon a grumpy older man. "+
		"You tell him you need to get one of the elevators working. He laughs \"Why would I help you? I have my own " +
		"important things to do, bratty college kid.\"" + " You offer to help him with his important things so that " +
		"he will help you get the elevator working." + "\"Okay, if you can tell me the tool I need for the job I'll let "+
		"you help me, and then I'll help you.");
		System.out.print(" The bathroom on this floor has flooded, and we need get rid of the excess water." + 
			" I have a \n\t(1) Hammer \n\t(2) Sump pump \n\t(3) Blow torch." + "\nWhich one should we use?");
		System.out.println("Which item do you choose?");

		do{
			invalid = false;
			try{
				System.out.print("Enter 1, 2, or 3 to make your choice: ");
				userChoice = kb.nextInt();

				while(userChoice != 1 && userChoice != 2 && userChoice != 3)
				{
					System.out.print("You did not enter a valid choice please try again: ");
					userChoice = kb.nextInt();
				}
			}
			catch(InputMismatchException ime)
			{
				System.out.println("You did not enter a valid choice.");
				kb.nextLine();
				invalid = true;
			}
		}while(invalid);
	
		if(userChoice == 1)
		{
			System.out.println("\"I'm really going to hope you're joking. Either way, WRONG. I'm not helping you." +
				" Take the stairs kid, exercise is good for you anyway.\"");
			level04(pn, riddles, answers);
		}
		else if(userChoice == 2)
		{
			System.out.println("\"Lucky guess. Okay fine I'll help you after we finish this. Let's get to work\"");
			System.out.println("You help fix the bathroom, and then the maintenance man helps you fix the elevator." +
				" You get in the elevator, and head up to face the evil that is planning to enslave the students.");
			level11(pn);
		}
		else if(userChoice == 3)
		{
			System.out.println("\"No, just no, even if that was the right answer do you think I'd trust a college kid " +
				"with a blow torch? I'm not helping you, take the stairs, exercise is good for you anyway\"");
			level04(pn, riddles, answers);
		}
	}

		/**
	Level 04 of the game. This level includes a choice of 1 of 2 possibilities. One of those possibilities will make
	the game play shorter and allow the user to skip ahead a few levels, the other choice will make the user 
	need to guess a riddle generated from the riddle array. 
	@param pn Takes in the player's name
	@param riddles Takes in the riddles array
	@param answers Takes in the answers array that mirrors the riddles array
	@exception Handles InputMismatchException if the user enters a string instead of a number for their choice
	*/
	public static void level04(String pn, String riddles[], String answers[])
	{
		Scanner kb = new Scanner(System.in);
		int userChoice = 0;
		int userChoice2 = 0;
		boolean invalid = false;
		Random randomRiddle = new Random();
		int riddleNumber = 0;
		String userAnswer;

		System.out.println("\nYou begin to climb the stairs. You go on for what seems like forever. You realize you're only " +
			"at the 7th floor, and you have a long way to go till you get to the top. You decide to look around and see if "+
			"you can find a water fountain to get a drink.");
		System.out.println("You roam the empty floor looking for a water fountain. " + "As you wander around the empty hallways " +
			"you come across a cup in the middle of the floor with a note that says \"drink me\" on it.");
		System.out.println("Do you choose to \n\t(1) Drink the coffee \n\t(2) Keep searching for a water fountain.");

		do{
			invalid = false;
			try{
				System.out.print("Enter 1 or 2 to make your choice: ");
				userChoice = kb.nextInt();

				while(userChoice != 1 && userChoice != 2)
				{
					System.out.print("You did not enter a valid choice please try again: ");
					userChoice2 = kb.nextInt();
				}
			}
			catch(InputMismatchException ime)
			{
				System.out.println("You did not enter a valid choice");
				kb.nextLine();
				invalid = true;
			}
		}while(invalid);

		kb.nextLine();

		if(userChoice == 1)
		{
			System.out.println("\nYou pick up the coffee and drink it. Your body starts to feel sort of... funny." +
			 " Time starts to slow down, or is that you're starting to speed up. " + "Drinking the coffee has" +
				" given you new found speed. You head back to stairwell and continue to climb with ease.");
			level06(pn, riddles, answers);
		}
		else if(userChoice == 2)
		{
			System.out.println("\nYou skip the coffee and continue to look for water fountain. Could've been poison you think." +
				" After walking a little longer you find the water fountain, as you bend down to get a drink you hear a " +
				"voice from behind you.");
			System.out.println("\"Aha chosen one, so nice of you to join me. It seems you have lost your way. If you can "+
				"answer my riddle, I will let you go. If you cannot you will be trapped here forever. ");
			riddleNumber = randomRiddle.nextInt(16);
			System.out.println("Here is your riddle: " + riddles[riddleNumber] +"\"");
			System.out.print("\"What is your answer?\" ");
			userAnswer = kb.nextLine();
			if(answers[riddleNumber].equalsIgnoreCase(userAnswer))
			{
				System.out.println("\"I guess you are a chosen one for a reason! Fine go on your way!\"");
				System.out.println("You make your way back to the stairwell and keep climbing the stairs before you " +
					"run into anyone else.");
				level05(pn, riddles, answers);
			}
			else
			{
				System.out.println("\"HAHAHA you are wrong, don't you know the answer is " + answers[riddleNumber] + 
					" ? You will now be trapped here forever!!!");
				System.out.println("GAME OVER");
			}
		}
	}

	/**
	Level 05 of the game. This level gives the player two choices. One will allow them to continue the game play. The other
	will result in a GAME OVER.
	@param pn Takes in the player's name
	@param riddles Takes in the riddles array
	@param answers Takes in the answers array that mirrors the riddles array
	@exception Handles InputMismatchException if the user enters a string instead of a number for their choice
	*/
	public static void level05(String pn, String riddles[], String answers[])
	{
		Scanner kb = new Scanner(System.in);
		boolean invalid;
		int userChoice = 0;

		System.out.println("\nYou continue up the stairs until you reach a barricade at the 18th floor, " +
			"You'll need to cut through the floor to get to another stairwell. You slowly open the door and notice " +
			"hooded figures roaming the halls, with the creepiest looking one standing in front of the door to the other " +
			"stairwell. You have two options \n\t(1) Make a mad dash to the door \n\t(2) Fight it out.");
		do{
			invalid = false;
			try{
				System.out.print("Enter 1 or 2 to make your choice: ");
				userChoice = kb.nextInt();

				while(userChoice != 1 && userChoice != 2)
				{
					System.out.print("You did not enter a valid choice please try again: ");
					userChoice = kb.nextInt();
				}
			}
			catch(InputMismatchException ime)
			{
				System.out.println("You did not enter a valid choice");
				kb.nextLine();
				invalid = true;
			}
		}while(invalid);

		if(userChoice == 1)
		{
			System.out.println("\nYou prepare to make a run for it when your communicator rings.");
			System.out.println("\"" + pn + ", listen carefully these monsters are terrified of loud noises" +
			" make lots of noise and you will be able to get to the other stairwell. Hurry! \"");
			System.out.println("You take your guides advice and make a dash to the other door screaming and yelling as loud " +
			"as you can. The monsters are paralysed with fear and make it to the other stairwell.");
			level06(pn, riddles, answers);
		}
		else if(userChoice == 2)
		{
			System.out.println("You release a fierce battle cry and enter the floor, weaponless and vulnerable.");
			System.out.println("You are quickly overtaken by the monsters. GAME OVER");
		}
	}

	/**
	Begin Ma'ayan's contribution.
	*/
	
	/**
	Level 06 of the game. This level includes a choice of 1 of 2 possibilities. One leads to a GAME OVER and the other continues the game.
	@param pn Takes in the player's name
	@param riddles Takes in the riddles array
	@param answers Takes in the answers array that mirrors the riddles array.
	@exception handles InputMismatchException if the user enters a string instead of a number for their choice
	*/
	public static void level06(String pn, String riddles[], String answers[])
	{
		int userChoice = 0;
		Scanner kb = new Scanner(System.in);
		boolean invalid;
		System.out.println("\nYou climb more flights of stairs, as you approach the 23rd floor your communicator buzzes. \n\'" +
		pn + ", you're going to need another key to get from the 36th floor to the 42nd, it's in one of the offices on the 23rd floor. " +
		"Leave the stairwell and go find it!\' You leave the stairwell, annoyed with Pitt and its policies about locking the top of the Cathedral. " +
		"You walk down a hallway and see two office doors, each bearing a sign: \n\t(1) The Reward \n\t(2) The Finish. \nWhich do you choose?");
		System.out.print("You choose: ");
		
		do{
			invalid = false;
			try{
				System.out.print("Enter 1 or 2 to make your choice: ");
				userChoice = kb.nextInt();

				while(userChoice != 1 && userChoice != 2)
				{
					System.out.print("You did not enter a valid choice please try again: ");
					userChoice = kb.nextInt();
				}
			}
			catch(InputMismatchException ime)
			{
				System.out.println("You did not enter a valid choice");
				kb.nextLine();
				invalid = true;
			}
		}while(invalid);
		if(userChoice == 2){
			System.out.println("\nYou choose The Finish, you open the door and there is the key sitting on the desk of one of the faculty members. "
			+ "You walk out of the office and keep moving up, wishing that the elevators were working in this stupid place.");
			level07(pn, riddles, answers);
		}
		else{
			System.out.println("\nYou choose The Reward. Cautiously opening the door, you step inside the dark room. You panic as the door locks behind you. "+ 
			"Just as you feel all hope of escape is lost, a spotlight shines in the center of the room. \nIn the light sits a box. You approach " + 
			"the strange object and open it. Inside is a neatly written note. \n'GAME OVER\'");
			
		}
	}
	
	/**
	Level 07 of the game. This level includes a riddle. A wrong answer leads to a GAME OVER. A correct answer leads to a continuation of the game.
	@param pn Takes in the player's name
	@param riddles Takes in the riddles array
	@param answers Takes in the answers array that mirrors the riddles array.
	*/
	public static void level07(String pn, String riddles[], String answers[])
	{
		Scanner kb = new Scanner(System.in);
		int riddleNumber;
		String userAnswer;
		Random randomRiddle = new Random();
		System.out.println("\nYou only make it up two more flights of stairs when you hear a loud buzzing coming from the 25th floor. The frequency is starting " + 
		"to make you weak, you have to hurry and turn it off or you won't last much longer. You enter the floor the sound is stronger, and the lights are bright. " + 
		"You enter the first door you come to, but there's nothing inside. \nYou keep going further checking door after door with no luck. Eventually you " + 
		"enter a room and you see a control box that is controlling the sound and bright lights. You have to shut it down, but you need a combination to do that. " + 
		"There is a note with a hint. 'Answer this riddle and the combination will be revealed': ");
		
		riddleNumber = randomRiddle.nextInt(16);
		System.out.println("\"" + riddles[riddleNumber] + "\"" );
		System.out.print("Please enter your answer: ");
		userAnswer = kb.nextLine();
		if(userAnswer.equalsIgnoreCase(answers[riddleNumber])){
			System.out.println("\nYou are correct! The code is 34953.");
			System.out.println("You quickly enter the code and hit the off switch. The sound stops. You feel your strength returning and head back to the stairs.");
			level08(pn);
		}
		else{
			System.out.println("\nNo combination is revealed. Desperate, you enter a random number. No luck. You try to think more, but you're becoming too weak. You pass out, unable to turn off the sounds.");
			System.out.println("GAME OVER");
		}
	}
	
	/**
	Level 08 of the game. This level includes a choice of 1 of 2 possibilities. One accelerates the player to level 11 of the game. The other continues regularly to level 9 of the game.
	@param pn Takes in the player's name
	@exception handles InputMismatchException if the user enters a string instead of a number for their choice
	*/
	public static void level08(String pn){
		Scanner kb = new Scanner(System.in);
		int userChoice = 0;
		boolean invalid;
		System.out.println("As you climb higher and higher you reach the 31st floor. You notice a robot in front of the door, its beckoning you to follow it. Do you decide to: \n\t(1) Ignore it \n\t(2) Follow it");
		System.out.print("You choose: ");
		
		do{
			invalid = false;
			try{
				System.out.print("Enter 1 or 2 to make your choice: ");
				userChoice = kb.nextInt();

				while(userChoice != 1 && userChoice != 2)
				{
					System.out.print("You did not enter a valid choice please try again: ");
					userChoice = kb.nextInt();
				}
			}
			catch(InputMismatchException ime)
			{
				System.out.println("You did not enter a valid choice");
				kb.nextLine();
				invalid = true;
			}
		}while(invalid);
		if(userChoice == 1){
			System.out.println("\nYou decide to ignore it and keep climbing up the stairs to the 36th floor.");
			level11(pn);
		}
		else{
			System.out.println("\nYou follow it, maybe it's here to help you. You soon find out, however, that it isn't here to help. Before you can fully collect your thoughts, it leads you back down to the 27th floor and locks you into a closet.");
			level09(pn);
		}

		
	}
	
	/**
	Level 09 of the game. This level includes a choice of 1 of 2 possibilities. One leads to a GAME OVER and the other continues the game.
	@param pn Takes in the player's name
	@exception handles InputMismatchException if the user enters a string instead of a number for their choice
	*/
	public static void level09(String pn){
		Scanner kb = new Scanner(System.in);
		int userChoice = 0;
		boolean invalid;
		System.out.println("You search around the small closet, looking for a way to get out. Among the things \nyou see in the closet, you find two things that you think might be useful to you: \n\t(1) A hammer \n\t(2) A thin metal rod");
		System.out.print("You choose: ");
		
		do{
			invalid = false;
			try{
				System.out.print("Enter 1 or 2 to make your choice: ");
				userChoice = kb.nextInt();

				while(userChoice != 1 && userChoice != 2)
				{
					System.out.print("You did not enter a valid choice please try again: ");
					userChoice = kb.nextInt();
				}
			}
			catch(InputMismatchException ime)
			{
				System.out.println("You did not enter a valid choice");
				kb.nextLine();
				invalid = true;
			}
		}while(invalid);
		if(userChoice == 1){
			System.out.println("You use the hammer to break the closet's glass door. Unfortunately, when you do this a monster hears the commotion and captures you.");
			System.out.println("GAME OVER");
		}
		else{
			System.out.println("You take the metal rod and try to use it as a way to pick the lock. After a lot of fussing, you hear a click. The door opens and you sneak out back into the stairwell.");
			level10(pn);
		}
	}
	
	/**
	Level 10 of the game. This level includes a choice of 1 of 2 possibilities. One leads to a GAME OVER and the other continues the game.
	@param pn Takes in the player's name
	@exception handles InputMismatchException if the user enters a string instead of a number for their choice
	*/
	public static void level10(String pn){
		Scanner kb = new Scanner(System.in);
		int userChoice = 0;
		boolean invalid;
		System.out.println("You reach the 30th floor and you see the figure again. It realizes you've escaped. You have to defeat it to continue on this time. You check your backpack to see if there's anything you can use to stop it. Your backpack contains the following items. \n\t(1) A highlighter \n\t(2) An umbrella \n\t(3) A textbook on artificial intelligence \n\t(4) A stapler");
		System.out.println("Please select your weapon of choice: ");
		do{
			invalid = false;
			try{
				System.out.print("Enter 1, 2, 3, or 4 to make your choice: ");
				userChoice = kb.nextInt();

				while(userChoice != 1 && userChoice != 2 && userChoice !=3 && userChoice !=4)
				{
					System.out.print("You did not enter a valid choice please try again: ");
					userChoice = kb.nextInt();
				}
			}
			catch(InputMismatchException ime)
			{
				System.out.println("You did not enter a valid choice");
				kb.nextLine();
				invalid = true;
			}
		}while(invalid);
		if(userChoice == 1 || userChoice == 2 || userChoice == 4){
			System.out.println("Your weapon of choice is no match for the robot. He captures you, this time making sure you are trapped for good.");
			System.out.println("GAME OVER");
		}
		else{
			System.out.println("You open your textbook trying to see if something will tell you how to stop a robot. You open to a particular page that reads AI systems cannot handle paradoxes'.");
			System.out.println("'Of course!', you yell out. You turn to the robot and clearly state, 'this sentence is false'.");
			System.out.println("The robot thinks about what you said and begins to malfunction, unable to handle the paradox you presented it with.");
			System.out.println("You are able to move past it and continue with your quest.");
			level11(pn);
		}
	}
	
	/**
	Level 11 of the game. This level includes a choice of 1 of 2 possibilities. One leads to a GAME OVER and the other continues the game.
	@param pn Takes in the player's name
	@exception handles InputMismatchException if the user enters a string instead of a number for their choice
	*/
	public static void level11(String pn){
		Scanner kb = new Scanner(System.in);
		int userChoice = 0;
		boolean invalid;
		System.out.println("You get to the 36th floor of the Cathedral. You hear the beast stirring above you. Only a locked door stands in your way.");
		System.out.println("Using the key you received earlier in your quest, you unlock the door and climb to the 42nd floor.");
		System.out.println("\nThis is it.... Are you ready?");
		System.out.println("\n\t(1) Wait! Ah! Give me a minute to collect my breath \n\t(2) Let's get this over with");
		System.out.print("You choose: ");
		do{
			invalid = false;
			try{
				System.out.print("Enter 1 or 2 to make your choice: ");
				userChoice = kb.nextInt();

				while(userChoice != 1 && userChoice != 2)
				{
					System.out.print("You did not enter a valid choice please try again: ");
					userChoice = kb.nextInt();
				}
			}
			catch(InputMismatchException ime)
			{
				System.out.println("You did not enter a valid choice");
				kb.nextLine();
				invalid = true;
			}
		}while(invalid);
		if(userChoice == 1){
			System.out.println("You stop to catch your breath. In that second, someone hits you over the back of the head with something heavy. You hit the floor. Your vision begins to blur. Then darkness.");
			System.out.println("You were so close. Sucks.");
			System.out.println("GAME OVER");
			
		}
		else{
			levelFinal(pn);
		}
	}
	
	/**
	The final level of the game. This level includes a complex riddle. If answered incorrectly, GAME OVER. If answered correctly, the player wins the game.
	@param pn Takes in the player's name
	*/
	public static void levelFinal(String pn){
		Scanner kb = new Scanner(System.in);
		System.out.println("\nThe door clicks shut behind you. You are in a room that is completely bare except for a desk with a piece of paper lying flatly on its surface. You cautiously move closer. It's another message from your guide.");
		System.out.println("'" +pn + ", you have made it to the final level. I knew you could do it! Now, be quick! To stop the mind-control device, you will have to defeat Dr. Doom. He is just beyond those doors.'");
		System.out.println("You walk through the doors in front of you and come face to face with a tall figure dressed in black standing next to a large machine that looks like an oversized microscope.");
		System.out.println("'Hello,'" + pn + ". So nice of you to join me for my final presentation. Once I press this red button on the side of my device, all of the University of Pittsburgh will become coffee-drinking, homework-doing zombies! Mwa hahahahha!'");
		System.out.println("\nYou take a second to ponder this. 'But isn't that already..... their reality?'");
		System.out.println("\n'Don't ruin my moment, " + pn + "! Now, time to activate the device.' Dr. Doom's hand moves towards the button, getting closer and closer. You think to yourself, 'I must remember my mission!'");
		System.out.println("\n'Wait,' you scream. 'What will it take for you to call off the device?'");
		System.out.println("Dr. Doom stops himself and thinks for a moment. 'What I want is for you to answer a riddle that even I cannot answer. If you get it correct, I will show respect for your intelligence by not igniting the device.'");
		System.out.println("'Hit me with it.'");
		System.out.println("'OK. There are 5 houses in 5 different colors. In each house lives a person with a different nationality. The 5 owners drink a certain type of beverage, smoke a certain brand of cigar, and keep a certain pet. No owners have the same pet, smoke the same brand of cigar, or drink the same beverage. \nThe question is, who owns the fish?'");
		System.out.println("'I will allow you these hints': \n\tThe Brit lives in the red house \n\tThe Swede keeps dogs as pets \n\tThe Dane drinks tea \n\tThe green house is on the left of the white house \n\tThe green home owner drinks coffee \n\tThe person who smokes Pall Mall rears birds \n\tThe owner of the yellow house smokes Dunhill \n\tThe man living in the " + 
		"center house drinks milk \n\tThe Norwegian lives in the first house \n\tThe man who smokes blend lives next to the one who keeps cats \n\tThe man who keeps the horse lives next to the man who smokes Dunhill \n\tThe owner who smokes Bluemaster drinks beer \n\tThe German smokes prince \n\tThe Norwegian lives next to the blue house \n\tThe man who " + 
		"smokes Blend has a neighbour who drinks water");
		System.out.println("\nWho owns the fish? Please include \'The\' in your answer.");
		System.out.print("\nYour answer: ");
		String answer = kb.nextLine();
		if(answer.equalsIgnoreCase("The German")){
			System.out.println("'You are correct! Damn!' Dr. Doom scoffs. And yet, he is true to his word and respects your intelligence by not pressing the activation button and disappearing from the face of the earth.");
			System.out.println("The University of Pittsburgh is safe once again.");
		}
		else{
			System.out.println("'Haha! You are incorrect!' Dr. Doom laughs as he presses the activation button. The last thing you remember is a single tear sliding down your cheek.");
			System.out.println("GAME OVER");
		}
	}
		
}