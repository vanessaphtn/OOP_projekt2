package com.example.oop_projekt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.random;

public class Sõnad {
    private List<String[]> sõnad;
    private Tähed tähed;

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
            String sõnaMorses = morse.substring(0, morse.length()-1);
            sõnaPaarideList.add(new String[]{sõna, sõnaMorses});
            System.out.println(sõna + " " + sõnaMorses); //spikker et näha sõnu morse koodis
        }
        return sõnaPaarideList;
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

}