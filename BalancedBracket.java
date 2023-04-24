package com.learning.DS;
import java.util.Stack;
class BalancedBracket {
    //function to check if brackets are balanced 
	public static boolean isBalanced(String input) {
		//create  a stack data Structure for Character
		Stack<Character> stack = new Stack<>();
		//iterate through the elements of inputs
		for (int index=0;index<input.length(); index++) {
			char ch = input.charAt(index);
			//if char is ({[ is this then add to stack
			if (ch=='(' || ch=='{' || ch=='[') {
				//push the char to stack
				stack.push(ch);
			}
			else {
				if (ch== ')' || ch== '}' || ch== ']') {
					char top = stack.pop();
					if (ch== ')' && top != '(' || (ch == '}' && top != '{') || (ch == ']' && top != '[')){
						return false;
					}
				}
			}
			return stack.empty();
		}
		return false;
		
		
	}
}
