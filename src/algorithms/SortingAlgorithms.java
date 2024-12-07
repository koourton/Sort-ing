package algorithms;

import javax.swing.*;

public class SortingAlgorithms {
    public static void bubbleSort(int[] array, JPanel panel) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                    panel.repaint();
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!swapped) break;
        }
    }

    public static void quickSort(int[] array, int low, int high, JPanel panel) {
        if (low < high) {
            int pi = partition(array, low, high, panel);
            quickSort(array, low, pi - 1, panel);
            quickSort(array, pi + 1, high, panel);
        }
    }

    private static int partition(int[] array, int low, int high, JPanel panel) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
                panel.repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        swap(array, i + 1, high);
        panel.repaint();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void mergeSort(int[] array, int left, int right, JPanel panel) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle, panel);
            mergeSort(array, middle + 1, right, panel);

            merge(array, left, middle, right, panel);
        }
    }

    private static void merge(int[] array, int left, int middle, int right, JPanel panel) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, middle + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
            panel.repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
            panel.repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
            panel.repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insertionSort(int[] array, JPanel panel) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
                panel.repaint();
                try {
                    Thread.sleep(12);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            array[j + 1] = key;
            panel.repaint();
            try {
                Thread.sleep(12);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void selectionSort(int[] array, JPanel panel) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                panel.repaint();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}