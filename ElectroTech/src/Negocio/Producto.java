/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;//define el paquete al que pertenece la clase

import Datos.ConexionBD;//importa la clase conexion bd del paquete de datos
import java.sql.ResultSet;//maneja los resultados de consultas sql

/**
 *
 * @author Programacion
 */
//atributos del producto
public class Producto {
    private String nombre, marca, categoria;
    private int precio, stock, id;
    private String fecha_adquisicion;
//constructor
    public Producto() {
    }
//constructor con parametros para inicializar los atributos
    public Producto(String nombre, String marca, String categoria, int precio, int stock, String fecha_adquisicion) {
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.fecha_adquisicion = fecha_adquisicion;
    }
//getters and setters para obtener y establecer valores de los atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    
    public void setFecha_adquisicion(String fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }
    //metodo para agregar un producto a la base de datos
        public void agregarProducto(){//sentencia sql para insertar producto
        try{
            String sql = "insert into PRODUCT (nombre, marca, categoria, precio, stock, fecha_adquisicion) values('"+nombre+"', '"+marca+"','"+categoria+"', "+precio+", "+stock+",'"+fecha_adquisicion+"')";
            ConexionBD.conectar();//conecta a la base de datos
            ConexionBD.sentencia = ConexionBD.conn.prepareStatement(sql);//prepara la sentencia sql
            ConexionBD.sentencia.execute(sql);//ejecuta la sentencia sql
            System.out.println("Los datos fueron almacenados.");
            ConexionBD.desconectar();
        }catch (Exception e){
            System.out.println("Error al agregar el producto: " + e.getMessage());
        }
    }
        
    public void buscarID(){
        
        try{
            ConexionBD.buscarID= false;//se establece la variable en falso al inicio asumiendo que no existe un id
            String sql = "select * from PRODUCT where id = '"+id+"'";//sentencia sql para buscar id en esta parte de la tabla
            ConexionBD.conectar();
            ConexionBD.sentencia = ConexionBD.conn.prepareStatement(sql);
            ResultSet res = ConexionBD.sentencia.executeQuery(sql);
            if (res.next()){
                ConexionBD.buscarID=true;
                id = Integer.parseInt(res.getString(1));
                nombre = res.getString(2);
                marca = res.getString(3);
                categoria = res.getString(4);
                precio = Integer.parseInt(res.getString(5));
                stock = Integer.parseInt(res.getString(6));
                fecha_adquisicion = res.getString(7);
            }
            ConexionBD.desconectar();
        }catch (Exception e){
            System.out.println("Error al buscar ID");
        }
    }
    
        public void buscarNombre(){
        
        try{
            ConexionBD.buscarNombre = false;
            String sql = "select * from PRODUCT where nombre = '"+nombre+"'";
            ConexionBD.conectar();
            ConexionBD.sentencia = ConexionBD.conn.prepareStatement(sql);
            ResultSet res = ConexionBD.sentencia.executeQuery(sql);
            if (res.next()){
                ConexionBD.buscarNombre=true;
                id = Integer.parseInt(res.getString(1));
                nombre = res.getString(2);
                marca = res.getString(3);
                categoria = res.getString(4);
                precio = Integer.parseInt(res.getString(5));
                stock = Integer.parseInt(res.getString(6));
                fecha_adquisicion = res.getString(7);
            }
            ConexionBD.desconectar();
        }catch (Exception e){
            System.out.println("Error al buscar ID");
        }
        
    }
        
        public void actualizarID(){
        try{
            String sql = "update PRODUCT set nombre = '"+nombre+"', marca = '"+marca+"', categoria = '"+categoria+"', precio = "+precio+", stock = "+stock+", fecha_adquisicion = '"+fecha_adquisicion+"' where id = '"+id+"' ";
            ConexionBD.conectar();
            ConexionBD.sentencia = ConexionBD.conn.prepareStatement(sql);
            ConexionBD.sentencia.execute(sql);
            System.out.println("Producto Actualizada");
            ConexionBD.desconectar();
        }catch(Exception e){
            System.out.println("Error al actualizar Producto");
        }
    }
    
    public void actualizarNombre(){
        try{
            String sql = "update PRODUCT set nombre = '"+nombre+"', marca = '"+marca+"', categoria = '"+categoria+"', precio = "+precio+", stock = "+stock+", fecha_adquisicion = '"+fecha_adquisicion+"' where nombre = '"+nombre+"' ";
            ConexionBD.conectar();
            ConexionBD.sentencia = ConexionBD.conn.prepareStatement(sql);
            ConexionBD.sentencia.execute(sql);
            System.out.println("Producto Actualizado");
            ConexionBD.desconectar();
        }catch(Exception e){
            System.out.println("Error al actualizar Producto");
        }
    }
    
    public void eliminar(){
        try{
            String sql = "delete from Product where id = '"+id+"' ";
            ConexionBD.conectar();
            ConexionBD.sentencia = ConexionBD.conn.prepareStatement(sql);
            ConexionBD.sentencia.execute(sql);
            System.out.println("Producto Eliminado");
            ConexionBD.desconectar();
        }catch(Exception e){
            System.out.println("Error al eliminar Producto");
        }
    }
}