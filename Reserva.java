import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {
    private String nombreCliente;
    private Date fechaReserva;
    private int cantidadPersonas;

    public Reserva(String nombre, Date fecha, int cantidad) throws ReservaInvalidaException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ReservaInvalidaException("El nombre del cliente no es valido.");
        }
        if (fecha == null) {
            throw new ReservaInvalidaException("La fecha es obligatoria.");
        }
        if (cantidad <= 0) {
            throw new ReservaInvalidaException("La cantidad de personas debe ser mayor a cero.");
        }

        this.nombreCliente = nombre.trim();
        this.fechaReserva = fecha;
        this.cantidadPersonas = cantidad;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Cliente: " + nombreCliente + " | Fecha: " + sdf.format(fechaReserva) + " | Personas: " + cantidadPersonas;
    }
}