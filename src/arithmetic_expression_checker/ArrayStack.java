/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic_expression_checker;

/**
 *
 * @author M S A
 */
public class ArrayStack implements Stack{
  int size;
  Object [] data;
  
  public ArrayStack(int n){
    size=0;
    data = new Object[n];
  }
  
  
  
  public int size()
  {
    return size;
  }
  
  
  public boolean isEmpty()
  {
    boolean b=false;
    if(size==0&&data[size]==null)
    {
      b=true;
    }
    return b;
  }
  
  
  public void push(Object e) 
  {
    data[size]=e;
    size++;
  }
  
  
  public Object pop()
  {
    Object x=null;
    if(size==0&&data[size]==null)
    {
      x=-1;
    }
    else
    {
      x=data[size-1];
      data[size-1]=null;
      size--;
    }
    return x;
  }
  
  
  public Object peek() 
  {
    Object x=null;
    if(size==0&&data[size]==null)
    {
      x=-1;
    }
    else
    {
      x=data[size-1];
    }
    return x;
  }
  
  
  public String toString()
  {
    String s="";
    if(size==0&&data[size]==null)
    {
      s="Empty Stack";
    }
    else
    {
      for(int i=size-1;i>=0;i--)
      {
        s=s.concat(String.valueOf(data[i]));
        s=s+" ";
      }
    }
    return s;
  }
  
  
  public Object[] toArray()
  {
    Object x[]=new Object[size];
    for(int i=0,j=size-1;i<size;i++,j--)
    {
      x[i]=data[j];
    }
    return x;
  }
  
  
  public int search(Object e)
  {
    int x=-1;
    for(int i=size-1,j=0;i>=0;i--,j++)
    {
      if(e==data[i])
      {
        x=j;
      }
    }
    return x;
  }
}
