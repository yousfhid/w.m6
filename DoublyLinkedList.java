public class DoublyLinkedList<E> {
    //Node
    private static class Node<E>
    {
        private E element;
        private Node<E> p;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            p = p;
            next = n;
        }
        public E getElement() { return element; }
        public Node<E> getP() { return p;}
        public Node<E> getNext() { return next;}
        public void setP(Node<E> p) { p = p; }
        public void setNext(Node<E> n) { next = n; }



    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    //Constructor
    public DoublyLinkedList()
    {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
    }

    //Method

    public boolean isEmpty() { return size == 0; }
    public E First()
    {
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }
    public E Last()
    {
        if(isEmpty()) return null;
        return trailer.getP().getElement();
    }
    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }
    public void addLast(E e){
        addBetween(e, trailer.getP(), trailer);
    }
    public void addBetween(E e, Node<E> predecessor, Node<E> successor)
    {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setP(newest);
        size++;
    }
    public E removeFirst()
    {
        if(isEmpty()) return null;
        return remove(header.getNext());
    }
    public E removeLast()
    {
        if(isEmpty()) return null;
        return remove(trailer.getP());
    }
    public E remove(Node<E> node)
    {
        Node<E> predecessor = node.getP();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setP(predecessor);
        size--;
        return node.getElement();
    }

    // Q1
    public Node<E> DoublyLinkedList()
    {
        if(header.next == null) return null;
        Node<E> x = header;
        int i = 0;
        while(x.getNext() != null){
            x = x.getNext();
   i++;
 }
int y= 0;
  i = i / 2;
 if(i % 2 == 0)
 while(y < i){
 x = x.getP();
     y++;
            }
        else

      while(y <= i){
  x = x.getP();
        y++;
       }
  return x;
    }

    // Q2
    public int size()
    {
        if(header.getNext() == null) return 0;
        int i = 0;
        Node<E> x= header.getNext();
        while(x != trailer){
            x = x.getNext();
            i++;
        }
        return i;
    }

    // Q3
    public boolean equals(DoublyLinkedList l)
    {
        if(this == l)
    return true;
  else if(this.size() == l.size()){
   Node<E> e = this.header.getNext();
  Node<E> e2 = l.header.getNext();
   while(e != null){
                if(e.getElement() != e2.getElement())
              return false;
                e = e.getNext();
                e2 = e2.getNext();
            }
            return true;
        }
        return false;
    }

    // Q4
    public void merge(DoublyLinkedList M)
    {
        if(!isEmpty() && !M.isEmpty()){
            while(!M.isEmpty()){
                addLast((E) M.removeFirst());
            }
        }
    }

    // Q5
    public void oneSentinel()
    {
        trailer.setNext(header.getNext());
        header.getNext().setP(trailer);
        header.setNext(null);
    }

    // Q6
    public void circular()
    {
        oneSentinel();
        Node<E> e = trailer.getNext();
        trailer = trailer.getP();
        trailer.setNext(e);
    }

    // Q7
    public void clone(DoublyLinkedList M) {
        if (!isEmpty() && !M.isEmpty()) {
            while (!isEmpty()) {
                removeFirst();
            }
            Node<E> m = M.header.getNext();
            while (m != M.trailer) {
                addLast(m.getElement());
                m = m.getNext();
            }
        }
    }}}

