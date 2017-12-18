import java.util.Random;

public class Generator {
	private Random rand = new Random();

	public Generator() {
	}

	public int[] generateAbilities(boolean ordered) {
		int[] abilites = new int[6];
		for (int s = 0; s < abilites.length; s++) {
			int dice[] = new int[4];
			for (int i = 0; i < 4; i++) {
				dice[i] = rand.nextInt(6) + 1;
			}
			int low = 6;
			for (int i = 0; i < 4; i++) {
				if (dice[i] < low) {
					low = dice[i];
				}
			}
			int total = 0;
			for (int i = 0; i < 4; i++) {
				total += dice[i];
			}
			abilites[s] = total - low;
		}
		if (ordered) {
			boolean swapped = true;
			int j = 0;
			int temp;
			while (swapped) {
				swapped = false;
				j++;
				for (int i = 0; i < 6 - j; i++) {
					if (abilites[i] > abilites[i + 1]) {
						temp = abilites[i];
						abilites[i] = abilites[i + 1];
						abilites[i + 1] = temp;
						swapped = true;
					}
				}
			}
		}
		return abilites;
	}

	public int generateHP(int totalDice, int hitDice, int conMod) {
		int hp = 0;
		for (int i = 0; i < totalDice; i++) {
			hp += (rand.nextInt(hitDice) + 1) + conMod;
		}
		return hp;
	}
	
	private int getCRIndex(double cr) {
		int crIndex = 0;
		if(cr < 1.0) {
			if(cr > 0.5) {
				crIndex = 4;
			}
			else if(cr > 0.25) {
				crIndex = 3;
			}
			else if(cr > 0.125) {
				crIndex = 2;
			} 
			else if(cr > 0) {
				crIndex = 1;
			}
		}
		else {
			crIndex = (int)cr + 3;
		}
		return crIndex;
	}
	
	private int getRandDie() {
		return 2 * (rand.nextInt(5) + 2);
	}
	
	private int getTotalHitDice(int crIndex, int hitDie, int conMod) {
		return MonsterStats.CRHPMax[crIndex] / (hitDie + conMod);
	}
	
	private int getAttackBonus(int profBonus, int dexMod, int strMod) {
		return profBonus + getDmgBonus(dexMod, strMod);
	}
	
	private int getDmgDice(int crIndex, int dmgDie, int dexMod, int strMod) {
		int dmgBonus = getDmgBonus(dexMod, strMod);
		return MonsterStats.CRDmgMax[crIndex] / (dmgDie + dmgBonus);
	}
	
	private int getDmgBonus(int dexMod, int strMod) {
		int mod = 0;
		if(dexMod > strMod) {
			mod  = dexMod;
		}
		else {
			mod = strMod;
		}
		return mod;
	}
	
	//Returns Array of stats: {Proficiency Bonus, Armor Class, Hit Die, Total Hit Dice, Hit Points, Attack Bonus, Damage Die, Total Damage Dice, Damage Bonus, Save DC}
	public int[] generateStatsWithCR(double cr, int dexMod, int strMod, int conMod) {
		int crIndex = getCRIndex(cr);
		int[] stats = new int[10];
		// Proficiency Bonus
		stats[0] = MonsterStats.CRProfB[crIndex];
		// Armor Class (AC)
		stats[1] = MonsterStats.CRACAvg[crIndex];
		// Hit Die
		stats[2] = getRandDie();
		// Total Hit Dice
		stats[3] = getTotalHitDice(crIndex, (int)stats[2], conMod);	
		// Hit Points (HP)
		stats[4] = generateHP((int)stats[3], (int)stats[2], conMod);
		// Attack Bonus
		stats[5] = getAttackBonus((int)stats[0], dexMod, strMod);
		// Damage Die
		stats[6] = getRandDie();
		// Total Damage Dice
		stats[7] = getDmgDice(crIndex, (int)stats[6], dexMod, strMod);
		// Damage Bonus
		stats[8] = getDmgBonus(dexMod, strMod);
		// Save DC
		stats[9] = MonsterStats.CRSaveDC[crIndex];
		
		return stats;
	}

}
