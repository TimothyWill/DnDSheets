
public class Test {
	public static void main(String[] args) {
		Generator gen = new Generator();
		int[] abilites = gen.generateAbilities(true);
		for(int i=0; i<abilites.length; i++){
			System.out.println(abilites[i]);
		}
//		System.out.println(gen.generateHP(5, 8, 2));
	}
}
