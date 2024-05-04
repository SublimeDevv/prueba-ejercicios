import java.util.Random;

public class Generador {
    private static final String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String caracteres_especiales = "^&*({<!@#$%>})-_=+";

    public static void main(String[] args) {
        String contrasenia = generarContrasenia(8);
        System.out.println("Contraseña generada: " + contrasenia);
    }

    public static String generarContrasenia(int longitud) {
        Random random = new Random();
        StringBuilder contrasenia = new StringBuilder();

        contrasenia.append(caracteres.charAt(random.nextInt(26)));

        contrasenia.append(caracteres_especiales.charAt(random.nextInt(15)));

        for (int i = 0; i < longitud - 2; i++) {
            String todosLosCaracteres = caracteres + caracteres_especiales;
            contrasenia.append(todosLosCaracteres.charAt(random.nextInt(todosLosCaracteres.length())));
        }

        return contrasenia.toString();
    }
}
