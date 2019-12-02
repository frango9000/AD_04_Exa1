/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_exa_01.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oracle
 */
public class Venta {

    private int nv;
    private String codp;
    private int cantidad;
    private boolean descuento;
    
    

    public Venta() {
    }

    public Venta(int nv, String codp, int cantidad, boolean descuento) {
        this.nv = nv;
        this.codp = codp;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public int getNv() {
        return nv;
    }

    public void setNv(int nv) {
        this.nv = nv;
    }

    public String getCodp() {
        return codp;
    }

    public void setCodp(String codp) {
        this.codp = codp;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Venta{" + "nv=" + nv + ", codp=" + codp + ", cantidad=" + cantidad + ", descuento=" + descuento + '}';
    }
    
    
    public static Venta build(ResultSet rs) throws SQLException {
        
       Venta venta = new Venta();
       venta.setNv(rs.getInt(1));
       venta.setCodp(rs.getString(2));
       venta.setCantidad(rs.getInt(3));
       venta.setDescuento((rs.getString(4).charAt(0) == 's'));
       return venta;
    }
    
    
}
