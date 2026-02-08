class Producto{
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        setPrecio(precio);
        setStock(stock);
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("Precio no puede ser negativo.");
        }
    }

    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        if(stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Stock no puede ser negativo.");
        }
    }

    public void vender(int cantidad){
        if(cantidad > 0 && cantidad <= stock){
            stock -= cantidad;
            System.out.println("Venta realizada. Nuevo stock:" + stock);
        }else{
            System.out.println("No hay suficiente stock o cantidad inválida.");
        }
    }
}