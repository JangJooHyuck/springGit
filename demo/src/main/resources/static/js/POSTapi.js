async function PostAPI(){

        // html 에서 값을 getemail에 저장함
        const getemail = document.getElementById("email").value;

        //제이쿼리. spinner 에 있는 display 값을 block으로 해준다.

        $("#spinner").css("display", "block");
        //api 호출
        await fetch(
            "http://localhost:1233/api/post", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                email : getemail,
                result : "failed"
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
         //제이쿼리. spinner 에 있는 display 값을 none으로 해준다.

        $("#spinner").css("display", "none");
     })
}