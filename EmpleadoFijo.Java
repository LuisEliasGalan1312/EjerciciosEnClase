plublic class EmpleadoFijo extends Empleado {
    private double salarioMensual;

    public EmpleadoFijo(String nombre, double salarioMensual) {
        super(nombre):
        this.salarioMensual = salarioMensual;
    }

    @override
    public double calcularSalario() {
        return this.salarioMensual;
    }
}

