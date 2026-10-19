import java.io.BufferedReader;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Error en la construcción del ProcessBuilder
        //ProcessBuilder processBuilder = new ProcessBuilder("ls -l");
        // Proceso para linux con un error
        ProcessBuilder processBuilder = new ProcessBuilder("ls", "-");
        Process process = null;
        try {
            //Lanzo el proceso
            process = processBuilder.start();
            BufferedReader stdOut = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            System.out.println("---- Salida Standard ----");
            stdOut.lines().forEach(System.out::println);
            System.out.println("---- Salida Error ----");
            stdError.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}