public class Impresora implements Runnable {
    //variables de la impresora
    private String nombre;//nombre de la impresora
    private int numPaginas;// numrero de hojas ha imprimir
    private static int contarHilos=0;
    private final int idHilo=contarHilos;

    //constructor
    public Impresora(String nombre, int numPaginas) {
        this.nombre = nombre;
        this.numPaginas = numPaginas;
        contarHilos++;
    }


    @Override
    public void run() {
        //imprime mientras existan paginas
        for(int i=0; i<numPaginas; i++){
            System.out.println("La impresora "+nombre+" esta imprimiendo la pagina "+(i+1)+" de "+numPaginas);
            //descansa un segundo entre pagina y pagina
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //Mensaje de fin de impresion
        System.out.println("Fin de la impresion");
    }
}
