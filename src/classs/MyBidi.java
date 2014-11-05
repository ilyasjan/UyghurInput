package classs;

import java.util.ArrayList;
import java.util.List;

public class MyBidi {

	private static final String Tag = "MyBidi";
	public static char[] UChar600 = { 'ت', 'پ', 'ب', 'ر', 'د', 'چ', 'ج', 'ز',
			'ف', 'ق', 'ك', 'ش', 'گ', 'س', 'ڭ', 'ن', 'م', 'ۋ', 'ل', 'خ', 'غ',
			'ژ', 'ي', 'ا', 'ە', 'و', 'ۈ', 'ۆ', 'ۇ', 'ې', 'ى', 'ھ', 'ئ' };
	public static char[] UCharExB = { 'ﺗ', 'ﭘ', 'ﺑ', 'ﺭ', 'ﺩ', 'ﭼ', 'ﺟ', 'ﺯ',
			'ﻓ', 'ﻗ', 'ﻛ', 'ﺷ', 'ﮔ', 'ﺳ', 'ﯕ', 'ﻧ', 'ﻣ', 'ﯞ', 'ﻟ', 'ﺧ', 'ﻏ',
			'ﮊ', 'ﻳ', 'ﺍ', 'ﻩ', 'ﻭ', 'ﯛ', 'ﯙ', 'ﯗ', 'ﯦ', 'ﯨ', 'ﮬ', 'ﺋ' };
	public static char[] UCharExO = { 'ﺘ', 'ﭙ', 'ﺒ', 'ﺮ', 'ﺪ', 'ﭽ', 'ﺠ', 'ﺰ',
			'ﻔ', 'ﻘ', 'ﻜ', 'ﺸ', 'ﮕ', 'ﺴ', 'ﯖ', 'ﻨ', 'ﻤ', 'ﯟ', 'ﻠ', 'ﺨ', 'ﻐ',
			'ﮋ', 'ﻴ', 'ﺎ', 'ﻪ', 'ﻮ', 'ﯜ', 'ﯚ', 'ﯘ', 'ﯧ', 'ﯩ', 'ﮭ', 'ﺌ' };
	public static char[] UCharExA = { 'ﺖ', 'ﭗ', 'ﺐ', 'ﺮ', 'ﺪ', 'ﭻ', 'ﺞ', 'ﺰ',
			'ﻒ', 'ﻖ', 'ﻚ', 'ﺶ', 'ﮓ', 'ﺲ', 'ﯔ', 'ﻦ', 'ﻢ', 'ﯟ', 'ﻞ', 'ﺦ', 'ﻎ',
			'ﮋ', 'ﻲ', 'ﺎ', 'ﻪ', 'ﻮ', 'ﯜ', 'ﯚ', 'ﯘ', 'ﯥ', 'ﻰ', 'ﮫ', 'ﺌ' };
	public static char[] UCharExY = { 'ﺕ', 'ﭖ', 'ﺏ', 'ﺭ', 'ﺩ', 'ﭺ', 'ﺝ', 'ﺯ',
			'ﻑ', 'ﻕ', 'ﻙ', 'ﺵ', 'ﮒ', 'ﺱ', 'ﯓ', 'ﻥ', 'ﻡ', 'ﯞ', 'ﻝ', 'ﺥ', 'ﻍ',
			'ﮊ', 'ﻱ', 'ﺍ', 'ﻩ', 'ﻭ', 'ﯛ', 'ﯙ', 'ﯗ', 'ﯤ', 'ﻯ', 'ﮪ', 'ﺋ' };
	public static char[] UCHARSp = { ' ', '.', '!', 'ﻼ', 'ﻻ', '،', '<', '>',
			'(', ')', '[', ']', '{', '}', '»', '«', '-', '-' };
	public static char[] strDigits = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9' };

