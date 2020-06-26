$.ajax({
    url: 'aver',
    type: 'GET',
    data: {action : "boroughsRooms"},
    success: function (fromServerJson) {
        $.ajax({
            url: 'aver?action=boroughsAverage',
            type: 'get',
            success : function(fromServer){
                var Boroughs = Object.keys(fromServerJson);
                var Rooms = Object.values(fromServerJson);
                var Doubles = Object.values(fromServer);
                for (var i = 0; i < Boroughs.length; i++) {
                    var res = `<h1>${Boroughs[i]} (${Number(Doubles[i]).toFixed(2)})</h1>`;
                    res += "<table class=\"table table-hover\">" + "<thead class=\"thead-dark\">" + "<tr>";
                    res += "<th>#" + "</th>";
                    res += "<th>Имя" + "</th>";
                    res += "<th>Цена" + "</th>";
                    res += "<th>Кол-во ночей" + "</th>";
                    res += "<th>Кол-во отзывов" + "</th>";
                    res += "</tr></thead><tbody>";
                    var string = Rooms[i];
                    for (var j = 0; j < string.length; j++) {
                        res += "<tr><td>" + (j + 1) + "</td>";
                        res += "<td>" + string[j].name + "</td>";
                        res += "<td>" + string[j].price + "</td>";
                        res += "<td>" + string[j].minimumNights + "</td>";
                        res += "<td>" +string[j].numberOfReviews + "</td>";
                        res += "</tr>";
                    }
                    res += "</tbody></table>";
                    $("#tab").append(res);
                }
                /*for (let i = 0; i < Doubles.length; i++) {
                    $(`#h_${i}`).append(" ("+Doubles[i]+")");
                }*/
            },
            error: function (fromServer) {
                alert("Dno");
            }
        });

    },
    error: function(xhr, status, error){
        var errorMessage = xhr.status + ': ' + xhr.statusText
        alert('Error - ' + errorMessage);
    }
});


