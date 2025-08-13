package com.String;

public class Licence_plate {
    public static void main(String[] args) {

    }
    static String licenseKeyFormatting(String s, int k) {
      StringBuilder formated = new StringBuilder();
        // Remove all dashes and convert to uppercase
      for(char c : s.toCharArray()){
          if(c != '-'){
              formated.append(Character.toUpperCase(c));
          }
      }

        // Determine the size of the first group
        int mod = formated.length() % k;
        StringBuilder result = new StringBuilder();

        // Add the first group if it's not empty
        if (mod > 0) {
            result.append(formated.substring(0, mod)).append("-");
        }

        // Add remaining groups of size 'k'
        for (int i = mod; i < formated.length(); i += k) {
            result.append(formated.substring(i, i + k)).append("-");
        }

        // Remove trailing dash if present
        if (result.length() > 0 && result.charAt(result.length() - 1) == '-') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();

    }

}
