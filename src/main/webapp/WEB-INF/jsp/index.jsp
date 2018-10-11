<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="baseurl" value="${pageContext.request.contextPath}/"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>KITADMIN 后台管理模板</title>
  <link rel="stylesheet" href="static/css/layui.css" id="layui">
  <link rel="stylesheet" href="static/css/theme/default.css" id="theme">
  <link rel="stylesheet" href="static/css/kitadmin.css" id="kitadmin">

</head>

<body class="layui-layout-body kit-theme-default">
  <div class="layui-layout layui-layout-admin">
    <!-- header -->
    <div class="layui-header">
      <div class="layui-logo">
        <div class="layui-logo-toggle" kit-toggle="side" data-toggle="on">
          <i class="layui-icon">&#xe65a;</i>
        </div>
        <div class="layui-logo-brand">
          <a href="#/"></a>
        </div>
      </div>
      <div class="layui-layout-left">
        <!-- <div class="kit-search">
          <form action="/">
            <input type="text" name="keyword" class="kit-search-input" placeholder="关键字..." />
            <button class="kit-search-btn" title="搜索" type="submit">
              <i class="layui-icon">&#xe615;</i>
            </button>
          </form>
        </div> -->
      </div>
      <div class="layui-layout-right">
        <ul class="kit-nav" lay-filter="header_right">
         <!--  <li class="kit-item" kit-target="help">
            <a href="javascript:;">
              <i class="layui-icon">&#xe607;</i>
              <span>帮助</span>
            </a>
          </li>
          <li class="kit-item" id="ccleft">
            <a href="javascript:;">
              <i class="layui-icon">&#xe60e;</i>
            </a>
          </li>
          <li class="kit-item" id="cc">
            <a href="javascript:;">
              <i class="layui-icon">&#xe64c;</i>
            </a>
          </li> -->
          <li class="kit-item">
            <a href="javascript:;">
              <span>
            欢迎您：    <!-- <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538019769379&di=34663f7b0abc627d0dc2cc3aca1d050f&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c02f55bb572f6ac7253f36797045.png" class="layui-nav-img"> -->${username}
              </span>
            </a>
            <ul class="kit-nav-child kit-nav-right">
            <!--   <li class="kit-item">
                <a href="#/user/my">
                  <i class="layui-icon">&#xe612;</i>
                  <span>个人中心</span>
                </a>
              </li>
              <li class="kit-item" kit-target="setting">
                <a href="javascript:;">
                  <i class="layui-icon">&#xe614;</i>
                  <span>设置</span>
                </a>
              </li> -->
              <li class="kit-nav-line"></li>
              <li class="kit-item">
                <a href="temp/login.jsp">
                  <i class="layui-icon">&#x1006;</i>
                  <span>注销</span>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
    <!-- silds -->
    <div class="layui-side" kit-side="true">
      <div class="layui-side-scroll">
        <div id="menu-box">
          <ul class="kit-menu">
             
         <c:if test="${list!=null }">  
           	 <c:forEach items="${list}" var="menu">
             <li class="kit-menu-item layui-show">
              <a href=" ${menu.menupath} " >
                <i class="layui-icon"></i>
                <span>${menu.menuname }</span>
              </a>
              
            <c:forEach items="${slist }" var="permission">
             	<c:if test="${menu.mid==permission.paremenuid}">
              <ul class="kit-menu-child layui-anim layui-anim-upbit">
                <li class="kit-menu-item">
                  <a href="${permission.menupath}"> 
                    <i class="layui-icon"></i>
                    <span>${permission.menuname }</span>
                  </a>
                </li>
              </ul>
              </c:if>
              </c:forEach> 
               
            </li>
               </c:forEach>
         </c:if>  
            
          </ul>
        </div>
      </div>
    </div>
    <!-- main -->
    <div class="layui-body" kit-body="true">
      <router-view></router-view>
    </div>
    <!-- footer -->
    <div class="layui-footer" kit-footer="true">
      <div style="width:400px; height:400px;" class="load-container load1">
         
      </div>
    </div>
  </div>
  <script src="static/js/polyfill.min.js"></script>
  <script src="static/js/layui.js"></script>
  <script src="static/js/kitadmin.js"></script>
  <script src="static/js/mockjs-config.js"></script>

  <script src="https://cdn.bootcss.com/echarts/4.1.0.rc2/echarts.min.js"></script>
  <script>layui.use("admin");</script>

</body>
</html>
