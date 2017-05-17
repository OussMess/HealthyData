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
        jQuery.ajaxSetup({async: false});
        $.get("/HealthyData/patient?idPatient=" + id, function (data, status) {

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
                    mesure.id = $(measureServer).attr("id");
                    mesure.seuil = $(measureServer).attr("seuil");
                    mesure.unit = $(measureServer).attr("unit");
                    mesure.type = $(measureServer).text();
                    capteur.addMesure(mesure)
                })
            })

        });
        this.mesureSelected = [];

    },
    addMesure: function (capter, me, id) {
        var mesure = Object.create(Mesure);

        patientSelected.capteurs.forEach(function(a, b, c){
            if(a.id == capter){
                a.mesures.forEach(function (p1, p2, p3) {
                    if(p1.id == me){
                        mesure = p1;
                        return;
                    }
                })
            }
        });

        this.mesureSelected.push(mesure);
        $("#tabsMesure").append('<li class="tab col s3"><a class="active" href="#c' + capter + 'm' + mesure.id + '">' + mesure.type + '</a></li>');
        $("#tabsMesure").parent().parent().append('<div id="c' + capter + 'm' + mesure.id + '" class="col s9" style="margin-top: 20px;"><div class="row"><div class="col m2" style="margin-top: 60px"><ul class="collapsible" data-collapsible=""><li><a class="collapsible-header" href="#' +
            '"><span class="new badge" style="margin-left: 0px;" data-badge-caption="'+ mesure.seuil+'"></span>Seuil</a></li></ul><ul class="tabs vertical"><li class="tab"><a class="active" href="#realTimec' + capter + 'm' + mesure.id + '">Temps Réel</a></li><li class="tab"><a  href="#historiquec' + capter + 'm' + mesure.id + '">Historique</a></li></ul></div><div class="col m10"><div id="realTimec' + capter + 'm' + mesure.id + '" class="col tab-content"><div id="tablerealTimec' + capter + 'm' + mesure.id + '" style="height: 400px"></div><div id ="grapheRealTimec' + capter + 'm' + mesure.id + '" style="height: 400px;width: 700px"> Graphe RealTime</div><div class="row bottom"><div class="col s4"></div><div class="col s6"><ul class="tabs vertical horizontal" style=""><li class="tab col" style=""><a href="#tablerealTimec' + capter + 'm' + mesure.id + '" class="active">Table</a></li><li class="tab col" style=""><a href="#grapheRealTimec' + capter + 'm' + mesure.id + '">Graphe</a></li></ul></div></div></div><div id="historiquec' + capter + 'm' + mesure.id + '" class="col tab-content"><div id="tableHistoriquec' + capter + 'm' + mesure.id + '" style="height: 400px"> Table Historique</div><div id ="grapheHistoriquec' + capter + 'm' + mesure.id + '" style="height: 400px"> Graphe Historique</div><div class="row bottom" ><div class="col s4"></div><div class="col s6"><ul class="tabs vertical horizontal" style=""><li class="tab col s6" style=""><a href="#tableHistoriquec' + capter + 'm' + mesure.id + '">Table</a></li><li class="tab col s6" style=""><a class="active" href="#grapheHistoriquec' + capter + 'm' + mesure.id + '">Graphe</a></li></ul></div></div></div></div></div>');
        $(document).ready(function () {
            $('ul.tabs').tabs();
        });
        $('ul.tabs').tabs('select_tab', 'c' + capter + 'm' + mesure.id);
        $('#tablerealTime' + 'c' + capter + 'm' + mesure.id).append('<table><thead><tr><th>Temps</th><th>Valeur('+mesure.unit+')</th></tr></thead><tbody></tbody></table>');
        mesure.socket = new WebSocket("ws://localhost:8080/RealTimeSocket/measure");

        google.charts.load('current', {'packages':['line']}, data);
        var options = {
            height: 400,
            weight: 700,
            vAxis: {},
            animation: {
                duration: 500,
                easing: 'in'
            }
        };
        google.charts.setOnLoadCallback(drawChart);
        var data,chart;
        function drawChart() {
            data = new google.visualization.DataTable();
            data.addColumn('timeofday', 'Temps');
            data.addColumn('number', 'Valeur('+  mesure.unit +')');
            data.addColumn('number', 'Seuil('+  mesure.unit +')');
            chart = new google.charts.Line(document.getElementById('grapheRealTimec' + capter + 'm' + mesure.id));
        }


        mesure.socket.onmessage = function (event) {

            var element = event.data.split(";");
            element[1] = parseInt(element[1]);
            element[0] = new Date(parseInt(element[0]));
            if(data.getNumberOfRows() >20){
                data.removeRow(0);
            }
            data.addRow([[element[0].getHours(), element[0].getMinutes(), element[0].getSeconds()], element[1], parseInt(mesure.seuil)]);
            chart.draw(data, options);
            if(element[1]>mesure.seuil){
                $('#tablerealTimec' + capter + 'm' + mesure.id + ' table tbody').append('<tr class="red lighten-1"><td>' + element[0].toUTCString() + '</td><td>' + element[1] + '</td></tr>');
            }
            else{
                $('#tablerealTimec' + capter + 'm' + mesure.id + ' table tbody').append('<tr><td>' + element[0].toUTCString() + '</td><td>' + element[1] + '</td></tr>')
            }
            $('#tablerealTimec' + capter + 'm' + mesure.id + ' table tbody').scrollTop($('#tablerealTimec' + capter + 'm' + mesure.id + ' table tbody')[0].scrollHeight);
            console.log(mesure.id + " " + event.data);
        };
        mesure.socket.onopen = function () {
            mesure.socket.send(patientSelected.id + ";" + mesure.idCapteur.id + ";" + mesure.id);
            console.log(mesure.id);
        }
        //drawChart('c' + capter + 'm' + mesure.id, mesure);


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
                mesures.append('<li class="collection-item" value="' + mesure.id + '"><a href="#!"><i class="material-icons"></i>' + mesure.type + '</a></li>');
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
            patientSelected.addMesure($(this).parent().attr("id").substring(7), $(this).attr("value"), $(this).text());

            $(this).find(".material-icons").append("done");
            $(this).addClass("dismissable");
            $("#left-nav-bar .mesureCol ul").append('<li class="collection-item avatar"> <a href="#!" ><span class="title">' + $(this).text().substring(4) + '</span></a> <span class="capteur">' + $(this).parent().parent().children("a").contents().filter(function () {
                    return this.nodeType == Node.TEXT_NODE;
                }).text() + '</span> <a href="#!"><i class="material-icons secondary-content pink-text">delete</i></a></li>');
            $('.dropdown-button').dropdown('close');
            resizeLeftSlideBar();
            $("a i.secondary-content").click(function () {
                var element = $(this).parent().parent().remove();
                console.log(element.find("span.title").text());
                console.log(element.find("span.capteur").text().substring(7));
                patientSelected.mesureSelected.forEach(function (mesure) {
                    if (mesure.idCapteur == element.find("span.title").text() && mesure.id == element.find("span.capteur").text().substring(7)) {
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