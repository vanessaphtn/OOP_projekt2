import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tähed tähed = new Tähed();

        boolean käib = true;
        while (käib) {
            Juhised.mainJuhised();

            Scanner input = new Scanner(System.in);
            System.out.println("Sisesta täht: ");
            String sisestus = input.nextLine();
            System.out.println("täht:" + sisestus);

            switch (sisestus) {
                case "L" -> käib = false;
                case "N" -> System.out.println(tähed);
                case "T" -> tähed.teisendus(0);
                case "K" -> tähed.teisendus(1);
                //sisestuse kontroll
            }
        }
        System.out.println();
        System.out.println("****/*/*-/-** *-/*/--*/*-!");
        System.out.println("(HEAD AEGA!)");
    }
}
