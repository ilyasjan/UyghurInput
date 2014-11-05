package classs;

import java.util.Stack;

public class BidiBulider {
	public BidiBulider() {

	}

	public String Build(String text) {
		Stack<String> list = RevStringsToList(text);
		String strRev = ListConvertToString(list);
		return strRev;
	}

	public String ListConvertToString(Stack<String> stack) {
		StringBuilder builder = new StringBuilder();
		while (!stack.empty()) {
			String tmp = stack.pop();
			builder.append(tmp);
			System.out.println("pop Strings:" + tmp);
		}
		return builder.toString();
	}

	public Stack<String> RevStringsToList(String line) {
		line = line + " ";
		Stack<String> stack = new Stack<String>();
		String cleand = "";
		String digits = "";
		for (int i = 0; i < line.length(); i++) {
			Character c = line.charAt(i);
			if (Character.isDigit(c)) {
				digits = digits + c.toString();
				continue;
			}
			if (!Character.isLetterOrDigit(c)) {
				if (Character.isWhitespace(c)) {
					if (!IsNullOrEmpty(cleand)) {
						String kuozhanstr = new kuozhan().Reshape(cleand);
						StringBuilder builder = new StringBuilder(kuozhanstr);
						String rev = builder.reverse().toString();
						stack.push(rev);
						cleand = "";
					}
				} else {
					if (!IsNullOrEmpty(digits)) {
						System.out.println("push digits:" + digits);
						stack.push(digits);
						digits = "";
					}
					cleand = cleand + c.toString();
				}
				continue;
			} else {
				cleand = cleand + c.toString();
			}
		}
		return stack;
	}

	private Boolean IsNullOrEmpty(String str) {
		return str.trim().length() < 1;

	}

}
