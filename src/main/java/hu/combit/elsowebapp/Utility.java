/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.elsowebapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NameNotFoundException;

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

    public static void create(String a, String b, String c, String d) {

        try (Connection conn = getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement("insert into ABC (A,B,C,D) values(?,?,?,?)");
            ps2.setInt(1, Integer.parseInt(a));
            ps2.setString(2, b);
            ps2.setString(3, c);
            ps2.setDate(4, java.sql.Date.valueOf(d));//csak erre a formatumra jó : 2000-01-01
            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<String[]> list() {
        List<String[]> ret = new ArrayList<>();

        try (Connection conn = getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement("select A,B,C,D,ID from ABC");

            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                ret.add(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
            }

            rs.close();
            ps2.close();
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }
}
