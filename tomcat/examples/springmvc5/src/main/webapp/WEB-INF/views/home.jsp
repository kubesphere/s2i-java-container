<!doctype html>

<html lang="en">
    <head>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ page session="false"%>
        <c:set var="pagetitle" value="Spring MVC Java 11 Example" scope="request" />
        <%@ include file="/WEB-INF/includes/header.jsp"%>

    </head>
    <body>

        <%@ include file="/WEB-INF/includes/site-navigation.jsp"%>
        <div id="maincontent" class="page-header container"> 

            <h1 class="hidden-xs">Home</h1>

            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page">Home</li>
                </ol>
            </nav>

        </div>

        <div class="container">

           <p>Spring MVC Java 11 Example</p>

        </div>

        <%@ include file="/WEB-INF/includes/footer.jsp"%>


    </body>
</html>
