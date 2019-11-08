class Permutation {
    public static void main(String[] args) {
        System.out.println("Using Vector Frequency -> " + isPermutation(args[0], args[1]));
    }

    // Solution using vector of frequency
    // Assuming we only use chars from ascii, 256 chars
    public static boolean isPermutation(String s1, String s2) {
        int[] chars = new int[256];
        if (s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); ++i) {
            chars[s1.charAt(i)] += 1;
            chars[s2.charAt(i)] -= 1;
        }

        for (int i : chars) {
            if (i != 0)
                return false;
        }
        return true;
    }

    // Another solution would be to sort both
    // strings and check if they are equals
}
