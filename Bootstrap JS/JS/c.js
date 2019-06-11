var d1;
var d2;
var status=0;
function dologin(){
if(status==1){alert("Already Logged in!!!!");}
if(status==0){
var username=prompt("Please Enter your name");
	if(username==""){alert("Please provide a name");}
	if (username!=null&&username!=""){
	document.getElementById("user").innerHTML = username;
	document.getElementById("logmessage").innerHTML="logged in";
	document.getElementById('myImage').src='images/wellcome.gif';
	d1= new Date();
	status=1;}	
}
}
function dologout(){
if(status==0){alert("Not Logged in!!!");}
if(status==1){
var res=confirm("Do You Want to LogOut?");
if(res==true){
document.getElementById("logmessage").innerHTML="logged out";
document.getElementById('myImage').src='images/goodbye.gif';
document.getElementById("user").innerHTML="";
d2=new Date();
var to=d2.getTime();
var ti=d1.getTime();
var te=(to-ti)/1000;
document.getElementById("logmessage").innerHTML="Logged Out.   You were there for " +te+" seconds";
status=0;}}
}
function bigImg(x) {
    x.style.height = "64px";
    x.style.width = "64px";
}

function normalImg(x) {
    x.style.height = "32px";
    x.style.width = "32px";
}
function myFunction() {
    var x = document.getElementById("mySelect").value;
    document.getElementById("car").innerHTML = "You selected: " + x;
}
function Small() {
    document.getElementById('logmessage').style.fontSize='15px';
	document.getElementById('user').style.fontSize='15px';
	document.getElementById('car').style.fontSize='15px';
}
function Medium() {
    document.getElementById('logmessage').style.fontSize='25px';
	document.getElementById('user').style.fontSize='25px';
	document.getElementById('car').style.fontSize='25px';
}
function Large() {
    document.getElementById('logmessage').style.fontSize='35px';
	document.getElementById('user').style.fontSize='35px';
	document.getElementById('car').style.fontSize='35px';
}
function imagechange() {
    var x = document.getElementById("imgcode").value;
   	if(x=="one"){document.getElementById('myImage').src='images/ONE.gif';}
	if(x=="untitled"){document.getElementById('myImage').src='images/untitled.gif';}
	if(x=="smiley"){document.getElementById('myImage').src='images/smiley.gif';}
	if(x=="home"){document.getElementById('myImage').src='images/hello.gif';}
}