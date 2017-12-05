import java.util.Random;

public class Generator {
	private Random rand = new Random();
	
	private int CRHPMin[] = {  1,  7, 36, 50, 71,  86, 101, 116, 131, 146, 161, 176, 191, 206, 221, 236, 251, 266, 281, 296, 311, 326, 341, 356, 401, 446, 491, 536, 581, 626, 671, 716, 761, 806 };
	private int CRHPMax[] = {  6, 35, 49, 70, 85, 100, 115, 130, 145, 160, 175, 190, 205, 220, 235, 250, 265, 280, 295, 310, 325, 340, 355, 400, 445, 490, 535, 580, 625, 670, 715, 760, 805, 850 };
	private int CRACAvg[] = { 13, 13, 13, 13, 13,  13,  13,  14,  15,  15,  15,  16,  16,  17,  17,  17,  18,  18,  18,  18,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19 };
	
	public Generator(){ }
	
	public int[] generateAbilities(boolean ordered){
		int[] abilites = new int[6];
		for(int s=0; s<abilites.length; s++){
			int dice[] = new int[4];
			for(int i=0; i<4; i++){
				dice[i] = rand.nextInt(6)+1;
			}
			int low = 6;
			for(int i = 0; i<4; i++){
				if(dice[i] < low){
					low = dice[i];
				}
			}
			int total = 0;
			for(int i=0; i<4; i++){
				total += dice[i];
			}
			abilites[s] = total - low;
		}
		if(ordered){
			boolean swapped = true;
		    int j = 0;
		    int temp;
		    while(swapped){
		        swapped = false;
		        j++;
		        for(int i=0; i<6-j; i++){
		            if(abilites[i] > abilites[i+1]){
		                temp = abilites[i];
		                abilites[i] = abilites[i+1];
		                abilites[i+1] = temp;
		                swapped = true;
		            }
		        }
		    }
		}
		return abilites;
	}
	
	public int generateHP(int totalDice, int hitDice, int conMod){
		int hp = 0;
		for(int i=0; i<totalDice; i++){
			hp += (rand.nextInt(hitDice)+1) + conMod; 
		}
		return hp;
	}
	
	//Comment
	private double calculateDefensiveCR(int armorClass, int hitPoints) {
		if(hitPoints > CRHPMax[CRHPMax.length - 1]) {
			return -1.0;
		}
		else {
			double defCR = 0;
			for(int i = 0; i < CRHPMin.length; i++) {
				if(hitPoints >= CRHPMin[i] && hitPoints <= CRHPMax[i]) {
					defCR = i;
				}
			}
			defCR -= (CRACAvg[(int)defCR] - armorClass) / 2;
			
			if(defCR <= 0) {
				defCR = 0.0;
			}
			else if(defCR <= 3) {
				defCR = (1.0 / (Math.pow(2, 4 - defCR)));
			}
			else if(defCR >= 31.0) {
				defCR = -1.0;
			}
			else {
				defCR -= 3.0;
			}
			return defCR;
		}
	}
	
	private double calculateOffensiveCR(int attackBonus, int damagePerRound, int saveDC) {
		double offCR = 0;
		//TODO: Calculate offensive CR
		return offCR;
	}
	
	public double calculateCR(int armorClass, int hitPoints, int attackBonus, int damagePerRound, int saveDC) {
		double defCR = calculateDefensiveCR(armorClass, hitPoints);
		double offCR = calculateOffensiveCR(attackBonus, damagePerRound, saveDC);
		return (int)Math.ceil((defCR + offCR) / 2.0);
	}
	
}
