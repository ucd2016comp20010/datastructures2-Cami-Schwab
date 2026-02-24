package project20280.stacksqueues;

class BracketChecker {
    private final String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        LinkedStack<Character> ls = new LinkedStack<>();
        for(int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if(curr == '(' || curr == '{' || curr == '[') {
                ls.push(curr);
            }
            if(curr == ')' || curr == '}' || curr == ']') {
                if(ls.isEmpty()) {
                    System.out.println("missing left delimiter error");
                    return;
                }
                char popped = ls.pop();
                if(!((popped == '(' && curr == ')') || (popped == '{' && curr == '}') || (popped == '[' && curr == ']'))) {
                    System.out.println("matching error");
                    return;
                }
            }
        }
        if(!ls.isEmpty()) {
            System.out.println("missing right delimiter error");
            return;
        }
        System.out.println("check successful");
        return;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "[]]()()", // not correct
                "c[d]", // correct\n" +
                "a{b[c]d}e", // correct\n" +
                "a{b(c]d}e", // not correct; ] doesn't match (\n" +
                "a[b{c}d]e}", // not correct; nothing matches final }\n" +
                "a{b(c) ", // // not correct; Nothing matches opening {
        };

        for (String input : inputs) {
            BracketChecker checker = new BracketChecker(input);
            System.out.println("checking: " + input);
            checker.check();
        }
    }
}