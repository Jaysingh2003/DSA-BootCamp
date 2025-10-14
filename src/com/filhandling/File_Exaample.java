package com.filhandling;

import java.io.File;
import java.io.FileWriter;

public class File_Exaample {
    public static void main(String[] args) {
        /// create a file
//        try {
//            File file = new File("/Users/jaysingh/DSA/DSA bootcamp by kunal/src/com/filhandling/file1.txt");//Creates a new File instance
//            file.createNewFile();///Atomically creates a new, empty file named by this abstract pathname if and only if a file with this name does not yet exist
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        /// write in file
        try{
            FileWriter fw= new FileWriter("/Users/jaysingh/DSA/DSA bootcamp by kunal/src/com/filhandling/file1.txt");
            fw.write("मत्तः परतरं नान्यत्किञ्चिदस्ति धनञ्जय।\n" +
                    "मयि सर्वमिदं प्रोतं सूत्रे मणिगणा इव।।7.7।।");
            fw.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
