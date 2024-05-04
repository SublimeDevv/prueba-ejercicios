import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Edad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Escribe tu año de nacimiento, usando el formato YYYY:");
        String anio = scan.nextLine();

        System.out.println("Escribe tu mes de nacimiento, formato MM");
        String mes = scan.nextLine();

        System.out.println("Escribe tu día de nacimiento, usando el formato dd:");
        String dia = scan.nextLine();

        System.out.println("Escribe tu hora de nacimiento usando el formato hh:mm:ss");
        String hora = scan.nextLine();

        scan.close();

        System.out.println(calcularEdadExacta(anio, mes, dia, hora));
    }

    public static String calcularEdadExacta(String anio, String mes, String dia, String hora) {
        long tiempoActualEnMilisegundos = System.currentTimeMillis();
        Date tiempoActual = new Date(tiempoActualEnMilisegundos);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHoraNacimientoStr = anio + "-" + mes + "-" + dia + " " + hora;
        
        Date fechaHoraNacimiento = null;

        try {
            fechaHoraNacimiento = dateFormat.parse(fechaHoraNacimientoStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        long diferenciaEnMillis = tiempoActual.getTime() - fechaHoraNacimiento.getTime();
        long segundos = diferenciaEnMillis / 1000;
        long minutos = segundos / 60;
        long horas = minutos / 60;
        long dias = horas / 24;
        long anios = dias / 365;

        String edadExacta = String.format("Tu edad es de %d años, %d meses y %d días.", anios, (anios*12)%365, dias%30);
        
        return edadExacta;
    }
}
