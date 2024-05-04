import java.util.Scanner;

public class Ahorcado {
    private static final int intentos = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabraOculta = generarPalabraOculta();
        iniciarJuego(palabraOculta, inicializarPalabraDescubierta(palabraOculta), intentos, scanner);
        scanner.close();
    }

    private static void iniciarJuego(String palabraOculta, String palabraDescubierta, int intentosRestantes, Scanner scanner) {
        System.out.println("-> " + palabraDescubierta + "\nTe quedan " + intentosRestantes + " intentos.");
        
        if (intentosRestantes == 0 || palabraOculta.equals(palabraDescubierta)) {
            System.out.println(intentosRestantes == 0 ? "¡Perdiste! La palabra oculta era: " + palabraOculta : "¡Felicidades! Adivinaste la palabra: " + palabraOculta);
            return;
        }

        System.out.print("Escribe una letra: ");
        char letra = scanner.next().charAt(0);
        
        iniciarJuego(palabraOculta, actualizarPalabra(palabraOculta, palabraDescubierta, letra), letraAdivinada(palabraOculta, letra) ? intentosRestantes : intentosRestantes - 1, scanner);
    }

    private static String generarPalabraOculta() {
        String[] palabras = {"linux", "arch", "php", "utcancun", "microsoft", "teclado", "laravel", "react"};
        return palabras[(int) (Math.random() * palabras.length)];
    }

    private static String inicializarPalabraDescubierta(String palabraOculta) {
        return "_".repeat(palabraOculta.length());
    }

    private static String actualizarPalabra(String palabraOculta, String palabraDescubierta, char letra) {
        StringBuilder nuevaPalabraDescubierta = new StringBuilder();
        
        for (int i = 0; i < palabraOculta.length(); i++) {
            if (palabraOculta.charAt(i) == letra || palabraDescubierta.charAt(i) == palabraOculta.charAt(i)) {
                nuevaPalabraDescubierta.append(palabraOculta.charAt(i));
            } else {
                nuevaPalabraDescubierta.append(palabraDescubierta.charAt(i));
            }
        
        }
        System.out.println(nuevaPalabraDescubierta);
        return nuevaPalabraDescubierta.toString();
    }

    private static boolean letraAdivinada(String palabraOculta, char letra) {
        return palabraOculta.indexOf(letra) != -1;
    }
}
