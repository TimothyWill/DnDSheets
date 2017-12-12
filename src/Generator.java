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
	
	private int generateHPWithCR(double cr, int conMod) {
		int crIndex = 0;
		int hitDice = 0;
		int totalHPDice = 0;
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
		hitDice = 2 * (rand.nextInt(5) + 2);
		totalHPDice = MonsterStats.CRHPMax[crIndex] / (hitDice + conMod);
		return generateHP(totalHPDice, hitDice, conMod);
	}
	
	//Returns Array of stats: {Proficiency Bonus, Armor Class, Hit Points, Attack Bonus, Damage/Round, Save DC}
	public double[] generateStatsWithCR(double cr, int conMod) {
		double[] stats = new double[5];
		
		stats[2] = generateHPWithCR(cr, conMod);
		return stats;
	}

}
