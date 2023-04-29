public class doubly{
    public static void main(String[] args){
    //testing DoublyLinked class
    DoublyLinked ls = new DoublyLinked(); 
    ls.insert("first");
    ls.insert("second"); 
    DoublyLinked.Node s = ls.insert("third"); //saved the pointer to s
    ls.insert("fourth"); 
    ls.insert("fifth"); 
    ls.delete("first"); 
    ls.delete("second"); 
    ls.delete("fourth");
    ls.insertBefore(s, "first"); 
    ls.print(); 
  }
}
 
 
class DoublyLinked{
  Node head; //ref to the first element
  Node tail; //ref to the last element
  //at all times we keep the pointers to the first and last element of 
  //the doubly linked list (head and tail as above)
  class Node{
    String data; //data of the node, the type can be changed to the desired type
    Node next; 
    Node prev; 
    Node(String data){//constructor, only used when creating new Nodes
      this.data = data; 
    }
  }
  public Node insert(String data){
    Node newNode = new Node(data); //create a new node, and initialize with data
    if(head == null){ //head is null => list empty, so we set head = tail = newNode
      head = tail = newNode; 
      head.prev = null;
      tail.next = null; 
    }else{ // list is not empty
      (tail.next) = newNode; //we insert at the end of the list (after tail)
      newNode.prev = tail; //newNode.prev needs to point to current tail
      newNode.next = null; 
      tail = newNode; //updating the tail reference from main class; 
    }
    return newNode; //returns the pointer to the inserted node
  }
  public void delete(String x){ //delete, with linear search T.C. O(n)
    Node propagate = head; 
    while(propagate != null){
     if(propagate.data.equals(x)){delete(propagate);}; 
      propagate = propagate.next;
    }
  }
  public void delete(Node toDel){ //delete, given a direct pointer O(n)
    if(toDel == null){return;}; 
    if(toDel.prev == null){ //if toDel is the head
      if(toDel.next == null){//case when we only have one node
        head = tail = null; 
      }else{
         head = toDel.next; //change the head pointer
        (toDel.next).prev = null; //change the backwards pointer of the next to null
      }
    }else if(toDel.next == null){ //if toDel is tail (and more than 1 node)
         tail = toDel.prev; //change the tail pointer
        (toDel.prev).next = null; //change the forward pointer of the prev to null
    }else{ //we are in the middle of the list, just reconnect 
        (toDel.next).prev = toDel.prev;
        (toDel.prev).next = toDel.next;
    }
  }

  //below is a method, to insert a node in front of beforeThis node
  public Node insertBefore(Node beforeThis, String replace){
    if(beforeThis == null){return null;}; // => wrong argument
    Node newNode = new Node(replace); //this node will be inserted (val = replace)
    if(beforeThis.prev == null){// case when we are at head
         newNode.next = beforeThis; 
         newNode.prev = null;
         beforeThis.prev = newNode; 
         head = newNode; //update pointer to the head
    }else{// we are somewhere in the middle, no need to update tail
      //since the tail pointer will remain the same when we insert it.
      //all the (this) pointers remain the same when we insert! 
       newNode.prev = beforeThis.prev; 
       (beforeThis.prev).next = newNode;
       newNode.next = beforeThis; 
       beforeThis.prev = newNode; 
    }
    return newNode; //this is the pointer to the newly inserted node
  }
  public void print(){ //method to print out the list values
    Node propagate = head; 
    while(propagate != null){
    System.out.println(propagate.data);
     propagate = propagate.next; 
    }
  }
 
}