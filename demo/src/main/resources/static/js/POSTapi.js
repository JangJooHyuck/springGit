async function PostAPI(){

        // html 에서 값을 email에 저장함
        const email = document.getElementById('email').value;

        
        //api 호출
        // 
        await fetch("http://localhost:1233/api/post", {
            method: "POST",
            headers: {
                "Content-Type" : "application/json"
            },
            body: JSON.stringify({
                useremail : email,
                result : false
            })
        }
     )
     .then(response => response.json())
     .then(data => {
         if(data.result)
         {
            document.getElementById("email").innerText = data.email;
            document.getElementById("result").innerText = data.result;
         }
         else{
            document.getElementById("email").innerText = data.email;
            document.getElementById("result").innerText = data.result;
         }
     })
}