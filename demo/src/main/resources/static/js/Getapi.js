
//사용자가 입력한 이메일 출력
async function GetAPI() {
    
     // email 에 id=email 안에 들어있는 값을 넣어줌
     const email = document.getElementById('email').value;



     //api 호출하기 --> fetch로 api를 호출하고(ApiController.26), check 에 email 값을 넣어준다
     const resp = await fetch(encodeURI("http://localhost:1233/api/get?check=" + email))
     //resp 에는 ApiController 에서 반환된 user 의 값이 들어가게됨

     //respData 에다가 resp 값을 json타입으로 넣어준다
     const respData = await resp.json();

     //만약 respData에 result 가 success 라면
     if(respData.result == "success"){
          document.getElementById("email").innerText = respData.email;
          document.getElementById("result").innerText = respData.result;

     //아니면
     }else{
          document.getElementById("email").innerText = respData.email;
          document.getElementById("result").innerText = respData.result;
     }

    }
     
   
   
  
    