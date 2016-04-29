
public class Items
	{
		private String Name;
		private int hpHealed;
		private int ppHealed;
		private int amount;
		
		public Items(String n, int hp, int pp, int a)
		{
			Name=n;
			hpHealed=hp;
			ppHealed=pp;
			amount=a;
		}

		public String getName()
			{
				return Name;
			}

		public void setName(String name)
			{
				Name = name;
			}

		public int getHpHealed()
			{
				return hpHealed;
			}

		public void setHpHealed(int hpHealed)
			{
				this.hpHealed = hpHealed;
			}

		public int getPpHealed()
			{
				return ppHealed;
			}

		public void setPpHealed(int ppHealed)
			{
				this.ppHealed = ppHealed;
			}

		public int getAmount()
			{
				return amount;
			}

		public void setAmount(int amount)
			{
				this.amount = amount;
			}
	}
