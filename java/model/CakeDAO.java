/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import context.DBContext;
import enity.Cake;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class CakeDAO {

    DBContext db;

    public CakeDAO() throws NamingException {
        db = new DBContext();
    }

    public int getTotalRows() throws Exception {
        int rows = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select count(*) from Cake";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                rows = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return rows;
    }

    public List<Cake> getTop2CakeSortByDate() throws Exception {
        List<Cake> cakes = new ArrayList<>();
        String query = "select top 2 * from Cake order by Date desc";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cake cake = new Cake();
                cake.setId(rs.getInt("ID"));
                cake.setImgLink(db.getResource() + rs.getString("ImgLink"));
                cake.setTitle(rs.getString("Title"));
                cake.setShortDesc(rs.getString("ShortDesc"));
                cake.setLongDesc(rs.getString("LongDesc"));
                cake.setPrice(rs.getFloat("Price"));
                cake.setDate(rs.getDate("Date"));
                cakes.add(cake);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return cakes;
    }

    public List<Cake> getCakeInPageHasPageSize(int page, int pageSize) throws Exception {
        int from = page * pageSize - (pageSize - 1);
        int to = page * pageSize;
        List<Cake> cakes = new ArrayList<>();
        String query = "select * from ("
                + " select *, ROW_NUMBER() over (order by id asc) as rownumber "
                + " from Cake) as ck "
                + "where ck.rownumber >= ? and ck.rownumber <= ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cake cake = new Cake();
                cake.setId(rs.getInt("ID"));
                cake.setImgLink(db.getResource() + rs.getString("ImgLink"));
                cake.setTitle(rs.getString("Title"));
                cake.setShortDesc(rs.getString("ShortDesc"));
                cake.setLongDesc(rs.getString("LongDesc"));
                cake.setPrice(rs.getFloat("Price"));
                cake.setDate(rs.getDate("Date"));
                cakes.add(cake);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, con);
        }
        return cakes;
    }

    public Cake getCakeByID(int id) throws Exception {
        Cake cake = new Cake();
        String query = "select * from Cake where ID = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                cake.setId(rs.getInt("ID"));
                cake.setImgLink(db.getResource() + rs.getString("ImgLink"));
                cake.setTitle(rs.getString("Title"));
                cake.setShortDesc(rs.getString("ShortDesc"));
                cake.setLongDesc(rs.getString("LongDesc"));
                cake.setPrice(rs.getFloat("Price"));
                cake.setDate(rs.getDate("Date"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return cake;
    }

    public List<Cake> getAllCake() throws Exception {
        List<Cake> cakes = new ArrayList<>();
        String query = "select * from Cake order by ID desc";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cake cake = new Cake();
                cake.setId(rs.getInt("ID"));
                cake.setImgLink(db.getResource() + rs.getString("ImgLink"));
                cake.setTitle(rs.getString("Title"));
                cake.setShortDesc(rs.getString("ShortDesc"));
                cake.setLongDesc(rs.getString("LongDesc"));
                cake.setPrice(rs.getFloat("Price"));
                cake.setDate(rs.getDate("Date"));
                cakes.add(cake);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return cakes;
    }
    
    public List<Cake> getCakeInPageFake(int page, int pageSize) throws Exception {
        int from = page * pageSize - (pageSize - 1);
        int to = page * pageSize;
        List<Cake> cakes = new ArrayList<>();
        List<Cake> all = getAllCake();
        for(int i = from-1 ; i <= to; i++){
            if(i < all.size()){
                cakes.add(all.get(i));
            }
        }
        return cakes;
    }
}
