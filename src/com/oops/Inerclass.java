package com.oops;

 public class Inerclass{

//if i put this then it will shows the error because it depend on the  Inerclass ;
//   class Inner{
//        String name ;
//
//       Inner(String name){
//           this.name=name;
//       }
//
//   }

   //if put the static the  program will work properly because it does not depnds on the object of  Inerclass;
  static class Inner{
        String name ;

        Inner(String name){
            this.name=name;
        }

    }

   //its shows wrong because Inerclass is inside the Inner class which has no object os being created;
    public static void main(String[] args) {
        Inner a = new Inner("jay");
        Inner b = new Inner("alok");

        System.out.println(a.name);
        System.out.println(b.name);
    }
}
