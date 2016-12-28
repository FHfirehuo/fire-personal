$('#user').hide();
$('#signout').hide();

$(function() {

	//init();

	$('#tologin').on('click', function() {
		$('.theme-popover-mask').fadeIn(100);
		$('.theme-popover').slideDown(200);
	});

	$('.theme-poptit .close').on('click', function() {
		$('.theme-popover-mask').fadeOut(100);
		$('.theme-popover').slideUp(200);
	});

	$('#login').on('click', function() {
		logIn();
	});

	$('#signout').on('click', function() {
		signOut();
	});

});

var init = function() {
	
	$.ajax({
		url : APP_BACKSTAGE_CTX + "security/user",
		method : "GET",
		success : function(result) {
			if (result.code) {
				var user = result.data;
				isLogin(user);
			}
		}
	})
};

var isLogin = function(_user) {
	if (_user != null) {
		$('#tologin').hide();
		$('#user').show();
		$('#signout').show();
		$('#user a').html(_user.name + " 你好！");
	}

};

var logIn = function() {

	var un = $('#username').val().trim();
	var pw = $('#password').val().trim();

	if (!un) {
		alert("账号不能为空");
		return false;
	}

	if (!pw) {
		alert("密码不能为空");
		return false;
	}

	$.ajax({
		/* url : "http://nxncp.mofcom.gov.cn/backstage/login", */
		url : APP_BACKSTAGE_CTX + "login",
		method : "POST",
		data : {
			username : un,
			password : pw
		},
		success : function(result) {
			if (result.code) {
				$('.close').click();
				var user = result.data;
				isLogin(user);
			} else {
				alert("账号或密码错误!");
			}
		}
	})

};

var signOut = function() {
	
	$.ajax({
		url : APP_BACKSTAGE_CTX + "signout",
		method : "POST",
		success : function(result) {
			if (result.code) {
				$('#tologin').show();
				$('#user').hide();
				$('#signout').hide();
				$('#user a').html("");

			} else {
				alert("系统错误！");
			}
		}
	})
};
