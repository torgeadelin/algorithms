import java.util.HashMap;

class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(testPermPalindrom(args[0]));
    }

    // Using HashMap
    public static boolean testPermPalindrom(String str) {
        HashMap<Character, Integer> chars = new HashMap<>();
        boolean flag = false;
        str = str.toLowerCase();
        int length = 0;
        for (char c : str.toCharArray()) {
            if (c != ' ') {
                int prev = chars.get(c) != null ? chars.get(c) : 0;
                chars.put(c, prev + 1);
                length++;
            }

        }
        if (length % 2 == 0) {
            for (char c : chars.keySet()) {
                if (chars.get(c) % 2 != 0)
                    return false;
            }
        } else {
            for (char c : chars.keySet()) {
                if (chars.get(c) % 2 != 0 && !flag) {
                    flag = true;
                    continue;
                }
                if (chars.get(c) % 2 != 0)
                    return false;
            }
        }
        return true;
    }

    // // Using Frequency Vector (more space efficient)
    // public static boolean testPermPalindromVector(String str) {

    // }
}