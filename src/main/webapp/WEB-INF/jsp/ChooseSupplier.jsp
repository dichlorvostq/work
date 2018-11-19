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
  搜索供应商： 
  <div class="layui-inline">
    <input class="layui-input" name="sscahangp" id="sscahangp" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="cpaiss" id="cpaissan">搜索</button>
</div>
 
 
<table class="layui-table" lay-data="{width: 800,    url:'ChooseSuppliers',  id:'idTests' ,page:true}" lay-filter="huanzhemlists">
  <thead>
    <tr>
      <!-- <th lay-data="{type:'checkbox', fixed: 'left'}"></th> -->
<!--       <th lay-data="{field:' ',   sort: true, fixed: true}">采购员id</th> -->
       <th lay-data="{field:'dname',   sort: true, fixed: true}">客户名称</th>
      <th lay-data="{field:'prchead',   sort: true, fixed: true}">拼音码</th>
      <th lay-data="{field:'cstid',   sort: true, fixed: true}">客户ID</th>
      <th lay-data="{field:'cstcode',   sort: true, fixed: true}">客户编码</th>
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
  table.on('checkbox(huanzhemlists)', function(obj){
    console.log(obj)
  });
  //监听工具条
  table.on('tool(huanzhemlists)', function(obj){
    var data = obj.data;
    if(obj.event === 'choices'){
      /* layer.msg('ID：'+ data.tcbs + ' 的查看操作'); */
       
      parent.$('#gongysname').val(data.dname);
      parent.$('#gongysid').val(data.cstid);
      
      parent.$('#gongysname2').val(data.dname);
      parent.$('#gongysid2').val(data.cstid);
      parent.layer.closeAll();
    }  
  });
  
  var $ = layui.$, active = {
		  cpaiss: function(){
		      var dd = $('#sscahangp');
		      
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
		  
		   $('#cpaissan').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });  
  
   
});
</script>

</body>
</html>