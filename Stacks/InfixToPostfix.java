// package Stacks;

// import caching.Stacks;

// /**
// * InfixToPostfix
// */

// public class InfixToPostfix {

// static int precedence(char ch) {

// if (ch == '+' || ch == '-') {
// return 1;
// }

// if (ch == '*' || ch == '/') {
// return 2;
// }

// if (ch == '^') {
// return 3;
// }

// return -1;
// }

// static String convertToPostfix(String exp) {
// String res = "";
// Stacks stk = new Stacks(exp.length());

// for (int i = 0; i < exp.length(); i++) {
// char ch = exp.charAt(i);

// if (precedence(ch) > 0) {
// // this is opearator
// System.out.println("Operator");
// while (!stk.isEmpty() && precedence(stk.peek()) > precedence(ch)) {
// res = res + stk.pop();
// }
// stk.push(ch);

// } else {

// if (ch == '(') {
// stk.push(ch);
// } else if (ch == ')') {
// char x = stk.pop();
// while (x != '(') {
// res = res + x;
// x = stk.pop();
// }
// } else {
// res = res + ch;
// }
// }
// System.out.println(ch);
// }
// System.out.println(stk.peek() + "peeking");
// return res;
// }

// public static void main(String[] args) {
// System.out.println("hello world");
// convertToPostfix("b+cs-23*9");

// }
// }
