package edu.c3341;
import java.util.Set;
/**
 * IdList non-terminal for the Core project
 * @author Renfei Wang
 *
 */
public interface IdList {
	
	/**
	 * Parse the idlist in the DS to a parse tree node
	 */
	public void ParseIdListForDS();
	
	/**
	 * Parse the idlist in the SS to a parse tree node
	 */
	public void ParseIdListForSS();
	
	/**
	 * Print the production of idlist
	 */
	public void PrintIdList();
	
	/**
	 * Execute the assign statement
	 * @param read	if the idlist in the IN non-terminal
	 * @return return a list of id name of the id in the idlist
	 */
	public Set<String> ExecIdList(boolean read);
}
