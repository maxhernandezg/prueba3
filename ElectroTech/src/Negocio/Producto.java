/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Datos.ConexionBD;

/**
 *
 * @author Programacion
 */
public class Producto {
    private String nombre, marca, categoria;
    private int precio, stock;
    private String fecha_adquisicion;

    public Producto() {
    }

    public Producto(String nombre, String marca, String categoria, int precio, int stock, String fecha_adquisicion) {
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    // METODOS CUSTOMER
    
    public void setFecha_adquisicion(String fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }
    
        public void agregarProducto(){
        try{
            String sql = "insert into PRODUCT (nombre, marca, categoria, precio, stock, fecha_adquisicion) values('"+nombre+"', '"+marca+"','"+categoria+"', "+precio+", "+stock+",'"+fecha_adquisicion+"')";
            ConexionBD.conectar();
            ConexionBD.sentencia = ConexionBD.conn.prepareStatement(sql);
            ConexionBD.sentencia.execute(sql);
            System.out.println("Los datos fueron almacenados.");
            ConexionBD.desconectar();
        }catch (Exception e){
            System.out.println("Error al agregar el producto: " + e.getMessage());
        }
    }
    
}
