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
<body  style=" margin-top: 10px;">
 
 <div style="width: 95%;">
 
 <div class="layui-form-item">
    <label class="layui-form-label">采购员：</label>
    <div class="layui-input-inline">
      <input type="text" name="caigouyuan"  id="caigouyuan" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
	    <input type="hidden" name="cgyid" id="cgyid"  >        
    <button class="layui-btn" id="xzcaigy">选择采购员</button>
  </div>
   
  <div class="layui-form-item">
    <label class="layui-form-label">厂牌：</label>
    <div class="layui-input-inline">
      <input type="text" name="cpai"  id="cpai" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
      <input type="hidden" name="cpaibh" id="cpaibh"  >      
    <button class="layui-btn" id="xzchangp">选择厂牌</button>  
  </div> 
  
   
    <div class="layui-form-item" style="margin-left: 20px;">
      <button class="layui-btn"   id="tijiaoanniua2">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary"  id="chongzhi">重置</button>
  </div>
 </div>
 
 <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>  
 <script type="text/javascript" src="static/js/lay/modules/layer.js"></script>
 <script  type="text/javascript" src="static/js/layui.js" charset="utf-8"></script>
   <script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  
  var checkStatus = parent.layui.table.checkStatus('druglistid');// 获取父页面名为“repairDataInfo”的表格中，选中的事件
 
	var params = checkStatus.data;// params就是父页面选中的那条记录
	 
	var ownerid=params[0].ownerid;
	var goodid=params[0].goodid;
	var linkid=params[0].linkid; 
    
  
  
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
});

//弹出一个页面层
 $('#xzcaigy').on('click', function(){
	 
 	 //弹出一个iframe层
 	    layer.open({
 	      type: 2,
 	      title: '选择采购员',
 	      maxmin: true,
 	      shadeClose: true, //点击遮罩关闭层
 	      area : ['95%' , '89%'],
 	      content: 'SelectPurchasers',
 	    	  end: function(){
 					 /* location.reload();   */
 				}
 	    });
 	  });  
 	  
//弹出一个页面层
 $('#xzchangp').on('click', function(){
	 
 	 //弹出一个iframe层
 	    layer.open({
 	      type: 2,
 	      title: '选择厂牌',
 	      maxmin: true,
 	      shadeClose: true, //点击遮罩关闭层
 	      area : ['90%' , '85%'],
 	      content: 'Choosebrands',
 	    	  end: function(){
 					 /* location.reload();   */
 				}
 	    });
 	  });  

 
 function cg(){
 	layui.use('layer', function(){
	  var layer = layui.layer;     
	  layer.msg('提交成功！');
	});
 }

 function bbb(){
	 layui.use('layer', function(){
		  var layer = layui.layer;
		  layer.msg('信息未填写完整！');
		});
 }
 
 
   $("#chongzhi").click(function(){
	    $("#caigouyuan").val("");
	    $("#cpai").val("") ;
   });
 
   $("#tijiaoanniua2").click(function(){
	   var checkStatus = parent.layui.table.checkStatus('druglistid');// 获取父页面名为“repairDataInfo”的表格中，选中的事件
	   
		var params = checkStatus.data;// params就是父页面选中的那条记录
		 
		var ownerid=params[0].ownerid;
		var goodid=params[0].goodid;
		var linkid=params[0].linkid; 
		var buyerid=params[0].buyerid;
	    var caigouyuan=$("#cgyid").val() ;
	    var cpai=$("#cpai").val() ;
	     if( caigouyuan == "" || caigouyuan == null || caigouyuan == undefined || cpai == "" || cpai == null || cpai == undefined  ){
	    	  bbb();
	    	  return;
	     }
	   
	    $.ajax({  
		    url: "modLinkbuyer",  
		    data: {linkid:linkid,caigouyuan:caigouyuan,cpai:cpai,ownerid:ownerid,goodid:goodid,buyerid:buyerid},  
		    type: "POST",  
		    dataType: "json",  
		    success: function (data) {  
		    	console.log(data);
		    	cg();
		    	console.log(data.state);
		    	if(data.state==100){
		    		/*  cg(); */
		    		 location.reload();
		    		/*  setTimeout(" var index = parent.layer.getFrameIndex(window.name);  parent.layer.close(index)", 1000 ) */
		    	}
		    	if(data.state==200){
		    	}
		    	/* window.location.reload(); */
		    }  
		});
   });
   
 
 </script>  
</body>
</html>