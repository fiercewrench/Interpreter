package edu.c3341;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Tokenizer for Core Interpreter project.
 * 
 * @author Renfei Wang
 *
 */
public class Tokenizer1 implements Tokenizer {
	/**
	 * The token we will get
	 */
	private StringBuilder front;
	/**
	 * The first part of the remainder that we will process
	 */
	private String head;
	/**
	 * The char position during looping and get the special symbol from head
	 */
	private int pos;
	/**
	 * The remainder without head
	 */
	private Iterator<String> restOfRemainder;
	/**
	 * The token kind of the token
	 */
	private TokenKind kind;
	/**
	 * Singleton pattern. The instance of the class
	 */
	private static Tokenizer1 instance = null;
	/**
	 * The boolean value to determine if we need to jump to the next token
	 */
	private boolean skip = true;

	/**
	 * The set contains all the special symbols
	 */
	private Set<Character> symbols;

	/**
	 * private constructor. Only can be called from the class.
	 * 
	 * @param itString
	 *            the program String
	 */
	private Tokenizer1(Iterator<String> itString) {
		this.front = new StringBuilder();
		this.restOfRemainder = itString;
		this.head = this.restOfRemainder.next();
		this.pos = 0;
		this.kind = null;
		String symbolStr = ";,=![]&|()+-*<>";
		symbols = new HashSet<>();
		for (char ch : symbolStr.toCharArray()) {
			this.symbols.add(ch);
		}
	}

	/**
	 * Singleton pattern. Only one instance of this class can be created.
	 * 
	 * @param itString
	 *            the program String
	 * @return the instance of this class
	 */
	public static Tokenizer1 create(Iterator<String> itString) {
		if (instance == null) {
			instance = new Tokenizer1(itString);
		}
		return instance;
	}
	
	public static Tokenizer1 instance() {
		return instance;
	}

