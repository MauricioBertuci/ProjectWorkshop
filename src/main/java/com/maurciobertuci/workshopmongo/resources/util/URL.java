package com.maurciobertuci.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    
    public static String decodeParam(String text){
        try{
            return java.net.URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e){
            return "";
        }
    }
}
