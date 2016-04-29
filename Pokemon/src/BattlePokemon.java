import java.util.Scanner;
public class BattlePokemon
	{
		static boolean bothStillLive=true; 
		static int userChoice;
		static int enemyChoice;
		static double userAttackDamage;
		static int enemyAttackDamage;
		public static int pickUserPokemon()
			{
				try
					{
				Scanner userInput=new Scanner(System.in);
				int i=1;
				System.out.println("Which pokemon would you like to play as?(Type the number corresponding to the pokemon.) If you want to view the specific stats for each pokemon, type 5.");
				for(Pokemon p:CreatePokemon.pokemon)
					{
						System.out.println(i+") "+p.getName());
						i++;
					}
				userChoice=userInput.nextInt()-1;
				if(userChoice==4)
					{
						CreatePokemon.displayPokemon();
					}
				else
					{
						System.out.println("You picked "+CreatePokemon.pokemon.get(userChoice).getName());
						System.out.println("");
					}
					}
				catch(Exception e)
					{
						System.out.println("You can't do that.");
						System.out.println("");
						pickUserPokemon();
					}
				
				return userChoice;
			}
		public static int pickEnemyPokemon()
		{
			Scanner userInput=new Scanner(System.in);
			enemyChoice=(int)(Math.random()*3);
			if(enemyChoice==userChoice)
				{
					pickEnemyPokemon();
				}
			else
				{
					System.out.println("Your enemy picked "+CreatePokemon.pokemon.get(enemyChoice).getName());
					System.out.println("");
				}
			
			return enemyChoice;
		}
		public static double calculateUserDamage()
		{
			try
				{
			Scanner userInput=new Scanner(System.in);
			int userAttack;
			userAttack=userInput.nextInt();
			int randomNumber=(int)(Math.random()*16)+85;
			if(userAttack==5)
				{
					CreatePokemon.displayStats();
				}
			else if(userAttack==6)
				{
					CreatePokemon.openInventory();
				}
			else{
				
			if(userChoice==0)
				{
					if(CreatePokemon.bulbasaurMoves.get(userAttack-1).getPowerPoints()==0)
						{
							System.out.println("This move is out of power points. Pick another.");
							System.out.println("");
							CreatePokemon.createMenu();
							calculateUserDamage();
						}
					else
						{
					if(CreatePokemon.pokemon.get(enemyChoice).getType()==CreatePokemon.pokemon.get(userChoice).getNemesis())
						{
							userAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(userChoice).getAttack()*CreatePokemon.bulbasaurMoves.get(userAttack-1).getPower()/CreatePokemon.pokemon.get(enemyChoice).getDeffense())/50)+2)*1*.5*100/randomNumber;
							System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" used "+CreatePokemon.bulbasaurMoves.get(userAttack-1).getName()+" and dealt "+(int)userAttackDamage+" damage.");
							CreatePokemon.pokemon.get(enemyChoice).setHP(CreatePokemon.pokemon.get(enemyChoice).getHP()-(int)userAttackDamage);
							CreatePokemon.bulbasaurMoves.get(userAttack-1).setPowerPoints(CreatePokemon.bulbasaurMoves.get(userAttack-1).getPowerPoints()-1);
						}
					else if(CreatePokemon.pokemon.get(enemyChoice).getNemesis()==CreatePokemon.pokemon.get(userChoice).getType())
						{
							userAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(userChoice).getAttack()*CreatePokemon.bulbasaurMoves.get(userAttack-1).getPower()/CreatePokemon.pokemon.get(enemyChoice).getDeffense())/50)+2)*1*2*100/randomNumber;
							System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" used "+CreatePokemon.bulbasaurMoves.get(userAttack-1).getName()+" and dealt "+(int)userAttackDamage+" damage.");
							CreatePokemon.pokemon.get(enemyChoice).setHP(CreatePokemon.pokemon.get(enemyChoice).getHP()-(int)userAttackDamage);
							CreatePokemon.bulbasaurMoves.get(userAttack-1).setPowerPoints(CreatePokemon.bulbasaurMoves.get(userAttack-1).getPowerPoints()-1);
						}
					else
						{
							userAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(userChoice).getAttack()*CreatePokemon.bulbasaurMoves.get(userAttack-1).getPower()/CreatePokemon.pokemon.get(enemyChoice).getDeffense())/50)+2)*1*1*100/randomNumber;
							System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" used "+CreatePokemon.bulbasaurMoves.get(userAttack-1).getName()+" and dealt "+(int)userAttackDamage+" damage.");
							CreatePokemon.pokemon.get(enemyChoice).setHP(CreatePokemon.pokemon.get(enemyChoice).getHP()-(int)userAttackDamage);
							CreatePokemon.bulbasaurMoves.get(userAttack-1).setPowerPoints(CreatePokemon.bulbasaurMoves.get(userAttack-1).getPowerPoints()-1);
						}
					
					if(CreatePokemon.pokemon.get(enemyChoice).getHP()<=0)
						{
							checkForWin();
						}
					else
						{
							if(CreatePokemon.pokemon.get(enemyChoice).getType()==CreatePokemon.pokemon.get(userChoice).getNemesis())
								{
									System.out.println(CreatePokemon.pokemon.get(enemyChoice).getName()+" now has "+CreatePokemon.pokemon.get(enemyChoice).getHP()+"HP.");
									System.out.println("It wasn't very effective...");
									System.out.println("");
								}
							else if(CreatePokemon.pokemon.get(enemyChoice).getNemesis()==CreatePokemon.pokemon.get(userChoice).getType())
								{
									System.out.println(CreatePokemon.pokemon.get(enemyChoice).getName()+" now has "+CreatePokemon.pokemon.get(enemyChoice).getHP()+"HP.");
									System.out.println("It was super effective!");
									System.out.println("");
								}
							else
								{
									System.out.println(CreatePokemon.pokemon.get(enemyChoice).getName()+" now has "+CreatePokemon.pokemon.get(enemyChoice).getHP()+"HP.");
									System.out.println("");
								}
							
						}
						}
				}
					
			
				
			if(userChoice==1)
				{
					if(CreatePokemon.pokemon.get(enemyChoice).getType()==CreatePokemon.pokemon.get(userChoice).getNemesis())
						{
							userAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(userChoice).getAttack()*CreatePokemon.squirtleMoves.get(userAttack-1).getPower()/CreatePokemon.pokemon.get(enemyChoice).getDeffense())/50)+2)*1*.5*100/randomNumber;
							System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" used "+CreatePokemon.squirtleMoves.get(userAttack-1).getName()+" and dealt "+(int)userAttackDamage+" damage.");
							CreatePokemon.pokemon.get(enemyChoice).setHP(CreatePokemon.pokemon.get(enemyChoice).getHP()-(int)userAttackDamage);
							CreatePokemon.squirtleMoves.get(userAttack-1).setPowerPoints(CreatePokemon.squirtleMoves.get(userAttack-1).getPowerPoints()-1);
						}
					else if(CreatePokemon.pokemon.get(enemyChoice).getNemesis()==CreatePokemon.pokemon.get(userChoice).getType())
						{
							userAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(userChoice).getAttack()*CreatePokemon.squirtleMoves.get(userAttack-1).getPower()/CreatePokemon.pokemon.get(enemyChoice).getDeffense())/50)+2)*1*2*100/randomNumber;
							System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" used "+CreatePokemon.squirtleMoves.get(userAttack-1).getName()+" and dealt "+(int)userAttackDamage+" damage.");
							CreatePokemon.pokemon.get(enemyChoice).setHP(CreatePokemon.pokemon.get(enemyChoice).getHP()-(int)userAttackDamage);
							CreatePokemon.squirtleMoves.get(userAttack-1).setPowerPoints(CreatePokemon.squirtleMoves.get(userAttack-1).getPowerPoints()-1);
						}
					else
						{
							userAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(userChoice).getAttack()*CreatePokemon.squirtleMoves.get(userAttack-1).getPower()/CreatePokemon.pokemon.get(enemyChoice).getDeffense())/50)+2)*1*1*100/randomNumber;
							System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" used "+CreatePokemon.squirtleMoves.get(userAttack-1).getName()+" and dealt "+(int)userAttackDamage+" damage.");
							CreatePokemon.pokemon.get(enemyChoice).setHP(CreatePokemon.pokemon.get(enemyChoice).getHP()-(int)userAttackDamage);
							CreatePokemon.squirtleMoves.get(userAttack-1).setPowerPoints(CreatePokemon.squirtleMoves.get(userAttack-1).getPowerPoints()-1);
						}
					if(CreatePokemon.pokemon.get(enemyChoice).getHP()<=0)
						{
							checkForWin();
						}
					else
						{
							if(CreatePokemon.pokemon.get(enemyChoice).getType()==CreatePokemon.pokemon.get(userChoice).getNemesis())
								{
									System.out.println(CreatePokemon.pokemon.get(enemyChoice).getName()+" now has "+CreatePokemon.pokemon.get(enemyChoice).getHP()+"HP.");
									System.out.println("It wasn't very effective...");
									System.out.println("");
								}
							else if(CreatePokemon.pokemon.get(enemyChoice).getNemesis()==CreatePokemon.pokemon.get(userChoice).getType())
								{
									System.out.println(CreatePokemon.pokemon.get(enemyChoice).getName()+" now has "+CreatePokemon.pokemon.get(enemyChoice).getHP()+"HP.");
									System.out.println("It was super effective!");
									System.out.println("");
								}
							else
								{
									System.out.println(CreatePokemon.pokemon.get(enemyChoice).getName()+" now has "+CreatePokemon.pokemon.get(enemyChoice).getHP()+"HP.");
									System.out.println("");
								}
							
						}
				}
			if(userChoice==2)
				{
					if(CreatePokemon.pokemon.get(enemyChoice).getType()==CreatePokemon.pokemon.get(userChoice).getNemesis())
						{
							userAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(userChoice).getAttack()*CreatePokemon.charmanderMoves.get(userAttack-1).getPower()/CreatePokemon.pokemon.get(enemyChoice).getDeffense())/50)+2)*1*.5*100/randomNumber;
							System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" used "+CreatePokemon.charmanderMoves.get(userAttack-1).getName()+" and dealt "+(int)userAttackDamage+" damage.");
							CreatePokemon.pokemon.get(enemyChoice).setHP(CreatePokemon.pokemon.get(enemyChoice).getHP()-(int)userAttackDamage);
							CreatePokemon.charmanderMoves.get(userAttack-1).setPowerPoints(CreatePokemon.charmanderMoves.get(userAttack-1).getPowerPoints()-1);
						}
					else if(CreatePokemon.pokemon.get(enemyChoice).getNemesis()==CreatePokemon.pokemon.get(userChoice).getType())
						{
							userAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(userChoice).getAttack()*CreatePokemon.charmanderMoves.get(userAttack-1).getPower()/CreatePokemon.pokemon.get(enemyChoice).getDeffense())/50)+2)*1*2*100/randomNumber;
							System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" used "+CreatePokemon.charmanderMoves.get(userAttack-1).getName()+" and dealt "+(int)userAttackDamage+" damage.");
							CreatePokemon.pokemon.get(enemyChoice).setHP(CreatePokemon.pokemon.get(enemyChoice).getHP()-(int)userAttackDamage);
							CreatePokemon.charmanderMoves.get(userAttack-1).setPowerPoints(CreatePokemon.charmanderMoves.get(userAttack-1).getPowerPoints()-1);
						}
					else
						{
							userAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(userChoice).getAttack()*CreatePokemon.charmanderMoves.get(userAttack-1).getPower()/CreatePokemon.pokemon.get(enemyChoice).getDeffense())/50)+2)*1*1*100/randomNumber;
							System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" used "+CreatePokemon.charmanderMoves.get(userAttack-1).getName()+" and dealt "+(int)userAttackDamage+" damage.");
							CreatePokemon.pokemon.get(enemyChoice).setHP(CreatePokemon.pokemon.get(enemyChoice).getHP()-(int)userAttackDamage);
							CreatePokemon.charmanderMoves.get(userAttack-1).setPowerPoints(CreatePokemon.charmanderMoves.get(userAttack-1).getPowerPoints()-1);
						}
					if(CreatePokemon.pokemon.get(enemyChoice).getHP()<=0)
						{
							checkForWin();
						}
					else
						{
					if(CreatePokemon.pokemon.get(enemyChoice).getType()==CreatePokemon.pokemon.get(userChoice).getNemesis())
						{
							System.out.println(CreatePokemon.pokemon.get(enemyChoice).getName()+" now has "+CreatePokemon.pokemon.get(enemyChoice).getHP()+"HP.");
							System.out.println("It wasn't very effective...");
							System.out.println("");
						}
					else if(CreatePokemon.pokemon.get(enemyChoice).getNemesis()==CreatePokemon.pokemon.get(userChoice).getType())
						{
							System.out.println(CreatePokemon.pokemon.get(enemyChoice).getName()+" now has "+CreatePokemon.pokemon.get(enemyChoice).getHP()+"HP.");
							System.out.println("It was super effective!");
							System.out.println("");
						}
					else
						{
							System.out.println(CreatePokemon.pokemon.get(enemyChoice).getName()+" now has "+CreatePokemon.pokemon.get(enemyChoice).getHP()+"HP.");
							System.out.println("");
						}
						}
				}
					
			}
				}
			catch(Exception e)
				{
					System.out.println("");
					System.out.println("You can't do that.");
					System.out.println("");
					CreatePokemon.createMenu();
					calculateUserDamage();
				}
				return userAttackDamage;
			
			
			
	}
	
		

		public static int calculateEnemyDamage()
		{
			int randomNumber=(int)(Math.random()*16)+85;
			int randomMove=(int)(Math.random()*4);
			int potionChance=(int)(Math.random()*2);
			if((CreatePokemon.pokemon.get(enemyChoice).getHP()<35)&&(potionChance==0))
				{
					System.out.println("Your opponent used a super potion.");
					CreatePokemon.pokemon.get(enemyChoice).setHP(CreatePokemon.pokemon.get(enemyChoice).getHP()+50);
					System.out.println(CreatePokemon.pokemon.get(enemyChoice).getName()+" now has "+CreatePokemon.pokemon.get(enemyChoice).getHP()+" HP.");
					System.out.println("");
					CreatePokemon.createMenu();
					calculateUserDamage();
				}
			else
				{
			if(enemyChoice==0)
				{
					if(CreatePokemon.pokemon.get(userChoice).getType()==CreatePokemon.pokemon.get(enemyChoice).getNemesis())
						{
							enemyAttackDamage=(int) (((((2*5/5+2)*CreatePokemon.pokemon.get(enemyChoice).getAttack()*CreatePokemon.bulbasaurMoves.get(randomMove).getPower()/CreatePokemon.pokemon.get(userChoice).getDeffense())/50)+2)*1*.5*100/randomNumber);
							System.out.println("Bulbasaur used "+CreatePokemon.bulbasaurMoves.get(randomMove).getName()+" and dealt "+enemyAttackDamage+" damage.");
							CreatePokemon.pokemon.get(userChoice).setHP(CreatePokemon.pokemon.get(userChoice).getHP()-enemyAttackDamage);
							
						}
					else if(CreatePokemon.pokemon.get(userChoice).getNemesis()==CreatePokemon.pokemon.get(enemyChoice).getType())
						{
							enemyAttackDamage=(int) (((((2*5/5+2)*CreatePokemon.pokemon.get(enemyChoice).getAttack()*CreatePokemon.bulbasaurMoves.get(randomMove).getPower()/CreatePokemon.pokemon.get(userChoice).getDeffense())/50)+2)*1*2*100/randomNumber);
							System.out.println("Bulbasaur used "+CreatePokemon.bulbasaurMoves.get(randomMove).getName()+" and dealt "+enemyAttackDamage+" damage.");
							CreatePokemon.pokemon.get(userChoice).setHP(CreatePokemon.pokemon.get(userChoice).getHP()-enemyAttackDamage);
						
						}
					else
						{
							enemyAttackDamage=(int) (((((2*5/5+2)*CreatePokemon.pokemon.get(enemyChoice).getAttack()*CreatePokemon.bulbasaurMoves.get(randomMove).getPower()/CreatePokemon.pokemon.get(userChoice).getDeffense())/50)+2)*1*1*100/randomNumber);
							System.out.println("Bulbasaur used "+CreatePokemon.bulbasaurMoves.get(randomMove).getName()+" and dealt "+enemyAttackDamage+" damage.");
							CreatePokemon.pokemon.get(userChoice).setHP(CreatePokemon.pokemon.get(userChoice).getHP()-enemyAttackDamage);
						
						}
					
					if(CreatePokemon.pokemon.get(userChoice).getHP()<=0)
						{
							checkForWin();
						}
					else
						{
							if(CreatePokemon.pokemon.get(userChoice).getType()==CreatePokemon.pokemon.get(enemyChoice).getNemesis())
								{
									System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" now has "+CreatePokemon.pokemon.get(userChoice).getHP()+"HP.");
									System.out.println("It wasn't very effective...");
									System.out.println("");
								}
							else if(CreatePokemon.pokemon.get(userChoice).getNemesis()==CreatePokemon.pokemon.get(enemyChoice).getType())
								{
									System.out.println(CreatePokemon.pokemon.get(enemyChoice).getName()+" now has "+CreatePokemon.pokemon.get(userChoice).getHP()+"HP.");
									System.out.println("It was super effective!");
									System.out.println("");
								}
							else
								{
									System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" now has "+CreatePokemon.pokemon.get(userChoice).getHP()+"HP.");
									System.out.println("");
								}
							
						}
				
		
				}
			if(enemyChoice==1)
				{
					if(CreatePokemon.pokemon.get(userChoice).getType()==CreatePokemon.pokemon.get(enemyChoice).getNemesis())
						{
							enemyAttackDamage=(int) (((((2*5/5+2)*CreatePokemon.pokemon.get(enemyChoice).getAttack()*CreatePokemon.squirtleMoves.get(randomMove).getPower()/CreatePokemon.pokemon.get(userChoice).getDeffense())/50)+2)*1*.5*100/randomNumber);
							System.out.println("Squirlte used "+CreatePokemon.squirtleMoves.get(randomMove).getName()+" and dealt "+enemyAttackDamage+" damage.");
							CreatePokemon.pokemon.get(userChoice).setHP(CreatePokemon.pokemon.get(userChoice).getHP()-enemyAttackDamage);
				
						}
					else if(CreatePokemon.pokemon.get(userChoice).getNemesis()==CreatePokemon.pokemon.get(enemyChoice).getType())
						{
							enemyAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(enemyChoice).getAttack()*CreatePokemon.squirtleMoves.get(randomMove).getPower()/CreatePokemon.pokemon.get(userChoice).getDeffense())/50)+2)*1*2*100/randomNumber;
							System.out.println("Squirlte used "+CreatePokemon.squirtleMoves.get(randomMove).getName()+" and dealt "+enemyAttackDamage+" damage.");
							CreatePokemon.pokemon.get(userChoice).setHP(CreatePokemon.pokemon.get(userChoice).getHP()-enemyAttackDamage);
					
						}
					else
						{
							enemyAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(enemyChoice).getAttack()*CreatePokemon.squirtleMoves.get(randomMove).getPower()/CreatePokemon.pokemon.get(userChoice).getDeffense())/50)+2)*1*1*100/randomNumber;
							System.out.println("Squirlte used "+CreatePokemon.squirtleMoves.get(randomMove).getName()+" and dealt "+enemyAttackDamage+" damage.");
							CreatePokemon.pokemon.get(userChoice).setHP(CreatePokemon.pokemon.get(userChoice).getHP()-enemyAttackDamage);
					
						}
					if(CreatePokemon.pokemon.get(userChoice).getHP()<=0)
						{
							checkForWin();
						}
					else
						{
							if(CreatePokemon.pokemon.get(userChoice).getType()==CreatePokemon.pokemon.get(enemyChoice).getNemesis())
								{
									System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" now has "+CreatePokemon.pokemon.get(userChoice).getHP()+"HP.");
									System.out.println("It wasn't very effective...");
									System.out.println("");
								}
							else if(CreatePokemon.pokemon.get(userChoice).getNemesis()==CreatePokemon.pokemon.get(enemyChoice).getType())
								{
									System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" now has "+CreatePokemon.pokemon.get(userChoice).getHP()+"HP.");
									System.out.println("It was super effective!");
									System.out.println("");
								}
							else
								{
									System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" now has "+CreatePokemon.pokemon.get(userChoice ).getHP()+"HP.");
									System.out.println("");
								}
							
						}
					
					
				}
			if(enemyChoice==2)
				{
					if(CreatePokemon.pokemon.get(userChoice).getType()==CreatePokemon.pokemon.get(enemyChoice).getNemesis())
						{
							enemyAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(enemyChoice).getAttack()*CreatePokemon.charmanderMoves.get(randomMove).getPower()/CreatePokemon.pokemon.get(userChoice).getDeffense())/50)+2)*1*1*100/randomNumber;
							System.out.println("Charmander used "+CreatePokemon.charmanderMoves.get(randomMove).getName()+" and dealt "+enemyAttackDamage+" damage.");
							CreatePokemon.pokemon.get(userChoice).setHP(CreatePokemon.pokemon.get(userChoice).getHP()-enemyAttackDamage);

						}
					else if(CreatePokemon.pokemon.get(userChoice).getNemesis()==CreatePokemon.pokemon.get(enemyChoice).getType())
						{
							enemyAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(enemyChoice).getAttack()*CreatePokemon.charmanderMoves.get(randomMove).getPower()/CreatePokemon.pokemon.get(userChoice).getDeffense())/50)+2)*1*1*100/randomNumber;
							System.out.println("Charmander used "+CreatePokemon.charmanderMoves.get(randomMove).getName()+" and dealt "+enemyAttackDamage+" damage.");
							CreatePokemon.pokemon.get(userChoice).setHP(CreatePokemon.pokemon.get(userChoice).getHP()-enemyAttackDamage);
			
						}
					else
						{
							enemyAttackDamage=((((2*5/5+2)*CreatePokemon.pokemon.get(enemyChoice).getAttack()*CreatePokemon.charmanderMoves.get(randomMove).getPower()/CreatePokemon.pokemon.get(userChoice).getDeffense())/50)+2)*1*1*100/randomNumber;
							System.out.println("Charmander used "+CreatePokemon.charmanderMoves.get(randomMove).getName()+" and dealt "+enemyAttackDamage+" damage.");
							CreatePokemon.pokemon.get(userChoice).setHP(CreatePokemon.pokemon.get(userChoice).getHP()-enemyAttackDamage);
					
						}
					if(CreatePokemon.pokemon.get(userChoice).getHP()<=0)
						{
							checkForWin();
						}
					else
						{
							if(CreatePokemon.pokemon.get(userChoice).getType()==CreatePokemon.pokemon.get(enemyChoice).getNemesis())
								{
									System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" now has "+CreatePokemon.pokemon.get(userChoice).getHP()+"HP.");
									System.out.println("It wasn't very effective...");
									System.out.println("");
								}
							else if(CreatePokemon.pokemon.get(userChoice).getNemesis()==CreatePokemon.pokemon.get(enemyChoice).getType())
								{
									System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" now has "+CreatePokemon.pokemon.get(userChoice).getHP()+"HP.");
									System.out.println("It was super effective!");
									System.out.println("");
								}
							else
								{
									System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" now has "+CreatePokemon.pokemon.get(userChoice ).getHP()+"HP.");
									System.out.println("");
								}
							
						}
					
				}
				}
			return enemyAttackDamage;
		}
		public static void checkForWin()
		{
			if(CreatePokemon.pokemon.get(userChoice).getHP()<=0)
				{
					System.out.println(CreatePokemon.pokemon.get(userChoice).getName()+" fainted.");
					System.exit(0);
				}
			if(CreatePokemon.pokemon.get(enemyChoice).getHP()<=0)
				{
					System.out.println(CreatePokemon.pokemon.get(enemyChoice).getName()+" fainted.");
					System.exit(0);
				}
		}
	
	}
