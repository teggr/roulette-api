package com.robintegg.roulette;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PayoutTest {

	@Test
	public void testGetPayout() {

		assertEquals(35, new Payout(1).getPayout());
		assertEquals(17, new Payout(2).getPayout());
		assertEquals(8, new Payout(4).getPayout());
		assertEquals(6, new Payout(5).getPayout());
		assertEquals(5, new Payout(6).getPayout());
		assertEquals(2, new Payout(12).getPayout());
		assertEquals(1, new Payout(18).getPayout());

	}

}
