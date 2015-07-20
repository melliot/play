
function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", theUrl, false);
    xmlHttp.send();

    return xmlHttp.responseText;
}
var persons = httpGet("/getperson");


