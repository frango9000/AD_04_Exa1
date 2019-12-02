package ad_exa_01;

import ad_exa_01.model.Precio;
import ad_exa_01.model.Resultado;
import ad_exa_01.model.Stock;
import ad_exa_01.model.Venta;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessObject {

    private static DataAccessObject instance;

    private final SessionDB sessionDB = SessionDB.getSession();

    private DataAccessObject() {
    }

    public static DataAccessObject getDAO() {
        if (instance == null) {
            synchronized (DataAccessObject.class) {
                if (instance == null) {
                    instance = new DataAccessObject();
                }
            }
        }
        return instance;
    }

    public ArrayList<Venta> getVentas() {
        ArrayList<Venta> ventas = new ArrayList<>();
        if (sessionDB.connect()) {
            String sql = "SELECT * FROM vendas";
            try (Statement ps = sessionDB.getConn().createStatement();
                    ResultSet rs = ps.executeQuery(sql)) {
                while (rs.next()) {
                    ventas.add(Venta.build(rs));
                }
                SessionDB.printSql(sql);
            } catch (SQLException ex) {
                SessionDB.log(ex + sql);
            } finally {
                sessionDB.close();
            }
        }
        return ventas;
    }

    public Stock getStock(String codp) {
        Stock stock = null;
        if (sessionDB.connect()) {
            String sql = String.format("SELECT * FROM stock WHERE codp = '%s'", codp);
            try (Statement ps = sessionDB.getConn().createStatement();
                    ResultSet rs = ps.executeQuery(sql)) {
                if (rs.next()) {
                    stock = Stock.build(rs);
                }
                SessionDB.printSql(sql);
            } catch (SQLException ex) {
                SessionDB.log(ex + sql);
            } finally {

                sessionDB.close();
            }
        }
        return stock;
    }

    public Precio getPrezo(String codp) {
        Precio precio = null;
        if (sessionDB.connect()) {
            String sql = String.format("SELECT * FROM prezos WHERE codp = '%s'", codp);
            try (Statement ps = sessionDB.getConn().createStatement();
                    ResultSet rs = ps.executeQuery(sql)) {
                if (rs.next()) {
                    precio = Precio.build(rs);
                }
                SessionDB.printSql(sql);
            } catch (SQLException ex) {
                SessionDB.log(ex + sql);
            } finally {
                sessionDB.close();
            }
        }
        return precio;
    }

    public int updateStock(Stock stock) {
        int rows = 0;
        if (sessionDB.connect()) {
            String sql = String.format("UPDATE stock set cants = ? WHERE codp = ?");
            try (PreparedStatement pstmt = sessionDB.getConn().prepareStatement(sql)) {
                pstmt.setInt(1, stock.getCantidad());
                pstmt.setString(2, stock.getCodp());
                rows = pstmt.executeUpdate();
                SessionDB.printSql(sql);
            } catch (SQLException ex) {
                SessionDB.log(ex + sql);
            } finally {
                sessionDB.close();
            }
        }
        return rows;
    }

    public void writeResultado(ArrayList<Resultado> resultados) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/ad_exa_01/resultado.txt")))) {
            for (Resultado result : resultados) {
                out.print(result.getNv());
                out.print("\t");
                out.print(result.getNomp());
                out.print("\t");
                out.print(result.getCant());
                out.print("\t");
                out.print(result.getTotal());
                out.print("\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AD_Exa_01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AD_Exa_01.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
