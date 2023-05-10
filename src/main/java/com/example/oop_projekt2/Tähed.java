package com.example.oop_projekt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.random;

public class Tähed {
    private String[][] tähed;
    private int vihje = 1;//mitmendat korda vihjet küsitakse

    public int getVihje() {
        return vihje;
    }

    public void setVihje(int vihje) {
        this.vihje = vihje;
    }

    public Tähed() {
        this.tähed = new String[][]{{"A", "*-"}, {"B", "-***"}, {"C", "-*-*"}, {"D", "-**"}, {"E", "*"},
                {"F", "**-*"}, {"G", "--*"}, {"H", "****"}, {"I", "**"}, {"J", "*---"}, {"K", "-*-"}, {"L", "*-**"},
                {"M", "--"}, {"N", "-*"}, {"O", "---"}, {"P", "*--*"}, {"Q", "--*-"}, {"R", "*-*"}, {"S", "***"},
                {"Z", "--**"}, {"T", "-"}, {"U", "**-"}, {"V", "***-"}, {"W", "*--"}, {"Ä", "*-*-"}, {"Ö", "---*"}, {"Õ", "---*"},
                {"Ü", "**--"}, {"X", "-**-"}, {"Y", "-*--"}};
        ;
    }

    public String[][] getTähed() {
        return tähed;
    }

    //võtab suvalise tähepaari (täht + täht morses)
    public String[] suvaline() {
        int suvalineIndeks = (int) (random() * tähed.length);
        return tähed[suvalineIndeks];
    }


    // teisendab tähe ja väljastab nii palju sümboleid kui mitmendat korda vihjet küsitakse
    public String vihje(String täht, int n) {
        for (String[] tähepaar : tähed) {
            if (tähepaar[0].equals(täht)) {
                täht = tähepaar[1];
            } else if (tähepaar[1].equals(täht)) {
                täht = tähepaar[0];
            }
        }
        if (n < täht.length()) return täht.substring(0, n);
        else return täht;
    }

    @Override
    public String toString() {
        return "Tähestik: " + Arrays.deepToString(tähed);
        //natuke ilusamaks vaja teha
    }


    //kontrollib kasutaja vastuste õigsust päris vastusega
    //indeks1 = 0  ja indeks2 = 1 ss toimub täht -> morseks
    //indeks1 = 1  ja indeks2 = 0 ss toimub morse -> täheks
    public boolean kontrolli(String kasutajaVastus, String küsimus, int indeks1, int indeks2) {
        for (String[] paar : tähed) {
            if (paar[indeks1].equals(küsimus)) {
                String õigeVastus = paar[indeks2];
                if (õigeVastus.equals(kasutajaVastus)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}

