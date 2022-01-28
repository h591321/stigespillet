package pk1;

import java.util.ArrayList;
import java.util.Collections;

public class Brett {
	public Brett() {
	}

	/**
	 * 
	 * Viser brettet grafisk i konsollen
	 * @AUTHOR Birk Johannessen
	 */
	public void visBrett(Spiller[] spillere) {
		for(int rad=10;rad>0;rad--){
			visRekke(spillere, rad);
		}
	}
	/**
	 * hjelpe metode for å vise brettet grafisk
	 * 
	 * snur listen annen hver gang for å oppnå en S formasjon
	 * @AUTHOR Birk Johannessen
	 */
	private void visRekke(Spiller[] spillere, int rad) {
		ArrayList<String> rekke=new ArrayList<String>();
		for(int j=0; j<10; j++) {
			int rute=rad*10-j;
			rekke.add(getRute(spillere, rute));
		}
		if(rad%2!=0) {
			Collections.reverse(rekke);
			printRekke(rekke);
		}else {
			printRekke(rekke);
		}
		System.out.println();
	}
	private void printRekke(ArrayList<String> rekke) {
		for(String rute:rekke) {
			System.out.print(rute);
		}
	}
	/**
	 * 
	 * @author Birk Johannessen
	 */
	private String getRute(Spiller[] spillere, int rute) {
		String brikker="";
		for(Spiller spiller:spillere) {
			if(spiller.getPosisjon()==rute) {
				brikker+=spiller.getBrikke();
			}
		}
		String rekke="[";
		rekke+=String.format("%5s", SlangerOgStiger.getSymbol(rute)+rute+":");
		rekke+=String.format("%5s", brikker);
		return rekke+"] ";
	}
}
