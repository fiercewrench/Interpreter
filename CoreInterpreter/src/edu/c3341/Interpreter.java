package edu.c3341;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Part 1 of Project 1 for CSE 3341. Test a Tokenizer for Core.
 *
 * @author Wayne D. Heym
 *
 */
public final class Interpreter {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Interpreter() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner in1 = null;
        Scanner in2 = null;
        Scanner in3 = null;
        try {
            in1 = new Scanner(Paths.get(args[0]));
        } catch (IOException e) {
            System.err.println("Error opening file: " + args[0]);
            return;
        }
        Tokenizer t = Tokenizer1.create(in1);
        if(args.length > 2) {
        	try {
        		in2 = new Scanner(Paths.get(args[1]));
	        } catch (IOException e) {
	            System.err.println("Error opening file: " + args[1]);
	            return;
	        }
            in3 = new Scanner(args[2]);
        }else if(args.length < 2){
        	System.err.println("Should specify print or not - enter print or doNotPrint");
        	return;	
        }else {
        	in3 = new Scanner(args[1]);
        }
        
        Prog1 prog = new Prog1(t, in2);
        prog.ParseProg();
        if(in3.hasNext()) {
        	String printFlag = in3.next();
        	if(printFlag.equals("print")) {
	        	prog.PrintProg();
	        	System.out.println();
        	}else if(!printFlag.equals("doNotPrint")) {
        		System.err.println("Missing or Invalid print flag");
        		return;
        	}
        }
        
        prog.ExecProg();
        if(in1 != null) {
        	in1.close();
        }
        in1.close();
        if(in2 != null) {
        	in2.close();
        }
        in3.close();
        
    }
    

}
