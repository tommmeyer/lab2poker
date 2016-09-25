package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HandTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void TestRoyalFlush() {
		Card cardOne = new Card(11,0,1);
		Card cardTwo = new Card(10,0,2);
		Card cardThree = new Card(9,0,3);
		Card cardFour = new Card(8,0,4);
		Card cardFive = new Card(12,0,5);
		Hand royalFlush = new Hand();
		royalFlush.setHand(cardOne,cardTwo,cardThree,cardFour,cardFive);
		assertTrue(Hand.isHandRoyalFlush(royalFlush));
		Card cardone = new Card(1,0,1);
		Card cardtwo = new Card(2,0,2);
		Card cardthree = new Card(3,0,3);
		Card cardfour = new Card(0,0,4);
		Card cardfive = new Card(12,0,5);
		Hand straightFlush = new Hand();
		straightFlush.setHand(cardone,cardtwo,cardthree,cardfour,cardfive);
		assertFalse(Hand.isHandRoyalFlush(straightFlush));
		
	}

	@Test
	public void TestFourOfAKind() {	
		Card cardOne = new Card(8,1,1);
		Card cardTwo = new Card(8,0,2);
		Card cardThree = new Card(8,2,3);
		Card cardFour = new Card(8,3,4);
		Card cardFive = new Card(12,0,5);
		Hand fourOfAKind = new Hand();
		fourOfAKind.setHand(cardOne,cardTwo,cardThree,cardFour,cardFive);
		assertTrue(Hand.isHandFourOfAKind(fourOfAKind));
		Card cardone = new Card(11,0,1);
		Card cardtwo = new Card(10,0,2);
		Card cardthree = new Card(9,0,3);
		Card cardfour = new Card(8,0,4);
		Card cardfive = new Card(12,0,5);
		Hand royalFlush = new Hand();
		royalFlush.setHand(cardone,cardtwo,cardthree,cardfour,cardfive);
		assertFalse(Hand.isHandFourOfAKind(royalFlush));
	}

	@Test
	public void TestStraightFlush() {
		Card cardOne = new Card(1,0,1);
		Card cardTwo = new Card(2,0,2);
		Card cardThree = new Card(3,0,3);
		Card cardFour = new Card(0,0,4);
		Card cardFive = new Card(12,0,5);
		Hand straightFlush = new Hand();
		straightFlush.setHand(cardOne,cardTwo,cardThree,cardFour,cardFive);
		assertTrue(Hand.isHandStraightFlush(straightFlush));
		Card cardone = new Card(11,0,1);
		Card cardtwo = new Card(10,0,2);
		Card cardthree = new Card(9,0,3);
		Card cardfour = new Card(8,0,4);
		Card cardfive = new Card(12,0,5);
		Hand royalFlush = new Hand();
		royalFlush.setHand(cardone,cardtwo,cardthree,cardfour,cardfive);
		assertFalse(Hand.isHandStraightFlush(royalFlush));
	}
	
}
