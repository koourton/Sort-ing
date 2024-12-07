package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import algorithms.SortingAlgorithms;

public class ControlPanel extends JPanel {
    private JComboBox<String> algorithmSelector;
    private JButton sortButton;
    private SortingVisualizer visualizer;
    private int[] originalArray;
    private Thread sortingThread;

    public ControlPanel(SortingVisualizer visualizer) {
        this.visualizer = visualizer;
        this.originalArray = visualizer.getArray().clone(); // Save the original array

        algorithmSelector = new JComboBox<>(new String[]{"Bubble Sort", "Quick Sort", "Merge Sort", "Insertion Sort", "Selection Sort"});
        sortButton = new JButton("Sort");

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sortingThread != null && sortingThread.isAlive()) {
                    sortingThread.interrupt(); // Interrupt the current sorting thread
                }
                resetArray(); // Reset the array to its original state
                String selectedAlgorithm = (String) algorithmSelector.getSelectedItem();
                disableControls(); // Disable controls during sorting
                sortingThread = new Thread(() -> {
                    try {
                        if ("Bubble Sort".equals(selectedAlgorithm)) {
                            SortingAlgorithms.bubbleSort(visualizer.getArray(), visualizer.getPanel());
                        } else if ("Quick Sort".equals(selectedAlgorithm)) {
                            SortingAlgorithms.quickSort(visualizer.getArray(), 0, visualizer.getArray().length - 1, visualizer.getPanel());
                        } else if ("Merge Sort".equals(selectedAlgorithm)) {
                            SortingAlgorithms.mergeSort(visualizer.getArray(), 0, visualizer.getArray().length - 1, visualizer.getPanel());
                        } else if ("Insertion Sort".equals(selectedAlgorithm)) {
                            SortingAlgorithms.insertionSort(visualizer.getArray(), visualizer.getPanel());
                        } else if ("Selection Sort".equals(selectedAlgorithm)) {
                            SortingAlgorithms.selectionSort(visualizer.getArray(), visualizer.getPanel());
                        }
                    } finally {
                        enableControls(); // Re-enable controls after sorting
                    }
                });
                sortingThread.start();
            }
        });

        add(algorithmSelector);
        add(sortButton);
    }

    private void resetArray() {
        synchronized (visualizer.getArray()) {
            int[] array = visualizer.getArray();
            System.arraycopy(originalArray, 0, array, 0, originalArray.length);
            visualizer.getPanel().repaint();
        }
    }

    private void disableControls() {
        algorithmSelector.setEnabled(false);
        sortButton.setEnabled(false);
    }

    private void enableControls() {
        algorithmSelector.setEnabled(true);
        sortButton.setEnabled(true);
    }
}
