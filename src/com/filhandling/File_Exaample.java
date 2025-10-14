package com.filhandling;

import java.io.*;

public class File_Exaample {
    public static void main(String[] args) {
        /// create a file
        try {
            File file = new File("/Users/jaysingh/DSA/DSA bootcamp by kunal/src/com/filhandling/file1.txt");//Creates a new File instance
            file.createNewFile();///Atomically creates a new, empty file named by this abstract pathname if and only if a file with this name does not yet exist
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /// write into file
        try{
            FileWriter fw= new FileWriter("/Users/jaysingh/DSA/DSA bootcamp by kunal/src/com/filhandling/file1.txt");
            fw.write("मत्तः परतरं नान्यत्किञ्चिदस्ति धनञ्जय।\n" +
                    "मयि सर्वमिदं प्रोतं सूत्रे मणिगणा इव।।7.7।।");
            fw.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        /// reading from the file -> dirctlt on the console
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/jaysingh/DSA/DSA bootcamp by kunal/src/com/filhandling/file1.txt"))) {
            while (br.ready()) {/// checks if the file has more characters to read.
                System.out.println(br.readLine());
            }
        } catch (IOException e) {//for the exception
            System.out.println(e.getMessage());
        }

        /// delete file
        try {
            File file = new File("/Users/jaysingh/DSA/DSA bootcamp by kunal/src/com/filhandling/random.txt");//Creates a new File instance
            file.createNewFile();// creates a new file
            file.delete();///delete the file at a give directory
            if(file.delete()){
                System.out.println(file.getName()+" is deleted");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
