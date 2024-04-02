import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sona = sonanetist.valisuvasona();

        System.out.println("Kirjuta järgnev sõna: " + sona);

        long aegStart = System.currentTimeMillis();
        String input = scanner.nextLine();
        long aegLopp = System.currentTimeMillis();

        if (input.equals(sona)) {
            long aegKokku = aegLopp - aegStart;
            System.out.println("Tubli! Sul kulus " + aegKokku + " millisekundit, et see sõna kirjutada.");
        } else {
            System.out.println("Kahjuks kirjutasid sõna valesti. Proovi uuesti!");
        }

        scanner.close();
    }
}
