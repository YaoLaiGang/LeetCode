package designLinkedList;

public class MyLinkedList {
    int val;
    MyLinkedList next;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index<0) return -1;
        MyLinkedList p = this;
        int count = 0;
        while (p!=null&&count<index){
            ++count;
            p = p.next;
        }
        if (p==null || p.next==null) return -1;
        return p.next.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        MyLinkedList n = new MyLinkedList();
        n.val = val;
        n.next = this.next;
        this.next = n;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        MyLinkedList p = this, rear = p, n = new MyLinkedList();
        while (p!=null){
            rear = p;
            p = p.next;
        }
        n.val = val;
        rear.next = n;
        n.next = null;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index<0) return;
        MyLinkedList n = new MyLinkedList(), p = this;
        n.val = val;
        int count = 0;
        while (p!=null && count<index){
            p = p.next;
            ++count;
        }
        if (p==null) return;;
        n.next = p.next;
        p.next = n;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index<0) return;
        MyLinkedList p = this, tmp;
        int count = 0;
        while (p!=null&&count<index){
            ++count;
            p = p.next;
        }
        if (p==null||p.next==null) return;
        tmp = p.next;
        p.next = p.next.next;
        tmp.next = null;
    }
}
