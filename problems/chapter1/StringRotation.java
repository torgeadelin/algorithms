class StringRotation {
    public static void main(String[] args) {
        System.out.println(isRotation(args[0], args[1]));
    }

    public static boolean isRotation(String s1, String s2) {
        // We need to find a way to split s1 in x and y, where s2 = y + x
        // Example s1 = waterbottle, s2 = erbottlewat
        // Then x = wat, y = erbottle x+y = waterbottle and y+x = erbottlewat = s2
        // Notice how if we have xyxy, yx is a substring of it
        // So all we need to do is check if s2 is substring of s1 + s1

        if (s1.length() != s2.length())
            return false;

        String s1s1 = s1 + s1;
        return s1s1.indexOf(s2) != -1;

    }
}