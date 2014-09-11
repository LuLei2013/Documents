package lei.lu.test;

import java.util.Arrays;

/**
 * @author lulei lei.a.lu@ericsson.com
 * @version Sep 11, 2014 7:33:51 PM
 */
public class KMP {

	public static int[] getNext(String target) {
		if (target == null || target.length() == 0)
			return null;
		int[] next = new int[target.length()];
		next[0] = -1;
		int i = 0;
		int j = -1;
		while (i < target.length() - 1) {
			if (j == -1 || target.charAt(i) == target.charAt(j)) {
				i++;
				j++;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
		return next;
	}

	public static int[] getOptionalNext(String target) {
		if (target == null || target.length() == 0)
			return null;
		int[] next = new int[target.length()];
		next[0] = -1;
		int i = 0;
		int j = -1;
		while (i < target.length() - 1) {
			if (j == -1 || target.charAt(i) == target.charAt(j)) {
				i++;
				j++;
				if (target.charAt(i) != target.charAt(j))
					next[i] = j;
				else {
					next[i] = next[j];
				}
			} else {
				j = next[j];
			}
		}
		return next;
	}

	public static int getPosition(String main, String target, boolean isOptional) {

		if (main == null || target == null)
			return -1;
		int[] next = null;
		next = isOptional ? getOptionalNext(target) : getNext(target);
		if (next == null)
			return -1;
		System.out.println(Arrays.toString(next));
		int i, j;
		i = j = 0;
		while (i < main.length()) {
			while (j != -1 && main.charAt(i) != target.charAt(j)) {
				j = next[j];
			}
			if (j == target.length() - 1) {
				return i - target.length() + 1;
			} else {
				j++;
				i++;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(getPosition("abababcabcd", "aaaab", true));
	}
}
