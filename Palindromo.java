import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Escribe una palabra: ");
        String palabra = scan.nextLine().toLowerCase();
        
        scan.close();

        boolean esPalindromo = esPalindromo(palabra);
        String resultado = esPalindromo ? "Valido." : "Invalido.";
        System.out.println(resultado);
    }

    public static boolean esPalindromo(String palabra) {
        String palabraInvertida = new StringBuilder(palabra).reverse().toString();
        return palabra.equals(palabraInvertida);
    }
}