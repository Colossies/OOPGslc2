package gslc2;

import java.util.*;

public class Main {
	int playerGold = 0;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		StatAllocator sa = new StatAllocator();
		Random rand = new Random();
		
		Hero player;
		Enemy enemy;
		
		System.out.println("Player Character Creation");
		System.out.println("=========================");
		System.out.println("0: allocate manually");
		System.out.println("else: allocate randomly");
		System.out.println("Note: manual allocation is just the proportion of stats allocated");
		
		int selection = sc.nextInt();
		sc.nextLine();
		
		if(selection == 0) {
			System.out.println("Input name:");
			String name = sc.next();
			System.out.println("Input allocation (hp > def > atk > cc > cd > spd");
			int hpAlloc = sc.nextInt();
			int defAlloc = sc.nextInt();
			int atkAlloc = sc.nextInt();
			int ccAlloc = sc.nextInt();
			int cdAlloc = sc.nextInt();
			int spdAlloc = sc.nextInt();
			
		
			double[] statArray = sa.allocateStats(hpAlloc, defAlloc, atkAlloc, ccAlloc, cdAlloc, spdAlloc);
			
			System.out.println("hp:" + statArray[0]);
			System.out.println(statArray[1]);
			System.out.println(statArray[2]);
			System.out.println(statArray[3]);
			System.out.println(statArray[4]);
			System.out.println(statArray[5]);
			
			player = new Hero(name, statArray[0], statArray[1], statArray[2], statArray[3], statArray[4], statArray[5]);
		}
		else {
			System.out.println("Input name:");
			String name = sc.next();
			
			double[] statArray = sa.randStats();
			
			System.out.println("hp:" + statArray[0]);
			System.out.println(statArray[1]);
			System.out.println(statArray[2]);
			System.out.println(statArray[3]);
			System.out.println(statArray[4]);
			System.out.println(statArray[5]);
			
			player = new Hero(name, statArray[0], statArray[1], statArray[2], statArray[3], statArray[4], statArray[5]);
		}
		
		double[] eStatArray = sa.randStats();
		double eS1Mult = rand.nextDouble() + 1;
		double eS2Mult = rand.nextDouble() + 1.5;
		double eS3Mult = rand.nextDouble() + 2;
		enemy = new Enemy("drunkard", eStatArray[0], eStatArray[1], eStatArray[2], eStatArray[3], eStatArray[4], eStatArray[5], eS1Mult, eS2Mult, eS3Mult);
		
		while(true) {
			if(player.hp <= 0) {
				LoseComent a = new LoseComent(0);
				break;
			}
			
			
//			System.out.println("Your Turn!");
//			System.out.println("hp: " + player.hp);
//			System.out.println("s2 cd: " + player.s1cd);
//			System.out.println("s3 cd: " + player.s2cd);
//			System.out.println("Use which skill? [1, 2, 3]");
			selection = sc.nextInt();
			double dmgDealt;
			switch(selection) {
				case 1: dmgDealt = player.s1(); break;
				case 2: dmgDealt = player.s2(); break;
				case 3: dmgDealt = player.s3(); break;
				default: dmgDealt = player.s1(); break;
			}
			
			enemy.takeDmg(dmgDealt);
			if(enemy.hp <= 0) {
				victoryComment a = new victoryComment(100);
				break;
			}
			
			selection = rand.nextInt(3);
			switch(selection) {
				case 1: dmgDealt = enemy.s1(); break;
				case 2: dmgDealt = enemy.s2(); break;
				case 3: dmgDealt = enemy.s3(); break;
				default: dmgDealt = enemy.s1(); break;
			}
			
			player.takeDmg(dmgDealt);
		}
	}

}
