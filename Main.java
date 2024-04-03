import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        System.out.println("Programmi töö lõpetamiseks kirjuta 'stop'.");
        Scanner scanner = new Scanner(System.in);
        while (running) {
            String sona = sonanetist.valisuvasona();

            System.out.println("Kirjuta järgnev sõna: " + sona);

            long aegStart = System.currentTimeMillis();
            String input = scanner.nextLine();
            long aegLopp = System.currentTimeMillis();
            if (input.equals("stop")) {
                System.out.println("Programm lõpetati!");
                running = false;
            }
            if (input.equals(sona)) {
                long aegKokku = aegLopp - aegStart;
                System.out.println("Tubli! Sul kulus " + aegKokku / 1000 + " sekundit, et see sõna kirjutada.");
            } else {
                if (running)
                    System.out.println("Kahjuks kirjutasid sõna valesti. Tuleme selle juurde tagasi, kui aega jääb: ");
                if (!running) System.out.println("Aitäh, et mängisid! :)");;
            }

        }
        scanner.close();
    }
}
