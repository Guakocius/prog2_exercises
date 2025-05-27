package aufgabe8;

/**
 *
 * @author Oliver Haase
 */

public class TestMergeSort {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5).add(7).add(3).add(12).add(2).add(10).add(15).add(4);
        System.out.println("List before merge sort: " + list);
        list.mergeSort();
        System.out.println("List after merge sort: " + list);
    }

}
