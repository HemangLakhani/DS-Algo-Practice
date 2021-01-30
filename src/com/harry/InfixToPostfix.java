package com.harry;

import java.util.Stack;

public class InfixToPostfix {
    static boolean isOpeningParentheses(char c){
        if(c == '(' || c == '{' || c == '[')
            return true;

    return false;
    }
    static boolean isClosingParentheses(char c){
        if(c == ')' || c == '}' || c == ']')
            return true;

    return false;
    }
    static boolean hasHigherPrecedence(char top, char exp){
        if(top == '*' && (exp == '+' || exp == '-'  || exp == '/') ){
            return true;
        }else if(top == '/' && (exp == '+' || exp == '-'  || exp == '*') ){
            return true;
        }else if(top == '+' && exp == '-'){
            return true;
        }else if(top == '-' && exp == '+'){
            return true;
        }else{
            return false;
        }
    }
    static String infixToPostfix(String exp){
        Stack<Character> st = new Stack<>();//to store operators and parentheses
        String postfix = ""; //to store result

        //looping through infix expression
        for(int i=0; i<exp.length();i++){
            char c = exp.charAt(i);
            if(Character.isDigit(c)){
                postfix+=c;
            }else if(c=='+' || c=='-' || c=='*' || c=='/'){
                while(!st.empty() && !isOpeningParentheses(st.peek()) && hasHigherPrecedence(st.peek(),c)){
                    postfix+=st.peek();
                    st.pop();
                }
                st.push(c);
            }else if(isOpeningParentheses(c)){
                st.push(c);
            }else if(isClosingParentheses(c)){
                //loop until you find the opening parentheses for the closing one
                while(!st.empty() && !isOpeningParentheses(st.peek())){
                    postfix+=st.peek();
                    st.pop();
                }
                st.pop(); //removing an opening parentheses from top of the stack
            }
        }
        //at the end of the expression empty the stack if it has any operator left
        while (!st.empty()){
            postfix+=st.peek();
            st.pop();
        }
    return postfix;
    }

    public static void main(String[] args) {
       String postfix= infixToPostfix("((5+8)*9-4)*3");
        System.out.println("Infix to Postfix: " + postfix);
    }
}
