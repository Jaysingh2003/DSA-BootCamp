package com.Shallowcopy_Deepcopy;


/// this is the sallow copy example, where the reference variable is copied and
///  both the objects are pointing to the same memory location,
/// so if we change the value of one object then it will reflect in another object as well.
///
/// what are the steps
//step-1 Implement the Cloneable interface
//step-2 Override the clone() method and call super.clone() to create a shallow copy of the object.
class Address {
    String city;   // removed private for simplicity

    public Address() {
        this.city = city;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }

    public static void main(String[] args) throws Exception {
        Person p1 = new Person();
        p1.name = "abc";
        p1.address = new Address();// creating a new Address object
        p1.address.city = "Bangalore";

        Person p2 = (Person) p1.clone();
        p2.address.city = "Mumbai";

        System.out.println(p1.address.city); // Mumbai
    }
}