	// after the create is call, call the gettoken to get the first token, gettoken
	// called findtoken
	// pos has some value that strictly less than the length of head - loop until ..
	// needed to be nested in a big loop
	// ask the restofremainder . hasNext()
	// call next(), put into the head, set pos = 0, process
	// find what state I'm in
	/**
	 * Find the token.
	 * 
	 * @updates this.front, this.kind
	 * @ensures this.front * this.head * this.restOfRemainder =
	 *          AGGREGATE(~#itString.unseen)
	 */
	private void findToken() {
		// System.out.println(this.head);
		if (this.head == "EOF") {
			this.kind = TokenKind.EOF;
		} else if (this.head.charAt(0) == ';') {
			this.kind = TokenKind.SEMICOLON;
			this.front.append(";");
			if (this.head.length() > 1) {
				skip = false;
				this.pos = 1;
			}
		} else if (this.head.charAt(0) == ',') {
			this.kind = TokenKind.COMMA;
			this.front.append(",");
			if (this.head.length() > 1) {
				skip = false;
				this.pos = 1;
			}
		} else if (this.head.charAt(0) == '!') {
			this.kind = TokenKind.NOT_OPERATOR;
			this.front.append("!");
			if (this.head.length() > 1) {
				if (this.head.charAt(1) == '=') {
					this.front.append("=");
					this.kind = TokenKind.INEQUALITY_TEST;
					if (this.head.length() > 2) {
						skip = false;
						this.pos = 2;
					}
				} else {
					skip = false;
					this.pos = 1;
				}
			}
		} else if (this.head.charAt(0) == '[') {
			this.kind = TokenKind.LEFT_SQUARE_BRACKET;
			this.front.append("[");
			if (this.head.length() > 1) {
				skip = false;
				this.pos = 1;
			}
		} else if (this.head.charAt(0) == ']') {
			this.kind = TokenKind.RIGHT_SQUARE_BRACKET;
			this.front.append("]");
			if (this.head.length() > 1) {
				skip = false;
				this.pos = 1;
			}
		} else if (this.head.charAt(0) == '(') {
			this.kind = TokenKind.LEFT_PARENTHESIS;
			this.front.append("(");
			if (this.head.length() > 1) {
				skip = false;
				this.pos = 1;
			}
		} else if (this.head.charAt(0) == ')') {
			this.kind = TokenKind.RIGHT_PARENTHESIS;
			this.front.append(")");
			if (this.head.length() > 1) {
				skip = false;
				this.pos = 1;
			}
		} else if (this.head.charAt(0) == '<') {
			this.kind = TokenKind.LESS_THAN;
			this.front.append("<");
			if (this.head.length() > 1) {
				if (this.head.charAt(1) == '=') {
					this.front.append("=");
					this.kind = TokenKind.LESS_THAN_OR_EQUAL;
					if (this.head.length() > 2) {
						skip = false;
						this.pos = 2;
					}
				} else {
					skip = false;
					this.pos = 1;
				}

			}
		} else if (this.head.charAt(0) == '>') {
			this.kind = TokenKind.GREATER_THAN;
			this.front.append(">");
			if (this.head.length() > 1) {
				if (this.head.charAt(1) == '=') {
					this.front.append("=");
					this.kind = TokenKind.GREATER_THAN_OR_EQUAL;
					if (this.head.length() > 2) {
						skip = false;
						this.pos = 2;
					}
				} else {
					skip = false;
					this.pos = 1;
				}

			}
		} else if (this.head.charAt(0) == '+') {
			this.kind = TokenKind.ADDITION_OPERATOR;
			this.front.append("+");
			if (this.head.length() > 1) {
				skip = false;
				this.pos = 1;
			}
		} else if (this.head.charAt(0) == '-') {
			this.kind = TokenKind.SUBTRACTION_OPERATOR;
			this.front.append("-");
			if (this.head.length() > 1) {
				skip = false;
				this.pos = 1;
			}
		} else if (this.head.charAt(0) == '*') {
			this.kind = TokenKind.MULTIPLICATION_OPERATOR;
			this.front.append("*");
			if (this.head.length() > 1) {
				skip = false;
				this.pos = 1;
			}
		} else if (this.head.charAt(0) == '=') {
			this.front.append("=");
			this.kind = TokenKind.ASSIGNMENT_OPERATOR;
			if (this.head.length() > 1) {
				if (this.head.charAt(1) == '=') {
					this.front.append("=");
					this.kind = TokenKind.EQUALITY_TEST;
					if (this.head.length() > 2) {
						skip = false;
						this.pos = 2;
					}
				} else {
					skip = false;
					this.pos = 1;
				}
			}

		} else if (this.head.charAt(0) == '|') {
			if (this.head.length() > 1 && this.head.charAt(1) == '|') {
				this.front.append("||");
				this.kind = TokenKind.OR_OPERATOR;
				if (this.head.length() > 2) {
					skip = false;
					this.pos = 2;
				}
			} else {
				this.kind = TokenKind.ERROR;
			}
		} else if (this.head.charAt(0) == '&') {
			if (this.head.length() > 1 && this.head.charAt(1) == '&') {
				this.front.append("&&");
				this.kind = TokenKind.AND_OPERATOR;
				if (this.head.length() > 2) {
					skip = false;
					this.pos = 2;
				}
			} else {
				this.kind = TokenKind.ERROR;
			}
		} else if (Character.isUpperCase(this.head.charAt(pos))) {
			boolean previousDigit = false;
			this.kind = TokenKind.IDENTIFIER;
			while (pos < this.head.length()) {
				if (Character.isUpperCase(this.head.charAt(pos))) {
					if (previousDigit) {
						this.kind = TokenKind.ERROR;
						break;
					}
					this.front.append(this.head.charAt(pos));
				} else if (Character.isDigit(this.head.charAt(pos))) {
					this.front.append(this.head.charAt(pos));
					previousDigit = true;
				} else {
					if (Character.isLowerCase(this.head.charAt(pos))) {
						this.kind = TokenKind.ERROR;
					} else if (this.symbols.contains(this.head.charAt(pos))) {
						skip = false;
					}
					break;
				}
				pos++;
			}

		} else if (Character.isLowerCase(this.head.charAt(pos))) {
			while (pos < this.head.length()) {
				if (Character.isLowerCase(this.head.charAt(pos))) {
					this.front.append(this.head.charAt(pos));
				} else {
					if (Character.isUpperCase(this.head.charAt(pos)) || Character.isDigit(this.head.charAt(pos))) {
						this.kind = TokenKind.ERROR;
					} else if (this.symbols.contains(this.head.charAt(pos))) {
						skip = false;
					}
					break;
				}
				pos++;
			}
			if (this.kind != TokenKind.ERROR) {
				switch (this.front.toString()) {
				case "program":
					this.kind = TokenKind.PROGRAM;
					break;
				case "begin":
					this.kind = TokenKind.BEGIN;
					break;
				case "end":
					this.kind = TokenKind.END;
					break;
				case "int":
					this.kind = TokenKind.INT;
					break;
				case "if":
					this.kind = TokenKind.IF;
					break;
				case "then":
					this.kind = TokenKind.THEN;
					break;
				case "else":
					this.kind = TokenKind.ELSE;
					break;
				case "while":
					this.kind = TokenKind.WHILE;
					break;
				case "loop":
					this.kind = TokenKind.LOOP;
					break;
				case "read":
					this.kind = TokenKind.READ;
					break;
				case "write":
					this.kind = TokenKind.WRITE;
					break;
				}
			}

		} else if (Character.isDigit(this.head.charAt(pos))) {
			this.kind = TokenKind.INTEGER_CONSTANT;
			while (pos < this.head.length()) {
				if (Character.isDigit(this.head.charAt(pos))) {
					this.front.append(this.head.charAt(pos));
				} else {
					if (Character.isUpperCase(this.head.charAt(pos)) || Character.isLowerCase(this.head.charAt(pos))) {
						this.kind = TokenKind.ERROR;
					} else if (this.symbols.contains(this.head.charAt(pos))) {
						skip = false;
					}
					break;
				}
				pos++;
			}

		} else {
			this.kind = TokenKind.ERROR;
		}
	}

	/**
	 * Return the kind of the front token. (Restores this.)
	 *
	 * @return the kind of the front token
	 * @ensures getToken = [the kind of token this.front]
	 */
	@Override
	public TokenKind getToken() {
		this.pos = 0;
		this.front = new StringBuilder();
		findToken();
		return this.kind;
	}

	/**
	 * Skip front token.
	 *
	 * @updates this
	 * @ensures
	 * 
	 *          <pre>
	 * (if [the token kind of #this.front is good and legal]
	 *                  then this.front * this.remainder = #this.remainder)  or
	 *          ([the token kind of #this.front is EOF] and
	 *          this = #this)
	 *          </pre>
	 */
	@Override
	public void skipToken() {
		if (!skip) {
			this.head = this.head.substring(pos);
			skip = true;
		} else {
			if (this.restOfRemainder.hasNext()) {
				this.head = this.restOfRemainder.next();
			} else {
				this.head = "EOF";
			}
		}
	}

	@Override
	public int intVal() {
		return Integer.parseInt(this.front.toString());
	}

	@Override
	public String idName() {
		return this.front.toString();
	}
}
