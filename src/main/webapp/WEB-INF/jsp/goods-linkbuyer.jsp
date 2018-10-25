  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="static/css/layui.css"  media="all">
</head>
<body>
 <div class="drugfid">
  请输入商品编码：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="drugsearchid" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" id="drugfid">搜索</button>
  <button class="layui-btn" data-type="reload" id="tjhplxrjl">添加一条记录</button>
</div>
 
<table class="layui-hide" id="LAY_table_user" lay-filter="druglist"></table> 
 
 
 
 
<!-- <table class="layui-table" lay-data="{height: 313, url:'PirvateList'}" lay-filter="demoEvent" id="druglistid">
  <thead>
    <tr>
      <th lay-data="{field:'id', width:80}">ID</th>
      <th lay-data="{field:'name', width:80,sort: true}">用户名</th>
      <th lay-data="{field:'gg', width:'50%', event: 'setSign', style:'cursor: pointer;'}">签名</th>
      <th lay-data="{field:'usage'}">积分</th>
    </tr>
  </thead>
</table> 
          -->      
          
<script src="static/js/layui.js" charset="utf-8"></script>

 <script type="text/html" id="deltaocan">
   <a class="layui-btn layui-btn-danger layui-btn-xs"  lay-event="dell">修改</a>
</script>  

<script>
layui.use('table', function(){
  var table = layui.table; 
  
  
  //方法级渲染
  table.render({
    elem: '#LAY_table_user'
    ,url: 'linkbuyer'
    ,cols: [[
      {checkbox: true, fixed: true}
      /* ,{field:'id', title:'序号',width:80, sort: true, style:'color:#000;',fixed: true,templet: '<div><a href="/detail/{{d.id}}" class="layui-table-link">{{d.LAY_TABLE_INDEX+1}}</a></div>'} */
      ,{field:'ownerid', title: '货主', sort: true, fixed: true}
      ,{field:'goodid', title: '商品编码'}
      ,{field:'linkid', title: '联系人'}
      ,{field:'buyerid', title: '采购员'}
      ,{field:'warebrand', title: '厂牌'}
      ,{field:'createdate', title: '创建时间'}
      /* ,{field:'purchaseprice', title: '采购价格', event: 'setSigns'}
      ,{field:'salesprice', title: '销售价格', event: 'setsalesprice'}
      ,{field:'supplier', title: '供应商'} */
      ,{field:'right', title: '修改品种', toolbar:"#deltaocan",width:150,align:'center'} 
    ]]
    ,id: 'druglistid'
    ,page: true
     
  });
  
  
  
//监听单元格事件
  table.on('tool(druglist)', function(obj){
    var data = obj.data;
    var drugnames=data.drugid;
	var drugname=data.drugname; 
	var tcbs=data.tcbs;
    
    
     console.log(drugname+"条件")
    if(obj.event === 'setSigns'){
      layer.prompt({
        formType: 2
        ,title: '修改['+ data.drugname +']的采购价格？'
        ,value: data.sign
      }, function(value, index){
        layer.close(index);
        
        	 var reg = /^[0-9]+.?[0-9]*$/;
        	  if (!reg.test(value)) {
        		  layer.alert("请输入正确的数字！");
        	      return;
        	  }
        $.ajax({  
		    url: "modpurchaseprice",  
		    data: {drugnames:drugnames,value:value},  
		    type: "POST",  
		    dataType: "json",  
		    success: function (state) {  
		    	if(state.state==100){
		    		 layer.alert("数据保存成功！" , function(index){
		    					  layer.close(index);
		    					  table.reload('druglistid', {
		    						  /* page: {
		    					          curr: 1 //重新从第 1 页开始
		    					        } */
		    					  });
		    					});
		    	}
		    	if(state.state==200){
		    		layer.alert("数据保存失败，请重新填写！"); 
		    	}
		    	/* window.location.reload(); */
		    }  
		});
        obj.update({
          sign: value
        });
      });
    }
     
     if(obj.event === 'dell'){
	      layer.confirm('您确定要将【'+drugname+'】从药品库中删除吗？',  {
			  btn: ['确定','取消'] //按钮
			}, function(){
				$.ajax({  
				    url: "delDrugs",  
				    data: {drugname:drugname},  
				    type: "POST",  
				    dataType: "json",  
				    success: function (state) {
				    	if(state.state==100){
				    		layer.alert("删除成功!",function(index){
				    			location.reload();
				    		});
				    	}
				    	if(state.state==200){
				    		layer.alert("删除失败,请重新操作!",function(index){
				    			location.reload();
				    		});
				    	}
				    }  
				});	
			} );
	    }  
     
     if(obj.event === 'setsalesprice'){
         layer.prompt({
           formType: 2
           ,title: '修改['+ data.drugname +']的销售价格？'
           ,value: data.sign
         }, function(value, index){
           layer.close(index);
           
           	 var reg = /^[0-9]+.?[0-9]*$/;
           	  if (!reg.test(value)) {
           		  layer.alert("请输入正确的数字！");
           	      return;
           	  }
           $.ajax({  
   		    url: "modsalesprice",  
   		    data: {drugnames:drugnames,value:value},  
   		    type: "POST",  
   		    dataType: "json",  
   		    success: function (state) {  
   		    	if(state.state==100){
   		    		 layer.alert("数据保存成功！" , function(index){
   		    					  layer.close(index);
   		    					  table.reload('druglistid', {
   		    						  /* page: {
   		    					          curr: 1 //重新从第 1 页开始
   		    					        } */
   		    					  });
   		    					});
   		    	}
   		    	if(state.state==200){
   		    		layer.alert("数据保存失败，请重新填写！"); 
   		    	}
   		    	/* window.location.reload(); */
   		    }  
   		});
           obj.update({
             sign: value
           });
         });
       }
  });
  
  
  var $ = layui.$, active = {
		    reload: function(){
		      var drugsearchid = $('#drugsearchid');
		      console.log(drugsearchid.val()+"获取输入框的值")
		      
		      //执行重载
		      table.reload('druglistid', {
		        page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
		        	drugname: drugsearchid.val()
		        }
		      });
		    }
		  };
  $("#drugfid").on('click', function(){
	    var type = $(this).data('type');
	    console.log("点击触发"+type)
	    active[type] ? active[type].call(this) : '';
	  });
  
});
</script>
 <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="static/js/lay/modules/layer.js"></script>
<script>
//弹出一个页面层
$('#tjhplxrjl').on('click', function(){
	 //弹出一个iframe层
	    layer.open({
	      type: 2,
	      title: '新增订单联系人记录',
	      maxmin: true,
	      shadeClose: true, //点击遮罩关闭层 （空白地方关闭子页面）
	      area : ['80%' , '85%'],
	      content: 'addlinkbuyer',
	    	  end: function(){
					 location.reload();  
				}

	    });
	  });
</script>
</body>
</html>