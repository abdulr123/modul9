/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package belajar.java.mysql;

/**
 *
 * @author ASUS
 */

//import yang diperlukan
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

//atau juga bisa diimport sekaligus seperti ini :
//import java.sql.*;

public class BelajarJavaMysql {

    /**
     * @param args the command line arguments
     */
    // MEnyiapkan parameter JDBC (Java Database Connectivity)
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";
    
    //menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    public static void main(String[] args) {
        // melakukan koneksi ke database
        // harus dibungkus dalam blok try/catch
        try {
            // register driver yang akan di pakai
            Class.forName(JDBC_DRIVER);
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            // buat objek statement
            stmt =  conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM buku";
            
            // eksekusi query dan simpan hasilnya di objResulSet
            rs = stmt.executeQuery(sql);
            
            // tampilkan hasil query
            while(rs.next()){
                System.out.println("ID Buku: "+rs.getInt("id_buku"));
                System.out.println("Judul: "+rs.getString("judul"));
                System.out.println("Pengarang: "+rs.getString("pengarang"));
            }
            
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
