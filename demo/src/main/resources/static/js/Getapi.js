
//사용자가 입력한 이메일 출력
async function ajaxGetAPI() {
    
     // email 에 id=email 안에 들어있는 값을 넣어줌
     const getemail = document.getElementById("email").value;
     const title = $("#title").text();

     //제이쿼리. spinner 에 있는 display 값을 block으로 해준다.
     $("#spinner").css("display", "block");

     //fetch 호출
     //api 호출하기 --> fetch로 api를 호출하고(ApiController.26), check 에 email 값을 넣어준다
     //const resp = await fetch(encodeURI("http://localhost:1233/api/get?check=" + getemail))
     //resp 에는 ApiController 에서 반환된 user 의 값이 들어가게됨

     //위 fetch 를 ajax Query로 바꾸기
     $.ajax({
          type: "GET",
          async: "async",
          url: "http://localhost:1233/api/get?check=" + getemail + "&userIP=" + title,
          contentType: "apllication/json"
          // api 통신을 받을 DataType 은
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
     
   
   
  
    