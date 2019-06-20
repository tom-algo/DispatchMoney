package com.github.tomjava.frame;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlgoFrameTest {
    @Test
    public void render() throws Exception{
        AlgoFrame algoFrame = new AlgoFrame("Hello", 1000, 1000);

        int[] money = new int[50];

        for (int i = 0; i < money.length; i++) {
            money[i] = i;
        }

        algoFrame.render(money);

        Thread.sleep(1000 * 100);
    }
}