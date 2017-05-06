/**
 * Created by Oussama on 22/04/2017.
 */
var Mesure = {
    type: null,
    information: null,
    idCapteur: null,
    tab: null,

    init: function (idCap, id) {
        this.type = "mesure" + idCap + "-" + id;
    },

    showData: function () {
        google.charts.load('current', {'packages': ['corechart']});
        google.charts.setOnLoadCallback(drawChart);
        var mesure = this;

        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Year', 'Sales', 'Expenses'],
                ['2004', 1000, 400],
                ['2005', 1170, 460],
                ['2006', 660, 1120],
                ['2007', 1030, 540]
            ]);

            var options = {
                title: 'Battement de coeur',
                curveType: 'Cardiologie',
                legend: {position: 'bottom'}
            };
            console.log('c' + mesure.idCapteur + 'm' + mesure.type);
            var chart = new google.visualization.LineChart(document.getElementById('c' + mesure.idCapteur + 'm' + mesure.type));
            chart.draw(data, options);
        }
    }


};