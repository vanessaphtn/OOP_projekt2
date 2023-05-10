package com.example.oop_projekt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.random;

public class Sõnad {
    private List<String[]> sõnad;
    private Tähed tähed;
    private int vihje = 1;//mitmendat korda vihjet küsitakse
    private int kordusedValesti = 0;//mitmendat korda valesti vastatakse, suureneb ka vihje andmisel
    private List<String> selged = new ArrayList<>();

    public List<String> getSelged() {
        return selged;
    }

    public int getVihje() {
        return vihje;
    }

    public void setVihje(int vihje) {
        this.vihje = vihje;
    }

    public int getKordusedValesti() {
        return kordusedValesti;
    }

    public void setKordusedValesti(int kordusedValesti) {
        this.kordusedValesti = kordusedValesti;
    }

    public Sõnad(List<String> sõnad, Tähed tähed) {
        this.tähed = tähed;
        this.sõnad = lisaMorseKood(sõnad);
    }

    //võtab suvalise sõnapaari (sõna + sõna morses) listist
    public String[] suvaline() {
        int suvalineIndeks = (int) (random() * sõnad.size());
        return sõnad.get(suvalineIndeks);
    }

    //kontrollib kasutaja vastuste õigsust päris vastusega
    //indeks1 = 0  ja indeks2 = 1 ss toimub sõna -> morseks
    //indeks1 = 1  ja indeks2 = 0 ss toimub morse -> sõnaks
    public boolean kontrolli(String kasutajaVastus, String küsimus, int indeks1, int indeks2) {
        for (String[] sõna : sõnad) {
            if (sõna[indeks1].equals(küsimus)) {
                String õigeVastus = sõna[indeks2];
                if (õigeVastus.equals(kasutajaVastus)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    //teisendab failist loetud sõnad ka morse koodi ja tagastab listi, mis sisaldab sõnapaare (sõna + sõna morses)
    public List<String[]> lisaMorseKood(List<String> sõnad) {
        List<String[]> sõnaPaarideList = new ArrayList<>();

        for (String sõna : sõnad) {
            String morse = "";
            for (Character täht : sõna.toCharArray()) {
                for (int i = 0; i < tähed.getTähed().length; i++) {
                    if (täht.toString().equals(tähed.getTähed()[i][0])) {
                        morse += tähed.getTähed()[i][1] + "/";
                    }
                }
            }
            String sõnaMorses = morse.substring(0, morse.length() - 1);
            sõnaPaarideList.add(new String[]{sõna, sõnaMorses});
            System.out.println(sõna + " " + sõnaMorses); //spikker et näha sõnu morse koodis
        }
        return sõnaPaarideList;
    }


    //see vihje leiab teisendab sõna vastuseks ja hakkab sõna algusest tähthaaval vastust andma sõltuvalt
    // varasemalt küsitud vihjete arvust
    public String vihje(String sõna, int n) {

        for (String[] sõnapaar : sõnad) {
            if (sõnapaar[0].equals(sõna)) {//kui on antud tavaliste tähtedega
                sõna = sõnapaar[1];
                String[] tähed = sõna.split("/");
                if (n < tähed.length) {
                    sõna = "";
                    for (int i = 0; i < n - 1; i++) {
                        sõna = sõna + tähed[i] + "/";
                    }
                    sõna = sõna + tähed[n - 1];
                }

            } else if (sõnapaar[1].equals(sõna)) {//kui on antud morses
                sõna = sõnapaar[0];
                if (n < sõna.length()) sõna =sõna.substring(0, n);
            }
        }
        return sõna;
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
}