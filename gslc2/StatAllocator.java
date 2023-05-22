package gslc2;

import java.util.Random;
// Used to allocate stats
public class StatAllocator {
	
//	Baseline for stats
//	Currently speed has no use
	int totalStats = 20000;
	double hpMod = 10;
	double defMod = 0.5;
	double atkMod = 1;
	double ccMod = 0.005;
	double cdMod = 0.00015;
	double spdMod = 0.016;
	double totalMod = hpMod + defMod + atkMod + ccMod + cdMod + spdMod;
//	hp, def, atk, cc, cd, spd
	double[] statArray = {0, 0, 0, 0, 0, 0};
	
	StatAllocator(){
		
	}
//	Allocate Stats semi-manually
	public double[] allocateStats(int hpAlloc, int defAlloc, int atkAlloc, int ccAlloc, int cdAlloc, int spdAlloc){
		int totalAlloc = hpAlloc + defAlloc + atkAlloc + ccAlloc + cdAlloc;
		statArray[0] = totalStats * hpAlloc * hpMod / totalAlloc / totalMod;
		statArray[1] = totalStats * defAlloc * defMod / totalAlloc / totalMod;
		statArray[2] = totalStats * atkAlloc * atkMod / totalAlloc / totalMod;
		statArray[3] = totalStats * ccAlloc * ccMod / totalAlloc / totalMod;
		statArray[4] = totalStats * cdAlloc * cdMod / totalAlloc / totalMod;
		statArray[5] = totalStats * spdAlloc * spdMod / totalAlloc / totalMod;
		
		return statArray;
	}
	Random rand = new Random();
	
//	Randomly allocate stats
	public double[] randStats() {
		int hpAlloc = rand.nextInt(100);
		int defAlloc = rand.nextInt(100);
		int atkAlloc = rand.nextInt(100);
		int ccAlloc = rand.nextInt(100);
		int cdAlloc = rand.nextInt(100);
		int spdAlloc = rand.nextInt(100);
		
		int totalAlloc = hpAlloc + defAlloc + atkAlloc + ccAlloc + cdAlloc;
		statArray[0] = totalStats * hpAlloc * hpMod / totalAlloc;
		statArray[1] = totalStats * defAlloc * defMod / totalAlloc;
		statArray[2] = totalStats * atkAlloc * atkMod / totalAlloc;
		statArray[3] = totalStats * ccAlloc * ccMod / totalAlloc;
		statArray[4] = totalStats * cdAlloc * cdMod / totalAlloc;
		statArray[5] = totalStats * spdAlloc * spdMod / totalAlloc;
		
		return statArray;
	}
	
	public void changeTotalStats(int totalStats) {
		this.totalStats = totalStats;
	}
	
}
