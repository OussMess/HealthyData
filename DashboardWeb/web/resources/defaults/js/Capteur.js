/**
 * Created by Oussama on 22/04/2017.
 */
var Capteur = {
    id: null,
    name: null,
    mesures: null,

    addMesure: function (mesure) {
        this.mesures.push(mesure);
    },

    init: function (id, name) {
        this.id = id;
        this.name = name;
        this.mesures = [];
    }


};