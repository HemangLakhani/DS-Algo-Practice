package com.harry.DS;

import java.util.Stack;

public class EvaluatePostfix {

    //this method will support operand with single and multiple digits
    static int evaluatePostfix(String expr){

        //create a stack to store operands
        Stack<Integer> st = new Stack<>();

        //scan the string character one by one
        for(int i=0; i<expr.length();i++){

            //take character from string
            char c = expr.charAt(i);

            if(c==' ')
                continue;
            //if the scanned character is operand (value) push it to the stack
            else if(Character.isDigit(c)){
                int n=0; //for storing multi digit number

                //loop it until character is a number
                while(Character.isDigit(c)){

                    // For a number with more than one digits, as we are scanning from left to right.
                    // Every time , we get a digit towards right, we can multiply current total in operand by 10
                    // and add the new digit.
                    n = n*10 + (c-'0'); //here c - '0' will subtract ascii of '0' from c and will give integer
                    i++; //go to next character
                    c = expr.charAt(i);
                }
                // Finally, you will come out of while loop with i set to a non-numeric character or end of string
                // decrement i because it will be incremented in increment section of the main for loop once again.
                // We do not want to skip the non-numeric character by incrementing i twice.
                i--;

                //push the number to stack
                st.push(n);
            }

            //if the scanned character is operator pop top two element from stack and apply operator
            //remember in postfix the top of the stack will be operand2 and the next will be operand1
            //see your notebook for detail explanation
            else{
                int op2=st.pop();
                int op1=st.pop();
                //check which operator it is and perform an operation
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
        String expression = "100 200 + 2 / 5 * 7 +";
        System.out.println("Expression 1 Evaluation: "+evaluatePostfix(expression));
        String expression2 = "5 8 + 9 * 4 - 3 *";
        System.out.println("Expression 2 Evaluation: "+evaluatePostfix(expression2));

    }
}
