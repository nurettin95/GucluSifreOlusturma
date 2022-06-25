package com.nurettingorsoy.guclusifreolusturma;

import java.security.SecureRandom;

public class SifreUret {

    private SecureRandom random;
    private String sifre;

    private String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private String NUMERIC = "0123456789";
    private String semboller = "{}[]()*/\\,.-_=:;";



    private String karakterleriSec(int len, String dic) {
        String result = "";
        for (int i = 0; i < len; i++) {
            int index = random.nextInt(dic.length());
            result += dic.charAt(index);
        }
        return result;
    }

    private String shuffle(String s)
    {
        char c;
        StringBuffer result = new StringBuffer(s);
        int n = result.length();
        while ( n > 1 )
        {
            int pos1 = random.nextInt(n);
            int pos2 = random.nextInt(n);
            c = result.charAt(pos1);
            result.setCharAt(pos1, result.charAt(pos2));
            result.setCharAt(pos2, c);
            n--;
        }
        return result.toString();
    }


    public String getSifre() {
        return sifre;
    }
    public Boolean kontrol(String kSifre) {
        int i;
        Boolean alphaCapsVar = false;
        Boolean alphaVar = false;
        Boolean numericVar = false;
        Boolean sembolVar = false;
        for (i=0; i < kSifre.length(); i++)
            if (ALPHA_CAPS.indexOf(kSifre.charAt(i)) == -1) {
                alphaCapsVar = true;
                break;
            }
        for (i=0; i < kSifre.length(); i++)
            if (ALPHA.indexOf(kSifre.charAt(i)) == -1) {
                alphaVar = true;
                break;
            }
        for (i=0; i < kSifre.length(); i++)
            if (NUMERIC.indexOf(kSifre.charAt(i)) == -1) {
                numericVar = true;
                break;
            }

        for (i=0; i < kSifre.length(); i++)
            if (semboller.indexOf(kSifre.charAt(i)) == -1) {
                sembolVar = true;
                break;
            }
        return alphaCapsVar && alphaVar && numericVar && sembolVar ;
    }

    SifreUret() {

    }
    SifreUret(int karakterSayisi) {
        random = new SecureRandom();
        sifre = "";
        sifre += karakterleriSec(random.nextInt(karakterSayisi / 3) + 1, ALPHA_CAPS);
        sifre += karakterleriSec(random.nextInt(karakterSayisi / 3) + 1, ALPHA);
        sifre += karakterleriSec(random.nextInt(karakterSayisi / 3) + 1, semboller);
        sifre += karakterleriSec(karakterSayisi - sifre.length(), NUMERIC);
        sifre = shuffle(sifre);
    }
}
