package edu.c3341;

/**
 * DS non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface DS {
	
	/**
	 * Parse the DS to a parse tree node
	 */
	public void ParseDS();
	
	/**
	 * Print the production of DS
	 */
	public void PrintDS();
	
	/**
	 * Execute the DS statement
	 */
	public void ExecDS();
}
