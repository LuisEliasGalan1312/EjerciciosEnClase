abstract class Figura {
    public abstract double area();
}

class Cuadrado extends Figura {
    private double lado;
    public Cuadrado(double lado) {
        this.lado = lado; }
    @Override
    public double area() {
        return lado * lado; }
}

class Rectangulo extends Figura {
    private double base, altura;
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double area() {
        return base * altura; }
}

class Circulo extends Figura {
    private double radio;
    public Circulo(double radio) {
        this.radio = radio; }
    @Override
    public double area() {
        return Math.PI * Math.pow(radio, 2); }
}

public class FigurasGeometricas {

    public void ejecutar() {
        System.out.println("\n--- Figuras ---");

        Figura[] figuras = new Figura[3];
        figuras[0] = new Cuadrado(10);
        figuras[1] = new Rectangulo(5, 8);
        figuras[2] = new Circulo(4);

        for (Figura f : figuras) {
            System.out.println("Area de la figura: " + f.area());
        }
    }
}