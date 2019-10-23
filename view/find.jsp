<%-- 
    Document   : find
    Created on : Feb 21, 2019, 3:03:51 AM
    Author     : ThangVD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/JPL15_Thang/css/home.css"/>
        <link rel="stylesheet" href="/JPL15_Thang/css/find.css"/>
        <title>Find</title>
    </head>
    <body>
        <div class="center">
            <%@include file="header.jsp" %>
            <div class="main-content">
                <div class="contentLeft">
                    <h1>Find Maria's Cafe </h1>
                    <div class="sectionFind">
                        <div class="leftFind">
                            <h4>Addreess and contact:</h4>
                            <p>${contactFind.address}</p>
                            <p>Tel: ${contactFind.phone}</p>
                            <p>Email: ${contactFind.email}</p>
                        </div>
                        <div class="rightFind">
                            <h4>Opening hours:</h4>
                            <c:forEach var="i" begin="0" step="1" end="${openHour.size()}">
                                <c:if test="${i < openHour.size()}">
                                    <p>${openHour.get(i).name}: ${openHour.get(i).content}</p>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="sectionMap">
                        <img src="${contactFind.imglink}"/>
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
