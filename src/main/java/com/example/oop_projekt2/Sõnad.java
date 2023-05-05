package com.example.oop_projekt2;

import java.util.Scanner;

import static java.lang.Math.random;

public class Sõnad {
    private String[] sõnad;

    public Sõnad(String[] sõnad) {
        this.sõnad = sõnad;
    }

    public String suvaline() {
        int suvalineIndeks = (int) (random() * sõnad.length);
        return sõnad[suvalineIndeks];
    }

    //see vihje hakkab sõna algusest tähthaaval vastust andma
    void vihje(String sõna, int n, String lõikamine) {
        String[] sõnaTükid = sõna.split(lõikamine);
        for (int i = 0; i < n; i++) {
            System.out.print(sõnaTükid[i] + lõikamine);
        }
    }

    //see vihje väljastab kõik küsimärgiga tähistatud tähed
    void vihje(String sõna, String teisendatudSõna, String lõikamine) {
        String[] sõnaTükid = sõna.split(lõikamine);
        String[] vihjeTükid = teisendatudSõna.split(lõikamine);
        for (int i = 0; i < sõnaTükid.length; i++) {
            if (sõnaTükid[i].equals("?")) {
                System.out.print(vihjeTükid[i] + lõikamine);
            } else System.out.print(" _ " + lõikamine);
        }

    }

    //sõna morsekeelseks sõnaks
    public String sõnaTeisendus(String sõna, String lõikamine, String sidumine, int indeks1, int indeks2) {
        String[] sõnaTähed = sõna.split(lõikamine);
        String sõnaTeisendus = "";
        Tähed tähed = new Tähed();

        for (String s : sõnaTähed) {
            for (int j = 0; j < tähed.getTähed().length; j++) {
                if (s.equals(tähed.getTähed()[j][indeks1])) {
                    sõnaTeisendus += tähed.getTähed()[j][indeks2] + sidumine;
                }
            }
        }
        if (sidumine.equals("/"))
            sõnaTeisendus = sõnaTeisendus.substring(0, sõnaTeisendus.length() - 1); //kui seotakse "/" sellega, siis siin eemaltatakse viimane kaldkriips
        return sõnaTeisendus;
    }

    public void sõnaVõrdlus(String lõikamine, String sidumine, int indeks1, int indeks2) {

        while (true) {
            String suvalineSõna = suvaline();
            String sõnaTeisendus = sõnaTeisendus(suvalineSõna, lõikamine, sidumine, indeks1, indeks2);
            int valeVastus = 1;
            int sõnaPikkus;

            while (true) {

                System.out.println("Teisenda sõna: " + suvalineSõna);
                Scanner input = new Scanner(System.in);
                System.out.print("Sisesta vastus: ");
                String sisestus = input.nextLine();

                if (sisestus.equals(sõnaTeisendus)) {
                    System.out.println("Õige vastus! \n");
                    break;

                } else {
                    System.out.println("Proovi uuesti! \n");

                    if (sisestus.contains("?")) {
                        System.out.print("vihje: ");
                        vihje(sisestus, sõnaTeisendus,sidumine);
                        System.out.println();

                    } else {

                        if (lõikamine.equals("")) sõnaPikkus = suvalineSõna.length(); //leiab sõna pikkuse
                        else
                            sõnaPikkus = sõnaTeisendus.length();   // kui sõna on algselt morse koodis, siis kasutab teisentatud sõna pikkust


                        if (valeVastus < sõnaPikkus) {          //väljastab vihjeid kuni eelviimase täheni
                            System.out.print("vihje: ");
                            vihje(sõnaTeisendus, valeVastus++, sidumine);
                            System.out.println();
                        } else {
                            System.out.println("Sõna '" + suvalineSõna + "' vastus oli '" + sõnaTeisendus + "'");
                            break;
                        }
                    }
                }
            }

            Scanner input1 = new Scanner(System.in);
            System.out.print("Soovid jätkata? (jah/ei) ");
            String jätkamine = input1.nextLine();

            if (jätkamine.equalsIgnoreCase("ei")){
                System.out.println("Tagasi algusesse :)");
                break;
            }
        }
    }
}
