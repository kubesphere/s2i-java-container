<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="background-color:#fff">
<div class="ui-helper-hidden-accessible">| <a href="#maincontent">Skip to main content</a> |</div>  
<div class="container-fluid">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#navbar" aria-expanded="false"
                        aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span> 
                    <span class="icon-bar"></span> 
                    <span class="icon-bar"></span> 
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value='/home' />">Spring MVC Java 11</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse"
                 aria-expanded="false" style="height: 1px;">

                <ul class="nav navbar-nav">
                    <li><a href="<c:url value='/home' />"  title="Home">Home</a></li>

                    <li><a href="<c:url value='/help' />" title="Help">Help</a></li>
                </ul>



            </div>
        </div>
    </nav>
</div>