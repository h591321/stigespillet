package pk1;

public class SlangerOgStiger {

	static int[] slangeOgStige = { 50, 25, 30, 27, 11, 80, 71, 59, 5, 98 };
	static int[] slangeOgStigeSum = { -23, 7, -8, 40, -3, -5, 8, 30, 21, -50 };

	/**
	 * 
	 * Returnerer et positivt eller negativt heltall basert på hvis ruten har
	 * slangehode eller stige. Angitt returntall er verdien brikken skal flyttes
	 * frem eller tilbake Hvis ingen slange eller stige returner funksjonen 0
	 * @AUTHOR Birk Johannessen
	 */
	public static int sumRute(int rute) {
		for (int i = 0; i < slangeOgStige.length; i++) {
			if (slangeOgStige[i] == rute) {
				return slangeOgStigeSum[i];
			}
		}
		return 0;
	}
	/**
	 * finner ut om en rute er en slange, stige eller trygg.
	 * returnerer -,+ og tom string reprensativt
	 * @AUTHOR Birk Johannessen
	 * @return string
	 */
	public static String getSymbol(int rute) {
		for (int i = 0; i < slangeOgStige.length; i++) {
			if (slangeOgStige[i] == rute) {
				if(slangeOgStigeSum[i]<0) {
					return "-";
				}else {
					return "+";
				}
			}
		}
		return "";

	}
}
