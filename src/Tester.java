import java.util.*;

public class Tester {

    public static <T extends Comparable<T>> boolean test(List<T> a, List<T> b) {
        //false if different size
        if (a.size() != b.size()) {
            return false;
        }

        //create mutable lists
        List<T> aMut = new ArrayList<>(a);
        List<T> bMut = new ArrayList<>(b);

        Collections.sort(aMut);
        Collections.sort(bMut);

        // checks to see if the lists are different
        for (int i = 0; i < aMut.size(); i++) {
            if (!aMut.get(i).equals(bMut.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        System.out.println(test(l1, l2));  // true
        System.out.println(test(List.of(1), List.of())); // false
        System.out.println(test(List.of(), List.of(1))); // false
        System.out.println(test(
                List.of(1, 3, 3, 2, 1),
                List.of(1, 3, 1, 3, 2)));              // true
        System.out.println();

        System.out.println(test(
                List.of('a', 'x', 'c', 'm', 'c', 'c', 'x', 'j'),
                List.of('a', 'x', 'c', 'm', 'c', 'x', 'j')));      // false

        System.out.println(test(
                List.of('a', 'x', 'c', 'm', 'c', 'c', 'x', 'j'),
                List.of('c', 'a', 'x', 'c', 'm', 'c', 'x', 'j')));  // true
    }
}
