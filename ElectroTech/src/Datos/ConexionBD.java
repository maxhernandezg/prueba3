/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // NOMBRE AL CREAR LA BASE DE DATOS CON MYSQL
    public static String bd = "inventorydb";
    // USUARIO DE MYSQL 
    public static String login = "root";
    // CONTRASEÑA DE MYSQL
    public static String pass = "";
    // DIRECCION PARA LA BASE DE DATOS
    public static String url = "jdbc:mysql://localhost:3306/"+bd;
    
    public static Connection conn;
    public static Statement sentencia;
    
    public static boolean buscarID;
    public static boolean buscarNombre;
    
    public static void conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // AQUI SE PROPORCIONA LA INFORMACION PARA ENTRAR A LA BASE DE DATOS (URL + USUARIO + CONTRASEÑA)
            conn = DriverManager.getConnection(url, login, pass);
            if (conn != null){
                System.out.println("Conexion establecida con "+bd);
            }
        } catch (SQLException e){
            System.out.println("Hubo un problema al conectar");
        } catch (ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    public static void desconectar() throws SQLException{
        conn.close();
    }
}

//
//CREATE database inventoryDB;
//use inventoryDB;

//create table PRODUCT(
//	id int(5) auto_increment,
//    primary key(id),
//    nombre varchar(250),
//    marca varchar(100),
//    categoria varchar(10),
//    precio int(4),
//    stock int(6),
//    fecha_adquisicion (date)
//);
