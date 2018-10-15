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
       <label class="layui-form-label">所属部门：</label>
       <div class="layui-input-inline">
        <input type="text" name="ssbumen" id="ssbumen" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        <input type="hidden" name="ycbmbh" id="ycbmbh"  >        
         <input type="hidden" name="ychzbh" id="ychzbh"  >  
       </div>
       <button class="layui-btn" id="xzbmen">选择部门</button>
   </div>
   
   
   
   
   
   <div class="layui-form-item">
       <label class="layui-form-label">商品编码：</label>
       <div class="layui-input-inline">
        <input type="text" name="spbianma" id="spbianma" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
       </div>
       <button class="layui-btn" id="xzhebianma">选择编码</button>
   </div>
   
    <div class="layui-form-item">
    <label class="layui-form-label">联系人：</label>
    <div class="layui-input-inline">
      <input type="text" name="lianxiren"  id="lianxiren" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
    <button class="layui-btn" id="">选择联系人</button>
  </div>
   
 <div class="layui-form-item">
    <label class="layui-form-label">采购员：</label>
    <div class="layui-input-inline">
      <input type="text" name="caigouyuan"  id="caigouyuan" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
    <button class="layui-btn" id="">选择采购员</button>
  </div>
   
  <div class="layui-form-item">
    <label class="layui-form-label">厂牌：</label>
    <div class="layui-input-inline">
      <input type="text" name="cpai"  id="cpai" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
    <button class="layui-btn" id="">选择厂牌</button>
  </div> 
  
   
    <div class="layui-form-item" style="
    margin-left: 20px;
">
 
      <button class="layui-btn"   id="tijiaoanniua">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary"  id="chongzhi">重置</button>
   
  </div>
   
 
 </div>
 
 
 <script type="text/javascript" src="static/js/lay/modules/layer.js"></script>
 <script  type="text/javascript" src="static/js/layui.js" charset="utf-8"></script>
 <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>  
   <script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
});

               
//弹出一个页面层
 $('#xzbmen').on('click', function(){
	 
 	 //弹出一个iframe层
 	    layer.open({
 	      type: 2,
 	      title: '选择部门',
 	      maxmin: true,
 	      shadeClose: true, //点击遮罩关闭层
 	      area : ['90%' , '85%'],
 	      content: 'ChooseDepartment',
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
	   var ypmchen=$("#ssbumen").val("");
	    var ypgge=$("#spbianma").val("") ;
	    var ypflei=$("#lianxiren").val("") ;
	    var ypjchen=$("#caigouyuan").val("") ;
	     var tiaoxm=$("#cpai").val("");
   });
 
  
 
 
 
   $("#tijiaoanniua").click(function(){
	    var ypmchen=$("#ypmchen").val().trim();
	    var ypgge=$("#ypgge").val().trim();
	    var ypflei=$("#ypflei").val().trim();
	    var ypjchen=$("#ypjchen").val().trim();
	    var tiaoxm=$("#tiaoxm").val().trim();
	    var sccjia=$("#sccjia").val().trim();
	    
	    var cgjge=$("#cgjge").val().trim();
	    var xsjge=$("#xsjge").val().trim();
	    var ypgxs=$("#ypgxs").val().trim();
	    
	    /* console.log("一"+ypflei+"二"+ypgge+"三"+ypjchen+"四"+ypmchen+"五"+ypphao+"六"+sccjia+"七"+kcsliang+"八"+cgjge+"九"+xsjge); */
	    
	     if(ypmchen == "" || ypmchen == null || ypmchen == undefined || ypgge == "" || ypgge == null || ypgge == undefined ||
	        ypflei == "" || ypflei == null || ypflei == undefined || ypjchen == "" || ypjchen == null || ypjchen == undefined ||	
	        sccjia == "" || sccjia == null || sccjia == undefined || tiaoxm == ""  || tiaoxm== null || tiaoxm== undefined ||
	        cgjge == "" || cgjge == null || cgjge == undefined ||
	        xsjge == "" || xsjge == null || xsjge == undefined || ypgxs == "" || ypgxs == null || ypgxs == undefined ){
	    	  bbb();
	    	  return;
	     }
	    
	    $.ajax({  
		    url: "addDrugss",  
		    data: {ypmchen:ypmchen,ypgge:ypgge,ypflei:ypflei,ypjchen:ypjchen,sccjia:sccjia,cgjge:cgjge,xsjge:xsjge,ypgxs:ypgxs,tiaoxm:tiaoxm},  
		    type: "POST",  
		    dataType: "json",  
		    success: function (data) {  
		    	console.log(data)
		    	if(data.state==100){
		    		 cg();
		    		 setTimeout(" var index = parent.layer.getFrameIndex(window.name);  parent.layer.close(index)", 1000 )
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