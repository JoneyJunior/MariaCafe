/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import context.DBContext;
import enity.OpeningHouse;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class OpeningHourDAO {
    DBContext db;

    public OpeningHourDAO() throws NamingException{
        db = new DBContext();
    }
    
    public List<OpeningHouse> getOpeningHour() throws Exception{
        List<OpeningHouse> op = new ArrayList<>();
        String query = "select * from OpeningHouse";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
               OpeningHouse openingHouse = new OpeningHouse();
               openingHouse.setId(rs.getInt("ID"));
               openingHouse.setName(rs.getString("Name"));
               openingHouse.setContent(rs.getString("Content"));
               op.add(openingHouse);
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            db.closeConnection(rs, ps, conn);
        }
        return op;
    }
}
