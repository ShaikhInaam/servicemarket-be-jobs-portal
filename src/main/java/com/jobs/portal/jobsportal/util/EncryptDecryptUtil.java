package com.jobs.portal.jobsportal.util;
public class EncryptDecryptUtil {


    public static String decrypt(String key){

        String value = "";

        for(int i=0; i<key.length(); i++){

            int vl = key.charAt(i);
            vl-=3;
            char ch = (char)vl;
            value=value+ch;
        }

        return value;

    }


}
