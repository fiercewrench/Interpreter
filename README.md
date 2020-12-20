# Interpreter

## Goal
This is the Core Interpreter project.

The program will read in a source program written in Core Language, and parse, print and execute the source program using recursive descent rules.

## Description of the overall design
Interpreter.java is a test driver. It will read in upto three argument inputs: a program as a file input, a data file input and a string as a flag to determine the interpreter will print the program or not.

Tokenizer1.java is a class file implementing the interface Tokenizer.java. It adopted the Singleton Pattern which means only one instance of that class can be created at a time. It will produce a corresponding stream of token numbers as its output based on the different numbers of token kinds in TokenKind.java.

Each non-terminal has its own class and its own parsing, printing and executing methods. It obeys the recursive descent rules. 

The parsing method for each non-terminal will generate a node for this non-terminal and recursive down to the next level, in order to generate a parse tree. After calling the parse method of the prog, which is the root of the parse tree, it will recursively go down and generate the whole parse tree.

The printing method for each non-terminal will recursively go through all the nodes (object of non-terminal class) in the parse tree and print out each non-terminal.

The executing method for each non-terminal will recursively go through all the nodes (object of non-terminal class) in the parse tree and execute each non-terminal.

## Tokenizer Class

The Tokenizer class is designed according to the singleton pattern,
ensuring that at most one instance will arise from this class.  Hence,
its default constructor is private.  It offers, instead, a static
create(Scanner) method to create the single instance.  It also offers
an instance() static method to obtain the only instance.  The public
methods it offers are as described in the course slides: getToken(),
skipToken(), idName(), and intVal().  The public enum TokenKind is the
type returned by getToken().  Note that skipToken() requires that the
current token not be the EOF token.  The method getToken() can, and
should, be called before the first call to skipToken() in order to get
information about the very first token.

Further notes on the design of the Tokenizer class:

So that the tokenizer instance always has a current token for which to
return information, create(Scanner) gets to the first token by calling
the private method findToken().  The body of skipToken() simply calls
findToken().  The method findToken() is organized as a finite state
automaton (FSA) within logic that obtains the next non-whitespace
string from the Scanner.  The enum State contains the states of the
FSA.  This tokenizer recognizes the "subset" of tokens of the Core
language as described in the Part 1 assignment.

Testing the Tokenizer class:

Eleven test files have been used to test the Tokenizer class using
two test drivers: TokenizerTest and TokenizerTestEnhanced.  The former
conforms to the Part 1 requirements; the latter also provides
information about integers and identifiers, and displays the EOF token.
