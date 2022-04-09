package pk1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class StigeOgSlangeSpillet {

	private int antSpillere;
	private Spiller[] spillere;
	private Brett brett;
	
	public StigeOgSlangeSpillet(String[] navnTab, char[] brikkeTab) {
		this.antSpillere=navnTab.length;
		this.brett=new Brett();
		
		this.spillere = new Spiller[antSpillere];
		
		for (int i = 0; i < antSpillere; i++) {
			Spiller spiller = new Spiller(navnTab[i], brikkeTab[i]);
			this.spillere[i] = spiller;
		}
	}



	/**
	 *  starter et spill og iterer mellom spillerne til en spiller har vunnet
	 *  @AUTHOR Birk Johannessen
	 */
	public void spill() {
		boolean gameFerdig = false;
		int trekk=0;
		while(!gameFerdig) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Spiller aktivSpiller=spillere[trekk%antSpillere];	
			aktivSpiller.printSpillerInfo();
			gameFerdig = nesteSpiller(aktivSpiller);
			aktivSpiller.printSpillerInfo2();
			brett.visBrett(spillere);

			trekk++;
		}
	}
	/**
	 * 
	 * Returnerer true hvis en spiller har nådd rute 100
	 * gjør et terningkast for en spiller og flytter brikken i henhold til terningkastet,
	 * stiger, slanger, lås og unntakhåndtering
	 * @AUTHOR Birk Johannessen
	 */
	public boolean nesteSpiller(Spiller spiller) {
		int terning=0;
		int rute=spiller.getPosisjon();
		
		if(!spiller.erLast()) {
			int iterator=0;
			do {
				
				terning=spiller.trill();
				
				if(iterator==2&&terning==6) {
					System.out.println("åååå den var kjip, stikk tilbake! btw du er nå låst");
					spiller.setPosisjon(1);
					spiller.setLaas(true);
					break;
				}
				
				rute+=terning;				
				rute+=SlangerOgStiger.sumRute(rute);
				spiller.setPosisjon(rute);

				if(rute==100) {return true;}
				if(rute>100) {rute-=terning;}
				
				spiller.setPosisjon(rute);
				
				iterator++;
			}while(terning==6);

		}else {
			terning=spiller.trill();
			if(terning==6){
				spiller.setLaas(false);
				nesteSpiller(spiller);
			}
		}
		return false;
	}
	
	
	
	/**
	 * 
	 * sorterer spillertabellen i rekkefølgen av hvem som starer(høyest terningkast) til den siste (lavest terningkast).
	 * TODO: INCOMPLETE METHOD, DO NOT USE!
	 * @AUTHOR Birk Johannessen
	 */
	protected void setRekkefolge() {
		Map<Integer, Spiller> unsortMap = new HashMap<>();
		
		for(int i=0;i<antSpillere;i++) {
			unsortMap.put(spillere[i].trill(), spillere[i]);
		}

        Map<Integer, Spiller> treeMap = new TreeMap<>(
				(Comparator<Integer>) (o1, o2) -> o2.compareTo(o1));

        treeMap.putAll(unsortMap);
          
		for(int i=0;i<antSpillere;i++) {
			spillere[i]=(Spiller) treeMap.values().toArray()[i];
		}


	}
}
