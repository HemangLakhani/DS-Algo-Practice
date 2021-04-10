package com.harry.DS;

import java.util.Stack;

public class EvaluatePrefix {

    //this method will also support three digit number as operand
    static int evaluatePrefix(String exp){

        //create a stack
        Stack<Integer> st = new Stack<>();

        //scan the expression for each character
        for(int i=exp.length()-1; i>=0; i--){
            char c= exp.charAt(i);
            //if space continue else if operand add to stack else operator evaluate
            if(c==' '){
                continue;
            }else if(Character.isDigit(c)){

                int n=0; //to store multi digit number

                //loop till you find digit
                while(Character.isDigit(c)){

                    n= n*10 + (c - '0'); //convert to number
                    i--;
                    c = exp.charAt(i);
                }
                //The while loop will decrement i in last iteration and the outer for loop will also decrease it. So, the loop will
                //break at the string index end and we don't want to skip one character so increasing i
                i++;

                st.push(n);
            }else{
                //pop top two element from stack but here the top operand will be op1 and the second will be op2 unlike postfix
                int op1 = st.pop();
                int op2 = st.pop();
                switch (c){
                    case '+':
                        st.push(op1+op2);
                        break;
                    case '-':
                        st.push(op1-op2);
                        break;
                    case '*':
                        st.push(op1*op2);
                        break;
                    case '/':
                        st.push(op1/op2);
                        break;
                }
            }
        }
    return st.peek();
    }

    public static void main(String[] args) {
        //prefix
        String exp1="- + * 2 3 * 5 4 9";
        String exp2="- + * 45 3 * 21 78 90";
        System.out.println("Evaluation of Exp1: "+evaluatePrefix(exp1));
        System.out.println("Evaluation of Exp2: "+evaluatePrefix(exp2));
    }
}
