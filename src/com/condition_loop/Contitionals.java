package com.condition_loop;

public class Contitionals {
    public static void main(String[] args) {
         int salary=20000;
        if(salary>10000){

            salary += 10000;
        }
        else if (salary>15000){
            salary +=3000;

        }else{
            salary +=1000;
        }
        System.out.println(salary);
    }

}
