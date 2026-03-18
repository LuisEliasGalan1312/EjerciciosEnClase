class A {
    int x = 10;
}

class B extends A {
    int x = 20;
}

public class OcultamientoAtributos {

    public void ejecutar() {
        System.out.println("\n--- Ocultamiento de Atributos ---");

        A objeto = new B();

        System.out.println("Valor de x: " + objeto.x);
    }
}