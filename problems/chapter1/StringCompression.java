import java.util.HashMap;

class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress(args[0]));
    }

    public static String compress(String s) {
        StringBuilder res = new StringBuilder();
        int k = 1;
        boolean newChar = true;

        for (int i = 0; i < s.length() - 1; ++i) {

            if (s.charAt(i) == s.charAt(i + 1)) {
                if (newChar) {
                    res.append(s.charAt(i));
                    newChar = false;
                }
                k++;
            } else {
                if (newChar)
                    res.append(s.charAt(i));
                res.append(k);

                k = 1;
                newChar = true;

            }
        }
        res.append(k);

        return res.toString();
    }
}