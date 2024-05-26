package com.stringandstringbuilder;

public class Comparison {
    public static void main(String[] args) {
        String a="jay";
        String b="jay";

        // '==' compares reference identity (whether a and b point to the same object)
        // For string literals Java interns them, so both a and b point to the same interned object here.
        System.out.println(a==b);//it will give the ture value

        // equals() compares the contents (characters) of the strings
        System.out.println(a.equals(b));//it will give the true value

        // Using 'new String(...)' intentionally to create distinct String objects on the heap
        // so we can demonstrate that equals() compares contents while '==' checks reference.
        String c = new String("kunal");
        String d = new String("kunal");

        // equals() still returns true because the character sequences are equal
        System.out.println(c.equals(d));//.eual ponly comaper the value

        // '==' is false because c and d are two distinct String objects allocated on the heap
        System.out.println(c==d);//so it will give the false value beacuse it point to 2 different objcets

        // call the reverse helper so it's used (removes 'method never used' warning)
        System.out.println("reverse of 'hello' = " + reverseString1("hello"));
    }
 //reverse the String
    // O(n) and 0(1)space complixty using StringBuilder
    static String reverseString1 (String str){
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();

    }

    /*
     Note about a map removal line you asked about earlier:
     if (map.get((int) leftChar) == 0) {
         map.remove((int) leftChar);
     }

     Explanation:
     - If you're using a frequency map (e.g., Map<Integer,Integer>) to count occurrences,
       map.get(key) returns the current count for that key.
     - The if-check compares the count to 0. If the count is zero, there's no reason to keep
       the key in the map, so map.remove(key) deletes the key from the map.
     - This keeps the map clean (no entries with zero counts) and can make logic simpler
       when later checking whether a key is present (map.containsKey(key)).

     Caution: ensure map.get(key) won't return null before comparing to 0. A safer pattern:
       Integer cnt = map.get(key);
       if (cnt != null && cnt == 0) map.remove(key);
    */

}
