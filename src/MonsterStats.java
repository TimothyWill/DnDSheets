import java.util.Random;

public class MonsterStats {
	private Generator gen = new Generator();
	private DataReader data = new DataReader();
	private Random rand = new Random();
	
	private int[] abilities = new int[6];
	
	private int str, dex, con, intel, wis, cha;
	private int strM, dexM, conM, intelM, wisM, chaM;
	private int hp, ac, speed;
	private int proficiency;
	private double cr;
	private String name, size, alignment, type, savingThrows, skills, senses, vulnerabilities, immunites, resistances, condition, languages; 
	
	public static int CRACAvg[] = {  13, 13, 13, 13, 13,  13,  13,  14,  15,  15,  15,  16,  16,  17,  17,  17,  18,  18,  18,  18,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19,  19 };
	public static int CRHPMin[] = {   1,  7, 36, 50, 71,  86, 101, 116, 131, 146, 161, 176, 191, 206, 221, 236, 251, 266, 281, 296, 311, 326, 341, 356, 401, 446, 491, 536, 581, 626, 671, 716, 761, 806 };
	public static int CRHPMax[] = {   6, 35, 49, 70, 85, 100, 115, 130, 145, 160, 175, 190, 205, 220, 235, 250, 265, 280, 295, 310, 325, 340, 355, 400, 445, 490, 535, 580, 625, 670, 715, 760, 805, 850 };
	public static int CRABAvg[] = {   3,  3,  3,  3,  3,   3,   4,   5,   6,   6,   6,   7,   7,   7,   8,   8,   8,   8,   8,   9,  10,  10,  10,  10,  11,  11,  11,  12,  12,  12,  13,  13,  13,  14 };
	public static int CRDmgMin[] = {  0,  2,  4,  6,  9,  15,  21,  27,  33,  39,  45,  51,  57,  63,  69,  75,  81,  87,  93,  99, 105, 111, 117, 123, 141, 159, 177, 195, 213, 231, 249, 267, 285, 303 };
	public static int CRDmgMax[] = {  1,  3,  5,  8, 14,  20,  26,  32,  38,  44,  50,  56,  62,  68,  74,  80,  86,  92,  98, 104, 110, 116, 122, 140, 158, 176, 194, 212, 230, 248, 266, 284, 302, 320 };
	public static int CRSaveDC[] = { 13, 13, 13, 13, 13,  13,  13,  14,  15,  15,  15,  16,  16,  16,  17,  17,  18,  18,  18,  18,  19,  19,  19,  19,  20,  20,  20,  21,  21,  21,  22,  22,  22,  23 };
	
	public MonsterStats() { }
	
	public void generate(){
		this.generateAbilities();
		this.generateStatistics();
	}
	
	private void generateAbilities() {
		abilities = gen.generateAbilities(false);
		this.setStr(abilities[0]);
		this.setDex(abilities[1]);
		this.setCon(abilities[2]);
		this.setIntel(abilities[3]);
		this.setWis(abilities[4]);
		this.setCha(abilities[5]);
		this.setAc(10 + this.getDexM());
		this.setSpeed(30);
		this.setProficiency(2);
	}
	
