/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_exa_01;

import ad_exa_01.model.Precio;
import ad_exa_01.model.Resultado;
import ad_exa_01.model.Stock;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class AD_Exa_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        SessionDB.getSession().setAutoclose(false);        
        DataAccessObject dao = DataAccessObject.getDAO();
        ArrayList<Resultado> resultados = new ArrayList<>();
        
        dao.getVentas().forEach(venta -> {
            Stock stock = dao.getStock(venta.getCodp());
            Precio precio = dao.getPrezo(venta.getCodp());
            System.out.println("\nVenta:\n"+venta);
            System.out.println(stock);
            System.out.println(precio);
            
            stock.reducirCantidad(venta.getCantidad());            
            dao.updateStock(stock);
            
            resultados.add(Resultado.build(venta, precio, stock));
        });        
        SessionDB.getSession().setAutoclose(true);
        
        dao.writeResultado(resultados);
    }

    
}
