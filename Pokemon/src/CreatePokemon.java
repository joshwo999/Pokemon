import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;
public class CreatePokemon
	{
		 static ArrayList<Pokemon> pokemon= new ArrayList<Pokemon>();
		 static ArrayList<Moves> bulbasaurMoves= new ArrayList<Moves>();
		 static ArrayList<Moves> squirtleMoves= new ArrayList<Moves>();
		 static ArrayList<Moves> charmanderMoves= new ArrayList<Moves>();
		 static ArrayList<Items> inventory=new ArrayList<Items>();
		 public static void fillDeck()
			{
			//Bulbasaur
			bulbasaurMoves.add(new Moves("Vine Whip", 45, 10, "Grass"));
			bulbasaurMoves.add(new Moves("Razor Leaf", 55, 10, "Grass"));
			bulbasaurMoves.add(new Moves("Double-Edge", 110, 5, "Grass"));
			bulbasaurMoves.add(new Moves("Seed Bomb", 80, 10, "Grass"));
			pokemon.add(new Pokemon("Bulbasaur", 100, 49, 49, 65, 65, 45, "Grass", "Fire", bulbasaurMoves.get(0), bulbasaurMoves.get(1), bulbasaurMoves.get(2), bulbasaurMoves.get(3)));
			//Squirtle
			squirtleMoves.add(new Moves("Water Pulse", 60, 10, "Water"));
			squirtleMoves.add(new Moves("Water Gun", 40, 10, "Water"));
			squirtleMoves.add(new Moves("Hydro Pump", 110, 5, "Water"));
			squirtleMoves.add(new Moves("Bubble", 40, 10, "Water"));
			pokemon.add(new Pokemon("Squirtle", 100, 48, 65, 50, 64, 43, "Water", "Grass", squirtleMoves.get(0), squirtleMoves.get(1), squirtleMoves.get(2), squirtleMoves.get(3)));
			//Charmander
			charmanderMoves.add(new Moves("Ember", 40, 10, "Fire"));
			charmanderMoves.add(new Moves("Fire Spin", 35, 10, "Fire"));
			charmanderMoves.add(new Moves("Flamethrower", 90, 5, "Fire"));
			charmanderMoves.add(new Moves("Fire Fang", 65, 10, "Fire"));
			pokemon.add(new Pokemon("Charmander", 100, 52, 43, 60, 50, 65, "Fire", "Water", charmanderMoves.get(0), charmanderMoves.get(1), charmanderMoves.get(2), charmanderMoves.get(3)));
			//User Inventory
			inventory.add(new Items("Potion", 20, 0, 5));
			inventory.add(new Items("Super Potion", 50, 0,1));
			
			}
		 public static void displayPokemon()
		 {
			 for(Pokemon p:pokemon)
					{
						System.out.println("Name: "+p.getName());
						System.out.println("Type: "+p.getType());
						System.out.println("Weakness: "+p.getNemesis());
						System.out.println("HP: "+(int)p.getHP());
						System.out.println("Attack: "+p.getAttack());
						System.out.println("Deffense: "+p.getDeffense());
						System.out.println("Special Attack: "+p.getSpAttack());
						System.out.println("Special Deffense: "+p.getSpDeffense());
						System.out.println("Speed: "+p.getSpeed());
						System.out.println("Moves: ");
						System.out.println("1) "+p.getMove1().getName());
						System.out.println("      Power: "+p.getMove1().getPower());
						System.out.println("      Power Points: "+p.getMove1().getPowerPoints());
						System.out.println("2) "+p.getMove2().getName());
						System.out.println("      Power: "+p.getMove2().getPower());
						System.out.println("      Power Points: "+p.getMove2().getPowerPoints());
						System.out.println("3) "+p.getMove3().getName());
						System.out.println("      Power: "+p.getMove3().getPower());
						System.out.println("      Power Points: "+p.getMove3().getPowerPoints());
						System.out.println("4) "+p.getMove4().getName());
						System.out.println("      Power: "+p.getMove4().getPower());
						System.out.println("      Power Points: "+p.getMove4().getPowerPoints());
						System.out.println("");
						System.out.println("");
					}
			 BattlePokemon.pickUserPokemon();
		 }
		 public static void createMenu()
		 {
			 System.out.println("Which move would you like to use? (Type the number corresponding to the move.) If you would like to view the stats of each moves, type 5.  ");
			 System.out.println("If instead you would like to use an item, type 6 to open your inventory.");
			 System.out.println("");
			 System.out.println("1) "+ pokemon.get(BattlePokemon.userChoice).getMove1().getName());
			 System.out.println("2) "+pokemon.get(BattlePokemon.userChoice).getMove2().getName());
			 System.out.println("3) "+pokemon.get(BattlePokemon.userChoice).getMove3().getName());
			 System.out.println("4) "+pokemon.get(BattlePokemon.userChoice).getMove4().getName());
		 }
		 public static void displayStats()
		 {
			 if(BattlePokemon.userChoice==0)
				 	{
					 for(Moves m:bulbasaurMoves)
						 	 {
						 	    System.out.println("Name: "+m.getName());
						 	    System.out.println("Type: "+m.getType());
						 	    System.out.println("Power: "+m.getPower());
						 	    System.out.println("Power Points: "+m.getPowerPoints());
						 		System.out.println("");
						 	 }
				 	 }
			 else if(BattlePokemon.userChoice==1)
					 {
						 for(Moves m:squirtleMoves)
							 {
								System.out.println("Name: "+m.getName());
								System.out.println("Type: "+m.getType());
								System.out.println("Power: "+m.getPower());
								System.out.println("Power Points: "+m.getPowerPoints());
								System.out.println("");
							 }	 
					 }
			 else
				 	 {
					 	for(Moves m:charmanderMoves)
						 	{
							   System.out.println("Name: "+m.getName());
							   System.out.println("Type: "+m.getType());
							   System.out.println("Power: "+m.getPower());
							   System.out.println("Power Points: "+m.getPowerPoints());
							   System.out.println("");
						 	}
					 	
				 	 }
			 createMenu();
			 BattlePokemon.calculateUserDamage();
			 
		 }
		 public static void openInventory()
		 {
			 try
				 {
			 Scanner userInput=new Scanner(System.in);
			 System.out.println("Type the number corresponding to the item you would like to use. If you do not want to use an item, type 6.");
			 System.out.println("");
			 int j =1;
			 for(Items i:inventory)
				 {
					 System.out.println(j+") "+i.getName()+" x "+i.getAmount());
					 j++;
				 }
			 int userDecision=userInput.nextInt()-1;
			 if(userDecision==5)
				 {
					 createMenu();
					 BattlePokemon.calculateUserDamage();
				 }
			 else
				 {
					 if(userDecision==0)
						 {
							 if(inventory.get(userDecision).getAmount()==0)
								 {
									 System.out.println("You don't have any of these items left.");
									 openInventory();
								 }
							 else
								 {
									
									 pokemon.get(BattlePokemon.userChoice).setHP(pokemon.get(BattlePokemon.userChoice).getHP()+20);
									 inventory.get(userDecision).setAmount(inventory.get(userDecision).getAmount()-1);
									 if(pokemon.get(BattlePokemon.userChoice).getHP()>100)
										 {
											 pokemon.get(BattlePokemon.userChoice).setHP(100);
										 }
								 }
						 }
					 if(userDecision==1)
						 {
							 if(inventory.get(userDecision).getAmount()==0)
								 {
									 System.out.println("You don't have any of these items left.");
									 openInventory();
								 }
							 else
								 {
									 pokemon.get(BattlePokemon.userChoice).setHP(pokemon.get(BattlePokemon.userChoice).getHP()+50);
									 inventory.get(userDecision).setAmount(inventory.get(userDecision).getAmount()-1);
									 if(pokemon.get(BattlePokemon.userChoice).getHP()>100)
										 {
											 pokemon.get(BattlePokemon.userChoice).setHP(100);
										 }
								 }
						 }
				 }
				 }
			 catch(Exception e)
				 {
					 System.out.println("You can't do that.");
					 openInventory();
				 }
		 }
		 
	
		
	}
