
public class Pokemon
	{
	String name;
	private double HP;
	private int Attack;
	private int Deffense;
	private int spAttack;
	private int spDeffense;
	private int Speed;
	private String Type;
	private String Nemesis;
	private Moves move1;
	private Moves move2;
	private Moves move3;
	private Moves move4;
	
	
	public Pokemon(String n, int hp, int a, int d, int spA, int spD, int s, String t, String nem, Moves m1, Moves m2, Moves m3, Moves m4)
{
	name=n;
	HP=hp;
	Attack=a;
	Deffense=d;
	spAttack=spA;
	spDeffense=spD;
	Speed=s;
	Type=t;
	Nemesis=nem;
	move1= m1;
	move2=m2;
	move3=m3;
	move4=m4;
}
public String getNemesis()
	{
		return Nemesis;
	}
public void setNemesis(String nemesis)
	{
		Nemesis = nemesis;
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
public double getHP()
	{
		return HP;
	}
public void setHP(double d)
	{
		HP = d;
	}
public int getAttack()
	{
		return Attack;
	}
public void setAttack(int attack)
	{
		Attack = attack;
	}
public int getDeffense()
	{
		return Deffense;
	}
public void setDeffense(int deffense)
	{
		Deffense = deffense;
	}
public int getSpAttack()
	{
		return spAttack;
	}
public void setSpAttack(int spAttack)
	{
		this.spAttack = spAttack;
	}
public int getSpDeffense()
	{
		return spDeffense;
	}
public void setSpDeffense(int spDeffense)
	{
		this.spDeffense = spDeffense;
	}
public int getSpeed()
	{
		return Speed;
	}
public void setSpeed(int speed)
	{
		Speed = speed;
	}
public Moves getMove1()
	{
		return move1;
	}
public void setMove1(Moves move1)
	{
		this.move1 = move1;
	}
public Moves getMove2()
	{
		return move2;
	}
public void setMove2(Moves move2)
	{
		this.move2 = move2;
	}
public Moves getMove3()
	{
		return move3;
	}
public void setMove3(Moves move3)
	{
		this.move3 = move3;
	}
public Moves getMove4()
	{
		return move4;
	}
public void setMove4(Moves move4)
	{
		this.move4 = move4;
	}


}
