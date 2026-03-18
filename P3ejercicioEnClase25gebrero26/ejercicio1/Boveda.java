package ejercicio1;
class Boveda{
    private int saldo = 50000;

    public void retirar(int monto){
        if( saldo >= monto){
            System.out.print("Rerirando: $" + monto + " Saldo restante: $" +  (saldo - monto));
            saldo-= monto;
        }
    }

    public int getSaldo(){
        return saldo;
    }
}