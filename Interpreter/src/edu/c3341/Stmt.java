package edu.c3341;

/**
 * Stmt non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface Stmt {
	
	/**
	 * Parse the stmt to a parse tree node
	 */
	public void ParseStmt();
	
	/**
	 * Print the production of stmt
	 */
	public void PrintStmt();
	
	/**
	 * Execute the stmt statement
	 */
	public void ExecStmt();
}
