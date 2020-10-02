package edu.c3341;

/**
 * Number non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface No {
	
	/**
	 * Parse the no to a parse tree node
	 */
	public void ParseNo();
	
	/**
	 * Print the production of no
	 */
	public void PrintNo();
	
	/**
	 * Execute the no statement
	 * @return the value of number
	 */
	public int ExecNo();
}
