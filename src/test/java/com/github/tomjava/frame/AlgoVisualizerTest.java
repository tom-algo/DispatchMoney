package com.github.tomjava.frame;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlgoVisualizerTest {

    @Test
    public void run() throws Exception{
        int sceneWidth = 1000;
        int sceneHeight = 800;

        AlgoVisualizer algoVisualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
        AlgoFrame frame = new AlgoFrame("Hello", sceneWidth, sceneHeight);
        algoVisualizer.setFrame(frame);

        algoVisualizer.run();
    }
}