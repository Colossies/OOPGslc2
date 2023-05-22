package gslc2;

import java.util.Random;

// Same as hero class but for the enemy (difference is the s1 s2 and s3 multipliers)

public class Enemy {
	Random rand = new Random();
	String name;
	double atk;
	double cc;
	double cd;
	int s1cd = 0;
	int s2cd = 0;
	int s3cd = 0;
	double hp;
	double def;
	double spd;
	double defMult;
	
	double s1mult;
	double s2mult;
	double s3mult;
	
	public Enemy(String name, double hp, double def, double atk, double cc, double cd, double spd, double s1mult,double s2mult, double s3mult) {
		this.name = name;
		this.atk = atk;
		this.cc = cc;
		this.cd = cd;
		this.hp = hp;
		this.def = def;
		this.spd = spd;
		this.s1mult = s1mult;
		this.s2mult = s2mult;
		this.s3mult = s3mult;
		
		defMult = 1 / ((def / 300) + 1);
	}
	
	public void takeDmg(double dmg) {
		double dmgTaken = dmg * defMult;
		this.hp -= dmgTaken;
		
		System.out.println(name + "took " + dmgTaken + " damage!");
	}
	
	public double s1() {
		int n = rand.nextInt(100);
		double dmg = atk;
		if(n >= cc) dmg = atk * cd;
		
		return 1.1 * dmg;
	}
	
	public double s2() {
		if(s2cd != 0) return 0;
		int n = rand.nextInt(100);
		double dmg = atk;
		if(n >= cc) dmg = atk * cd;
		s2cd += 2;
		return 1.4 * dmg;
	}
	
	public double s3() {
		if(s3cd != 0) return 0;
		int n = rand.nextInt(100);
		double dmg = atk;
		if(n >= cc) dmg = atk * cd;
		s3cd += 5;
		return 2.3 * dmg;
	}
	
	
	
	
}
