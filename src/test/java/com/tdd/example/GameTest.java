package com.tdd.example;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GameTest {

    @Test
    public void shouldCalculateTotalScores() throws Exception {
        Game game = new Game();
        game.add(generateFrame(5, 4));
        game.add(generateFrame(5, 3));

        assertEquals(17, game.getTotal());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalStatementExceptionIfMoreThan10Frames() throws Exception {
        Game game = new Game();
        for (int i = 0; i < 11; i++) {
            game.add(generateFrame(5, 4));
        }
    }

    @Test
    public void shouldAddNextRollIfSpare() throws Exception {
        Game game = new Game();
        game.add(generateFrame(5, 5));
        game.add(generateFrame(4, 4));

        assertEquals(22, game.getTotal());
    }

    @Test
    public void shouldAddNextTwoRollsIfTripleStrikes() throws Exception {
        Game game = new Game();
        game.add(generateFrame(10));
        game.add(generateFrame(10));
        game.add(generateFrame(10));
        assertEquals(30, game.getTotal());
    }

    @Test
    public void testDoubleStrikesAndOneNormal() throws Exception {
        Game game = new Game();
        game.add(generateFrame(10));
        game.add(generateFrame(10));
        game.add(generateFrame(5, 4));
        assertEquals(53, game.getTotal());
    }

    @Test
    public void shouldAddNextTwoRollsIfStrike() throws Exception {
        Game game = new Game();
        game.add(generateFrame(10));
        game.add(generateFrame(4, 4));
        assertEquals(26, game.getTotal());
    }

    private Frame generateFrame(int... scores) {
        Frame frame = new Frame();
        for (int s : scores) {
            frame.rolls(s);
        }
        return frame;
    }
}
