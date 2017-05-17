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
<jsp:include page="fragments/navSideBar.jsp"/>
<div class="container" style="margin-left: 350px;margin-top:50px;">
    <form>
        <div class="row">
            <div class="input-field col s6">
                <input value="localhost" id="host" type="text" class="validate valid">
                <label class="active" for="host"> Host</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <input value="8080" id="port" type="text" class="validate valid">
                <label class="active" for="port"> Port</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <input value="RealTimeSocket" id="name" type="text" class="validate valid">
                <label class="active" for="name">Application Name</label>
            </div>
        </div>

        <br/><br/>
        <div class="row">
            <div class="col s6">
                <a href="#!" class="btn waves-effect waves-light pink col s5 left" type="submit" name="action">
                    reinitialiser
                </a>
                <a href="#!" class="btn waves-effect waves-light col s5 right" type="reset" name="action">
                    enregistrer
                </a>
            </div>
        </div>
    </form>
</div>
</body>

</html>