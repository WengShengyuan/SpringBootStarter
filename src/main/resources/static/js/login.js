var name;
var password;

function doLogin(){
	name = document.getElementById('loginName').value;
	password = document.getElementById('password').value;
	
	
	$.ajax({
		url : '/no-auth/api/doLogin',
		data : {name : name, password : password},
		async : true,
		type : 'POST'
	}).done(function(r){
//		alert(r);
		$('#ta').val(r);
	}).fail(function(err){
//		alert(err);
		$('#ta').val(err);
	});
	
}

function reset(){
	document.getElementById('loginName').value='';
	document.getElementById('password').value='';
}