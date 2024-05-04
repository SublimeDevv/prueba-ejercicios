import java.util.Scanner;

public class Ahorcado {
    private static final int intentos = 5;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = generarPalabraSecreta();
        StringBuilder palabraDescubierta = new StringBuilder("_".repeat(palabraSecreta.length()));

        jugar(palabraSecreta, palabraDescubierta, intentos, scanner);

        scanner.close();
    }

    private static void jugar(String palabraSecreta, StringBuilder palabraDescubierta, int intentosRestantes, Scanner scanner) {
        System.out.println("->" + palabraDescubierta);
        System.out.println("Te quedan " + intentosRestantes + " intentos.");

        if (intentosRestantes == 0) {
            System.out.println("¡Perdiste! La palabra oculta era: " + palabraSecreta);
            return;
        }

        if (palabraSecreta.equals(palabraDescubierta.toString())) {
            System.out.println("¡Felicidades! Adivinaste la palabra: " + palabraSecreta);
            return;
        }

        System.out.print("Escribe una letra: ");
        char letra = scanner.next().charAt(0);

        boolean letraAdivinada = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraDescubierta.setCharAt(i, letra);
                letraAdivinada = true;
            }
        }

        if (!letraAdivinada) {
            intentosRestantes--;
            System.out.println("Letra incorrecta.");
        }

        jugar(palabraSecreta, palabraDescubierta, intentosRestantes, scanner);
    }

    private static String generarPalabraSecreta() {
        String[] palabras = {"linux", "arch", "php", "utcancun", "microsoft", "teclado", "laravel", "react"};
        return palabras[(int) (Math.random() * palabras.length)];
    }
}
