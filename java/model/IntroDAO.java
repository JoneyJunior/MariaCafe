/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import context.DBContext;
import enity.Intro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class IntroDAO {
    DBContext db;

    public IntroDAO() throws NamingException {
        db = new DBContext();
    }
    
    public Intro getIntro() throws Exception{
        Intro intro = new Intro();
        String query = "select * from Intro";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                intro.setId(rs.getInt("ID"));
                intro.setTitle(rs.getString("Title"));
                intro.setDescription(rs.getString("Description"));
                intro.setImgLink(db.getResource() + rs.getString("ImgLink"));
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            db.closeConnection(rs, ps, conn);
        }
        return intro;
    }
}
