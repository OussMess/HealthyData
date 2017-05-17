/**
 * Created by Oussama on 22/04/2017.
 */
var Mesure = {
    type: null,
    information: null,
    idCapteur: null,
    tab: null,
    id:null,
    socket: null,
    seuil:null,
    unit:null,

    init: function () {
        this.information = [];
    },
    addInformation: function (data) {
        var datas = data.split(";");
        var date = new Date(data[0]);
        var time= [date.getHours() , date.getMinutes(), date.getSeconds()];

        var donnee = datas[1];
        var info = [];
        info.push(time);
        info.push(donnee);
        this.information.push(info);
    }


};