/**
 * Created by Oussama on 22/04/2017.
 */
var Patient = {
    id: null,
    lastName: null,
    firstName: null,
    birthDay: null,
    adresse: null,
    weight: null,
    taille: null,
    capteurs: null,
    mesureSelected: null,


    init: function (id) {
        this.id = id;
        this.capteurs = [];
        jQuery.ajaxSetup({async:false});
        $.get("/HealthyData/patient?idPatient="+id, function(data, status){

            patientSelected.firstName = $(data).children("firstName").text();
            patientSelected.lastName = $(data).children("lastName").text();
            patientSelected.birthday = $(data).children("birthday").text();
            patientSelected.adresse = $(data).children("adress").text();
            patientSelected.taille = $(data).children("height").text();
            patientSelected.weight = $(data).children("weight").text();
            $(data).children("sensor").each(function (indice, element) {
                var capteur = Object.create(Capteur);
                capteur.init($(element).attr("id"), $(element).attr("name"));
                patientSelected.capteurs.push(capteur);
                $(element).children("mesure").each(function (index, measureServer) {
                    var mesure = Object.create(Mesure);
                    mesure.idCapteur = capteur;
                    mesure.type = $(measureServer).text();
                    capteur.addMesure(mesure)
                })
            })

        });
        this.mesureSelected = [];

    },
    addMesure: function (capter, me) {
        var mesure = Object.create(Mesure);
        mesure.init();
        mesure.idCapteur = capter;
        mesure.type = me;
        this.mesureSelected.push(mesure);
        $("#tabsMesure").append('<li class="tab col s3"><a class="active" href="#c' + capter + 'm' + mesure.type + '">' + mesure.type + '</a></li>');
        $("#tabsMesure").parent().parent().append('<div id="c' + capter + 'm' + mesure.type + '" class="col s9" style=""></div>');
        $('ul.tabs').tabs('select_tab', 'c' + capter + 'm' + mesure.type);
        var socket = new WebSocket("ws://localhost:8080/RealTimeSocket/measure");
        socket.onmessage = function (event) {
            mesure.addInformation(event.data);

        };
        socket.onopen = function(){
            socket.send(patientSelected.id+";"+mesure.idCapteur+";"+mesure.type);
        }
        drawChart('c' + capter + 'm' + mesure.type, mesure);


    },

    setCapteurs: function (id) {
        for (var i = 0; i < 50; i++) {
            var capteur = Object.create(Capteur);
            capteur.init(i, "Capteur" + i + "-" + id);
            this.capteurs.push(capteur);
        }
    },
    setHtml: function () {
        $("#left-nav-bar .capteurCol .capters").empty();
        $("#left-nav-bar .mesureCol .scroll").empty();
        this.capteurs.forEach(function (element) {
            var capteur = $('<li class="collection-item unselectable" ></li>');
            capteur.attr("value", element.id);
            capteur.append('<a class="dropdown-button" href="#" data-activates="capteur' + element.id + '"><i class="material-icons">view_headline</i> ' + element.name + '</a>');
            var mesures = $('<ul id="capteur' + element.id + '"  class="dropdown-content collection-items teal lighten-4"></ul>');

            element.mesures.forEach(function (mesure) {
                mesures.append('<li class="collection-item" value="' + mesure.type + '"><a href="#!"><i class="material-icons"></i>' + mesure.type + '</a></li>');
            });
            capteur.append(mesures);
            $("#left-nav-bar .capteurCol .capters").append(capteur);

        });
        $('.dropdown-button').dropdown({
            inDuration: 300,
            outDuration: 225,
            constrainWidth: true, // Does not change width of dropdown to that of the activator
            hover: false, // Activate on hover
            gutter: 0, // Spacing from edge
            belowOrigin: false, // Displays dropdown below the button
            alignment: 'left', // Displays dropdown with edge aligned to the left of button
            stopPropagation: false // Stops event propagation
        });
        $("#formInfosPatient input[id='prenom']").val(this.firstName);
        $("#formInfosPatient input[id='nom']").val(this.lastName);
        $("#formInfosPatient input[id='date_naissance']").val(this.birthday);
        $("#formInfosPatient input[id='adresse']").val(this.adresse);
        $("#formInfosPatient input[id='taille']").val(this.taille);
        $("#formInfosPatient input[id='poid']").val(this.weight);
        $(".capters ul li ").click(function (element) {
            patientSelected.addMesure($(this).parent().attr("id").substring(7), $(this).attr("value"));

            $(this).find(".material-icons").append("done");
            $(this).addClass("dismissable");
            $("#left-nav-bar .mesureCol ul").append('<li class="collection-item avatar"> <a href="#!" ><span class="title">' + $(this).attr("value") + '</span></a> <span class="capteur">' + $(this).parent().attr("id") + '</span> <a href="#!"><i class="material-icons secondary-content pink-text">delete</i></a></li>');
            $('.dropdown-button').dropdown('close');
            resizeLeftSlideBar();
            $("a i.secondary-content").click(function () {
                var element = $(this).parent().parent().remove();
                console.log(element.find("span.title").text());
                console.log(element.find("span.capteur").text().substring(7));
                patientSelected.mesureSelected.forEach(function (mesure) {
                    if (mesure.idCapteur == element.find("span.title").text() && mesure.type == element.find("span.capteur").text().substring(7)) {
                        patientSelected.mesureSelected.splice(id, 1);
                        $(".capters ul[id='capteur" + mesure.idCapteur + "'] li[value='" + mesure.type + "']").find(".material-icons").text("");
                    }
                });
                resizeLeftSlideBar();
            });
        });

        resizeLeftSlideBar();
    }

};