class URLify {

    // URLify: Write a method to replace all spaces in a string with '%20'.
    // You may assume that the string has sufficient space at the end to hold the
    // additional
    // characters,and that you are given the "true" length of the string. (Note: If
    // implementing in
    // Java,please use a character array so that you can perform this operation in
    // place.)

    // EXAMPLE
    // Input: "Mr John Smith ", 13
    // Output: "Mr%20John%20Smith"
    public static void main(String[] args) {
        System.out.println("URLify -> " + urlify(args[0], 13));
        System.out.println("URLify -> " + urlify2(args[0], 13));
    }

    // Using string builder
    public static String urlify(String str, int n) {
        str = str.trim(); // remove spaces front and back;
        StringBuilder s = new StringBuilder();
        boolean seenSpace = false;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (!seenSpace) {
                    s.append("%20");
                    seenSpace = true;
                } else
                    continue;
            } else {
                s.append(c);
                seenSpace = false;
            }
        }
        return s.toString();
    }

    // Hint It's often easiest to modify strings by going from the end of the string
    // to the beginning.
    // Solution without string builder
    public static String urlify2(String str, int n) {
        str = str.trim(); // This runs O(n) worst case

        int k = 0; // position for string in res
        boolean seenSpace = false;
        int spacesNeeded = 0;

        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (!seenSpace) {
                    spacesNeeded++;
                } else
                    continue;
            }
        }

        char[] res = new char[n + spacesNeeded * 3];

        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (!seenSpace) {
                    res[k++] = '%';
                    res[k++] = '2';
                    res[k++] = '0';
                } else {
                    continue;
                }
            } else {
                res[k++] = c;
                seenSpace = false;
            }
        }

        StringBuilder r = new StringBuilder();
        for (char c : res) {
            r.append(c);
        }
        return r.toString();
    }
}