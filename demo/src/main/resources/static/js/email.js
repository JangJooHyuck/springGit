
//사용자가 입력한 이메일 출력
function verifyEmail() {
    
     // email 에 id=email 안에 들어있는 값을 넣어줌
     const email = document.getElementById('email').value;

     // id=result 안에 innerText를 통해 저장된 email 의 값을 출력해줌
     document.getElementById("inputEmail").innerText = email;
     
     const 
     fetch('http://localhost:1233/api')
     .then(console.log(email))

   
        
         }
     
   
   
  
    