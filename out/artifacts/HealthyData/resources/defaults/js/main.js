/**
 * Created by Oussama on 23/04/2017.
 */
var patientSelected;

var drawChart = function(element, mesure){
    google.charts.load('current', {'packages':['line']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        var data = new google.visualization.DataTable();
        data.addColumn('number', 'Temps');
        data.addColumn('number', mesure.type);

        data.addRows([
            [10, 5],
            [12, 10],
            [13, 32],
            [15, 42]
            ]);

        var options = {
            title: mesure.type,
            height: 300,
            weight: 450
        };

        var chart = new google.charts.Line(document.getElementById(element));

        chart.draw(data, google.charts.Line.convertOptions(options));
    }
};

// Initialize collapse button
$(".button-collapse").sideNav();
$(".button-collapse-left").sideNav({
    menuWidth: 250, // Default is 300
    edge: 'right', // Choose the horizontal origin
    closeOnClick: false,
    draggable: true // Choose whether you can drag to open on touch screens
});

resizeLeftSlideBar = function () {
    if ($(".mesureCol .scroll li").length == 0) {
        $(".mesureCol").hide();
        $(".capteurCol").height($(document).height() - 60);
    }
    else {
        $(".mesureCol").show();
        $(".capteurCol").height($(document).height() - $(".mesureCol").height() - 70);
    }
};
$('#loginDropDown').dropdown({
        inDuration: 300,
        outDuration: 225,
        hover: true, // Activate on hover
        belowOrigin: true, // Displays dropdown below the button
        alignment: 'right' // Displays dropdown with edge aligned to the left of button
    });
resizeLeftSlideBar();

$('#slide-out li a').click(function () {

    patientSelected = Object.create(Patient);
    patientSelected.init($(this).attr("id"));
    console.log(patientSelected);
    patientSelected.setHtml();
    $("#slide-out li").removeClass("teal lighten-2");
    $(this).parent().addClass("teal lighten-2");
    $(".tabs .tab.disabled").removeClass("disabled");
});



