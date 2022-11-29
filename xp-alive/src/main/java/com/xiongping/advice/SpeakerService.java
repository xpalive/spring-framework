package com.xiongping.advice;

public class SpeakerService {
    
    public String language() {
        System.out.println("language is english");
        return "english";
    }
    
    public String laugh() {
        String str = "hahaha";
        System.out.println(str);
        return str;
    }
    
    public String cry() {
        String str = "crying";
        System.out.println(str);
        throw new IllegalArgumentException();
    }
}
