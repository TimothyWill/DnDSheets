public class MonsterStats {
	Generator gen = new Generator();
	private int[] abilities = new int[6];
	
	private int str, dex, con, intel, wis, cha;
	private int strM, dexM, conM, intelM, wisM, chaM;
	private int hp, ac, speed;
	String savingThrows, skills, senses, vulnerabilities, immunites, resistances, condition, languages; 
	
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
}
