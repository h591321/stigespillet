package tester;
import org.junit.Assert;
import org.junit.Test;


import pk1.*;
public class LogikkTest {
	
		String brikker= "ABC";
		private char[] brikkeTab=brikker.toCharArray();
		private String[] navnTab= {"ALFA","BRAVO","CHARLIE"};
		private StigeOgSlangeSpillet spill = new StigeOgSlangeSpillet(navnTab, brikkeTab);

	    @Test
	    public void testSumRute() {
	    	int[] slangeOgStige = { 50, 25, 30, 27, 11, 80, 71, 59, 5, 98 };
	    	int[] slangeOgStigeSum = { -23, 7, -8, 40, -3, -5, 8, 30, 21, -50 };
	    	for(int rute:slangeOgStige) {
	        	Assert.assertNotSame(0, SlangerOgStiger.sumRute(rute)); 
	    	}
	    	int[] feilTab= {20,3,1,100};
	    	for (int rute:feilTab) {
	    		Assert.assertEquals(0, SlangerOgStiger.sumRute(rute));
	    	}
	    }

}
