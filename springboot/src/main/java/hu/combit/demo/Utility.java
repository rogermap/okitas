/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.demo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krisztianfarkas
 */
public class Utility {

    public static Integer toNumber(String s) {
        if (s == null) {
            return 0;
        }
        return Integer.parseInt(s);
    }

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:ojote/ojote@127.0.0.1:1522:dev10g");
        return conn;
    }

    public static void create(Integer a, String b, String c, java.util.Date d) {

        try (Connection conn = getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement("insert into ABC (A,B,C,D,ID) values(?,?,?,?,?)");
            ps2.setInt(1, a);
            ps2.setString(2, b);
            ps2.setString(3, c);
            ps2.setDate(4, new java.sql.Date(d.getTime()));//csak erre a formatumra jó : 2000-01-01
            ps2.setLong(5, System.currentTimeMillis());
            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void update(Long id, Integer a, String b, String c, java.util.Date  d) {

        try (Connection conn = getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement("update ABC set A=?, B=?,C=?,D=? where ID=?");
            ps2.setInt(1, a);
            ps2.setString(2, b);
            ps2.setString(3, c);
            ps2.setDate(4, new java.sql.Date(d.getTime()));//csak erre a formatumra jó : 2000-01-01
            ps2.setLong(5, id);
            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public static String[] findById(String id) {
        String[] ret = null;
        try (Connection conn = getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement("select A,B,C,to_char(D,'YYYY-MM-DD'),ID from ABC where id = ?");
            ps2.setLong(1, Long.parseLong(id));
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                ret = new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
            }
            ps2.close();
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public static void delete(String id) {
        try (Connection conn = getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement("delete from  ABC where id = ?");
            ps2.setLong(1, Long.parseLong(id));
            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public static List<Abc> list() {
        List<Abc> ret = new ArrayList<>();

        try (Connection conn = getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement("select Id, A,B,C,D from ABC");

            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                ret.add(new Abc(rs.getLong(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
            }

            rs.close();
            ps2.close();
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }
}
