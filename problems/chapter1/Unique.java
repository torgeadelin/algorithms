import java.util.HashSet;

class Unique {

    /*
     * Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures?
     */
    public static void main(String[] args) {
        System.out.println("Using HashSet -> " + isUnique(args[0]));
        System.out.println("Using Frequency Vector -> " + isUniqueNoDS(args[0]));
    }

    // Using Additional Data Structure
    // Time complexity O(n)

    public static boolean isUnique(String str) {
        HashSet<Character> s = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (s.contains(c)) {
                return false;
            } else {
                s.add(c);
            }
        }
        return true;
    }

    // Not using Additional Data Structure
    // We assume we only use ascii chars 256 chars in total.
    // Time complexity O(n)
    public static boolean isUniqueNoDS(String str) {
        int[] frequency = new int[256];
        for (char c : str.toCharArray()) {
            frequency[c] += 1;
            if (frequency[c] > 1)
                return false;
        }
        return true;
    }
}