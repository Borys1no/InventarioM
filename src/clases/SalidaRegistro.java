/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import com.mysql.cj.xdevapi.Statement;
import inventariom.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.ResultSet;



/**
 *
 * @author borys
 */
public class SalidaRegistro {
    Integer id_productos;
    String Nombre_producto;
    Integer Cantidad;
    Float Precio;
    Date Fecha_ingreso;
    String Tipo_producto;
    Date Fecha_caducidad;
    String Proveedor;

    public Integer getId_productos() {
        return id_productos;
    }

    public String getNombre_producto() {
        return Nombre_producto;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public Float getPrecio() {
        return Precio;
    }

    public Date getFecha_ingreso() {
        return Fecha_ingreso;
    }

    public String getTipo_producto() {
        return Tipo_producto;
    }

    public Date getFecha_caducidad() {
        return Fecha_caducidad;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setId_productos(Integer id_productos) {
        this.id_productos = id_productos;
    }

    public void setNombre_producto(String Nombre_producto) {
        this.Nombre_producto = Nombre_producto;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }

    public void setFecha_ingreso(Date Fecha_ingreso) {
        this.Fecha_ingreso = Fecha_ingreso;
    }

    public void setTipo_producto(String Tipo_producto) {
        this.Tipo_producto = Tipo_producto;
    }

    public void setFecha_caducidad(Date Fecha_caducidad) {
        this.Fecha_caducidad = Fecha_caducidad;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }
    
    
   
}
