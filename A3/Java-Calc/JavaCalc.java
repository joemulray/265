/**
*@author Joseph Mulray
* Assignment 3 Java-Calc
*November 20 2016
*The purpose of this file is to parses an infix expression into postfix, and then evaluates it.
*Parses infix expressions into appropriate tokens and stores them into an ArrayList
*/	 

import java.io.*;
import java.util.*;



/**
*Public Class JavaCalc, used to convern infix expression into postfix
*/
public class JavaCalc{

	/**
	*Purpose of this class is to convert infix to postFix, and return a Stack of postfix expressions.
	* @param is an ArrayList of Tokens in infix form
	* @return value is a Stack object of Tokens. 
	*/ 
	public static Stack<Token> infix2postfix(ArrayList<Token> infix){



	Stack<Token> postfix = new Stack<Token>();
	Stack<Operator> opStack = new Stack<Operator>();	

	//operand, append it to the postfix expression.
		for(Token tokenVal : infix){

				if(tokenVal.isOperand()){

					postfix.push(tokenVal);
				}
				//left paren, push it onto the stack
				else
				{ 

					if((((Operator)tokenVal).getVal().getName()).equals("(")){

							opStack.push((Operator)tokenVal);
						}

					//right paren, pop operators from the stack and append to the postfix expression
					//until a left paren is encountered on the stack
				    else if((((Operator)tokenVal).getVal().getName()).equals(")")){

			                	while (! LParen(opStack.peek())) {

			                    	postfix.push(opStack.pop());
			                		}
			                
			                	opStack.pop();
			            	}
			        else if (tokenVal.isOperator()) {
			        		//operator, then pop operators from the stack and append to the postfix expression
			        		//while the operators have equal or higher precedence than the current token
			                while(!opStack.isEmpty() && compareOps((Operator)tokenVal,opStack.peek())) {

			                    	postfix.push(opStack.pop());
			                		}

			                	opStack.push((Operator)tokenVal);
			            	}
		    	}
	    }

        		while (!opStack.isEmpty()) {

        	    	postfix.push(opStack.pop());
    	   		}

        return postfix;
    }

   	/**
   	*Helper function to compare two operator values, avoids EmptyStackException.
   	*@param Takes in two Operator values, the token from the Infix expressions, and the other from the Stack
   	*@return returns a boolean value depending on compare values.
   	*/
	 public static boolean compareOps(Operator tokenVal, Operator popVal) 
    {
    	return (Operator.compare(tokenVal, popVal) == 0 || Operator.compare(tokenVal, popVal) == 1);
    }



   	/**
   	*Function to parse incoming lines from file. Uses string tokenizer to split values from list.
   	*@param Takes a string value from file input
   	*@return returns an ArrayList of Token objects.
   	*/
	public static ArrayList<Token> parseInfix(String line){

		//uses tokenizer to parse earch character in a line
		ArrayList<Token> tokens = new ArrayList<Token>();
		StringTokenizer tk = new StringTokenizer(line," ");		


		//assign given operators or operands for each token
		while(tk.hasMoreTokens()){
			
			String value = tk.nextToken();
		
			switch(value){
			
			case "+":
				tokens.add( new Operator(opType.ADD) );
				break;
			case "-":
				tokens.add( new Operator(opType.SUB) );
				break;
				
			case "*":
				tokens.add( new Operator(opType.MULT) );
				break;
			case "/":	
				tokens.add( new Operator(opType.DIV) );
				break;
			case "%":
				tokens.add( new Operator(opType.MOD) );
				break;
			case "(":
				tokens.add( new Operator(opType.LPAR) );
				break;
			case ")":
				tokens.add( new Operator(opType.RPAR) );
				break;
			default:
				tokens.add( new Operand(Integer.parseInt(value)) );
				break;
				
				}						

		}		
		
		return tokens;
	}

   	/**
   	*Helper function takes one Token value, returns boolean value of token Operator.
   	*@param Takes token Operator
   	*@return returns a boolean value depending on if token value equals LParen
   	*/
    public static boolean LParen(Token token) 
   	{
        return ((Operator)token).getVal().getName() == "(";
    }


   	/**
   	*Function to evaluate a Postfix expression, takes in a Stack of Tokens compares the values token values and
   	* 
   	*@param takes in the postfix expression after evaluated from infix2Postfix
   	*@return returns integer value of the final result of the evaluation
   	*/
	public static int evalPostfix(Stack<Token> postfix){



		Stack<Token> evalFinal = new Stack<Token>();
		for (Token tokens : postfix){
		
			if(tokens.isOperand()){
	
				evalFinal.push((Operand)tokens);		
	
				}
			
			else{

				String operatorVal = (((Operator)tokens).getVal().getName());
		
				int x = ((Operand)evalFinal.pop()).getVal();		
				int y = ((Operand)evalFinal.pop()).getVal();		



					if (operatorVal.equals("+")) {
						evalFinal.push(new Operand(x + y));
					} 
					else if (operatorVal.equals("-")) {
						evalFinal.push(new Operand(y - x));
					} 
					else if (operatorVal.equals("*")) {
						evalFinal.push(new Operand(x * y));
					} 
					else if (operatorVal.equals("/")) {
						evalFinal.push(new Operand(y / x));
					}
					else {
						evalFinal.push(new Operand(y % x));
					}

				} 	
				
			}
		
		return ((Operand)evalFinal.pop()).getVal();

	}


	/**
	*Main function
	*/ 
	public static void main(String [] args)throws IOException{

	File infixFile = new File(args[0]);
	Scanner inputFile = new Scanner(infixFile);
	
	while(inputFile.hasNext()){
	
			String line = inputFile.nextLine();
			ArrayList<Token> infix = parseInfix(line);
				
			Stack<Token> postFixTk = infix2postfix(infix);
	
			for(Token token: postFixTk){
			
				if (token.isOperator()){
					System.out.print(((Operator)token).getVal().getName() + " ");
				}
				else{
					System.out.print(((Operand)token).getVal() + " ");
				}
		
		}	
			try{

				System.out.println("= " + evalPostfix(postFixTk));
			}
			catch(ArithmeticException e){System.out.println("= 0");}
			catch(EmptyStackException e){}
			System.out.println();

		}

	}
}

