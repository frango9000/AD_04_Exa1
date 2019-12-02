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
public class Precio {

    public static Precio build(ResultSet rs) throws SQLException {
        Precio precio = new Precio();
        precio.setCodp(rs.getString(1));
        precio.setPrezo(rs.getInt(2));
        precio.setDesc(rs.getInt(3));
        return precio;
    }
    
    private String codp;
    private int prezo;
    private int desc;

    public Precio() {
    }

    public Precio(String codp, int prezo, int desc) {
        this.codp = codp;
        this.prezo = prezo;
        this.desc = desc;
    }

    public String getCodp() {
        return codp;
    }

    public void setCodp(String codp) {
        this.codp = codp;
    }

    public int getPrezo() {
        return prezo;
    }

    public void setPrezo(int prezo) {
        this.prezo = prezo;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Precio{" + "codp=" + codp + ", prezo=" + prezo + ", desc=" + desc + '}';
    }
    
    
    
}
