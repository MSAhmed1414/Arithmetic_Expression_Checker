/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic_expression_checker;

import java.util.*;

/**
 *
 * @author M S A1
 * 
 */
import java.util.Scanner;
public class Tester{
  public static void main (String[]args){
    Scanner k = new Scanner(System.in);
    int selection;
    while(true){
      try{
        System.out.println("Please, enter:\n1 to select array based stack\n2 to select linked list based stack");
        selection = k.nextInt();
        if(selection!=1 && selection!=2)
          System.err.println("Wrong Selection! Please, try Again.");
        else break;
      }
      catch(Exception e){
        System.err.println("Input Format Mismatch! Please, try Again.");
        k.next();
      }
    }
    System.out.println("Input the expression:");
    String s=k.next();
    Stack stack;
    if(selection==1) stack = new ArrayStack(s.length()*2);
    else stack = new ListStack();
    int count=0;
    for(int i=0;i<s.length();i++)
    {
      
      if(((int)s.charAt(i)==40)||((int)s.charAt(i)==91)||((int)s.charAt(i)==123))
      {
        stack.push(s.charAt(i));
        stack.push(i);
      }
      else if(((int)s.charAt(i)==41)||((int)s.charAt(i)==93)||((int)s.charAt(i)==125))
      {
        if(stack.isEmpty())
        {
          System.out.println("This expression is NOT correct.");
          System.out.println("Error at character#"+(i+1)+".'"+s.charAt(i)+"'-not opened");
          count++;
          break;
        }
        else
        {
          int in1=(int)stack.pop();
          char op=(char)stack.pop();
          int in2=i;
          char cp=s.charAt(i);
          if(((int)op==40&&(int)cp!=41)||((int)op==91&&(int)cp!=93)||((int)op==123&&(int)cp!=125))
          {
            System.out.println("This expression is NOT correct.");
            System.out.println("Error at character # "+(in1+1)+".'"+op+"'-not closed");
            count++;
            break;
          }
          
        }
      }
      
    }
    if(stack.isEmpty()&&count==0)
    {
      System.out.println("This expression is correct.");
    }
    else
    {
      if(count==0)
      {
      int in=(int)stack.pop();
      char opa=(char)stack.pop();
      while((int)stack.peek()!=-1)
      {
        in=(int)stack.pop();
        opa=(char)stack.pop();
      }
      System.out.println("This expression is NOT correct.");
      System.out.println("Error at character # "+(in+1)+".'"+opa+"'-not closed");
      }
    }
  }
}
