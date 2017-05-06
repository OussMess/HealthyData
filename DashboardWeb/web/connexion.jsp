<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>HealthyData</title>

    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link href="resources/materialize/css/materialize.min.css" rel="stylesheet"/>

    <script src="resources/jquery/jquery-3.2.0.min.js"></script>
    <script src="resources/materialize/js/materialize.min.js"></script>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>

<body>
<div class="section"></div>
<main>
    <center>
        <h3 class="teal-text">HealthyData</h3>
        <div class="section"></div>

        <div class="section"></div>

        <div class="container">
            <div class="z-depth-1 grey lighten-4 row"
                 style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">
                <p class="pink-text">${requestScope.error}</p>
                <form class="col s12" method="post" action="#">
                    <div class='row'>
                        <div class='col s12'>
                        </div>
                    </div>

                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='text' name='pseudo' id='pseudo'/>
                            <label for='pseudo' style="width: initial;">Entrer votre pseudo</label>
                        </div>
                    </div>

                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='password' name='password' id='password'/>
                            <label for='password' style="width: initial;">Entrer votre mot de passe</label>
                        </div>
                        <label style='float: right;'>
                            <a class='teal-text' href='#!'><b>Mot de passe oublié?</b></a>
                        </label>
                    </div>

                    <br/>
                    <center>
                        <div class='row'>
                            <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'>
                                Connexion
                            </button>
                        </div>
                    </center>
                </form>
            </div>
        </div>
    </center>

    <div class="section"></div>
    <div class="section"></div>
</main>

</body>

</html>