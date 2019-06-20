package com.github.tomjava.frame;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

/**
 * JFrame = MenuBar + Panel
 */
public class AlgoFrame extends JFrame {
    private static int defaultWidth = 800;
    private static int defaultHeight = 800;

    /**
     * width and height of this frame's writable area
     */
    @Getter
    private int canvasWidth;
    @Getter
    private int canvasHeight;

    /**
     * JFrame dependent on panel
     */
    @Getter @Setter
    private JPanel panel;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas algoCanvas = new AlgoCanvas();
        algoCanvas.setPreferredSize(
                new Dimension(canvasWidth, canvasHeight));
        setContentPane(algoCanvas);

        // make algoFrame follow size of panel
        pack();
        // setSize(canvasWidth, canvasHeight);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AlgoFrame(String title){
        this(title, defaultWidth, defaultHeight);
    }

    private int[] moneyArray;
    public void render(int[] moneyArray){
        this.moneyArray = moneyArray;

        // refresh this canvas
        repaint();
    }

    /**
     * hold out content and display on JFrame
     */
    private class AlgoCanvas extends JPanel{
        public AlgoCanvas() {
            super(true);
        }

        /**
         * do all paint jobs
         * @param g: inject by context
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (moneyArray == null) {
                return;
            }

            Graphics2D g2D = (Graphics2D) g;

            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2D.addRenderingHints(hints);


            int width = canvasWidth / moneyArray.length;
            for (int i = 0; i < moneyArray.length; i++) {
                if (moneyArray[i] > 0) {
                    g2D.setColor(AlgoVisHelper.Blue);
                    AlgoVisHelper.fillRectangle(g2D, i * width + 1,
                            canvasHeight/2 - moneyArray[i], width - 1, moneyArray[i]);
                } else {
                    g2D.setColor(AlgoVisHelper.Red);
                    AlgoVisHelper.fillRectangle(g2D, i * width + 1,
                            canvasHeight/2, width - 1, -moneyArray[i]);
                }

            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
