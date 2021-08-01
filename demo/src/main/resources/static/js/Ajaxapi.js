// userlog를 출력한 Tbody 태그
var table = document.getElementById("userLogTBody")
// Tbody 태그에 넣을 html
var html = "";

fetch("http://localhost:1233/api/findIdxCount")
    .then(response => response.json())
    .then(data => {
        $('#pagination-demo').twbsPagination({
            totalPages: data,
            visiblePages: 10,
            onPageClick: function (event, page) {
                logAPI(page);
            }
        });
    });


//api를 호출하여 pageNumber에 필요한 데이터베이스 불러와 데이터 입력해주는 함수
function logAPI(page){
    var targetURL="http://localhost:1233/api/ajax?pageNumber=" + page;
    fetch(targetURL)
        .then(response => response.json())
        .then(data => {
            // html 초기화
            html="";
            tableCreate(data);
    });
}

// Tbody 안에 html 태그 넣어주는 함수
function tableCreate(data){

    for(key in data){
        html += "<tr>";
        html += "<td>" +data[key].idx + "</td>";
        html += "<td>" +data[key].Date + "</td>";
        html += "<td>" +data[key].UserIP + "</td>";
        html += "<td>" +data[key].Mail + "</td>";
        html += "<td>" +data[key].Result + "</td>";
        html += "</tr>";
    }


    // Tbody 초기화
    $("#userLogTBody").empty();
    $("#userLogTBody").append(html);
}