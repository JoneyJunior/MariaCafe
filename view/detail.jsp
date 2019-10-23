<%-- 
    Document   : detail
    Created on : Feb 21, 2019, 3:05:17 AM
    Author     : ThangVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/JPL15_Thang/css/home.css"/>
        <link rel="stylesheet" href="/JPL15_Thang/css/detail.css"/>
        <title>Detail</title>
    </head>
    <body>
        <div class="center">
            <%@include file="header.jsp" %>
            <div class="main-content">
                <div class="contentLeft">
                    <div class="contentDetail">
                        <p class="titleCake">${cake.title}</p>
                        <div class="imageCake">
                            <img src="${cake.imgLink}"/>
                        </div>

                        <p>${cake.shortDesc}</p>    
                        <p>${cake.longDesc} Lorem Ipsum is simply dummy text of the printing and 
                            typesetting industry. Lorem Ipsum has been the industry's standard dummy
                            text ever since the 1500s, when an unknown printer took a galley of type and
                            scrambled it to make a type specimen book. It has survived not only five centuries, 
                            but also the leap into electronic typesetting, remaining essentially unchanged.
                            It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with
                            desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                            Lorem Ipsum is simply dummy text of the printing and 
                            typesetting industry. Lorem Ipsum has been the industry's standard dummy
                            text ever since the 1500s, when an unknown printer took a galley of type and
                            scrambled it to make a type specimen book. It has survived not only five centuries, 
                            but also the leap into electronic typesetting, remaining essentially unchanged.
                            It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with
                            desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                        <p>Price: ${cake.price}$</p>
                        <p>Date: ${cake.date}</p>
                    </div>
                </div>
                <div class="contentRight">
                    <%@include file="aside.jsp" %>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
