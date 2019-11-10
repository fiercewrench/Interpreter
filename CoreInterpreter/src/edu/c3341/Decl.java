package edu.c3341;

/**
 * Decl non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface Decl {
	
	/**
	 * Parse the decl to a parse tree node
	 */
	public void ParseDecl();
	
	/**
	 * Print the production of decl
	 */
	public void PrintDecl();
	
	/**
	 * Execute the decl statement
	 */
	public void ExecDecl();
}
