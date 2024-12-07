package gui;

import javax.swing.*;
import java.awt.*;

public class SortingVisualizer extends JFrame {
    private JPanel panel;
    private int[] array;

    public SortingVisualizer(int[] array) {
        this.array = array;
        setTitle("Sorting Algorithm Visualizer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Custom panel for drawing the array
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawArray(g); // Draw the array as bars
            }
        };

        add(panel, BorderLayout.CENTER);
        add(new ControlPanel(this), BorderLayout.SOUTH);
    }

    // Draws the array as bars on the panel
    private void drawArray(Graphics g) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int barWidth = width / array.length;

        for (int i = 0; i < array.length; i++) {
            int barHeight = (int)(((double)array[i] / getMaxValue()) * height);
            g.setColor(Color.BLUE);
            g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
        }
    }

    // Finds the maximum value in the array for scaling bar heights
    private int getMaxValue() {
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public JPanel getPanel() {
        return panel;
    }

    public int[] getArray() {
        return array;
    }
}