$("#observation").keyup(function () {
    console.log($("#observation").val().length);
    if ($("#observation").val().length > 0) {

        if (!$(".observation").hasClass('hidden')) {
            $(".observation").addClass('hidden');
            console.log('hidden');
        }
    }
    else {
        if ($(".observation").hasClass('hidden')) {
            $(".observation").removeClass('hidden');
            console.log('displayed');
        }
    }

});