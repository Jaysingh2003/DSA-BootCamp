package com.oops.acces;

public class Objectclass {

    int num;
    float num2;

    Objectclass(int num, float num2) {
        this.num = num;
        this.num2 = num2;
    }

    public Objectclass() {
        super();
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return  this.num == ((Objectclass) obj).num;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }




    //this metgod is used to clean up resources before the object is garbage collected
    //but now this is deprecated and not recommended to use
//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//    }

    public static void main(String[] args) {
        Objectclass obj1 = new Objectclass(10, 20.5f);
        Objectclass obj2 =new Objectclass(20, 20.5f);


        //it will compare the memory address of the objects
        if(obj1 == obj2) {
            System.out.println("Objects are same");
        }
            //using equals method to compare objects values or content
          if(obj1.equals(obj2)){
           System.out.println("Objects are equal");
         }

        System.out.println(obj1.getClass().getName());
       }




    }


