<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="description" content="IT干货技术分享网-修改信息">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="IT干货技术分享网-修改信息">
<meta content="_csrf" name="csrf-param">
<meta content="gqpb25GFirs5rHHq/KylANDoUyNTk46Ey0Dng=" name="csrf-token">
<title>注册-IT干货技术分享网</title>
<link rel="icon" href="#">
<link href="<%=path %>/static/css/min.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="<%=path %>/static/js/plugin/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/analytics.js"></script>
<script type="text/javascript">
function formCheck() {
	var account = jQuery("#account").val(), password = jQuery("#password").val(), security_code = $('#security_code').val();
	var email_reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
	password_reg = /^.*[A-Za-z0-9\\w_-]+.*$/;
	if (account == "") {
		jQuery(".alert.alert-error").show();
		jQuery("#j_msg").text("账号不能为空");
		jQuery("#account").focus();
		return false;
	} else if (account.length < 6) {
		jQuery(".alert.alert-error").show();
		jQuery("#j_msg").text("账号长度至少6个字符");
		jQuery("#account").focus();
		return;
	} else {
		jQuery(".alert.alert-error").hide();
	}
	if (password == "") {
		jQuery(".alert.alert-error").show();
		jQuery("#j_msg").text("密码不能为空");
		jQuery("#password").focus();
		return;
	} else if (password.length < 6) {
		jQuery(".alert.alert-error").show();
		jQuery("#j_msg").text("密码长度至少6个字符");
		jQuery("#password").focus();
		return;
	} else if (!password_reg.test(password)) {
		jQuery(".alert.alert-error").show();
		jQuery("#j_msg").text("密码含有特殊字符");
		jQuery("#password").focus();
		return;
	} else {
		jQuery(".alert.alert-error").hide();
	}
	if (security_code == '') {
		jQuery(".alert.alert-error").show();
		jQuery("#j_msg").text("验证码不能为空。");
		jQuery("#security_code").focus();
		return;
	} else {
		jQuery(".alert.alert-error").hide();
	}
	jQuery(".btn").attr("onclick", "");
	jQuery(".alert.alert-error").hide();
	jQuery.post('<%=path %>/user/register',jQuery("#register_form").serialize(),function(data) {
		if (data.status == '0000') {
			window.location.href = '<%=path %>/user/signin';
		} else {
			jQuery(".alert.alert-error").show();
			jQuery("#j_msg").text(data.message);
			jQuery(".btn").attr("onclick", "formCheck();");
		}
	});
}
jQuery(document).keyup(function(e){
	var e = e || event, keycode = e.which || e.keyCode;
	if (keycode == 13) {
		jQuery(".btn").trigger("click");
	}
});

//更换验证码
function refreshCaptcha() {
    document.getElementById("img_captcha").src="<%=path%>/verificationCode/kaptcha.jpg?t=" + Math.random();  
}
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div id='main'>
	<div id='sidebar'>
		<div class='panel'>
			<div class='header'> <span class='col_fade'>关于</span> </div>
			<div class="inner">
				<p>IT干货</p>  
				<p>在这里你可以：</p>
				<ul>
					<li>分享工作经验帮助遇到问题的人</li>
					<li>和其它人一起进步</li>
				</ul>
			</div>
		</div>
    </div>
	<div id="content">
		<div class="panel">
			<div class="header">
				<ul class="breadcrumb">
				  <li><a href="<%=path %>">主页</a><span class="divider">/</span></li>
				  <li class="active">注册</li>
				</ul>
			</div>
			<div class="inner">
				<div class="alert alert-error" style="display: none">
				  <strong id="j_msg">信息不完整。</strong>
				</div>
				<form id="register_form" class="form-horizontal">
					<div class="control-group">
						<label class="control-label" for="account">账号</label>
						<div class="controls">
							<input class="input-xlarge" id="account" name="account" size="30" type="text">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">密码</label>
						<div class="controls">
							<input class="input-xlarge" id="password" name="password" size="30" type="password">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="security_code">验证码</label>
						<div class="controls">
							<input class="input-mini" id="security_code" name="securityCode" size="4" type="text">
							<img id="img_captcha" alt="验证码" src="<%=path%>/verificationCode/kaptcha.jpg" style="height: 30px; width: 120px">
							<a href="javascript:refreshCaptcha();">看不清？</a>
						</div>
					</div>
					<div class="form-actions">
						<input type="button" class="btn" value="强势注册" onclick="formCheck();">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<div id='backtotop'>回到顶部</div>
<%@ include file="../common/footer.jsp" %>
<div id="sidebar-mask"></div>
</body>
</html>