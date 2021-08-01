async function ajaxPostAPI(){

        // html 에서 값을 getemail에 저장함
        var getemail = document.getElementById("email").value;
        var title = $("#title").text();

        //제이쿼리. spinner 에 있는 display 값을 block으로 해준다.

        $("#spinner").css("display", "block");
        //ajax 통신
        $.ajax({
            type: "POST",
            async: "async",
            url: "http://localhost:1233/api/post", 
            contentType: "apllication/json",
            data: JSON.stringify({
                idx : null,
                Date : null,
                UserIP : title,
                checkMail : getemail,
                Result : null
            })
            ,dataType: "json"
            ,success:function(data){
                 if(data.result == "success"){
                      document.getElementById("emailprint").innerText = data.email+ " :";
                      document.getElementById("result").innerText = data.result;
            
                 //아니면
                 }else{
                      document.getElementById("emailprint").innerText = data.email + " :";
                      document.getElementById("result").innerText = data.result;
                 }
                 $("#spinner").css("display", "none");
                 
                 }
                 //통신 실패시 콘솔에 에러 출력
                 ,error:function(data){
                    console.log("error");
                    $("#spinner").css("display", "none");
            }
       });
}