	public static String reverseStrs(String value) {
		if (value != null) {
			StringBuilder builder = new StringBuilder(value);
			return builder.reverse().toString();
		}
		return "";
	}
/*
	public static String spiltString(String value, int lineWidth, Paint p) {
		if (TextUtils.isEmpty(value))
			return null;
		if (value.indexOf("\n") == -1 && p.measureText(value) <= lineWidth) {
			return value;
		}
		String rValue = "";
		int spaceIndex = -1; // 表示最后出现的空格的位置
		float drawWidth = 0; // 花字符串的实际宽度
		float charWidth = 0; // 单个字符的宽度
		int start = 0; // 起始位置
		int end = 0; // 结束位置
		String temp = "";
		char[] chars = value.toCharArray(); // 转换为字符数组
		char ch; // 单个的字符
		for (int i = 0; i < chars.length; i++) {
			ch = chars[i];
			if (ch == ' ') // 如果是空格
			{
				spaceIndex = i;
				Log.i(Tag, "发现空格,index=" + i);
			} else if (ch == '\n') // 有换行字符
			{
				end = i;
				if (start == end) {
					spaceIndex = -1;
					drawWidth = 0;
					rValue += "\n";
					continue;
				} else {
					end = i;
					spaceIndex = -1;
					temp = value.substring(start, end);
					rValue += temp + "\n";
				
					start = end;
					drawWidth = 0;
					continue;
				}
			}
			charWidth = p.measureText(chars, i, 1); // 计算单个字符的宽度
		
			if (drawWidth + charWidth >= lineWidth) // 如果加起来的宽度大于区域的宽度
			{
				if (spaceIndex != -1) // 如果有空格
				{
					
					end = i = spaceIndex;
					temp = value.substring(start, end);
					rValue += temp + "\n";
					
					start = end;
					spaceIndex = -1;
				} else // 如果最近没有空格
				{
					
					end = i = i - 1;
					temp = value.substring(start, end);
					rValue += temp + "\n";
					
					start = end;
				}
				drawWidth = 0.0f;

			} else {
				
				drawWidth += charWidth; // 如果小的话累加
			}
		}
		if (start != -1) {
			if (start <= value.length()) {
				if (start == end) {
					end = value.length();
					temp = value.substring(start, end);
				
					rValue += temp + "\n";
				}
			}
		}
		return rValue;
	}
*/
	public static String MyTestBidi(String value, boolean isNeedreverse) {

		// value = reverseStrs(value); // 先颠倒
		int start = -1, end = -1;
		boolean isStarting = false;
		
		List<Integer> idcollaction = new ArrayList<Integer>();
		int index1 = 0, index2 = 0;
		for (int i = 0; i < value.length(); i++) {
			if (!IsUyExChar(value.charAt(i))) {
				isStarting = true;
				idcollaction.add(i);

			} else {
				if (isStarting) {
					index1 = idcollaction.get(0);
					index2 = idcollaction.get(idcollaction.size() - 1);
					value = Inverted(value, index1, index2);
					idcollaction.clear();
					isStarting = false;
				}
			}
		}
		if (isStarting) {
			index1 = idcollaction.get(0);
			index2 = idcollaction.get(idcollaction.size() - 1);
			value = Inverted(value, index1, index2);
		}
		StringBuilder builder = new StringBuilder(value);
		if (isNeedreverse)
			return builder.reverse().toString();
		return builder.toString();
	}

	public static String MyTestBidi2(String value) {

		// value = reverseStrs(value); // 先颠倒
		int start = -1, end = -1;
		boolean isStarting = false;
		List<Integer> idcollaction = new ArrayList<Integer>();
		int index1 = 0, index2 = 0;
		for (int i = 0; i < value.length(); i++) {
			if (IsUyExChar(value.charAt(i))) {
				isStarting = true;
				idcollaction.add(i);

			} else {
				if (isStarting) {
					index1 = idcollaction.get(0);
					index2 = idcollaction.get(idcollaction.size() - 1);
					value = Inverted(value, index1, index2);
					idcollaction.clear();
					isStarting = false;
				}
			}
		}
		if (isStarting) {
			index1 = idcollaction.get(0);
			index2 = idcollaction.get(idcollaction.size() - 1);
			value = Inverted(value, index1, index2);
		}
		return new StringBuilder(value).reverse().toString();
	}

	public static String Inverted(String strValue, int start_index,
			int end_index) {

		StringBuilder builder = new StringBuilder();
		String temp = strValue.substring(start_index, end_index + 1);
		System.out.println("start:" + start_index + ",end:" + end_index
				+ ",subValue=" + temp);
		// temp=reverseStrs(temp);

		for (int i = 0; i < start_index; i++) {
			builder.append(strValue.charAt(i));
		}
		for (int i = 0; i < temp.length(); i++) {
			builder.append(temp.charAt(temp.length() - 1 - i));
		}

		for (int i = end_index + 1; i < strValue.length(); i++) {
			builder.append(strValue.charAt(i));
		}
		return builder.toString();

	}

	// 是维文字符（扩展区）
	public static boolean IsUyExChar(char c) {
		boolean isuy = false;
		if (!isuy)
			isuy = IsUyExChar(c, UCharExA);
		if (!isuy)
			isuy = IsUyExChar(c, UCharExB);
		if (!isuy)
			isuy = IsUyExChar(c, UCharExO);
		if (!isuy)
			isuy = IsUyExChar(c, UCharExY);
		if (!isuy)
			isuy = IsUyExChar(c, UCHARSp);
		return isuy;
	}

	public static boolean IsUyExChar(char c, char[] all) {

		for (int i = 0; i < all.length; i++)
			if (c == all[i])
				return true;
		return false;
	}

	public static boolean isDigit(char ch) {
		for (int i = 0; i < strDigits.length; i++) {
			if (strDigits[i] == ch)
				return true;
		}
		return false;
	}

}
