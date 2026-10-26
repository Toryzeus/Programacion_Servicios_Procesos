//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //creamos las impresoras
    Impresora i1=new Impresora("A", 3);
    Impresora i2=new Impresora("B", 5);
    Impresora i3=new Impresora("C", 4);

    //asociamos las impresoras a los Thread
    Thread impresora1=new Thread(i1);
    Thread impresora2=new Thread(i2);
    Thread impresora3=new Thread(i3);

    //Iniciamos las impresoras
    impresora1.start();
    impresora2.start();
    impresora3.start();
}
