package aufgabe7;

/**
 *
 * @author Oliver Haase
 */

public class BitonicArrayTest {

    public static void main(String[] args) {
        // Test array sizes
        int[] sizes = {10_000_000, 100_000_000};
        int numTrials = 100;

        for (int size : sizes) {
            System.out.println("Testing with array size: " + size);

            long totalIterativeTime = 0;
            long totalDivideConquerTime = 0;

            for (int trial = 0; trial < numTrials; trial++) {
                // Generate a random bitonic array
                int[] array = generateBitonicArray(size);

                // Time iterative solution
                long startTime = System.nanoTime();
                int peakIterative = BitonicArray.findPeakIterative(array);
                long iterativeTime = System.nanoTime() - startTime;
                totalIterativeTime += iterativeTime;

                // Time divide-and-conquer solution
                startTime = System.nanoTime();
                int peakDivideConquer = BitonicArray.findPeakDivideAndConquer(array);
                long divideConquerTime = System.nanoTime() - startTime;
                totalDivideConquerTime += divideConquerTime;

                // Verify both solutions found the same peak
                if (peakIterative != peakDivideConquer) {
                    System.out.println("Error: Solutions found different peaks!");
                }
            }
            System.out.println("Cumulative times (" + numTrials + " trials): ");
            System.out.println("Iterative = " + (totalIterativeTime / 1_000) +
                    " microsec, Divide-Conquer = " + (totalDivideConquerTime / 1_000) + " microsec");
        }
    }

    // Function to generate a random bitonic array of given size
    private static int[] generateBitonicArray(int size) {
        int[] array = new int[size];

        // Random peak position between 0 and size-1
        int peakPos = (int)(Math.random() * (size - 1));

        int value = 0;

        // Generate increasing sequence up to peak
        for (int i = 0; i <= peakPos; i++) {
            array[i] = ++value;  // Add some randomness
        }

        // Generate decreasing sequence after peak
        for (int i = peakPos + 1; i < size; i++) {
            array[i] = --value;  // Decrease with some randomness
        }

        return array;
    }
}
