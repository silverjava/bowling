package com.tdd.example;

import org.junit.Test;

import static junit.framework.Assert.*;

public class FrameTest {

    @Test
    public void shouldCalculateScores() throws Exception {
        Frame frame = new Frame();
        frame.rolls(5);
        frame.rolls(4);

        Frame frame1 = new Frame();
        frame1.rolls(5);
        frame1.rolls(1);

        assertEquals(9, frame.getScore());
        assertEquals(6, frame1.getScore());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldLessThan10InFrame() throws Exception {
        Frame frame = new Frame();
        frame.rolls(5);
        frame.rolls(7);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldOnlyRoll2TimeAtMost() throws Exception {
        Frame frame = new Frame();
        frame.rolls(1);
        frame.rolls(1);
        frame.rolls(1);
    }

    @Test
    public void shouldReturnTrueIfIsSpare() throws Exception {
        Frame frame = new Frame();
        frame.rolls(1);
        frame.rolls(9);
        assertTrue(frame.isSpare());
    }

    @Test
    public void shouldReturnFalseIfIsNormal() throws Exception {
        Frame frame = new Frame();
        frame.rolls(1);
        frame.rolls(4);
        assertFalse(frame.isSpare());
    }

    @Test
    public void shouldReturnFalseIfIsStrike() throws Exception {
        Frame frame = new Frame();
        frame.rolls(10);
        assertFalse(frame.isSpare());
    }

    @Test
    public void shouldReturnTrueIfIsStrike() throws Exception {
        Frame frame = new Frame();
        frame.rolls(10);
        assertTrue(frame.isStrike());
    }

    @Test
    public void shouldReturnScoreForEachRoll() {
        Frame frame = new Frame();
        frame.rolls(3);
        frame.rolls(4);

        assertEquals(3, frame.firstRollScore());
        assertEquals(4, frame.secondRollScore());
    }
}
