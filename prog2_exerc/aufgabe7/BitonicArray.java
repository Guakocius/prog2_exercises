package aufgabe7;

public class BitonicArray {
    public BitonicArray() {

    }

    public static int findPeakIterative(int[] a) {
        int idx = 0;

        if (a.length == 1) {
            return 0;
        } else if (a.length == 0) {
            throw new NullPointerException("The Array mustn't be null for it to work!");
        }
        int i = 0;
        
        while (i < a.length && a[i + 1] > a[i]) {
            idx = i + 1;
            i++;
        }
        return idx;
    }

    public static int findPeakDivideAndConquer(int[] a) {
        return recArrBord(a, 0, a.length - 1);
    }

    /*private static int recArrBord(int[] a, int l, int r) {

        switch (a.length) {
            case 0 -> {
                return 0;
            }
            case 1 -> {
                return 1;
            }
            default -> {
                if (l == r) {
                    return l;
                } else {
                    int m =  (l + r) / 2;
                    int peakL = recArrBord(a, l, m);
                    int peakR = recArrBord(a, m + l, r);
                    if (peakL >= peakR) {
                        return peakL;
                    } else {
                        return peakR;
                    }
                }
            }
        }
    }*/

    private static int recArrBord(int[] a, int l, int r) {
        if (l == r) {
                    return l;
                } else {
                    int m =  (l + r) / 2;
                    int peakL = recArrBord(a, l, m);
                    int peakR = recArrBord(a, m + 1, r);
                    if (a[peakL] >= a[peakR]) {
                        return peakL;
                    } else {
                        return peakR;
                    }
                }
    }
}
