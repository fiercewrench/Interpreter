package edu.c3341;

/**
 * Prog non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface Prog {
	
	/**
	 * Parse the prog to a parse tree node
	 */
	public void ParseProg();
	
	/**
	 * Print the production of prog
	 */
	public void PrintProg();
	
	/**
	 * Execute the prog statement
	 */
	public void ExecProg();
}
