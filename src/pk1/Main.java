package pk1;


import java.util.Scanner;

public class Main {

	/**
	 * Startpunkt i Spillet.
	 * tar inn spilerdata og inisialiserer spillet.
	 * starter spillet
	 * @author Birk Johannessen
	 */
	public static void main(String[] args) {
		String[] navnTab = new String[0];
		char[] brikkeTab = new char[0];
		int antSpillere = 0;
		int spillerNr = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Antall spillere som deltar (2-4): ");
		antSpillere = Integer.parseInt(sc.nextLine());
		navnTab = new String[antSpillere];
		brikkeTab = new char[antSpillere];
		for (int i = 0; i < antSpillere; i++) {
			spillerNr=i+1;
			System.out.println("Si navnet på spiller " + spillerNr + ": ");
			navnTab[i] = sc.nextLine();
			System.out.println("Gi navn på brikken på spiller (char) " + spillerNr + ": ");
			brikkeTab[i] = sc.nextLine().toCharArray()[0];
		}
		
		sc.close();
		


		StigeOgSlangeSpillet spill = new StigeOgSlangeSpillet(navnTab,brikkeTab);

		System.out.println("Starter Stige og Slangspillet!");
		spill.spill();
		System.out.print("\nGame over!");
	}
}
