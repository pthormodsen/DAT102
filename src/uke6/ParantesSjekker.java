package uke6;

import java.util.Stack;

public class ParantesSjekker {
    public boolean sjekkParanteser(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (erStartParantes(c)) {
                stack.push(c);
            } else if (erSluttParantes(c)) {
                if (stack.isEmpty() || !erParantesPar(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


        public boolean erStartParantes(char c){
            return c == '(' || c == '{' || c == '[';
        }

        public boolean erSluttParantes(char c){
            return c == ')' || c == '}' || c == ']';
        }

        public boolean erParantesPar(char start, char slutt) {
            return  (start == '(' && slutt == ')') ||
                    (start == '[' && slutt == ']') ||
                    (start == '{' && slutt == '}');
        }

        public static void main(String[] args){
        ParantesSjekker ps = new ParantesSjekker();

            System.out.println(ps.sjekkParanteser("{ [ ( ) ] }")); // true
            System.out.println(ps.sjekkParanteser("{ [ ( ) }"));   // false
            System.out.println(ps.sjekkParanteser("[ ( ) ] }"));   // false
            System.out.println(ps.sjekkParanteser("{ [ ( ] ) }")); // false
            System.out.println(ps.sjekkParanteser("class HelloWorld { public static void main(String[] args) { System.out.println(\"Hello World!\"); } }")); // true
        }
}

