
$(".default_option").click(function () {
    $(".dropdown ul").addClass("active");
});

$(".dropdown ul li").click(function () {
    var text = $(this).text();
    $(".default_option").text(text);
    $(".dropdown ul").removeClass("active");
});



function search(url) {
$("#employee").css("visibility", "visible");
        $('#employee').DataTable({
            "bProcessing": true,
            "bDestroy": true,
            "paging": false,
            "ordering": false,
            "searching": false,
            "bInfo": false,
            ajax: {
                url: url,
                dataSrc: ""
            },
            "columns": [
                { "data": "fname" },
                { "data": "lname" },
                { "data": "address" },
                { "data": "phone" },
                { "data": "work" },
                { "data": "home" },
            ]
        });
}

$("#searchbtn").click(function () {
    var type = $("#dropdown").val();
    var url="";
     var searchString =  $("#searchString").val();
    if(type == 1 ) 
    {
        url = "http://localhost:8080/search?name="+searchString;
        
    }
    else if(type == 2) {
        url = "http://localhost:8080/searchByNumber?phone="+searchString;
    }
    search(url);
});