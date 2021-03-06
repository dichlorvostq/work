   <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="static/css/layui.css"  media="all">
</head>
<body>
<div style="margin-bottom: 5px;">     </div>
 
 <div class="demoTable" style=" margin-left: 40px;">
  搜索联系人： 
  <div class="layui-inline">
    <input class="layui-input" name="sslxir" id="sslxir" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="lxrbntty" id="lxrssbtn">搜索</button>
</div>
 
 
<table class="layui-table" lay-data="{width: 550,   url:' SelectContacts',  id:'idTests'  ,page: true ,limits: [3,5,10]  ,limit: 5}" lay-filter="huanzhemlist">
  <thead>
    <tr>
      <!-- <th lay-data="{type:'checkbox', fixed: 'left'}"></th> -->
      <th lay-data="{field:'linkid',   sort: true, fixed: true}">联系人id</th>
      <th lay-data="{field:'linkcode',   sort: true, fixed: true}">联系人编码</th>
       <th lay-data="{field:'linkname',   sort: true, fixed: true}">联系人名字</th>
      <th lay-data="{fixed: 'right',   align:'center', toolbar: '#czannius'}">操作</th>
    </tr>
  </thead>
</table>
 
<script type="text/html" id="czannius">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="choices">选择</a>
</script>
               
 <script src="http://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js"></script>            
<script src="static/js/layui.js" charset="utf-8"></script>
<script>
layui.use('table', function(){
  var table = layui.table;
  //监听表格复选框选择
  table.on('checkbox(huanzhemlist)', function(obj){
    console.log(obj)
  });
  //监听工具条
  table.on('tool(huanzhemlist)', function(obj){
    var data = obj.data;
    if(obj.event === 'choices'){
      /* layer.msg('ID：'+ data.tcbs + ' 的查看操作'); */
       
      parent.$('#lianxiren').val(data.linkid);
      parent.$('#lxrid').val(data.linkcode);
      parent.$('#lxrcode').val(data.linkname);
      parent.layer.closeAll();
    }  
  });
  
  var $ = layui.$, active = {
		  lxrbntty: function(){
		      var dd = $('#sslxir');
		      
		      //执行重载
		      table.reload('idTests', {
		      /*   page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        , */where: {
		            name: dd.val()
		        }
		      });
		    }
		  };
		  
		  $('#lxrssbtn').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
  
   
});
</script>

</body>
</html>