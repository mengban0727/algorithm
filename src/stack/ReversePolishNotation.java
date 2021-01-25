package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangjie
 */
public class ReversePolishNotation {

  public static int evalRPN(String []tokens){
    Deque<Integer> stack = new ArrayDeque<>();
    Integer op1,op2;
    for (String token : tokens) {
      switch (token){
        case "+":
          op2 = stack.pop();
          op1 = stack.pop();
          stack.push(op1+op2);
          break;
        case "-":
          op2 = stack.pop();
          op1 = stack.pop();
          stack.push(op1-op2);
          break;
        case "*":
          op2 = stack.pop();
          op1 = stack.pop();
          stack.push(op1*op2);
          break;
        case "/":
          op2 = stack.pop();
          op1 = stack.pop();
          stack.push(op1/op2);
          break;
        default:
          stack.push(Integer.parseInt(token));
          break;
      }
    }
    return stack.pop();
  }
}
