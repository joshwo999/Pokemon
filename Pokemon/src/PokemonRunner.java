
public class PokemonRunner
	{

		public static void main(String[] args)
			{
				CreatePokemon.fillDeck();
				BattlePokemon.pickUserPokemon();
				BattlePokemon.pickEnemyPokemon();
				while(BattlePokemon.bothStillLive)
					{
								CreatePokemon.createMenu();
								BattlePokemon.calculateUserDamage();
								BattlePokemon.calculateEnemyDamage();
					}
				
			}

	}
