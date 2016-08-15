package com.robintegg.roulette;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PocketTest {

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowOutOfRangeValues() {
		new Pocket("37");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowUndefinedValues() {
		new Pocket("word");
	}

	@Test
	public void shouldRecogniseDoubleZero() {
		Pocket pocket = new Pocket("00");
		assertTrue(pocket.isAZero());
		assertTrue(pocket.isDoubleZero());
		assertFalse(pocket.isEven());
		assertFalse(pocket.isOdd());
		assertTrue(pocket.matchesRange(0, 0));
		assertEquals(Pocket.Colour.Green, pocket.getColour());
	}

	@Test
	public void shouldRecogniseZero() {
		Pocket pocket = new Pocket("0");
		assertTrue(pocket.isAZero());
		assertFalse(pocket.isDoubleZero());
		assertFalse(pocket.isEven());
		assertFalse(pocket.isOdd());
		assertTrue(pocket.matchesRange(0, 0));
		assertEquals(Pocket.Colour.Green, pocket.getColour());
	}

	@Test
	public void shouldAssignOddNumbersInRange1to10ToRed() {
		Pocket pocket = new Pocket("1");
		assertFalse(pocket.isAZero());
		assertFalse(pocket.isDoubleZero());
		assertFalse(pocket.isEven());
		assertTrue(pocket.isOdd());
		assertTrue(pocket.matchesRange(1, 10));
		assertEquals(Pocket.Colour.Red, pocket.getColour());
	}

	@Test
	public void shouldAssignEvenNumbersInRange1to10ToBlack() {
		Pocket pocket = new Pocket("10");
		assertFalse(pocket.isAZero());
		assertFalse(pocket.isDoubleZero());
		assertTrue(pocket.isEven());
		assertFalse(pocket.isOdd());
		assertTrue(pocket.matchesRange(1, 10));
		assertEquals(Pocket.Colour.Black, pocket.getColour());
	}

	@Test
	public void shouldAssignOddNumbersInRange19to28ToRed() {
		Pocket pocket = new Pocket("19");
		assertFalse(pocket.isAZero());
		assertFalse(pocket.isDoubleZero());
		assertFalse(pocket.isEven());
		assertTrue(pocket.isOdd());
		assertTrue(pocket.matchesRange(19, 28));
		assertEquals(Pocket.Colour.Red, pocket.getColour());
	}

	@Test
	public void shouldAssignEvenNumbersInRange19to28ToBlack() {
		Pocket pocket = new Pocket("28");
		assertFalse(pocket.isAZero());
		assertFalse(pocket.isDoubleZero());
		assertTrue(pocket.isEven());
		assertFalse(pocket.isOdd());
		assertTrue(pocket.matchesRange(19, 28));
		assertEquals(Pocket.Colour.Black, pocket.getColour());
	}

	@Test
	public void shouldAssignOddNumbersInRange11to18ToBlack() {
		Pocket pocket = new Pocket("11");
		assertFalse(pocket.isAZero());
		assertFalse(pocket.isDoubleZero());
		assertFalse(pocket.isEven());
		assertTrue(pocket.isOdd());
		assertTrue(pocket.matchesRange(11, 18));
		assertEquals(Pocket.Colour.Black, pocket.getColour());
	}

	@Test
	public void shouldAssignEvenNumbersInRange11to18ToRed() {
		Pocket pocket = new Pocket("18");
		assertFalse(pocket.isAZero());
		assertFalse(pocket.isDoubleZero());
		assertTrue(pocket.isEven());
		assertFalse(pocket.isOdd());
		assertTrue(pocket.matchesRange(11, 18));
		assertEquals(Pocket.Colour.Red, pocket.getColour());
	}

	@Test
	public void shouldAssignOddNumbersInRange29to36ToBlack() {
		Pocket pocket = new Pocket("29");
		assertFalse(pocket.isAZero());
		assertFalse(pocket.isDoubleZero());
		assertFalse(pocket.isEven());
		assertTrue(pocket.isOdd());
		assertTrue(pocket.matchesRange(29, 36));
		assertEquals(Pocket.Colour.Black, pocket.getColour());
	}

	@Test
	public void shouldAssignEvenNumbersInRange29to36ToRed() {
		Pocket pocket = new Pocket("36");
		assertFalse(pocket.isAZero());
		assertFalse(pocket.isDoubleZero());
		assertTrue(pocket.isEven());
		assertFalse(pocket.isOdd());
		assertTrue(pocket.matchesRange(29, 36));
		assertEquals(Pocket.Colour.Red, pocket.getColour());
	}

}
