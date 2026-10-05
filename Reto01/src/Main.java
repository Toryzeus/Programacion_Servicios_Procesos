//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    // Variable donde guardaremos el comando que vamos a ejecutar
    String comando="";

    // Obtiene el directorio personal del usuario
    String userHome=System.getProperty("user.home");

    // Obtiene el directorio de trabajo actual
    String userDir=System.getProperty("user.dir");

    // Obtiene el nombre del sistema operativo
    String systemOS=System.getProperty("os.name");

    // Muestra el directorio personal del usuario
    System.out.println("Directorio del usuario "+userHome);

    // Muestra el directorio de trabajo actual
    System.out.println("Directorio de trabajo "+userDir);

    // Muestra el sistema operativo
    System.out.println("Sistema operativo "+systemOS);

    // Comprueba si el sistema operativo es Linux
    if (systemOS.equalsIgnoreCase("linux")){

        // En Linux utilizamos el comando ls para mostrar los archivos
        comando="sh -c ls";

        // Comprueba si el sistema operativo es Windows
    } else if (systemOS.equalsIgnoreCase("windows")) {

        // En Windows utilizamos el comando dir para mostrar los archivos
        comando="cmd /c dir";
    }

    // Intentamos ejecutar el comando
    try {

        // Creamos un ProcessBuilder utilizando el comando indicado
        ProcessBuilder pBuider=new ProcessBuilder(comando.split("\\s"));

        // Indicamos que el proceso se ejecute en el directorio personal del usuario
        pBuider.directory(new File(userHome));

        // Creamos e iniciamos el proceso
        Process process = pBuider.start();

        // Obtenemos la información que devuelve el proceso
        BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));

        // Leemos cada línea y la mostramos por pantalla
        reader.lines().forEach(System.out::println);

        // Capturamos cualquier error que pueda producirse
    } catch (Exception e) {

        // Mostramos información sobre el error
        e.printStackTrace();
    }
}