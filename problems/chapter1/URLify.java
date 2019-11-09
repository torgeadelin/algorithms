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
        System.out.println("URLify -> " + urlify(args[0]));
    }

    // Using string builder
    public static String urlify(String str) {
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
}