	private void generateStatistics(){
		String nameGen = "";
		int adNum = rand.nextInt(3);
		if(adNum > 0){
			nameGen += data.getAdjectives(adNum);
		}
		nameGen += " " + data.getName();
		this.setName(nameGen);
		
		String[] sizes = {"Tiny", "Small", "Medium", "Large", "Huge", "Gargantuan"};
		this.setSize(sizes[rand.nextInt(sizes.length)]);
		
		this.setAlignment(data.getAlignment());
		
		this.setType(data.getMonsterType());
		
		
		String savingThrowsGen = "";
		int savingThrowsNum = rand.nextInt(10)+1;
		if(savingThrowsNum > 4){
			savingThrowsNum = 0;
		}
		int[] savingThrowsCheck = {0, 0, 0, 0, 0, 0};
		for(int i=0; i<savingThrowsNum; i++){
			int newSavingThrow;
			do{
				newSavingThrow = rand.nextInt(6);
			}while(savingThrowsCheck[newSavingThrow] == 1);
			savingThrowsCheck[newSavingThrow] = 1;
		}
		for(int i=0; i<savingThrowsCheck.length; i++){
			String currentName = "";
			int currentMod = 0;
			if(savingThrowsCheck[i] == 1){
				switch(i){
				case 0:
					currentName = "Str";
					currentMod = this.getStrM();
					break;
				case 1:
					currentName = "Dex";
					currentMod = this.getDexM();
					break;
				case 2:
					currentName = "Int";
					currentMod = this.getIntelM();
					break;
				case 3:
					currentName = "Con";
					currentMod = this.getConM();
					break;
				case 4:
					currentName = "Wis";
					currentMod = this.getWisM();
					break;
				case 5:
					currentName = "Cha";
					currentMod = this.getChaM();
					break;
				}
				currentMod += this.getProficiency();
				if(currentMod >= 0){
					currentName += " +" + currentMod;
				}
				else{
					currentName += " -" + currentMod;
				}
				savingThrowsGen += ", " + currentName;
			}
		}
		if(savingThrowsNum == 0){
			this.setSavingThrows("");
		}
		else{
			this.setSavingThrows(savingThrowsGen.substring(2, savingThrowsGen.length()));
		}
		
		
		String skillsGen = "";
		int[] skillsNumList = {0, 0, 0, 1, 1, 2, 2, 3, 4, 5};
		int skillsNum = rand.nextInt(10);
		String[] skillsArray = data.getSkill(skillsNumList[skillsNum]);
		for(int i=0; i<skillsArray.length; i++){
			String mod = skillsArray[i].substring(skillsArray[i].length()-3, skillsArray[i].length());
			int modNum = 0;
			switch(mod){
			case "STR":
				modNum = this.getStrM();
				break;
			case "DES":
				modNum = this.getDexM();
				break;
			case "CON":
				modNum = this.getConM();
				break;
			case "INT":
				modNum = this.getIntelM();
				break;
			case "WIS":
				modNum = this.getWisM();
				break;
			case "CHA":
				modNum = this.getChaM();
				break;
			}
			skillsGen += ", " + skillsArray[i].substring(0, skillsArray[i].length()-3) + " +" + (this.getProficiency()+modNum);
		}
		if(skillsNumList[skillsNum] != 0){
			skillsGen = skillsGen.substring(2, skillsGen.length());
		}
		this.setSkills(skillsGen);
		
		
		String sensesGen = "";
		int sensesNum = rand.nextInt(3)+1;
		String[] distances = {"10ft", "30ft", "60ft", "120ft"};
		String[] sensesArray = data.getSense(sensesNum);
		for(int i=0; i<sensesArray.length; i++){
			if(sensesArray[i].substring(sensesArray[i].length()-1, sensesArray[i].length()).equals("*")){
				sensesGen += ", " + sensesArray[i].substring(0, sensesArray[i].length()-1) + " +" + (10+this.getWisM());
			}
			else{
				sensesGen += ", " + sensesArray[i] + " " + distances[rand.nextInt(distances.length)];
			}
		}
		this.setSenses(sensesGen.substring(2, sensesGen.length()));
		
		
		int[] damageNum = new int[3];
		for(int i=0; i<damageNum.length; i++){
			damageNum[i] = rand.nextInt(10)+1;
			if(damageNum[i] > 3){
				damageNum[i] = 0;
			}
		}
		String[][] damages = data.getDamage(damageNum);
		String[] finDamages = {"", "", ""};
		for(int i=0; i<finDamages.length; i++){
			for(int j=0; j<damages[i].length; j++){
				finDamages[i] += ", " + damages[i][j];
			}
			if(damageNum[i] != 0){
				finDamages[i] = finDamages[i].substring(2, finDamages[i].length());
			}
		}
		this.setVulnerabilities(finDamages[0]);
		this.setResistances(finDamages[1]);
		this.setImmunites(finDamages[2]);
		
		
		String conditionGen = "";
		int conditionNum = rand.nextInt(10)+1;
		if(conditionNum > 4){
			conditionNum = 0;
		}
		if(conditionNum > 0){
			String[] conditionArray = data.getConditionalImmunity(conditionNum);
			for(int i=0; i<conditionArray.length; i++){
				conditionGen += ", " + conditionArray[i];
			}
			conditionGen = conditionGen.substring(2, conditionGen.length());
		}
		this.setCondition(conditionGen);
		
		
		String languageGen = "";
		int languageNum = rand.nextInt(5)+1;
		String[] languageArray = data.getLanguage(languageNum);
		for(int i=0; i<languageArray.length; i++){
			languageGen += ", " + languageArray[i];
		}
		languageGen = languageGen.substring(2, languageGen.length());
		this.setLanguages(languageGen);
	}

	private int getProficiency() {
		return proficiency;
	}

	private void setProficiency(int proficiency) {
		this.proficiency = proficiency;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSavingThrows() {
		return savingThrows;
	}

	public void setSavingThrows(String savingThrows) {
		this.savingThrows = savingThrows;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getSenses() {
		return senses;
	}

	public void setSenses(String senses) {
		this.senses = senses;
	}

	public String getVulnerabilities() {
		return vulnerabilities;
	}

	public void setVulnerabilities(String vulnerabilities) {
		this.vulnerabilities = vulnerabilities;
	}

	public String getImmunites() {
		return immunites;
	}

	public void setImmunites(String immunites) {
		this.immunites = immunites;
	}

	public String getResistances() {
		return resistances;
	}

	public void setResistances(String resistances) {
		this.resistances = resistances;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
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
		double avgCR;
		if(defCR < 0 || offCR < 0) {
			avgCR = -1;
		}
		else {
			avgCR = (int)Math.ceil((defCR + offCR) / 2.0);
			if(avgCR < 0.125) {
				avgCR = 0;
			}
			else if(avgCR < 0.25) {
				avgCR = 0.125;
			}
			else if(avgCR < 0.5) {
				avgCR = 0.25;
			}
			else if(avgCR < 1) {
				avgCR = 0.5;
			}
		}
		return avgCR;
	}
}
