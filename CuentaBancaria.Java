public class CuentaBancaria {
    private double saldo;
    private String numeroCuenta;

    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Depósito de RD$" + monto + " realizado.");
        }
    }

public void retirar(double monto) {
    if (monto > 0 && monto <= this.saldo) {
        this.saldo -= monto;
        System.out.println("Retiro de RD$" + monto + " realizado.");
    } else {
        System.out.println("Monto inválido o saldo insuficiente.");
    }
}

    public double getSaldo(){
        return this.saldo;
    }

}