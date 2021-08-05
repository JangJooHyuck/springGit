
//사용자가 입력한 이메일 출력
function ajaxGetAPI() {

     // email 에 id=email 안에 들어있는 값을 넣어줌
     var getemail = document.getElementById("email").value;
     var title = $("#title").text();

     // spinner 에 있는 display 값을 block으로 해준다.
     $("#spinner").css("display", "block");

     $.ajax({
          type: "GET",
          async: "async",
          url: "http://localhost:1233/api/get?check=" + getemail + "&userIP=" + title,
          contentType: "application/json"
          // api 통신을 받을 DataType 은
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
               //통신 실패시 콘솔에 에러 출력
               ,error:function(data){
                    console.log("error");
                    $("#spinner").css("display", "none");
               }
     });

    }




