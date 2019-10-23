<%-- 
    Document   : about
    Created on : Feb 21, 2019, 3:02:29 AM
    Author     : ThangVD
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/JPL15_Thang/css/home.css"/>
        <link rel="stylesheet" href="/JPL15_Thang/css/about.css"/>
        <title>About</title>
    </head>
    <body>
        <div class="center">
            <%@include file="header.jsp" %>
            <div class="main-content">
                <div class="contentLeft">
                    <div class="contentAbout">
                        <h2>About my Cakes</h2>
                        <c:if test="${not empty noContent}">
                            <p>${noContent}</p>
                        </c:if>
                        <c:if test="${empty noContent}">
                            <ul>
                                <c:forEach var="i" begin="0" step="1" end="2">
                                    <c:if test="${i < cakes.size()}">
                                        <li>
                                            <div class="imageCake">
                                                <img src="${cakes.get(i).imgLink}"/>
                                            </div>
                                            <a href="DetailController?id=${cakes.get(i).id}">${cakes.get(i).title}</a>
                                            <p>${cakes.get(i).longDesc}</p>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </c:if>
                    </div>
                    <div class="paging">
                        <c:forEach var="i" begin="1" step="1" end="${totalPage}">
                            <c:if test="${page != i}">
                                <a href="AboutController?page=${i}">${i}</a> |
                            </c:if>
                            <c:if test="${page == i}">
                                ${i} |
                            </c:if>
                        </c:forEach>
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
