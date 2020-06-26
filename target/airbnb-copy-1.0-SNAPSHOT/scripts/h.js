$.ajax({
    url: 'aver',
    type: 'GET',
    data: {action : "boroughsAverage"},
    success: function (fromServerJson) {
        var Boroughs = Object.keys(fromServerJson);
        var Averages = Object.values(fromServerJson);
        for (var i = 0; i < Boroughs.length; i++) {
            var res = "(" + Averages[i] + ")";
            $("#h" + i).append(res);
        }
    },
    error: function(xhr, status, error){
        var errorMessage = xhr.status + ': ' + xhr.statusText
        alert('Error - ' + errorMessage);
    }
});