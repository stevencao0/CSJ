
function rowClicked(value) {
    window.location.href = "/group?groupName=" + value;
}

$("#groupRow tr").click(function() {
    window.location = $(this).find('td:eq(5)').attr("href");
});