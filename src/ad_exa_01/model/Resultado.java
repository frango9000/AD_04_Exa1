/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_exa_01.model;

/**
 *
 * @author oracle
 */
public class Resultado {
    private int nv;
    private String nomp;
    private int cant;
    private int total;

    public Resultado() {
    }

    public Resultado(int nv, String nomp, int cant, int total) {
        this.nv = nv;
        this.nomp = nomp;
        this.cant = cant;
        this.total = total;
    }

    public int getNv() {
        return nv;
    }

    public void setNv(int nv) {
        this.nv = nv;
    }

    public String getNomp() {
        return nomp;
    }

    public void setNomp(String nomp) {
        this.nomp = nomp;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Resultado{" + "nv=" + nv + ", nomp=" + nomp + ", cant=" + cant + ", total=" + total + '}';
    }
    
    public static Resultado build(Venta venta, Precio precio, Stock stock){
        Resultado resultado = new Resultado();
        resultado.setNv(venta.getNv());
        resultado.setNomp(stock.getNome());
        resultado.setCant(venta.getCantidad());
        resultado.setTotal( (precio.getPrezo() - (venta.isDescuento() ? precio.getDesc() : 0 )) * venta.getCantidad() );
        return resultado;        
    }
    
}
