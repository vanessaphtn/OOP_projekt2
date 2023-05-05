public class Juhised {
    static void mainJuhised() {
        System.out.println();
        System.out.println("Vali ülesanne:");
        System.out.println("N - näita tähestikku");
        System.out.println("T - tähed morse koodiks");
        System.out.println("K - morse kood tähtedeks");
        System.out.println();
        System.out.println("Lõpetamiseks sisesta L");
        System.out.println();
    }

    static void sisestus(){
        System.out.println("Sidekriips tähistab pikka signaali ja tärn lühikest");
        System.out.println("Kõik tähed on trükitähed");
    }
    static void ülesanne(){
        System.out.println("Sisesta antud tähele vastav kood!");
        System.out.println("Sisesta antud koodile vastav täht!");
        sisestus();
    }
}
