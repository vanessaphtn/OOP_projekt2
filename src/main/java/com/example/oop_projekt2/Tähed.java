package com.example.oop_projekt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.random;

public class Tähed {
    private String[][] tähed = {{"A", "*-"}, {"B", "-***"}, {"C", "-*-*"}, {"D", "-**"}, {"E", "*"},
            {"F", "**-*"}, {"G", "--*"}, {"H", "****"}, {"I", "**"}, {"J", "*---"}, {"K", "-*-"}, {"L", "*-**"},
            {"M", "--"}, {"N", "-*"}, {"O", "---"}, {"P", "*--*"}, {"Q", "--*-"}, {"R", "*-*"}, {"S", "***"},
            {"Z", "--**"}, {"T", "-"}, {"U", "**-"}, {"V", "***-"}, {"W", "*--"}, {"Ä", "*-*-"}, {"Ö", "---*"}, {"Õ", "---*"},
            {"Ü", "**--"}, {"X", "-**-"}, {"Y", "-*--"}};

    // private String[][] tähed = {{"A", "*-"}, {"B", "-***"}, {"C", "-*-*"}, {"D", "-**"}}; katsetamiseks hea


    public String[][] getTähed() {
        return tähed;
    }

    String[] suvaline() {
        int suvalineIndeks = (int) (random() * tähed.length);
        return tähed[suvalineIndeks];
    }


    // väljastab nii palju sümboleid kui mitu korda ollakse valesti vastanud
    void vihje(String sõna, int n){
        String [] sõnaTükid = sõna.split("");
        for (int i = 0; i < n; i++) {
            System.out.print(sõnaTükid[i]);
        }
    }

    @Override
    public String toString() {
        return "Tähestik: " + Arrays.deepToString(tähed);
        //natuke ilusamaks vaja teha
    }

    void teisendus(int i) {
        int j = 0;
        if (i == 0) j = 1;
        ArrayList<String> õpitudTähed = new ArrayList<>();

        while (true) {
            String[] paar = suvaline();     //õigete vastuste korral tähed ei kordu
            if (õpitudTähed.contains(paar[0])) continue;
            System.out.println("Teisenda: " + paar[i]);
            int valeVastus = 1;

            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.print("Sisesta vastus: ");
                String sisestus = input.nextLine();

                if (sisestus.equals(paar[j])) {
                    System.out.println("Õige vastus \n");
                    õpitudTähed.add(paar[0]);
                    break;
                } else {
                    System.out.println("Proovi uuesti \n");
                    System.out.println("Teisenda: " + paar[i]);
                    if(valeVastus < paar[j].length()){
                        System.out.print("vihje: ");        //kui vastad valesti saad sümbolhaaval vihjeid
                        vihje(paar[j],valeVastus++);
                        System.out.println();
                    } else{
                        System.out.println("Vastus oli: " + paar[j]);
                        break;
                    }

                }
            }
            if (õpitudTähed.size() == tähed.length) {     //kui kõik tähed on korra õigesti kirjutatud, siis programm lõppeb ise
                System.out.println("Kõik on õpitud!");
                break;
            }

            Scanner input = new Scanner(System.in);
            System.out.print("Soovid jätkata? (jah/ei) ");
            String jätkamine = input.nextLine();

            if (jätkamine.equalsIgnoreCase("ei")) {
                System.out.println("Tagasi algusesse :)");
                break;
            }
        }
    }
}

