
function get(url)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", url, false);
    xmlHttp.send();

    return xmlHttp.responseText;
}
var persons = get("/getperson");

var array = JSON.parse(persons);

array.forEach(function(object) {
    console.log(object.name);
    document.body.innerHTML += "<li>" + object.name;
});
