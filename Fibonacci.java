import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa un número para ver su secuencia Fibonacci:");
        int posicion = scan.nextInt();
        scan.close();
        
        System.out.print("La secuencia del número que escribiste (" + posicion + ") es: ");
        for (int i = 0; i < posicion; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
    
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
