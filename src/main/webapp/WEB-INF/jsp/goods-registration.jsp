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
   <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
 
 
</head>
<body>

<div>
<div class="layui-form-item">
            <div class="layui-inline">
			    <label class="layui-form-label">客户:</label> 
			      <div class="layui-input-inline">
			        <input class="layui-input" name="gongysname2" id="gongysname2"  readonly="readonly"  style="width: 100%">
			         <input class="layui-input" name="gongysid2" id="gongysid2"  readonly="readonly"  style="width: 100%">
			        
			       <!--  <input    type="hidden"  name="gongysid2" id="gongysid2"  > -->
			      </div>
    		</div>
    		<div class="layui-inline">
		      <!-- <div class="layui-input-inline">
		        <input class="layui-input" name="gongysmcheng" id="gongysmcheng" autocomplete="off"  >
		      </div> -->
       		<button class="layui-btn  layui-btn-sm " id="xzgongys2">选择客户</button>
    	</div>
   
    <div class="layui-inline">
    <label class="layui-form-label">商品:</label> 
      <div class="layui-input-inline">
        <input  name="shangpbianmid2"  id="shangpbianmid2"    class="layui-input"  readonly="readonly">
        <input  name="shangpbianm2"  id="shangpbianm2"    class="layui-input"  readonly="readonly">
    <!--     <input  name="shangpbianm2"  id="shangpbianm2"   type="hidden" > -->
      </div>
    </div>
    <div class="layui-inline">
     <!--  <div class="layui-input-inline">
        <input  name="shangpbianm"  id="shangpbianm"  class="layui-input">
      </div> -->
           <button class="layui-btn   layui-btn-sm" id="xzbianma">选择商品</button>
    </div>

  <div class="layui-inline"  style=" left: 130px;">
		      <button class="layui-btn" data-type="reload2" id="sousuoann2">搜索</button>
		     <button  id="resetczs" class="layui-btn layui-btn-primary">重置</button>
   </div>
     </div>
</div>


 <table class="layui-hide" id="LAY_table_user" lay-filter="druglists"></table> 
 
 <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>  
 <script src="static/js/layui.js" charset="utf-8"></script>
 <script type="text/html" id="deltaocans">
   
<a class="layui-btn layui-btn-danger layui-btn-xs"  lay-event="modify">修改</a>
</script>  
 <script>
