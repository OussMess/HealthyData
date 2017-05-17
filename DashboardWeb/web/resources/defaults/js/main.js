/**
 * Created by Oussama on 23/04/2017.
 */
var patientSelected =null;


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
    if(patientSelected !=null && patientSelected.mesureSelected != null){
        patientSelected.mesureSelected.forEach(function (p1, p2, p3) {
            var id = "#c"+p1.idCapteur.id + "m" + p1.id;
            $("a[href='"+id+"']").parent().remove();
            $(id).remove();
            p1.socket.close();
        });
    }
    patientSelected = Object.create(Patient);
    patientSelected.init($(this).attr("id"));
    console.log(patientSelected);
    patientSelected.setHtml();
    $("#slide-out li").removeClass("teal lighten-2");
    $(this).parent().addClass("teal lighten-2");
    $(".tabs .tab.disabled").removeClass("disabled");
});



