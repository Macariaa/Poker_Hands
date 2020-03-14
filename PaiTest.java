import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaiTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testLessthan() {
		String B = "2H 3D 5S 9C KD"; 
		String W = "2C 3H 4S 8C AH";
		char[] Black = B.toCharArray(); 
		char[] White = W.toCharArray();
		KaPai[] cardsBlack=new KaPai[5];
		KaPai[] cardsWhite=new KaPai[5];
		String CardValues= "23456789TJQKA";
		int i;
	    for(i=0;i<5;i++) {
	    	cardsBlack[i]=new KaPai(Black[i*3],0,Black[i*3+1]);
	    	cardsBlack[i].value=CardValues.indexOf(cardsBlack[i].name);
	    	cardsWhite[i]=new KaPai(White[i*3],0,White[i*3+1]);
	    	cardsWhite[i].value=CardValues.indexOf(cardsWhite[i].name);
	    }
		assertEquals(0, Pai.lessthan(cardsBlack[1],cardsWhite[1]));
	}

	@Test
	public void testDiffence() {
		String B = "2H 3D 5S 9C KD"; 
		String W = "2C 3H 4S 8C AH";
		char[] Black = B.toCharArray(); 
		char[] White = W.toCharArray();
		KaPai[] cardsBlack=new KaPai[5];
		KaPai[] cardsWhite=new KaPai[5];
		String CardValues= "23456789TJQKA";
		int i;
	    for(i=0;i<5;i++) {
	    	cardsBlack[i]=new KaPai(Black[i*3],0,Black[i*3+1]);
	    	cardsBlack[i].value=CardValues.indexOf(cardsBlack[i].name);
	    	cardsWhite[i]=new KaPai(White[i*3],0,White[i*3+1]);
	    	cardsWhite[i].value=CardValues.indexOf(cardsWhite[i].name);
	    }
		assertEquals(1, Pai.diffence(cardsBlack[3],cardsWhite[3]));
	}

	@Test
	public void testExchange() {
		String B = "2H 3D 5S 9C KD"; 
		char[] Black = B.toCharArray(); 
		KaPai[] cardsBlack=new KaPai[5];
		String CardValues= "23456789TJQKA";
		int i;
	    for(i=0;i<5;i++) {
	    	cardsBlack[i]=new KaPai(Black[i*3],0,Black[i*3+1]);
	    	cardsBlack[i].value=CardValues.indexOf(cardsBlack[i].name);
	    }
	    Pai.exchange(cardsBlack, 3, 4);
		assertEquals(7,cardsBlack[4].value );
	}
	
	@Test
	public void testIsBomb() {
		String B = "2H 3D 5S 9C KD"; 
		char[] Black = B.toCharArray(); 
		KaPai[] cardsBlack=new KaPai[5];
		String CardValues= "23456789TJQKA";
		int i;
	    for(i=0;i<5;i++) {
	    	cardsBlack[i]=new KaPai(Black[i*3],0,Black[i*3+1]);
	    	cardsBlack[i].value=CardValues.indexOf(cardsBlack[i].name);
	    }
	    assertEquals(0,Pai.IsBomb(cardsBlack, 0));
	}

	@Test
	public void testIsThree() {
		String B = "2H 2D 2S 9C KD"; 
		char[] Black = B.toCharArray(); 
		KaPai[] cardsBlack=new KaPai[5];
		String CardValues= "23456789TJQKA";
		int i;
	    for(i=0;i<5;i++) {
	    	cardsBlack[i]=new KaPai(Black[i*3],0,Black[i*3+1]);
	    	cardsBlack[i].value=CardValues.indexOf(cardsBlack[i].name);
	    }
	    assertEquals(1,Pai.IsThree(cardsBlack, 0));
	}

	@Test
	public void testIsPair() {
		String B = "2H 2D 7S 9C KD"; 
		char[] Black = B.toCharArray(); 
		KaPai[] cardsBlack=new KaPai[5];
		String CardValues= "23456789TJQKA";
		int i;
	    for(i=0;i<5;i++) {
	    	cardsBlack[i]=new KaPai(Black[i*3],0,Black[i*3+1]);
	    	cardsBlack[i].value=CardValues.indexOf(cardsBlack[i].name);
	    }
	    assertEquals(1,Pai.IsPair(cardsBlack, 0));
	}

	@Test
	public void testIsStraight() {
		String B = "2H 3D 7S 9C KD"; 
		char[] Black = B.toCharArray(); 
		KaPai[] cardsBlack=new KaPai[5];
		String CardValues= "23456789TJQKA";
		int i;
	    for(i=0;i<5;i++) {
	    	cardsBlack[i]=new KaPai(Black[i*3],0,Black[i*3+1]);
	    	cardsBlack[i].value=CardValues.indexOf(cardsBlack[i].name);
	    }
	    assertEquals(0,Pai.IsStraight(cardsBlack));
	}

	@Test
	public void testIsFlush() {
		String B = "2H 3H 7H 9H KH"; 
		char[] Black = B.toCharArray(); 
		KaPai[] cardsBlack=new KaPai[5];
		String CardValues= "23456789TJQKA";
		int i;
	    for(i=0;i<5;i++) {
	    	cardsBlack[i]=new KaPai(Black[i*3],0,Black[i*3+1]);
	    	cardsBlack[i].value=CardValues.indexOf(cardsBlack[i].name);
	    }
	    assertEquals(1,Pai.IsFlush(cardsBlack));
	}

	@Test
	public void testGetLevel() {
		String B = "2H 3H 4H 5H 6H"; 
		char[] Black = B.toCharArray(); 
		KaPai[] cardsBlack=new KaPai[5];
		int[] orderBlack=new int[5];
		String CardValues= "23456789TJQKA";
		int i;
	    for(i=0;i<5;i++) {
	    	cardsBlack[i]=new KaPai(Black[i*3],0,Black[i*3+1]);
	    	cardsBlack[i].value=CardValues.indexOf(cardsBlack[i].name);
	    }
	    assertEquals(9,Pai.GetLevel(cardsBlack,orderBlack));
	}

	@Test
	public void testMain() {
		
	}

}
