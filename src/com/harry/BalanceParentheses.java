package com.harry;
import java.util.Stack;


public class BalanceParentheses {

    public boolean matchingPair(char open, char close){
        if(open =='(' && close ==')'){
            return true;
        }else if(open=='{' && close=='}'){
            return true;
        }else if(open=='['&&close==']'){
            return true;
        }else{
            return false;
        }
    }
    public boolean checkBalancedParentheses(String expression){
        char[] exp=expression.toCharArray();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<exp.length;i++){
            if(exp[i] == '(' || exp[i] == '{' || exp[i] == '['){
                st.push(exp[i]);
            }else if(exp[i] == ')' || exp[i] == '}' || exp[i] == ']'){
                if(st.empty() || !matchingPair(st.peek(),exp[i])){
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }
        return st.empty();
    }

    public static void main(String[] args) {
        BalanceParentheses b = new BalanceParentheses();
       // boolean balanced = b.checkBalancedParentheses("{(])}");
       // boolean balanced = b.checkBalancedParentheses("{([])[[)}}");
        boolean balanced = b.checkBalancedParentheses("{([])}");
        if(balanced){
            System.out.println("Parentheses are Balanced");
        }else{
            System.out.println("Parentheses are NOT Balanced");
        }
    }
}