layui.use('table', function(){
  var table = layui.table;
  
  //方法级渲染
  table.render({
    elem: '#LAY_table_user'
    ,url: 'selectSelleeruploadqtyLists'
    ,cellMinWidth: 120
    ,cols: [[
       {type:'radio',fixed: true}
       ,{field:'deptname', title:'所属公司'}
       ,{field:'bmdeptname', title:'冲差方式（一退一开或冲差）'}
       ,{field:'deptname', title:'所属部门'}
       ,{field:'ywyuan', title:'业务员'}
       ,{field:'cstcode', title:'客户代码'}
       ,{field:'goods', title:'商品代码'}
       ,{field:'marketno,', title:'交易编码'}
       ,{field:'name', title:'药品名称'}
       ,{field:'spec', title:'药品规格'}
       ,{field:'msunitno', title:'单位'}
       ,{field:'producer', title:'生成厂商'}
       ,{field:'qty2016', title:'销量'}
       ,{field:'prc', title:'原中标价格'}
       ,{field:'prc11', title:'重新申报挂网价格'}
       ,{field:'qty2017',title: '<span style="color:red">客户库存</span>'}
       ,{field:'qty201710', title:'子公司内部库存'}
       ,{field:'lotno', title:'<span style="color:red">批号</span>'}
       ,{field:'glbc', title:'公立医疗机构是否补偿'}
       ,{field:'mybc', title:'民营医疗机构是否有补偿'}
       ,{field:'sybc', title:' 商业公司是否有补偿'}
       ,{field:'lsbc', title:'零售连锁是否有补偿'}
       ,{field:'wabc', title:'维安是否有补偿'}
       ,{field:'txphao', title:' 是否需要填写批号'}
       ,{field:'sfyzm', title:'是否需要证明'}
       ,{field:'sfxyddzm', title:'是否需要单独的库存证明'}
       ,{field:'ccfs', title:'冲差方式（一退一开或冲差）'}
      ,{field:'wcsj',title:'要求完成时间'}
       ,{field:'jjr', title: '核算采购员'}
       ,{field:'right', title: '修改库存/批号',fixed: 'right', toolbar:"#deltaocans",width:150,align:'center' }   
    ]]
    ,id: 'druglistid'
    ,page: true
    ,limit: 7 
    ,limits: [3,5,7,10,20,30]
    /* , done: function(res, curr, count){
    	layer.close(endload);
		  } */
		 
  });
 
  
  
  var $ = layui.$, active = {
		    reload2: function(){
		      var gongysid2 = $('#gongysname2');
		      var spid=$("#shangpbianm2");
		      console.log(gongysid2.val()+"获取输入框的值")
		      
		      //执行重载
		      table.reload('druglistid', {
		        page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
		        	gongysid2: gongysid2.val()
		        	,spid:spid.val()
		        }
		      });
		    }
		  };
  $("#sousuoann2").on('click', function(){
	    var type = $(this).data('type');
	    console.log("点击触发"+type)
	    active[type] ? active[type].call(this) : '';
	  });
  
  
  $("#resetczs").click(function(){
	    $("#gongysname2").val("");
	    $("#gongysid2").val("") ;
	    $("#shangpbianmid2").val("") ;
	    $("#shangpbianm2").val("") ;
 });
  
  
//监听单元格事件
  table.on('tool(druglists)', function(obj){
    var data = obj.data;
    var goodid=data.goodid;
    var name=data.name;
    var linkid=data.linkid;
    var ownerid=data.ownerid;
    var  buyerid=data.buyerid; 
     
     if(obj.event === 'modify'){
    	 var checkStatus = table.checkStatus('druglistid');// 获取父页面名为“repairDataInfo”的表格中，选中的事件
    		console.log(checkStatus.data);
    		if(checkStatus.data == "" || checkStatus.data == null || checkStatus.data == undefined){
    			 layer.alert("请勾选一条记录！")
    		}else{
    			 //弹出一个iframe层
    		    layer.open({
    		      type: 2,
    		      title: '修改联系人信息',
    		      maxmin: true,
    		      shadeClose: true, //点击遮罩关闭层
    		      area : ['45%' , '75%'],
    		      content: 'modlinkbuyer',
    		    	  end: function(){
    						 location.reload();  
    					}

    		    });
    		}
    		
       }
  });
  
  
  
});
</script> 
<script>
//弹出一个页面层
$('#xzgongys2').on('click', function(){
	 //弹出一个iframe层
	    layer.open({
	      type: 2,
	      title: '选择客户',
	      maxmin: true,
	      shadeClose: true, //点击遮罩关闭层 （空白地方关闭子页面）
	      area : ['80%' , '85%'],
	      content: 'ChooseSupplier ',
	    	  end: function(){
					/*  location.reload(); */  //刷新父页面 （主表）
				}
	    });
	  });
	  
	  
$('#xzhuozhu').on('click', function(){
	 //弹出一个iframe层
	    layer.open({
	      type: 2,
	      title: '选择货主',
	      maxmin: true,
	      shadeClose: true, //点击遮罩关闭层 （空白地方关闭子页面）
	      area : ['40%' , '85%'],
	      content: 'ChooseDept',
	    	  end: function(){
					/*  location.reload(); */  //刷新父页面 （主表）
				}
	    });
	  });	  
	  
$('#xzbianma').on('click', function(){
	 //弹出一个iframe层
	    layer.open({
	      type: 2,
	      title: '选择商品编码',
	      maxmin: true,
	      shadeClose: true, //点击遮罩关闭层 （空白地方关闭子页面）
	      area : ['80%' , '85%'],
	      content: 'ChooseCommoditycode',
	    	  end: function(){
					/*  location.reload(); */  //刷新父页面 （主表）
				}
	    });
	  });	 
	  

	var endload=layer.msg('加载中', {
	 icon: 16
	 ,shade: 0.01
	 ,time: 9999999
	});
	  
 
/*  $("#shengcwenjian").click(function(){
	 var a=0;
	 layer.msg('表格生成中',{
		 icon:16
		 ,shade:0.01
		 ,time:9999999
	 });
	 $.ajax({  
		    url: "exportSalesDetailList",  
		    
		    type: "POST",  
		    dataType: "json",  
		    success: function (data) {
		    	   console.log( data.message+"<--");  
		    	$("#ycdxzdz").val(data.message);
		    	$("#xiazaiwenjian").removeAttr("disabled");
		    	layer.confirm('文件已经生成,请点击下载按钮下载！', {
		    		  btn: ['确定'] //按钮
		    		}, function(){
		    			 layer.closeAll();
		    		});
		    	
		    }  
		});	
	 
 }) */
 
</script>
</body>
</html>