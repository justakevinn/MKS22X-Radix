import java.util.*;
import java.io.*;


public class MyLinkedList<E>{

  private int size;
  private Node start;
  private Node end;


  public MyLinkedList(){
    size = 0;
  }

  public void clear(){
    size = 0;
  }
  public int size(){
    return size;
  }
////////////////////////////////////  ADD  /////////////////////////////////////
  public boolean add(E value){
    if (size() == 0){
      start = new Node(value, null, null);
      end = start;
    }
    else{
      Node current = new Node(value, null, end);
      end.setNext(current);
      end = current;
    }
    size++;
    return true;
  }

  public void add(int index, E value) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }
    Node current = start;
     if(index == 0) {
       Node n = new Node(value, current, null);
       current.setPrev(n);
       start = n;
     }
     else if(index == size){
       add(value);
     }
     else {
       for(int i=0; i< size; i++) {
         if(i == index) {
           Node n = new Node(value, current, current.prev());
           current.prev().setNext(n);
           current.setPrev(n);
         }
         current = current.next();
       }
     }
     size ++;
   }

////////////////////////////////  TO STRING  ///////////////////////////////////
  public String toString(){
    if (size == 0) {
      return "[]";
    }
    String s = "[";
    Node current = start;
    while (current != end){
      s += current.getData() + ", ";
      current = current.next();
    }
    s += current.getData();
    s += "]";
    return s;
  }

  public String toStringBackwards(){
    if (size == 0) {
      return "[]";
    }
    String s = "]";
    Node current = end;
    while (current != start){
      s =  ", " + current.getData() + s;
      current = current.prev();
    }
    s += current.getData();
    s += "[";
    return s;
  }



  ///////////////////////////////  GET & SET  //////////////////////////////////

  private Node getNthNode(int index){
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }
    Node current = start;
    int i= 0;
    while (index != i){
      current = current.next();
      i++;
    }
    return current;
  }

  public E get(int index){
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }
    return (getNthNode(index)).getData();
  }

  public E set(int index,E value){
    Node change = getNthNode(index);
    E temp = change.getData();
    change.setData(value);
    return temp;
  }

//////////////////////////////////  FINDING  ///////////////////////////////////
  public boolean contains(E value){
    Node n = start;
    for (int i = 0; i < size()-1; i++){
      n = n.next();
      if (n.getData() == value){
        return true;
      }
    }
    return false;
  }

  public int indexOf(E value){
    E x = value;
    Node current = start;
    for (int i = 0; i < size; i++){
      if (current.getData().equals(x)){
        return i;
      }
      current = current.next();
    }
    return -1;
  }



///////////////////////////////////  REMOVE  ///////////////////////////////////
  public E remove(int index){
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }

    if (index == 0){
      Node n = start;
      size --;
      start = start.next();
      return n.getData();
    }

    else if (index == size-1){
      Node n = end;
      end = n.prev();
      return n.getData();
    }

    else{
    Node change = getNthNode(index);
    Node prev = change.prev();
    Node next = change.next();
    prev.setNext(next);
    next.setPrev(prev);
    size --;
    return change.getData();
  }
  }



  public boolean remove(E value){
    int i = indexOf(value);
    return (remove(i) == value);
  }


  public void extend(MyLinkedList other){
    this.end.setNext(other.start);
    other.start.setPrev(this.end);
    end = other.end;
    this.size += other.size;
    other.start = other.end = null;
    other.size = 0;
  }



  /******************************************************************************/

  public class Node{
    private E data;
    private Node next;
    private Node prev;


    public Node(E d, Node n, Node p){
      setData(d);
      setNext(n);
      setPrev(p);
    }

    public Node next(){
      return next;
    }

    public Node prev(){
      return prev;
    }

    public void setNext(Node other){
      next = other;
    }

    public void setPrev(Node other){
      prev = other;
    }

    public E getData(){
      return data;
    }

    public E setData(E i){
      E x = data;
      data = i;
      return x;
    }






  }

}
