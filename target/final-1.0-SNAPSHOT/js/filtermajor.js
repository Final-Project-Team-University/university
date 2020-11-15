$(document).ready(function () {
    $('.results > li').hide();

    $('div.tags').find('input:checkbox').live('click', function () {
        $('.results > li').hide();
        $('div.tags').find('input:checked').each(function () {
            $('.results > li.' + $(this).attr('rel')).show();
        });
    });
});


