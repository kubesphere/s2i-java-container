<!doctype html>

<html lang="en">
<head>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ page session="false"%>
        <c:set var="pagetitle" value="Error" scope="request" />
        <%@ include file="/WEB-INF/includes/header.jsp"%>

</head>

<body>

    <%@ include file="/WEB-INF/includes/site-navigation.jsp"%>
    <div id="maincontent" class="page-header container">

            <h1>Spring MVC Java 11: Error</h1>
              <ul class="breadcrumb">
                <li>
                    <a href="<c:url value='/home' />">Home</a></li><li class="active">Error
                </li>
            </ul>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p style="font-size:1.1em;font-weight:700;margin-bottom:121px">
                    A problem occurred that prevents this application from
                    continuing.
                </p>
            </div>
        </div>
    </div><!-- /container -->

    <%@ include file="/WEB-INF/includes/footer.jsp"%>
</body>
</html>