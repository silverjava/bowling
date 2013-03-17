package com.tdd.example;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Frame {
    private List<Integer> scores = newArrayList();

    public void rolls(int score) {
        if (scores.size() == 2) {
            throw new IllegalStateException("Only allowed throw 2 times for normal frame");
        }
        if (getScore() + score > 10) {
            throw new IllegalStateException("Score should not larger than ten");
        }
        scores.add(score);
    }

    public int getScore() {
        int score = 0;
        for (int each : scores) {
            score += each;
        }
        return score;
    }

    public boolean isSpare() {
        return getScore() == 10 && scores.size() == 2;
    }

    public int firstRollScore() {
        return scores.get(0);
    }

    public int secondRollScore() {
        return scores.get(1);
    }

    public boolean isStrike() {
        return scores.size() == 1 && getScore() == 10;
    }
}
