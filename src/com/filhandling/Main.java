package com.filhandling;

import java.io.*;

import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        /// 1- Using the System.in
        ///menas read  from the console
        try (InputStreamReader isr = new InputStreamReader(System.in)) {/// creates a reader to read characters from the console.
            System.out.println("enter any character:");
            int letter = isr.read();///reads the first character as an integer (ASCII value).
            while (isr.ready()) {/// eads the first character as an integer (ASCII value).
                System.out.println((char) letter);///prints the character.
                letter = isr.read();///reads the next one.
            }
            /// isr.close();
            System.out.println();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /// 2- using the filereader
        try (FileReader fr = new FileReader("/Users/jaysingh/DSA/DSA bootcamp by kunal/src/com/filhandling/note.txt")) {/// creates a reader to read characters from the console.

            int letter = fr.read();///reads the first character as an integer (ASCII value).
            while (fr.ready()) {/// eads the first character as an integer (ASCII value).
                System.out.println((char) letter);///prints the character.
                letter = fr.read();///reads the next one.
            }
            /// isr.close();
            System.out.println();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /// 3- using the bufferdreader
        /// buffers the input so that characters are read in larger chunks rather than one at a time.
        /// if we want to read from console
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {/// it will take the data from the keyboard
        /// buffer to char stream and then read the char stream
            System.out.println(bf.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /// if we want to read from the file
        try (BufferedReader bf = new BufferedReader(new FileReader("/Users/jaysingh/DSA/DSA bootcamp by kunal/src/com/filhandling/note.txt"))) {
            while (bf.ready()) {/// checks if the file has more characters to read.
                System.out.println(bf.readLine());
            }
        } catch (IOException e) {//for the exception
            System.out.println(e.getMessage());
        }

    }
}
