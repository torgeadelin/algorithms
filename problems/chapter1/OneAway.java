class OneAway {
    public static void main(String[] args) {
        System.out.println(isOneAway(args[0], args[1]));
    }

    public static boolean isOneAway(String a, String b) {

        boolean flag_a = true;
        boolean flag_b = true;
        int p = 0;
        int q = 0;

        if (Math.abs(a.length() - b.length()) > 1)
            return false;

        while (p < a.length() && q < b.length()) {
            if (a.charAt(p) == b.charAt(q)) {
                p++;
                q++;
            } else {
                if (a.length() > b.length()) {
                    if (flag_a) {
                        flag_a = false;
                        p += 2;
                        q++;
                    } else
                        return false;
                } else if (a.length() > b.length()) {
                    if (flag_b) {
                        flag_b = false;
                        q += 2;
                        p++;
                    } else
                        return false;
                } else {
                    if (flag_a && flag_b) {
                        p++;
                        q++;
                        flag_a = false;
                        flag_b = false;
                    } else
                        return false;
                }
            }
        }

        return true;
    }
}