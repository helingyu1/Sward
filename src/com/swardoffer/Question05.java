package com.swardoffer;

public class Question05 {
    /**
     * 替换空格
     */
    public String replaceSpace(StringBuffer str) {
        StringBuffer ret = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                ret.append("%20");
            }else{
                ret.append(str.charAt(i));
            }
        }
        return ret.toString();
    }
}
