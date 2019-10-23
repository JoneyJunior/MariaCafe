 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import context.DBContext;
import enity.ContactFind;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ContactFindDAO {
    DBContext db;

    public ContactFindDAO() throws NamingException{
        db = new DBContext();
    }
    
    public ContactFind getContactFind() throws Exception{
        ContactFind contactFind = new ContactFind();
        String query = "select top 1 * from ContactFind order by id desc";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                contactFind.setId(rs.getInt("ID"));
                contactFind.setAddress(rs.getString("Address"));
                contactFind.setEmail(rs.getString("Email"));
                contactFind.setPhone(rs.getString("Phone"));
                contactFind.setImglink(db.getResource() + rs.getString("ImgLink"));
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            db.closeConnection(rs, ps, conn);
        }
        return contactFind;
    }
}
