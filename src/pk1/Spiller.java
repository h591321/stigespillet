package pk1;

public class Spiller {
	
	private String navn;
	private int posisjon;
	private boolean laas;
	private char brikke;
	public Spiller(String navn, char brikke) {
		this.brikke=brikke;
		this.laas=false;
		this.navn=navn;
		this.posisjon=1;
	}
	public String getNavn() {
		return navn;
	}
	public boolean erLast() {
		return laas;
	}
	public void setLaas(boolean laas) {
		this.laas=laas;
	}
	public char getBrikke() {
		return brikke;
	}

	public int getPosisjon() {
		return posisjon;
	}
	public void setPosisjon(int posisjon) {
		this.posisjon = posisjon;
	}
	
	/**
	 *
	 * returnerer et tilfeldig heltall mellom 1-6 for å simulerer terningkast
	 * @AUTHOR Birk Johannessen
	 */
	public int trill() {
		int terning=(int)(6*Math.random()+1);
		System.out.println("Terning: "+terning);
		return terning;
	}
	
	/**
	 * 
	 * void metode som printer spillerinfo før spilleren kaster
	 * @AUTHOR Birk Johannessen
	 */
	public void printSpillerInfo() {
		System.out.println("\n"+navn + " starter..");
		System.out.println("posisjon på brettet: "+ getPosisjon());
		System.out.println("starter kast:");
	}
	
	/**
	 *
	 * void metode som printer spillerinfo etter  spillerens tur
	 * @AUTHOR Birk Johannessen
	 */
	public void printSpillerInfo2() {
		System.out.println(getNavn() + " er ferdig. \n" + getNavn() + "'s posisjon på brettet etter tur: " + getPosisjon());
		if(getPosisjon()==100) {
			System.out.println(getNavn() + " Vant Slange og StigeSpillet!");
		}
	}
}
