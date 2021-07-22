async function PostAPI(){

        // html 에서 값을 getemail에 저장함
        const getemail = document.getElementById("email").value;

        
        //api 호출
        await fetch(
            "http://localhost:1233/api/post", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                email = getemail,
                result = "failed",
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