package com.github.tomjava.frame;

import com.github.tomjava.shape.Circle;
import lombok.Setter;

import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class AlgoVisualizer {
    private int[] moneyArray;

    @Setter
    private AlgoFrame frame;

    private int sceneWidth, sceneHeight;

    private boolean isPaused;

    public AlgoVisualizer(int sceneWidth, int sceneHeight){
        this.sceneHeight = sceneHeight;
        this.sceneWidth = sceneWidth;
        moneyArray = new int[100];
        for (int i = 0; i < moneyArray.length; i++) {
            // moneyArray[i] = moneyArray.length;
            moneyArray[i] = 0;
        }
    }

    public void run() throws InterruptedException{
        while (true) {
            Arrays.sort(moneyArray);
            frame.render(moneyArray);
            Thread.sleep(1);

            for (int k = 0; k < 50; k++) {
                for (int i = 0; i < moneyArray.length; i++) {
                    //if (moneyArray[i] > 0){
                        int target = (int)(Math.random() * moneyArray.length);
                        moneyArray[i]--;
                        moneyArray[target]++;
                    //}
                }
            }

        }
    }
}
