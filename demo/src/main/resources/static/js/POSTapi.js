async function PostAPI(){

        // html 에서 값을 getemail에 저장함
        const getemail = document.getElementById("email").value;
        const title = $("#title").text();

        //제이쿼리. spinner 에 있는 display 값을 block으로 해준다.

        $("#spinner").css("display", "block");
        //api 호출
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
            ,success:function(respData){
                 if(respData.result == "success"){
                      document.getElementById("emailprint").innerText = respData.email+ " :";
                      document.getElementById("result").innerText = respData.result;
            
                 //아니면
                 }else{
                      document.getElementById("emailprint").innerText = respData.email + " :";
                      document.getElementById("result").innerText = respData.result;
                 }
                 $("#spinner").css("display", "none");
            }
       });
}