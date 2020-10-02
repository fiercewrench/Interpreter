package edu.c3341;

/**
 * Comp non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface Comp {
	
	/**
	 * Parse the comp to a parse tree node
	 */
	public void ParseComp();
	
	/**
	 * Print the production of comp
	 */
	public void PrintComp();
	
	/**
	 * Execute the comp statement
	 * @ return the result of evaluating comp
	 */
	public boolean ExecComp();
}
