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
            contentType: "application/json",
            data: JSON.stringify({
                id : null,
                createDate : null,
                modifiedDate : null,
                userIP : title,
                mail : getemail,
                result : null
            })
            ,dataType: "json"
            ,success:function(data){
               console.log(data);
               if(data.result == "success"){
                    document.getElementById("emailprint").innerText = "Entered Email:" + data.mail;
                    document.getElementById("result").innerText = data.result;

                 //아니면
                 }else{
                    document.getElementById("emailprint").innerText =  "Entered Email:" + data.mail;
                    document.getElementById("result").innerText = data.result;
                 }
                 $("#spinner").css("display", "none");

                 }


       });
}

async function ajaxPostDic(){

   // html 에서 값을 getemail에 저장함
   var getword = document.getElementById("word").value;
   var title = $("#title").text();

   //제이쿼리. spinner 에 있는 display 값을 block으로 해준다.

   $("#spinner").css("display", "block");

   //ajax 통신
   $.ajax({
       type: "POST",
       async: "async",
       url: "http://localhost:1233/api/postDic",
       contentType: "application/json",
       data: JSON.stringify({
           idx : null,
           word : getword,
           content : null
       })
       ,dataType: "json"
       ,success:function(data){


          document.getElementById("wordprint").innerText = "입력하신 단어는 : " + data.word;
          document.getElementById("wordprint2").innerText = "입력하신 단어는 : " + data.content;

            $("#spinner").css("display", "none");

            }


  });
}

