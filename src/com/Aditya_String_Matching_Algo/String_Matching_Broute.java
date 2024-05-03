package com.Aditya_String_Matching_Algo;



///in this question we find that  string B is the substring of the A; or A contaion the string B
public class String_Matching_Broute {

    public boolean ismatching(String pattern, String text){
        for(int i=0; i <= text.length()-pattern.length(); i++ ){
            int j;// becouse it should we available outside also
            for( j=0; j<pattern.length(); j++){
                if(text.charAt(i+j)!=pattern.charAt(j)){
                    break;
                }
            }
            if(j==pattern.length()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String_Matching_Broute s=new String_Matching_Broute();
        System.out.println(s.ismatching("in", "jay singh"));
    }
}
