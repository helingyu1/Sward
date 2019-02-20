package com.classic;

public class RegexPattern {

    private boolean matched = false;
    private char[] pattern;
    private int pLen;

    public RegexPattern(char[] pattern, int pLen){
        this.pattern = pattern;
        this.pLen = pLen;
    }

    public boolean match(char[] text, int tLen){
        matched = false;
        rMatch(0, 0, text, tLen);
        return matched;
    }

    public void rMatch(int ti, int pj, char[] text, int tLen){
        if(matched) return ;
        if(pj == pLen){
            if(ti == tLen){
                matched = true;
                return ;
            }
        }
        // 如果是通配符*
        if(pattern[pj] == '*'){
            for(int k = 0; k < tLen - ti; k++){
                rMatch(ti + k, pj+1, text, tLen);
            }
        }
        // 如果是通配符？
        else if(pattern[pj] == '?'){
            rMatch(ti, pj+1, text, tLen);
            rMatch(ti+1, pj+1, text, tLen);
        }
        // 如果是普通字符
        else if(ti < tLen && pattern[pj] == text[ti]){
            rMatch(ti+1, pj+1, text, tLen);
        }
    }

    public static void main(String[] args) {
        RegexPattern pattern = new RegexPattern("h*l?*u".toCharArray(), 6);
        System.out.println(pattern.match("helingyu".toCharArray(),8));
    }
}
