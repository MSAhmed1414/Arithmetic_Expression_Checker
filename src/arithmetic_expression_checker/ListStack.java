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
public class ListStack implements Stack{
    int size;
    Node top;
  
    
    public ListStack(){
        size = 0;
        top = null;
    }
    
    
    
    public int size()
     {
       return size;
     }
     
     
     public boolean isEmpty()
     {
       boolean b=false;
      if(size==0&&top==null)
      {
        b=true;
      }
      return b;
     }
     
     
      public void push(Object e)
      {
        Node x=top;
        Node n=new Node(e,null);
        top=n;
        top.next=x;
        size++;
       
        
      }
      
      
      public Object pop()
      {
        Object x=null;
        if(size==0&&top.val==null)
        {
          x='0';
        }
        else
        {
          x=top.val;
          Node temp=top;
          top=top.next;
          temp.val=null;
          size--;
        }
        return x;
      }
      
      
       public Object peek() 
       {
         Object x=null;
         if(size==0&&top==null)
         {
          x='0';
         }
         else
         {
           x=top.val;
         }
        return x;
       }
       
       
       public String toString()
       {
        String s="";
        if(size==0&&top==null)
        {
          s="Empty Stack";
        }
        else
        {
          for(Node i=top;i!=null;i=i.next)
          {
            s=s.concat(String.valueOf(i.val));
            s=s+" ";
          }
        }
        return s;
       }
       
       
       public Object[] toArray()
       {
         Object x[]=new Object[size];
         int j=0;
         for(Node i=top;i!=null;i=i.next)
         {
           x[j]=i.val;
           j++;
         }
         return x;
       }
       
       
        public int search(Object e)
        {
          int x=-1;
          int j=0;
          for(Node i=top;i!=null;i=i.next)
          {
            if(e==i.val)
            {
              x=j;
            }
            j++;
          }
          return x;
        }
}
