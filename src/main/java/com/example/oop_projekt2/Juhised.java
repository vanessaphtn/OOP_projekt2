package com.example.oop_projekt2;
import java.util.Scanner;

public class Juhised {
    static void mainJuhised() {
        System.out.println();
        System.out.println("Vali ülesanne:");
        System.out.println("N - näita tähestikku");
        System.out.println("J - programmi juhised");
        System.out.println("T - tähed morse koodiks");
        System.out.println("K - morse kood tähtedeks");
        System.out.println("S - sõna morse koodi");
        System.out.println("M - morse kood sõnaks");
        System.out.println();
        System.out.println("Lõpetamiseks sisesta L");
        System.out.println();
    }

    static void sisestus() {
        while(true) {
            System.out.println(" Selles programmis saab 4 erinevat ülesannet lahendada:");
            System.out.println("1) tähti morse koodi teisendada \n" +
                    "2) sõnasid morse koodi teisendada \n" +
                    "3) tähti morse koodist eesti keelde teisendada \n" +
                    "4) sõnasid morse koodist eesti keelde teisendada");
            System.out.println("\n Teisenduse reeglid: ");
            System.out.println("1) Sidekriips tähistab pikka signaali ja tärn lühikest");
            System.out.println("2) Kõik tähed on trükitähed (nt: ISA)");
            System.out.println("3) Kahe morse koodi tähe vahele läheb '/' (nt: **/***/*-)");
            System.out.println("\n Vihjed:");
            System.out.println("1) Ülesandes 'tähed morse koodiks' annab programm sümbolhaaval vihjeid,\n" +
                    "kui vastus valesti sisestada");
            System.out.println("2) Sõnade teisendusel on kaks erinevat vihjet:");
            System.out.println("2.1) Kui sisestada vigane või tühi vastus annab programm sõna algusest tähthaaval vihjeid");
            System.out.println("2.2) Kui sisestada vastus nii, et teadmata tähed asendada '?' annab programm vihje ainult");
            System.out.println("teadamata tähtede kohta (nt: I?A -> _ /***/ _ / või **/?/*- -> _ S _ )");

            Scanner input = new Scanner(System.in);
            System.out.print("\n Juhendist lahkumiseks sisesta 'L': ");
            String sisestus = input.nextLine();

            if(sisestus.equals("L"))break;
        }
    }

    static void ülesanne() {
        System.out.println("Sisesta antud tähele vastav kood!");
        System.out.println("Sisesta antud koodile vastav täht!");
        sisestus();
    }
}
