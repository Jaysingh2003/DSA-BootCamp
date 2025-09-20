package com.LinkedList;

class Node {
    int data;
    Node next;
    static Node head;
    static Node tail;
    static int size;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }


    //main concept start fron here
    public static class Bubble_sort {
        public void bubbleSort() {
            bubbleSort(size - 1, 0);
        }

        private static void bubbleSort(int row, int col) {
            if (row == 0) {
                return;
            }
            if (row > col) {
                Node first = get(col);
                Node second = get(col + 1);
                if (first.data > second.data) {
                    //swap
                    if (first == head) {
                        head = second;
                        first.next = second.next;
                        second.next = first;
                    } else if (second == tail) {
                        Node prev = get(col - 1);
                        prev.next = second;
                        tail = first;
                        first.next = null;
                        second.next = first;
                    } else {
                        Node prev = get(col - 1);
                        prev.next = second;
                        first.next = second.next;
                        second.next = first;
                    }
                }
                bubbleSort(row, col + 1);
            }else {
                bubbleSort( row-1,0);
            }
        }

        public static Node get(int index) {
            if (index < 0) {
                throw new IndexOutOfBoundsException("Index cannot be negative");
            }
            Node temp = head;
            for (int i = 0; i < index; i++) {
                if (temp == null) {
                    throw new IndexOutOfBoundsException("Index out of bounds");
                }
                temp = temp.next;
            }
            return temp;
        }
        public void insertLast(int val) {
            Node node = new Node(val);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data);
                if (temp.next != null) System.out.print(" -> ");
                temp = temp.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            Bubble_sort list = new Bubble_sort();
            list.insertLast(5);
            list.insertLast(1);
            list.insertLast(4);
            list.insertLast(2);
            list.insertLast(8);

            System.out.print("Before: ");
            list.display();

            list.bubbleSort();

            System.out.print("After:  ");
            list.display();
        }
        }

    }
