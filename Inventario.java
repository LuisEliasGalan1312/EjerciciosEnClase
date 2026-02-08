public class Inventario {

    public void ejecutar() {
        System.out.println("\n--- Inventario con Arrays de Objetos ---");

        Producto[] listaProductos = new Producto[3];

        listaProductos[0] = new Producto("Monitor Gamer", 15000.0, 5);
        listaProductos[1] = new Producto("Mouse Nitro", 2500.0, 0);
        listaProductos[2] = new Producto("Teclado Mecanico", 4500.0, 10);

        double valorTotal = 0;
        for (Producto p : listaProductos) {
            valorTotal += (p.getPrecio() * p.getStock());
        }
        System.out.println("Productos disponibles en almacen:");
        for (Producto p : listaProductos) {
            if (p.getStock() > 0) {
                System.out.println("- " + p.getNombre() + " | Stock: " + p.getStock() + " | Precio: RD$ " + p.getPrecio());
            }
        }

        System.out.println("\nValor total del inventario: RD$ " + valorTotal);
    }
}