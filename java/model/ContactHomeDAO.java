/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import context.DBContext;
import enity.ContactHome;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class ContactHomeDAO {
    DBContext db;

    public ContactHomeDAO() throws NamingException{
        db = new DBContext();
    }
    
    public ContactHome getContactHome() throws Exception{
        ContactHome contactHome = new ContactHome();
        String query = "select * from ContactHome";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                contactHome.setId(rs.getInt("ID"));
                contactHome.setAddress(rs.getString("Address"));
                contactHome.setPhone(rs.getString("Phone"));
                contactHome.setContent(rs.getString("Content"));
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            db.closeConnection(rs, ps, conn);
        }
        return contactHome;
    }
}
