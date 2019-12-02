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
public class Stock {

    public static Stock build(ResultSet rs) throws SQLException {
        Stock stock = new Stock();
        stock.setCodp(rs.getString(1));
        stock.setNome(rs.getString(2));
        stock.setCantidad(rs.getInt(3));
        return stock;
    }
    private String codp;
    private String nome;
    private int cantidad;

    public Stock() {
    }

    public Stock(String codp, String nome, int cantidad) {
        this.codp = codp;
        this.nome = nome;
        this.cantidad = cantidad;
    }

    public String getCodp() {
        return codp;
    }

    public void setCodp(String codp) {
        this.codp = codp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void reducirCantidad(int reduccion){
        this.cantidad -= reduccion;
    }

    @Override
    public String toString() {
        return "Stock{" + "codp=" + codp + ", nome=" + nome + ", cantidad=" + cantidad + '}';
    }

}
