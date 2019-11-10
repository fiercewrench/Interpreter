package edu.c3341;

/**
 * Id non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface Id {
	

	/**
	 * Print the production of Id
	 */
	public void PrintId();
	
	/**
	 * Execute the Id statement
	 * @param read if the Id in the nonterminal of in
	 * @return the id value
	 */
	public int ExecId(boolean read);
}
