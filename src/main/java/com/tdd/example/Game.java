package com.tdd.example;

import com.google.common.collect.Lists;

import java.util.List;

public class Game {

    private List<Frame> frames = Lists.newArrayList();

    public int getTotal() {
        int total = 0;

        for (int index = 0; index < frames.size(); index++) {
            Frame frame = frames.get(index);
            if (frame.isSpare()) {
                if (frames.size() - index == 1) {
                    return total;
                }
                total += frames.get(index + 1).firstRollScore();
            }

            if (frame.isStrike()) {
                int restFrameSize = frames.size() - index - 1;
                if (restFrameSize > 0) {
                    if (!frames.get(index + 1).isStrike()) {
                        total += frames.get(index + 1).getScore();
                    } else {
                        if (restFrameSize > 1) {
                            total += frames.get(index + 1).getScore() + frames.get(index + 2).firstRollScore();
                        } else {
                            return total;
                        }
                    }
                } else {
                    return total;
                }
            }
            total += frame.getScore();
        }
        return total;
    }

    public void add(Frame frame) {
        if (frames.size() == 10) {
            throw new IllegalStateException("You can only throw 10 Frames");
        }
        frames.add(frame);
    }

}
