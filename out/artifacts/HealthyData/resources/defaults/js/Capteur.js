/**
 * Created by Oussama on 22/04/2017.
 */
var Capteur = {
    id: null,
    name: null,
    mesures: null,

    setMesures: function () {
        for (var i = 0; i < 50; i++) {
            var mesure = Object.create(Mesure);
            mesure.init(this.id, i);
            this.mesures.push(mesure);
        }
    },

    init: function (id, name) {
        this.id = id;
        this.name = name;
        this.mesures = [];
        this.setMesures();
    }


};