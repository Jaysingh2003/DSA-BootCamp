package com.FamousQuestions.string;

public class Remove_character_from_string {
    public String removeCharacter(String str, char ch) {
        StringBuilder result = new StringBuilder();
        for(char c : str.toCharArray()){
            if(c != ch){
                result.append(c);
            }
        }
        return result.toString();

    }

    public static void main(String[] args) {
        Remove_character_from_string remover = new Remove_character_from_string();
        String str = "hello world";
        char ch = 'o';
        String modifiedStr = remover.removeCharacter(str, ch);
        System.out.println("Original String: " + str);
        System.out.println("Modified String: " + modifiedStr);
    }

}
