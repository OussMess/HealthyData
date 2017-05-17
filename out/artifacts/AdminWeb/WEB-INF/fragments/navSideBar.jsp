<%-- User: Oussama, Date: 14/05/2017, Time: 16:11 --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
    <div class="nav-wrapper" style="background-color: darkcyan;">
        <a href="#" class="brand-logo">Admin</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="<c:url value="/"/>"><i class="material-icons left">input</i>Deconnexion</a></li>
        </ul>
    </div>
</nav>

<ul id="slide-out" class="side-nav fixed" style="margin-top:65px;">
    <c:choose>
        <c:when test="${pageContext.request.servletPath.equals('/flux')}" >
            <li class="active"><a href="#!">Flux</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="<c:url value="/flux"/>">Flux</a></li>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${pageContext.request.servletPath.equals('/mongo')}" >
            <li class="active"><a href="#!">MongoDB</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="<c:url value="/mongo"/>">MongoDB</a></li>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${pageContext.request.servletPath.equals('/real')}" >
            <li class="active"><a href="#!">Real Time</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="<c:url value="/real"/>">Real Time</a></li>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${pageContext.request.servletPath.equals('/spark')}" >
            <li class="active"><a href="#!">Spark</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="<c:url value="/spark"/>">Spark</a></li>
        </c:otherwise>
    </c:choose>
</ul>
