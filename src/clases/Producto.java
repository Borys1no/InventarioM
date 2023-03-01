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
/**
 *
 * @author borys
 */
public class Producto {
    String Nombre_producto;
    Integer Cantidad;
    Float Precio;
    Date Fecha_ingreso;
    String Tipo_producto;
    Date Fecha_caducidad;
    String Proveedor;

  /*  public Producto(String Nombre_producto, Integer Cantidad, Float Precio, Date Fecha_ingreso, String Tipo_producto, Date Fecha_caducidad, String Proveedor) {
        this.Nombre_producto = Nombre_producto;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Fecha_ingreso = Fecha_ingreso;
        this.Tipo_producto = Tipo_producto;
        this.Fecha_caducidad = Fecha_caducidad;
        this.Proveedor = Proveedor;
    }
*/

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
    
    public void InsertarProducto(JTextField NombreProducto, JTextField Cantidad, JTextField Precio, JDateChooser FechaIngreso, JComboBox TipoProducto, JDateChooser FechaCaducidad, JTextField Proveedor ) throws SQLException{
        setNombre_producto(NombreProducto.getText());
        setCantidad(Integer.parseInt(Cantidad.getText()));
        setPrecio(Float.parseFloat(Precio.getText()));
        setFecha_ingreso(FechaIngreso.getDate());
        setTipo_producto(TipoProducto.getSelectedItem().toString());
        setFecha_caducidad(FechaCaducidad.getDate());
        setProveedor(Proveedor.getText());
        
        Conexion obConexion = new Conexion();
         String query ="INSER INTO productos (nombre_producto, cantidad, precio, fecha_ingreso, tipo, fecha_caducidad, proveedor) values(?, ?, ?, ?, ?, ?, ?);";
         
         try {
             CallableStatement cs = obConexion.getConnection().prepareCall(query);
             cs.setString(1, getNombre_producto());
             cs.setInt(2, getCantidad());
             cs.setFloat(3, getPrecio());
             cs.setDate(4, (java.sql.Date) getFecha_ingreso());
             cs.setString(5, getTipo_producto());
             cs.setDate(6, (java.sql.Date) getFecha_caducidad());
             cs.setString(7, getProveedor());
             
             cs.execute();
              
             JOptionPane.showMessageDialog(null, "Se realizó el registro correctamente!");
             
         }catch (Exception e){
             JOptionPane.showMessageDialog(null, "Error al completar el registro, error:"+e.toString());
             
         }
        
        
        
        
    }
    
    
    
    
}
