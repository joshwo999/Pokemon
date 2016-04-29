
		public class Moves
		{
			private String name;
			private int power;
			private int powerPoints;
			private String Type;
	public Moves(String n, int p, int pp, String t)
	{
		name=n;	
		power=p;
		powerPoints=pp;
		Type=t;
	}
	public String getType()
		{
			return Type;
		}
	public void setType(String type)
		{
			Type = type;
		}
	public String getName()
		{
			return name;
		}
	public void setName(String name)
		{
			this.name = name;
		}
	public int getPower()
		{
			return power;
		}
	public void setPower(int power)
		{
			this.power = power;
		}
	public int getPowerPoints()
		{
			return powerPoints;
		}
	public void setPowerPoints(int powerPoints)
		{
			this.powerPoints = powerPoints;
		}
		}
	
