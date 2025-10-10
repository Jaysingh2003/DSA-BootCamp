package com.filhandling;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try(InputStreamReader isr = new InputStreamReader(System.in)){/// creates a reader to read characters from the console.
            System.out.println("enter any character:");
            int letter= isr.read();///reads the first character as an integer (ASCII value).
            while(isr.ready()){/// eads the first character as an integer (ASCII value).
                System.out.println((char)letter);///prints the character.
                letter= isr.read();///reads the next one.
            }
           /// isr.close();
            System.out.println();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
