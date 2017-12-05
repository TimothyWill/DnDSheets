public class MonsterStats {
	Generator gen = new Generator();
	private int[] abilities = new int[6];
	
	private int str, dex, con, intel, wis, cha;
	private int strM, dexM, conM, intelM, wisM, chaM;
	private int hp, ac, speed;
	private double cr;
	String savingThrows, skills, senses, vulnerabilities, immunites, resistances, condition, languages; 
	
	private int CRACAvg[] = {  13, 13, 13, 13, 13,  13,  13,  14,  15,  15,  15,  16,  16,  17,  17,  17,  18,  18,  18,  18,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19 };
	private int CRHPMin[] = {   1,  7, 36, 50, 71,  86, 101, 116, 131, 146, 161, 176, 191, 206, 221, 236, 251, 266, 281, 296, 311, 326, 341, 356, 401, 446, 491, 536, 581, 626, 671, 716, 761, 806 };
	private int CRHPMax[] = {   6, 35, 49, 70, 85, 100, 115, 130, 145, 160, 175, 190, 205, 220, 235, 250, 265, 280, 295, 310, 325, 340, 355, 400, 445, 490, 535, 580, 625, 670, 715, 760, 805, 850 };
	private int CRABAvg[] = {   3,  3,  3,  3,  3,   3,   4,   5,   6,   6,   6,   7,   7,   7,   8,   8,   8,   8,   8,   9,  10,  10,  10,  10,  11,  11,  11,  12,  12,  12,  13,  13,  13,  14 };
	private int CRDmgMin[] = {  0,  2,  4,  6,  9,  15,  21,  27,  33,  39,  45,  51,  57,  63,  69,  75,  81,  87,  93,  99, 105, 111, 117, 123, 141, 159, 177, 195, 213, 231, 249, 267, 285, 303 };
	private int CRDmgMax[] = {  1,  3,  5,  8, 14,  20,  26,  32,  38,  44,  50,  56,  62,  68,  74,  80,  86,  92,  98, 104, 110, 116, 122, 140, 158, 176, 194, 212, 230, 248, 266, 284, 302, 320 };
	private int CRSaveDC[] = { 13, 13, 13, 13, 13,  13,  13,  14,  15,  15,  15,  16,  16,  16,  17,  17,  18,  18,  18,  18,  19,  19,  19,  19,  20,  20,  20,  21,  21,  21,  22,  22,  22,  23 };
	
	public MonsterStats() { }
	
	public void generateAbilities() {
		abilities = gen.generateAbilities(false);
		this.setStr(abilities[0]);
		this.setDex(abilities[1]);
		this.setCon(abilities[2]);
		this.setIntel(abilities[3]);
		this.setWis(abilities[4]);
		this.setCha(abilities[5]);
//		this.setHp(gen.generateHP(totalDice, hitDice, conMod));
		this.setAc(10 + this.getDexM());
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
		this.setStrM((str-10)/2);
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
		this.setDexM((dex-10)/2);
	}

	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
		this.setConM((con-10)/2);
	}

	public int getIntel() {
		return intel;
	}

	public void setIntel(int intel) {
		this.intel = intel;
		this.setIntelM((intel-10)/2);
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
		this.setWisM((wis-10)/2);
	}

	public int getCha() {
		return cha;
	}

	public void setCha(int cha) {
		this.cha = cha;
		this.setChaM((cha-10)/2);
	}

	public int getStrM() {
		return strM;
	}

	private void setStrM(int strM) {
		this.strM = strM;
	}

	public int getDexM() {
		return dexM;
	}

	private void setDexM(int dexM) {
		this.dexM = dexM;
	}

	public int getConM() {
		return conM;
	}

	private void setConM(int conM) {
		this.conM = conM;
	}

	public int getIntelM() {
		return intelM;
	}

	private void setIntelM(int intelM) {
		this.intelM = intelM;
	}

	public int getWisM() {
		return wisM;
	}

	private void setWisM(int wisM) {
		this.wisM = wisM;
	}

	public int getChaM() {
		return chaM;
	}

	private void setChaM(int chaM) {
		this.chaM = chaM;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
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
		if(damagePerRound > CRDmgMax[CRDmgMax.length - 1]) {
			return -1.0;
		}
		else {
			for(int i = 0; i < CRDmgMin.length; i++) {
				if(damagePerRound >= CRDmgMin[i] && damagePerRound <= CRDmgMax[i]) {
					offCR = i;
				}
			}
			if((attackBonus / CRABAvg[(int)offCR]) > (saveDC / CRSaveDC[(int)offCR])) {
				offCR -= (CRABAvg[(int)offCR] - attackBonus) / 2;
			}
			else {
				offCR -= (CRSaveDC[(int)offCR] - saveDC) / 2;
			}
			if(offCR <= 0) {
				offCR = 0.0;
			}
			else if(offCR <= 3) {
				offCR = (1.0 / (Math.pow(2, 4 - offCR)));
			}
			else if(offCR >= 31.0) {
				offCR = -1.0;
			}
			else {
				offCR -= 3.0;
			}
		}
		
		return offCR;
	}
	
	public double calculateCR(int armorClass, int hitPoints, int attackBonus, int damagePerRound, int saveDC) {
		double defCR = calculateDefensiveCR(armorClass, hitPoints);
		double offCR = calculateOffensiveCR(attackBonus, damagePerRound, saveDC);
		return (int)Math.ceil((defCR + offCR) / 2.0);
	}
}
