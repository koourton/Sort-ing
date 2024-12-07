import gui.SortingVisualizer;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        int[] array = {34, 7, 23, 32, 5, 62, 78, 45, 90, 12, 56, 89, 67, 43, 21, 10, 98, 54, 76, 33, 29, 88, 15, 49, 72, 60, 81, 39, 25, 70, 95, 18, 50, 66, 83, 40, 27, 92, 14, 58, 74, 36, 19, 85, 47, 64, 99, 31, 22, 77, 11, 53, 68, 84, 41, 28, 93, 16, 59, 75, 37, 20, 86, 48, 65, 100, 30, 24, 79, 13, 57, 73, 35, 17, 87, 46, 63, 97, 26, 91, 9, 52, 69, 82, 38, 44, 80, 6, 61, 94, 8, 51, 71, 3, 55, 1, 42, 2, 4, 96};
        SwingUtilities.invokeLater(() -> {
            SortingVisualizer visualizer = new SortingVisualizer(array);
            visualizer.setVisible(true);
        });
    }
}