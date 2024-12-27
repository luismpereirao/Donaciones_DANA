package Entities;

public class Producto {
    private String producto;
    private int hora;
    private String puntoEntrega;

    public Producto() {
        producto = "";
        hora = 0;
        puntoEntrega = "";
    }

    public Producto(String producto, int hora, String puntoEntrega) {
        this.producto = producto;
        this.hora = hora;
        this.puntoEntrega = puntoEntrega;
    }

    public String getProducto() {
        return this.producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getHora() {
        return this.hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getPuntoEntrega() {
        return this.puntoEntrega;
    }

    public void setPuntoEntrega(String puntoEntrega) {
        this.puntoEntrega = puntoEntrega;
    }

    public Producto producto(String producto) {
        setProducto(producto);
        return this;
    }

    public Producto hora(int hora) {
        setHora(hora);
        return this;
    }

    public Producto puntoEntrega(String puntoEntrega) {
        setPuntoEntrega(puntoEntrega);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " producto='" + getProducto() + "'" +
                ", hora='" + getHora() + "'" +
                ", puntoEntrega='" + getPuntoEntrega() + "'" +
                "}";
    }

}
