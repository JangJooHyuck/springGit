function findWord(){
    var word = document.getElementById("word").value;
    window.location.href = "/dictionary?word=" + word;
}