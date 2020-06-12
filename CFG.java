//T11_37_4023_Nadeen_Fathallah

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class CFG {
	public String s;

	public CFG(String s) {
		this.s = s;
	}

	public String helper(char t) {
		CFG c = new CFG(s);
		String f = c.First();
		String r = "";
		ArrayList<String> first = new ArrayList<>(Arrays.asList(f.split(";")));
		for (int i = 0; i < first.size(); i++) {
			if (first.get(i).charAt(0) == t) {
				r = first.get(i).substring(2, first.get(i).length());
			}
		}
		return r;
	}

	private static boolean isStringUpperCase(String str) {

		// convert String to char array
		char[] charArray = str.toCharArray();

		for (int i = 0; i < charArray.length; i++) {

			// if any character is not in upper case, return false
			if (!Character.isUpperCase(charArray[i]))
				return false;
		}

		return true;
	}

	public static String sortString(String inputString) {
		// convert input string to char array
		char tempArray[] = inputString.toCharArray();

		// sort tempArray
		Arrays.sort(tempArray);

		// return new sorted string
		return new String(tempArray);
	}

	public static boolean helper1(char current) {
		char[] specialCh = { '!', '@', ']', '#', '$', '%', '^', '&', '*', '(',
				'_', '+', ')' }; // you can specify all special characters in
									// this array

		boolean hasSpecialChar = false;

		for (Character c : specialCh) {
			if (current == c) {
				hasSpecialChar = true;
			}
		}
		return hasSpecialChar;
	}

	public String First() {
		ArrayList<String> rules = new ArrayList<>(Arrays.asList(s.split(";")));
		ArrayList<String> firsts = new ArrayList<String>();
		for (int x = 0; x < rules.size(); x++) {
			String temp = "";
			temp += rules.get(x).charAt(0);
			firsts.add(temp);

		}
		for (int x = 0; x < rules.size(); x++) {
			for (int y = 0; y < rules.get(x).length(); y++) {
				if (Character.isLowerCase(rules.get(x).charAt(y))) {
					String temp = rules.get(x).charAt(y) + "";
					firsts.add(temp);
				}
			}
		}

		for (int i = 0; i < rules.size(); i++) {
			String currentRuleStr = rules.get(i);
			ArrayList<String> currentRule = new ArrayList<>(
					Arrays.asList(currentRuleStr.split(",")));
			for (int j = 1; j < currentRule.size(); j++) {

				// law terminal tamam
				if (Character.isLowerCase(currentRule.get(j).charAt(0))
						|| helper1(currentRule.get(j).charAt(0))) {
					String temp = firsts.get(i) + ","
							+ currentRule.get(j).charAt(0);
					firsts.set(i, temp);
				}
			}
		}
		// test1
		for (int i = 0; i < rules.size(); i++) {
			String currentRuleStr = rules.get(i);
			ArrayList<String> currentRule = new ArrayList<>(
					Arrays.asList(currentRuleStr.split(",")));
			for (int j = 1; j < currentRule.size(); j++) {
				if (Character.isUpperCase(currentRule.get(j).charAt(0))) {
					String save = "";
					for (int s = 0; s < firsts.size(); s++) {
						if (firsts.get(s).charAt(0) == currentRule.get(j)
								.charAt(0)) {
							save = firsts.get(s);
						}
					}
					String temp = firsts.get(i) + save;

					firsts.set(i, temp);
				}
				for (int y = 1; y < currentRule.get(j).length(); y++) {
					boolean beforeHasEpsilon = false;
					boolean allUpper = false;
					int count = 0;
					int count2 = 0;
					for (int s = 0; s < firsts.size(); s++) {
						for (int f = 0; f < y; f++) {
							if (firsts.get(s).charAt(0) == currentRule.get(j)
									.charAt(f) && firsts.get(s).contains("e")) {
								count++;
							}
						}
					}
					for (int q = 0; q < y; q++) {
						if (Character.isUpperCase(currentRule.get(j).charAt(q))) {
							count2++;
						}
					}
					if (count2 == y) {
						allUpper = true;
					}
					if (count == y) {
						beforeHasEpsilon = true;
					}
					if (beforeHasEpsilon && allUpper) {

						String save = "";
						for (int s = 0; s < firsts.size(); s++) {
							if (firsts.get(s).charAt(0) == currentRule.get(j)
									.charAt(y)) {
								save = firsts.get(s);
							}
						}
						String temp = firsts.get(i) + save;
						firsts.set(i, temp);

					}
				}

			}
		}
		// test1

		// test1
		for (int i = 0; i < rules.size(); i++) {
			String currentRuleStr = rules.get(i);
			ArrayList<String> currentRule = new ArrayList<>(
					Arrays.asList(currentRuleStr.split(",")));
			for (int j = 1; j < currentRule.size(); j++) {
				if (Character.isUpperCase(currentRule.get(j).charAt(0))) {
					String save = "";
					for (int s = 0; s < firsts.size(); s++) {
						if (firsts.get(s).charAt(0) == currentRule.get(j)
								.charAt(0)) {
							save = firsts.get(s);
						}
					}
					String temp = firsts.get(i) + save;

					firsts.set(i, temp);
				}
				for (int y = 1; y < currentRule.get(j).length(); y++) {
					boolean beforeHasEpsilon = false;
					boolean allUpper = false;
					int count = 0;
					int count2 = 0;
					for (int s = 0; s < firsts.size(); s++) {
						for (int f = 0; f < y; f++) {
							if (firsts.get(s).charAt(0) == currentRule.get(j)
									.charAt(f) && firsts.get(s).contains("e")) {
								count++;
							}
						}
					}
					for (int q = 0; q < y; q++) {
						if (Character.isUpperCase(currentRule.get(j).charAt(q))) {
							count2++;
						}
					}
					if (count2 == y) {
						allUpper = true;
					}
					if (count == y) {
						beforeHasEpsilon = true;
					}
					if (beforeHasEpsilon && allUpper) {

						String save = "";
						for (int s = 0; s < firsts.size(); s++) {
							if (firsts.get(s).charAt(0) == currentRule.get(j)
									.charAt(y)) {
								save = firsts.get(s);
							}
						}
						String temp = firsts.get(i) + save;
						firsts.set(i, temp);

					}
				}

			}
		}
		// test1

		// test1
		for (int i = 0; i < rules.size(); i++) {
			String currentRuleStr = rules.get(i);
			ArrayList<String> currentRule = new ArrayList<>(
					Arrays.asList(currentRuleStr.split(",")));
			for (int j = 1; j < currentRule.size(); j++) {
				if (Character.isUpperCase(currentRule.get(j).charAt(0))) {
					String save = "";
					for (int s = 0; s < firsts.size(); s++) {
						if (firsts.get(s).charAt(0) == currentRule.get(j)
								.charAt(0)) {
							save = firsts.get(s);
						}
					}
					String temp = firsts.get(i) + save;

					firsts.set(i, temp);
				}
				for (int y = 1; y < currentRule.get(j).length(); y++) {
					boolean beforeHasEpsilon = false;
					boolean allUpper = false;
					int count = 0;
					int count2 = 0;
					for (int s = 0; s < firsts.size(); s++) {
						for (int f = 0; f < y; f++) {
							if (firsts.get(s).charAt(0) == currentRule.get(j)
									.charAt(f) && firsts.get(s).contains("e")) {
								count++;
							}
						}
					}
					for (int q = 0; q < y; q++) {
						if (Character.isUpperCase(currentRule.get(j).charAt(q))) {
							count2++;
						}
					}
					if (count2 == y) {
						allUpper = true;
					}
					if (count == y) {
						beforeHasEpsilon = true;
					}
					if (beforeHasEpsilon && allUpper) {

						String save = "";
						for (int s = 0; s < firsts.size(); s++) {
							if (firsts.get(s).charAt(0) == currentRule.get(j)
									.charAt(y)) {
								save = firsts.get(s);
							}
						}
						String temp = firsts.get(i) + save;
						firsts.set(i, temp);

					}
				}

			}
		}
		// test1
		ArrayList<String> one1 = new ArrayList<String>();
		ArrayList<String> two2 = new ArrayList<String>();

		for (int i = 0; i < rules.size(); i++) {
			String currentRuleStr = rules.get(i);
			ArrayList<String> currentRule = new ArrayList<>(
					Arrays.asList(currentRuleStr.split(",")));

			String one = "false";
			for (int j = 1; j < currentRule.size(); j++) {
				int count = 0;
				if (isStringUpperCase(currentRule.get(j))) {

					for (int e = 0; e < currentRule.get(j).length(); e++) {
						for (int w = 0; w < firsts.size(); w++) {
							if (firsts.get(w).charAt(0) == currentRule.get(j)
									.charAt(e) && firsts.get(w).contains("e")) {
								count++;
							}
						}
					}
					if (currentRule.get(j).length() == count) {
						one = "true";
					}
				}
			}
			one1.add(one);
		}

		// dd
		for (int i = 0; i < rules.size(); i++) {
			String currentRuleStr = rules.get(i);
			ArrayList<String> currentRule = new ArrayList<>(
					Arrays.asList(currentRuleStr.split(",")));
			String two = "false";

			for (int j = 1; j < currentRule.size(); j++) {
				// int count = 0;
				if (currentRule.get(j).equals("e")) {

					two = "true";
				}
			}
			two2.add(two);
		}

		int size = 0;
		for (int q = 0; q < firsts.size(); q++) {
			if (Character.isUpperCase(firsts.get(q).charAt(0))) {
				size++;
			}
		}
		for (int b = 0; b < size; b++) {
			if (one1.get(b).equals("true") || two2.get(b).equals("true")) {
				String p = firsts.get(b) + "e";
				firsts.set(b, p);
			} else {
				String p = firsts.get(b).replaceAll("e", "");
				firsts.set(b, p);
			}
		}

		// dd

		String dd = "";
		for (int r = 0; r < firsts.size(); r++) {
			if (Character.isUpperCase(firsts.get(r).charAt(0))) {
				String temp = "";
				for (int d = 2; d < firsts.get(r).length(); d++) {
					if ((Character.isLowerCase(firsts.get(r).charAt(d)) || helper1(firsts
							.get(r).charAt(d)))
							&& !temp.contains(firsts.get(r).charAt(d) + "")) {
						temp += firsts.get(r).charAt(d);
					}
				}
				dd += firsts.get(r).substring(0, 1) + "," + sortString(temp)
						+ ";";
			}
		}
		return dd.substring(0, dd.length() - 1);
	}

	public String Follow() {
		ArrayList<String> follows = new ArrayList<String>();
		ArrayList<String> rules = new ArrayList<>(Arrays.asList(s.split(";")));
		for (int x = 0; x < rules.size(); x++) {

			String temp = "";
			temp += rules.get(x).charAt(0) + ",";
			if (rules.get(x).charAt(0) == 'S') {
				temp += '$';
			}
			follows.add(temp);

		}

		for (int x = 0; x < follows.size(); x++) {
			String newFollow = follows.get(x);
			for (int i = 0; i < rules.size(); i++) {
				String currentRuleStr = rules.get(i);
				ArrayList<String> currentRule = new ArrayList<>(
						Arrays.asList(currentRuleStr.split(",")));
				for (int g = 1; g < currentRule.size(); g++) {
					for (int q = 0; q < currentRule.get(g).length(); q++) {

						if (currentRule.get(g).charAt(q) == follows.get(x)
								.charAt(0)) {

							int index = q;
							boolean epsilon = false;
							boolean epsilon2 = false;

							if (index < currentRule.get(g).length() - 1) {
								// ba3daha terminal
								if (Character.isLowerCase(currentRule.get(g)
										.charAt(index + 1))) {
									newFollow += currentRule.get(g).charAt(
											index + 1);
								}
								// ba3daha non-terminal
								if (Character.isUpperCase(currentRule.get(g)
										.charAt(index + 1))) {
									// get first of this uppercase char
									CFG test = new CFG(s);
									String temp = test.helper(currentRule
											.get(g).charAt(index + 1));
									if (temp.contains("e")) {
										epsilon = true;
									}
									newFollow += temp.replaceAll("e", "");
								}
								if (epsilon) {

									if (index + 1 < currentRule.get(g).length() - 1) {
										CFG test = new CFG(s);
										String temp = test.helper(currentRule
												.get(g).charAt(index + 2));
										if (temp.contains("e")) {
											epsilon2 = true;
										}
										if (Character.isLowerCase(currentRule
												.get(g).charAt(index + 2))) {
											temp = currentRule.get(g).charAt(
													index + 2)
													+ "";
										}

										newFollow += temp.replaceAll("e", "");

									}
									if (epsilon2) {
										String tmp = "";
										for (int u = 0; u < follows.size(); u++) {
											if (follows.get(u).charAt(0) == currentRule
													.get(0).charAt(0)) {
												tmp += follows
														.get(u)
														.substring(
																2,
																follows.get(u)
																		.length());
											}
										}
										newFollow += tmp.replaceAll("e", "");

									}

									if (index + 1 == currentRule.get(g)
											.length() - 1) {
										String tmp = "";
										for (int u = 0; u < follows.size(); u++) {
											if (follows.get(u).charAt(0) == currentRule
													.get(0).charAt(0)) {
												tmp += follows
														.get(u)
														.substring(
																2,
																follows.get(u)
																		.length());
											}
										}
										newFollow += tmp.replaceAll("e", "");

									}

								}
							}

							if (index == currentRule.get(g).length() - 1) {

								String tmp = "";
								for (int u = 0; u < follows.size(); u++) {
									if (follows.get(u).charAt(0) == currentRule
											.get(0).charAt(0)) {
										tmp += follows.get(u).substring(2,
												follows.get(u).length());
									}
								}
								newFollow += tmp.replaceAll("e", "");

							}
						}
					}
				}
			}
			follows.set(x, newFollow);
		}

		// gg

		for (int x = 0; x < follows.size(); x++) {
			String newFollow = follows.get(x);
			for (int i = 0; i < rules.size(); i++) {
				String currentRuleStr = rules.get(i);
				ArrayList<String> currentRule = new ArrayList<>(
						Arrays.asList(currentRuleStr.split(",")));
				for (int g = 1; g < currentRule.size(); g++) {
					for (int q = 0; q < currentRule.get(g).length(); q++) {

						if (currentRule.get(g).charAt(q) == follows.get(x)
								.charAt(0)) {

							int index = q;
							boolean epsilon = false;
							boolean epsilon2 = false;

							if (index < currentRule.get(g).length() - 1) {
								// ba3daha terminal
								if (Character.isLowerCase(currentRule.get(g)
										.charAt(index + 1))) {
									newFollow += currentRule.get(g).charAt(
											index + 1);
								}
								// ba3daha non-terminal
								if (Character.isUpperCase(currentRule.get(g)
										.charAt(index + 1))) {
									// get first of this uppercase char
									CFG test = new CFG(s);
									String temp = test.helper(currentRule
											.get(g).charAt(index + 1));
									if (temp.contains("e")) {
										epsilon = true;
									}
									newFollow += temp.replaceAll("e", "");
								}
								if (epsilon) {

									if (index + 1 < currentRule.get(g).length() - 1) {
										CFG test = new CFG(s);
										String temp = test.helper(currentRule
												.get(g).charAt(index + 2));
										if (temp.contains("e")) {
											epsilon2 = true;
										}
										if (Character.isLowerCase(currentRule
												.get(g).charAt(index + 2))) {
											temp = currentRule.get(g).charAt(
													index + 2)
													+ "";
										}

										newFollow += temp.replaceAll("e", "");

									}
									if (epsilon2) {
										String tmp = "";
										for (int u = 0; u < follows.size(); u++) {
											if (follows.get(u).charAt(0) == currentRule
													.get(0).charAt(0)) {
												tmp += follows
														.get(u)
														.substring(
																2,
																follows.get(u)
																		.length());
											}
										}
										newFollow += tmp.replaceAll("e", "");

									}

									if (index + 1 == currentRule.get(g)
											.length() - 1) {
										String tmp = "";
										for (int u = 0; u < follows.size(); u++) {
											if (follows.get(u).charAt(0) == currentRule
													.get(0).charAt(0)) {
												tmp += follows
														.get(u)
														.substring(
																2,
																follows.get(u)
																		.length());
											}
										}
										newFollow += tmp.replaceAll("e", "");

									}

								}
							}

							if (index == currentRule.get(g).length() - 1) {

								String tmp = "";
								for (int u = 0; u < follows.size(); u++) {
									if (follows.get(u).charAt(0) == currentRule
											.get(0).charAt(0)) {
										tmp += follows.get(u).substring(2,
												follows.get(u).length());
									}
								}
								newFollow += tmp.replaceAll("e", "");

							}
						}
					}
				}
			}
			follows.set(x, newFollow);
		}

		// gg
		for (int i = 0; i < follows.size(); i++) {
			String t = follows.get(i).substring(2, follows.get(i).length());

			String r = "";
			for (int j = 0; j < t.length(); j++) {
				if (!r.contains(t.charAt(j) + "")) {
					r += t.charAt(j);
				}
			}
			r = sortString(r);
			if (r.contains('$' + "")) {
				r = r.substring(1, r.length());
				r += "$";
			}
			String replace = follows.get(i).substring(0, 2) + r;
			follows.set(i, replace);
		}
		String zz = "";
		for (int u = 0; u < follows.size(); u++) {
			zz += follows.get(u).replaceAll("\\s", "") + ";";
		}
		return zz.substring(0, zz.length() - 1);
	}

	public ArrayList<Character> getNonTerminals() {
		ArrayList<String> rules = new ArrayList<>(Arrays.asList(s.split(";")));
		ArrayList<Character> vars = new ArrayList<Character>();
		for (int i = 0; i < rules.size(); i++) {
			String tmp1 = rules.get(i);
			vars.add(tmp1.charAt(0));
		}
		return vars;
	}

	public ArrayList<Character> getTerminals() {
		ArrayList<String> rules = new ArrayList<>(Arrays.asList(s.split(";")));
		ArrayList<Character> vars = new ArrayList<Character>();
		for (int i = 0; i < rules.size(); i++) {
			for (int j = 0; j < rules.get(i).length(); j++) {
				if ((rules.get(i).charAt(j) == '$' || Character
						.isLowerCase(rules.get(i).charAt(j)))
						&& rules.get(i).charAt(j) != 'e')
					vars.add(rules.get(i).charAt(j));
			}
		}
		ArrayList<Character> r = new ArrayList<Character>();
		for (int x = 0; x < vars.size(); x++) {
			if (!r.contains(vars.get(x))) {
				r.add(vars.get(x));
			}
		}
		return r;
	}

	public static void main(String[] args) {
		String input = "S,aA;A,SB,e;B,pA,mA";
		CFG cfg = new CFG(input);
		String firstEncoding = cfg.First();
		String followEncoding = cfg.Follow();
		System.out.println("First: " + firstEncoding);
		System.out.println("Follow: " + followEncoding);
		
	}
}
