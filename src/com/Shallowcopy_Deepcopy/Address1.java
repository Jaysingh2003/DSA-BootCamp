package com.Shallowcopy_Deepcopy;

class Address1 {
    String city;

    Address1(String city) {
        this.city = city;
    }
}

class Person1 implements Cloneable {
    String name;//
    Address1 address;// reference variable

    @Override
    public Person1 clone() throws CloneNotSupportedException {
        Person1 cloned = (Person1) super.clone(); // shallow copy
        cloned.address = new Address1(this.address.city); // deep copy -> ( steps:- Creates a new Address1 object->Copies the city value from original object->Assigns it to cloned object)
        return cloned;
    }

    public static void main(String[] args) throws Exception {
        Person1 p1 = new Person1();
        p1.name = "abc";
        p1.address = new Address1("Bangalore");

        Person1 p2 = p1.clone();
        p2.address.city = "Mumbai";

        System.out.println(p1.address.city); // Bangalore ✅
    }
}