class FixParanthesis {
    public static void main(String[] args) {

        int counter = 0;
        StringBuilder res = new StringBuilder();
        if (args.length != 0) {

            for (char c : args[0].toCharArray()) {
                if (c == '(') {
                    res.append('(');
                    counter++;
                } else {
                    if (counter == 0) {
                        res.append('(');
                    } else {
                        counter--;
                    }
                    res.append(')');
                }
            }

            while (counter > 0) {
                res.append(')');
                counter--;
            }

            System.out.println(res.toString());
        } else {
            System.out.println("Please insert a string");
        }
    }
}
