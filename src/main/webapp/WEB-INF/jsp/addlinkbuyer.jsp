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
 
 	<!--  <div class="layui-form-item">
       <label class="layui-form-label">所属货主：</label>
       <div class="layui-input-inline">
        <input type="text" name="ssbumen" id="ssbumen" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        <input type="text" name="ycbmbh" id="ycbmbh"  >        
         <input type="text" name="ychzbh" id="ychzbh"  >  
       </div>
       <button class="layui-btn" id="xzbmen">选择货主</button>
   </div> -->
   
   
   <div class="layui-form-item">
       <label class="layui-form-label">商品编码：</label>
       <div class="layui-input-inline">
        <input type="text" name="spbianma" id="spbianma" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
         <input type="hidden" name="nbcode" id="nbcode"  >        
         <input type="hidden" name="ycxzbh" id="ycxzbh"  >  
       </div>
       <button class="layui-btn" id="xzhebianma">选择编码</button>
   </div>
   
    <div class="layui-form-item">
    <label class="layui-form-label">联系人：</label>
    <div class="layui-input-inline">
      <input type="text" name="lianxiren"  id="lianxiren" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
     <input type="hidden" name="lxrid" id="lxrid"  >        
     <input type="hidden" name="lxrcode" id="lxrcode"  > 
    <button class="layui-btn" id="xzlxren">选择联系人</button>
  </div>
   
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
 $('#xzhebianma').on('click', function(){
	 
 	 //弹出一个iframe层
 	    layer.open({
 	      type: 2,
 	      title: '选择商品',
 	      maxmin: true,
 	      shadeClose: true, //点击遮罩关闭层
 	      area : ['90%' , '85%'],
 	      content: 'ChooseCommoditycode',
 	    	  end: function(){
 					 /* location.reload();   */
 				}

 	    });
 	  });
 	  
//弹出一个页面层
 $('#xzlxren').on('click', function(){
	 
 	 //弹出一个iframe层
 	    layer.open({
 	      type: 2,
 	      title: '选择联系人',
 	      maxmin: true,
 	      shadeClose: true, //点击遮罩关闭层
 	      area : ['60%' , '85%'],
 	      content: 'SelectContact',
 	    	  end: function(){
 					 /* location.reload();   */
 				}
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
 	      area : ['60%' , '85%'],
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

 function sb(){
	 	layui.use('layer', function(){
		  var layer = layui.layer;     
		  layer.msg('提交失败,请检查是否有重复！');
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
	    var spbianma=$("#nbcode").val() ;
	    var lianxiren=$("#lianxiren").val() ;
	    var caigouyuan=$("#cgyid").val() ;
	    var cpai=$("#cpai").val() ;
	     if(spbianma == "" || spbianma == null || spbianma == undefined || lianxiren == "" || lianxiren == null || lianxiren == undefined ||
	    		 caigouyuan == "" || caigouyuan == null || caigouyuan == undefined || cpai == "" || cpai == null || cpai == undefined  ){
	    	  bbb();
	    	  return;
	     }
	    
	    $.ajax({  
		    url: "addLinkbuyer",  
		    data: {spbianma:spbianma,lianxiren:lianxiren,caigouyuan:caigouyuan,cpai:cpai},  
		    type: "POST",  
		    dataType: "json",  
		    success: function (data) {  
		    	console.log(data)
		    	if(data.state==100){
		    		 cg();
		    		 setTimeout(" var index = parent.layer.getFrameIndex(window.name);  parent.layer.close(index)", 1000 )
		    	}
		    	if(data.state==200){
		    		sb();
		    	}
		    	/* window.location.reload(); */
		    }  
		});
   });
   
 
 </script>  
</body>
</html>