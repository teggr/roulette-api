package com.robintegg.roulette;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.robintegg.roulette.Pocket.Colour;

public class TableLayoutTest {

	@Test
	public void testEuropeanLayout() {

		TableLayout layout = TableLayout.EUROPEAN_SINGLE_ZERO;

		assertEquals(37, layout.getPockets().size());
		assertEquals("30", layout.getPockets().get(15).getNumber());
		assertEquals(Colour.Red, layout.getPockets().get(15).getColour());
	}

	@Test
	public void testAmericanLayout() {

		TableLayout layout = TableLayout.AMERICAN_DOUBLE_ZERO;

		assertEquals(38, layout.getPockets().size());
		assertEquals("24", layout.getPockets().get(15).getNumber());
		assertEquals(Colour.Black, layout.getPockets().get(15).getColour());

	}

}
