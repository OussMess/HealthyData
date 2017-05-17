<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>HealthyData</title>

    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link href="resources/materialize/css/materialize.min.css" rel="stylesheet"/>

    <script src="resources/jquery/jquery-3.2.0.min.js"></script>
    <script src="resources/materialize/js/materialize.min.js"></script>
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<style>
    nav{
        color: #fff;
        background-color: #263238 !important;
    }
</style>
<body>
<nav>
    <div class="nav-wrapper gray">
        <a href="#" class="brand-logo">HealthyData</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="#"><i class="material-icons left">aperson_pin</i>Dr. ${sessionScope.doctor.name}</a></li>
            <li><a href="dashboard"><i class="material-icons left">dashboard</i>Dashboard</a></li>
            <li><a href="logout"><i class="material-icons left">input</i>Deconnexion</a></li>
        </ul>
    </div>
</nav>

<div class="row" style="margin-top: 60px;margin-left: 100px;margin-right: 100px;">
    <form class="col s12">
        <div class="row">
            <div class="input-field col s6">
                <input id="prenom" type="text" class="validate valid" value="${sessionScope.doctor.name}">
                <label for="prenom">Name</label>
            </div>
            <div class="input-field col s6">
                <input id="nom" type="text" class="validate valid" value="${sessionScope.doctor.id}">
                <label for="nom">Id</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input type="text" id="taille" class="validate valid" value="${sessionScope.doctor.hopital}">
                <label for="taille">Hospital</label>
            </div>
            <div class="input-field col s6">
                <input id="mail" type="text" class="validate valid" value="${sessionScope.doctor.mail}">
                <label for="mail">Mail</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input type="text" class="validate valid" id="service"  value="${sessionScope.doctor.service}">
                <label for="service">Service</label>
            </div>
            <div class="input-field col s6">
                <input id="tel" type="text" class="validate valid" value="${sessionScope.doctor.tel}">
                <label for="tel">Telephone</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input type="text" class="validate valid" value="${sessionScope.doctor.specialite}">
                <label for="taille">Speciality</label>
            </div>

        </div>
        <br/><br/><br/>

        <button class="btn waves-effect waves-light pink" type="submit" name="action">reinitialiser
        </button>
        <button class="btn waves-effect waves-light" type="submit" name="action">enregistrer
        </button>
    </form>
</div>
</body>
</html>
