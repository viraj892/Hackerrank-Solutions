package BalancedBrackets;

import java.util.*;

public class BalancedOrNot {

	public static boolean isBalanced(String expression) {
		if (expression == null)
			return true;
		
		Stack<Character> s = new Stack<Character>();
		char[] char_exp = expression.toCharArray();
		Character exp[] = new Character[char_exp.length];
		for (int i = 0; i < char_exp.length; i++)
			exp[i] = new Character(char_exp[i]);

		for (int i = 0; i < exp.length; i++) {
			System.out.println(i);
			if (exp[i].charValue() == '(' || exp[i].charValue() == '{' || exp[i].charValue() == '[')
				s.push(exp[i]);
			else if (exp[i].charValue() == ')' || exp[i].charValue() == '}' || exp[i].charValue() == ']') {
				if(s.isEmpty())
					return false;
				if ((exp[i].charValue() == ')' && s.peek().charValue() == '(')
						|| (exp[i].charValue() == '}' && s.peek().charValue() == '{')
						|| (exp[i].charValue() == ']' && s.peek().charValue() == '['))
					s.pop();
				else
					return false;
			}
		}
		if(!s.isEmpty())
			return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
		in.close();
	}
}