package com.robintegg.roulette;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleTableLayoutTest {

	@Test
	public void shouldParseListOfPockets() {

		TableLayout layout = new SimpleTableLayout("test", "3-4-5");

		assertEquals(3, layout.getPockets().size());
		assertEquals("3", layout.getPockets().get(0).getNumber());
		assertEquals("4", layout.getPockets().get(1).getNumber());
		assertEquals("5", layout.getPockets().get(2).getNumber());
	}

}
