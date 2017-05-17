<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
  <title>Admin</title>
  <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <!-- Compiled and minified JavaScript -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
</head>

<body>
<div class="section"></div>
<main>
  <center>
    <h3 class="teal-text">Admin</h3>
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