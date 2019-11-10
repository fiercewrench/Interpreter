package edu.c3341;

/**
 * A helper class
 * @author Renfei Wang
 *
 */
public class Helper {
	/**
	 * print indentation for each nonterminal
	 * @param indent number of levels
	 */
	public static void PrintIndentation(int indent) {
		for(int i = 0; i < indent; i++) {
			System.out.print("   ");
		}
	}

}
