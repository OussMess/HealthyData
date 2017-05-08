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
    <link href="resources/defaults/css/style.css" rel="stylesheet"/>

    <script src="resources/jquery/jquery-3.2.0.min.js"></script>
    <script src="resources/materialize/js/materialize.min.js"></script>
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<ul id="loginDropDown" class="dropdown-content">
    <li><a href="#!">Profil</a></li>
    <li><a href="#!">Parametres</a></li>
    <li class="divider"></li>
    <li><a href="#!">Deconnexion</a></li>
</ul>
<nav>
    <div class="nav-wrapper gray">
        <a href="#" class="brand-logo">HealthyData</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="#">Alert</a></li>
            <li><a class="dropdown-button" href="#!" data-activates="loginDropDown">Dr. ${sessionScope.doctor.name}<i
                    class="material-icons right">arrow_drop_down</i></a></li>
        </ul>
    </div>
</nav>
<div id="slide-out" style="margin-top: 65px;" class="side-nav fixed">
    <div class="title teal lighten-2 header">
        <h5>Patients</h5>
    </div>
    <div class="search header">
        <div class="search-wrapper card">
            <input/><i class="material-icons">search</i>
            <div class="search-results"></div>
        </div>
    </div>
    <ul class="scroll">
        <c:forEach var="patient" items="${sessionScope.doctor.patientList}" varStatus="statut">
            <li><a id="${patient.id}" href="#!">${patient.firstName} ${patient.lastName}</a></li>
        </c:forEach>
    </ul>


</div>
<a href="#" data-activates="slide-out" class="button-collapse ">
    <i class="material-icons" style="position:relative;top: 15px;">perm_identity</i></a>
<div class="container">
    <div class="row" style="padding-top: 70px">
        <div class="col s12">
            <ul class="tabs">
                <li class="tab col s3 tab "><a class="active" href="#notification">Notification</a></li>
                <li class="tab col s3 tab disabled"><a href="#patient">Patient</a></li>
            </ul>
        </div>
        <div id="notification" class="row">notificatiooon +++++</div>
        <div id="patient" class="row">
            <div class="side-nav fixed" style="margin-top: 65px; padding: 0" id="left-nav-bar">
                <div class="collection mesureCol">
                    <div class="collection-header">
                        <div class="title teal lighten-2 header">
                            <h5>Mesures selectionnees</h5>
                        </div>
                    </div>
                    <div class="search header">
                        <div class="search-wrapper card">
                            <input/><i class="material-icons">search</i>
                            <div class="search-results"></div>
                        </div>
                    </div>
                    <ul class="collection-items scroll ">

                    </ul>
                </div>
                <div class="collection capteurCol" style="height: 50%">
                    <div class="collection-header">
                        <div class="title teal lighten-2 header">
                            <h5>Capteurs</h5>
                        </div>
                    </div>
                    <div class="search header">
                        <div class="search-wrapper card">
                            <input/><i class="material-icons">search</i>
                            <div class="search-results"></div>
                        </div>
                    </div>
                    <ul class="collection-items scroll capters">

                    </ul>

                </div>
            </div>
            <a href="#" data-activates="left-nav-bar" class="button-collapse-left "><i class="material-icons"
                                                                                       style="position: absolute;right: 0px;top: 15px;">description</i></a>
            <div class="row">
                <div class="col s12">
                    <ul class="tabs" id="tabsMesure">
                        <li class="tab col s3"><a class="active" href="#infos">Infos</a></li>
                    </ul>
                </div>
                <div id="infos" class="col s12">

                    <div class="row">
                        <form id="formInfosPatient" class="col s12">
                            <br/><br/>
                            <div class="row">
                                <div class="input-field col s6">
                                    <input id="prenom" type="text" class="validate valid" value=" "/>
                                    <label for="prenom">Prenom</label>
                                </div>
                                <div class="input-field col s6">
                                    <input id="nom" type="text" class="validate valid" value=" "/>
                                    <label for="nom">Nom</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s6">
                                    <input placeholder="JJ/MM/AAAA" id="date_naissance" type="text" value=" "
                                           class="validate valid"/>
                                    <label for="date_naissance">Date de naissance</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s6">
                                    <input id="adresse" type="text" class="validate valid" value=" "/>
                                    <label for="adresse">Adresse</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s6">
                                    <input placeholder="1,75m" id="taille" type="text" class="validate valid"
                                           value=" "/>
                                    <label for="taille">Taille(m)</label>
                                </div>
                                <div class="input-field col s6">
                                    <input placeholder="75kg" id="poid" type="text" class="validate valid" value=" "
                                    />
                                    <label for="poid">Poids(kg)</label>
                                </div>
                            </div>
                            <br/><br/><br/>
                            <div class="row">
                                <a href="#!" class="btn waves-effect waves-light pink col s6" type="submit"
                                   name="action">
                                    reinitialiser
                                </a>
                                <a href="#!" class="btn waves-effect waves-light col s6" type="submit" name="action">
                                    enregistrer
                                </a>
                            </div>

                        </form>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>

<script src="resources/charts/loader.js"></script>
<script src="resources/defaults/js/Mesure.js"></script>
<script src="resources/defaults/js/Capteur.js"></script>
<script src="resources/defaults/js/Patient.js"></script>
<script src="resources/defaults/js/main.js"></script>

</body>

</html>