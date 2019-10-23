/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

import java.sql.Date;

/**
 *
 * @author ThangVD
 */
public class Cake {
    private int id;
    private String imgLink, title, shortDesc, longDesc;
    private float price;
    private Date date;

    public Cake() {
    }

    public Cake(int id, String imgLink, String title, String shortDesc, String longDesc, float price, Date date) {
        this.id = id;
        this.imgLink = imgLink;
        this.title = title;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }    
    
}
