<%-- 
    Document   : home
    Created on : Feb 21, 2019, 2:03:37 AM
    Author     : ThangVD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/JPL15_Thang/css/home.css"/>
        <title>Home</title>
    </head>
    <body>
        <div class="center">
            <%@include file="header.jsp" %>
            <div class="main-content">
                <div class="contentLeft">
                    <div class="sectionIntro">
                        <section class="content">
                            <div class="left-content">
                                <img src="${intro.getImgLink()}"/>
                            </div>
                            <div class="right-content">
                                <h2>${intro.getTitle()}</h2>
                                <p>${intro.getDescription()}</p>
                            </div>

                        </section>
                    </div>
                    <div class="section">
                        <ul>
                            <c:forEach var="i" begin="0" step="1" end="1">
                                <c:if test="${i < cakes.size()}">
                                    <li class="li${i}">
                                        <div>
                                            <img src="${cakes.get(i).imgLink}" />
                                        </div>
                                        <a href="DetailController?id=${cakes.get(i).id}">${cakes.get(i).title}</a>
                                        <p>${cakes.get(i).shortDesc}</p>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="sectionContact">
                        <div class="titleContact">
                            <p>Visit my Cafe</p>
                        </div>
                        <p>${contactHome.content}</p>
                        <p>${contactHome.address}</p>
                        <p>Phone: ${contactHome.phone}</p>
                    </div>
                    <div class="sectionSignature">
                        <p>Kind regards</p>
                        <div class="signature">
                            <p>Maria Bagnarelli</p>
                        </div>
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
