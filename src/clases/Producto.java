/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import com.toedter.calendar.JDateChooser;
import inventariom.Conexion;
import inventariom.Conexion;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 *
 * @author borys
 */
public class Producto {

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

    public void setId_productos(Integer Id_productos) {
        this.id_productos = Id_productos;
    }

    public String getNombre_producto() {
        return Nombre_producto;
    }

    public void setNombre_producto(String Nombre_producto) {
        this.Nombre_producto = Nombre_producto;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }

    public Date getFecha_ingreso() {
        return Fecha_ingreso;
    }

    public void setFecha_ingreso(Date Fecha_ingreso) {
        this.Fecha_ingreso = Fecha_ingreso;
    }

    public String getTipo_producto() {
        return Tipo_producto;
    }

    public void setTipo_producto(String Tipo_producto) {
        this.Tipo_producto = Tipo_producto;
    }

    public Date getFecha_caducidad() {
        return Fecha_caducidad;
    }

    public void setFecha_caducidad(Date Fecha_caducidad) {
        this.Fecha_caducidad = Fecha_caducidad;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public void ModificarProductos(JTextField pId, JTextField pNombreProducto, JTextField pCantidad, JTextField pPrecio,
            JComboBox pTipo, JDateChooser pFechaCaducidad, JTextField pProveedor) {

        setId_productos(Integer.parseInt(pId.getText()));
        setNombre_producto(pNombreProducto.getText());
        setCantidad(Integer.parseInt(pCantidad.getText()));
        setPrecio(Float.parseFloat(pPrecio.getText()));
        setTipo_producto((String) pTipo.getSelectedItem());
        setFecha_caducidad(pFechaCaducidad.getDate());
        setProveedor(pProveedor.getText());
        
        
        Conexion obConexion = new Conexion();
        String query = "UPDATE productos SET nombre_producto=?, cantidad=?, precio=?, tipo=?, fecha_caducidad=?, proveedor=? WHERE id_productos=?";
        
        try {
            CallableStatement cs = obConexion.getConnection().prepareCall(query);
            cs.setString(1, getNombre_producto());
            cs.setInt(2, getCantidad());
            cs.setFloat(3, getPrecio());
            cs.setString(4, getTipo_producto());
            cs.setDate(5, new java.sql.Date(getFecha_caducidad().getTime()));
            cs.setString(6, getProveedor());
            cs.setInt(7, getId_productos());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa!");
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar, error:"+e.toString());
        }
    }
    
    
    public void EliminarProducto(JTextField PIde){
        setId_productos(Integer.parseInt(PIde.getText()));
        Conexion obConexion = new Conexion();
        String query="DELETE FROM productos WHERE id_productos=?";
        
        try {
            CallableStatement cs = obConexion.getConnection().prepareCall(query);
            cs.setInt(1, getId_productos());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se elimino correctamente");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar, error:"+e.toString());
        }
    }

}

