<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>xx管理登录</TITLE>
<META content="text/html; charset=gb2312" http-equiv=Content-Type>
<SCRIPT src="static/js/jquery-1.8.3.min.js"></SCRIPT>
<SCRIPT language=javascript type=text/javascript>

 
	function killerror()
	{
		return true;	
	}
	window.onerror=killerror;
	$(document).ready(function(){
		$('#username').focus();
		$('#adminlogin').submit(function(){
			if($.trim($('#username').val())=='')
			{
				$('#username').css("border-color","#ff9900");
				$('#username').focus();
				return false;
			}
			else
			{
				$('#username').css("border-color","");
			}

			if($.trim($('#password').val())=='')
			{
				$('#password').css("border-color","#ff9900");
				$('#password').focus();
				return false;
			}
			else
			{
				$('#password').css("border-color","");
			}
			
			/* if($.trim($('#checkcode').val()).length!=4)
			{
				$('#checkcode').css("border-color","#ff9900");
				$('#checkcode').focus();
				return false;
			}
			else
			{
				$('#checkcode').css("border-color","");
			} */
			return true;
		})
		
		
		$("#btnResett").click(function(e){
			 var e = e || window.e;
			 e.preventDefault();
			 $("#username").val("");
			 $("#password").val("");
			 $("#tips").text("");
		})

		$("#username").change(function(){
		    var bm=$("#username").val();
			$("#mySelect option").remove();
		    $.ajax({  
				    url: "xzbumen",  
				    data: {bm:bm},  
//					data: formData,
				    type: "POST",  
				    dataType: "json",  
				    success: function (data) {
				    	for (var i = 0; i < data.length; i++) {
				    		                  $("#mySelect").append("<option>" + data[i].deptname + "</option>");
				    		            }
				    },
				});
		});
	});
	
</SCRIPT>


<STYLE type=text/css>BODY {
	TEXT-ALIGN: center; PADDING-BOTTOM: 0px; BACKGROUND-COLOR: #ddeef2; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; PADDING-TOP: 0px
}
A:link {
	COLOR: #000000; TEXT-DECORATION: none
}
A:visited {
	COLOR: #000000; TEXT-DECORATION: none
}
A:hover {
	COLOR: #ff0000; TEXT-DECORATION: underline
}
A:active {
	TEXT-DECORATION: none
}
.input {
	BORDER-BOTTOM: #ccc 1px solid; BORDER-LEFT: #ccc 1px solid; LINE-HEIGHT: 20px; WIDTH: 182px; HEIGHT: 20px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid
}
.input1 {
	BORDER-BOTTOM: #ccc 1px solid; BORDER-LEFT: #ccc 1px solid; LINE-HEIGHT: 20px; WIDTH: 120px; HEIGHT: 20px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid
}
</STYLE>

<META name=GENERATOR content="MSHTML 8.00.6001.23486"></HEAD>
<BODY>
<FORM id=adminlogin onsubmit="return checklogin();" method=post name=adminlogin action="login">
 
<DIV></DIV>
<TABLE style="MARGIN: auto; WIDTH: 100%; HEIGHT: 100%" border=0 cellSpacing=0 cellPadding=0>
  <TBODY>
  <TR>
    <TD height=150>&nbsp;</TD></TR>
  <TR style="HEIGHT: 254px">
    <TD>
      <DIV style="MARGIN: 0px auto; WIDTH: 936px"><IMG style="DISPLAY: block"  src= 'static/images/body_03.jpg'> </DIV>
      <DIV style="BACKGROUND-COLOR: #278296">
      <DIV style="MARGIN: 0px auto; WIDTH: 936px">
      <DIV 
      style="BACKGROUND: url(static/images/body_005.jpg) no-repeat; HEIGHT: 155px">   
      <DIV  style="TEXT-ALIGN: left; WIDTH: 265px; FLOAT: right; HEIGHT: 125px; _height: 95px;position: relative;">
      <TABLE border=0 cellSpacing=0 cellPadding=0 width="100%">
        <TBODY>
        <TR>
          <TD style="HEIGHT: 43px"><INPUT id=username class=input type=text  name=username></TD></TR>
        <TR>
          <TD><INPUT id=password class=input type=password name=password></TD></TR>
           <TR>
			         <TD>
			          <select id="mySelect"  name="xlxname"  style=" margin-top: 10px;">
			          </select>
			          </TD>
			</TR>
          <div style="position: absolute;top:100px;left:0;font-size: 12px;font-weight: 700;color: red;" id="tips">${error}  </div>
        <TR>
       	  
           </TR></TBODY></TABLE></DIV>
      <DIV style="HEIGHT: 1px; CLEAR: both"></DIV> 
      <DIV style="WIDTH: 380px; FLOAT: right; CLEAR: both">
      <TABLE border=0 cellSpacing=0 cellPadding=0 width=300>
        <TBODY>
        <TR>
          <TD width=100 align=right>
          
	         	 <INPUT  style="BORDER-RIGHT-WIDTH: 0px; BORDER-TOP-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px" 
	             id=btnLogin src="static/images/btn1.jpg"   type=image name=btnLogin>
          </TD>
          <TD width=100 align=middle>
          <INPUT  style="BORDER-RIGHT-WIDTH: 0px; BORDER-TOP-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px" 
            id=btnResett src="static/images/btn2.jpg"   type=image name=btnResett>
            </TD></TR></TBODY></TABLE></DIV></DIV></DIV></DIV>
      <DIV style="MARGIN: 0px auto; WIDTH: 936px"><IMG  src="static/images/body_06.jpg"> </DIV></TD></TR>
  <TR style="HEIGHT: 30%">
    <TD>&nbsp;</TD></TR></TBODY></TABLE></FORM></BODY>
    </HTML>
