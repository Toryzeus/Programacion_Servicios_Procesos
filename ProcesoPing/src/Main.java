import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
void main() {
    Process proceso=null;
    try{
        // Detectar el sistema operativo
        String os=System.getProperty("os.name");

        // Preparar el comando dependiendo del sistema operativo
        ProcessBuilder pBuilder;

        if(os.toLowerCase().startsWith("windows")){
            pBuilder=new ProcessBuilder("ping","-n","4","localhost");
        }else{
            pBuilder=new ProcessBuilder("ping","-c","4","localhost");
        }

        // Crear un nuevo proceso
        proceso=pBuilder.start();

        // Obtener el manejador y la información del proceso
        ProcessHandle handle=proceso.toHandle();
        ProcessHandle.Info info=handle.info();

        // Mostrar la información inicial del proceso
        System.out.println("---- Informacion del proceso ----");
        System.out.println("¿Esta vivo?: "+handle.isAlive());
        System.out.println("PID: "+handle.pid());
        System.out.println("Argumentos: "+info.arguments().map(Arrays::toString).orElse("No disponible"));
        System.out.println("Usuario: "+info.user().orElse("No disponible"));

        // Leer y mostrar el resultado del ping
        System.out.println("---- Resultado del ping ----");

        BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

        String linea;

        while ((linea=reader.readLine())!=null){
            System.out.println(linea);
        }

        // Esperar a que termine el proceso
        int resultado=proceso.waitFor();

        // Mostrar el resultado final
        System.out.println("----Resultado final----");
        System.out.println("Codigo de salida: "+resultado);
        System.out.println("¿Ha finalizado correctamente?: "+(resultado==0));
        System.out.println("Sigue vivo?: "+handle.isAlive());
    }catch (Exception e){
        // Mostrar los errores que se produzcan
        e.printStackTrace();
    }
}
