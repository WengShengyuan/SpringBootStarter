var name;
var password;

function doLogin(){
	name = document.getElementById('loginName').value;
	password = document.getElementById('password').value;
	
	
	$.ajax({
		  type: 'POST',
		  url: '/api/doLogin',
		  data: {name : name, password : password},
		  success: function(data, status){
				alert(data);
				alert(status);
			}
		});
	
}

function reset(){
	document.getElementById('loginName').value='';
	document.getElementById('password').value='';
}