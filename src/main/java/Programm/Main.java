package Programm;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Tähed tähed = new Tähed();
        Sõnad sõnad1 = new Sõnad(new String[]{"-*-/*-/***/***", "-*-/---/*/*-*", "*/--/*-", "**/***/*-", "***-/*/-*/-**", "---*/-**/*", "-*-/---/---/*-**"});
        Sõnad sõnad2 = new Sõnad(new String[]{"KASS", "KOER", "EMA", "ISA", "VEND", "ÕDE", "KOOL"});

        boolean käib = true;
        while (käib) {
            Juhised.mainJuhised();

            Scanner input = new Scanner(System.in);
            System.out.print("Sisesta täht: ");
            String sisestus = input.nextLine();

            switch (sisestus) {
                case "L" -> käib = false;
                case "J" -> Juhised.sisestus();
                case "N" -> System.out.println(tähed);
                case "T" -> tähed.teisendus(0);
                case "K" -> tähed.teisendus(1);
                case "S" -> sõnad2.sõnaVõrdlus("","/",0,1);
                case "M" -> sõnad1.sõnaVõrdlus("/", "",1,0);
                //sisestuse kontroll
            }
        }
        System.out.println();
        System.out.println("****/*/*-/-** *-/*/--*/*-!");
        System.out.println("(HEAD AEGA!)");
    }
}
