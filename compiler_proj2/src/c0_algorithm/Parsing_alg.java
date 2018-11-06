package c0_algorithm;

import compiler_proj.*;

import java.io.IOException;
import java.util.*;

import com.oracle.tools.packager.JreUtils.Rule;

public class Parsing_alg {

	private List<ArrayList<char[]>> Final_array = new ArrayList<ArrayList<char[]>>();
	private ArrayList<char[]> start = new ArrayList<char[]>();
	private ArrayList<ArrayList<char[]>> c0 = new ArrayList<ArrayList<char[]>>();

	public Parsing_alg() throws IOException {
		rules rule_ = new rules();

		start = setdot(rule_);
		c0_compute();

		Final_array = c0;

	}

	private void c0_compute() {

		ArrayList<char[]> temp = new ArrayList<char[]>();

		c0.add(start); // set I0

		for (int i = 0; i < c0.size(); i++) {
			ArrayList<Character> ch = new ArrayList<Character>();
			// System.out.println("1");
			for (int j = 0; j < c0.get(i).size(); j++) {
				if (!ch.contains(dotNext(c0.get(i).get(j))))
					if (dotNext(c0.get(i).get(j)) != ']')
						ch.add(dotNext(c0.get(i).get(j)));
			}
			for (char ch_ : ch) {
				temp = GOTO(c0.get(i), ch_);
				if (!is_exist_arrayList(c0, temp))
					c0.add(temp);

			}

		}

	}

	/*
	 * Set dots to existing rules.
	 */
	private ArrayList<char[]> setdot(rules rule_) {
		ArrayList<char[]> setdot_rule = new ArrayList<char[]>();

		for (int i = 0; i < rule_.getRules().size(); i++) {
			char[] rule = rule_.getRules().get(i).toCharArray();

			for (int j = 0; j < rule.length; j++) {
				if (rule[j] == '>') {
					for (int k = rule.length - 1; k > j + 1; k--) {
						rule[k] = rule[k - 1];
					}
					rule[j + 1] = '.';
				}

			}
			setdot_rule.add(rule);
		}

		return setdot_rule;
	}

	/*
	 * move the dot to the right.
	 */
	private char[] movedot(char[] rule) {
		char tmp;
		char[] rule_copy = rule.clone();
		for (int i = 0; i < rule_copy.length; i++) {
			if (rule_copy[i] == '.') {
				tmp = rule_copy[i];
				rule_copy[i] = rule_copy[i + 1];
				rule_copy[i + 1] = '.';
				break;
			}

		}

		return rule_copy;
	}

	/*
	 * Returns the character following the dot.
	 */
	private char dotNext(char[] rule) {
		for (int i = 0; i < rule.length; i++) {
			if (rule[i] == '.')
				return rule[i + 1];
		}
		return 0;

	}

	/*
	 * CLOUSRE..
	 */
	private ArrayList<char[]> CLOSURE(ArrayList<char[]> rules) {

		ArrayList<char[]> list = new ArrayList<char[]>();
		list.addAll(rules);

		for (int i = 0; i < start.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (dotNext(list.get(j)) == start.get(i)[1] && !list.contains(start.get(i))) {
					list.add(start.get(i));
				}
			}

		}

		return list;
	}

	/*
	 * GOTO..
	 */
	private ArrayList<char[]> GOTO(ArrayList<char[]> I, char ch) {
		ArrayList<char[]> tmp = new ArrayList<char[]>();

		for (int i = 0; i < I.size(); i++) {
			if (dotNext(I.get(i)) == ch) {
				tmp.add(movedot(I.get(i)));
			}
		}

		return CLOSURE(tmp);
	}

	/*
	 * compare two ArrayList<char[]>s
	 */
	private boolean compare_charList(ArrayList<char[]> source, ArrayList<char[]> target) {
		if (source.size() != target.size())
			return false;
		else {
			for (int i = 0; i < source.size(); i++) {
				if (source.get(i).length != target.get(i).length)
					return false;
				else {
					for (int j = 0; j < source.get(i).length; j++)
						if (source.get(i)[j] != target.get(i)[j])
							return false;
				}
			}
			return true;

		}

	}

	/*
	 * Return whether 'ArrayList<char[]> target' exists in c0
	 */
	private boolean is_exist_arrayList(ArrayList<ArrayList<char[]>> c0, ArrayList<char[]> target) {
		for (ArrayList<char[]> a : c0) {
			if (compare_charList(a, target))
				return true;
		}

		return false;

	}

	public List<ArrayList<char[]>> getFinal_array() {
		return Final_array;
	}

}
