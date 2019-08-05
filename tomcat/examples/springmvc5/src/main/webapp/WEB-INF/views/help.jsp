<!doctype html>

<html lang="en">
    <head>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ page session="false"%>
        <c:set var="pagetitle" value="Help | Spring MVC Java 11" scope="request" />
        <%@ include file="/WEB-INF/includes/header.jsp"%>



    </head>
    <body>

        <%@ include file="/WEB-INF/includes/site-navigation.jsp"%>
        <div id="maincontent" class="page-header container"> 
            <h1>Spring MVC Java 11: Help</h1>
            <ul class="breadcrumb">
                <li>
                    <a href="<c:url value='/home' />">Home</a></li><li class="active">Help
                </li>
            </ul>
        </div>
       
        <div class="container">	

        </div> 

        <%@ include file="/WEB-INF/includes/footer.jsp"%>
    </body>
</html>
