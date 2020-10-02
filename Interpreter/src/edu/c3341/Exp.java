package edu.c3341;

/**
 * Exp non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface Exp {
	
	/**
	 * Parse the exp to a parse tree node
	 */
	public void ParseExp();
	
	/**
	 * Print the production of exp
	 */
	public void PrintExp();
	
	/**
	 * Execute the exp statement
	 * @return the result of evaluating exp
	 */
	public int ExecExp();
}
