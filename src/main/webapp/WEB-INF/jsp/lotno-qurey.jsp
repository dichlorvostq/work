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

<!-- 开始 -->
<div>
<div class="layui-form-item">
       <div class="layui-inline">
       <label class="layui-form-label">厂牌:</label>
          <div class="layui-input-inline">
		       <input class="layui-input" name="changpai" id="changpai" autocomplete="off">
		    </div>
		    
		   <label class="layui-form-label">联系人:</label> 
          <div class="layui-input-inline">
		       <input class="layui-input" name="lianxirenlxr" id="lianxirenlxr" autocomplete="off">
		    </div> 
		    
		    	<!--   <div class="layui-inline">
		    	  <label class="layui-form-label">日期:</label> 
	      			<div class="layui-input-inline">
	           			 <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input"  readonly="readonly">
	      			  </div>
       				</div> -->
	      			  
	      			 <!--  <div class="layui-inline">
					      <div class="layui-input-inline">
					        <input type="text" name="date1" id="date1" lay-verify="date1"placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input"  readonly="readonly">
					      </div> 
					   </div> -->
        </div>
</div>


<div class="layui-form-item">
  
      <!--   <div class="layui-inline">
          <label class="layui-form-label">货主:</label> 
          <div class="layui-input-inline">
		    <input class="layui-input" name="huozhuhz" id="huozhuhz" autocomplete="off"   readonly="readonly">
		    <input   name="huozhuhzid" id="huozhuhzid"  type="hidden" >
		    </div>
        </div> 
        
	   <button   class="layui-btn   layui-btn-sm "  id="xzhuozhu">选择货主</button>-->
	   
	    <div class="layui-inline">
    <label class="layui-form-label">商品编码:</label> 
      <div class="layui-input-inline">
        <input  name="shangpbianmid"  id="shangpbianmid"    class="layui-input"  readonly="readonly">
        <input  name="shangpbianm"  id="shangpbianm"   type="hidden" >
      </div>
    </div>
    <div class="layui-inline">
     <!--  <div class="layui-input-inline">
        <input  name="shangpbianm"  id="shangpbianm"  class="layui-input">
      </div> -->
           <button class="layui-btn   layui-btn-sm" id="xzbianma">选择编码</button>
    </div>
	   
            <div class="layui-inline">
			    <label class="layui-form-label">供应商:</label> 
			      <div class="layui-input-inline">
			        <input class="layui-input" name="gongysname" id="gongysname"  readonly="readonly"  style="width: 100%">
			        <input    type="hidden"  name="gongysid" id="gongysid"  >
			      </div>
    		</div>
    		<div class="layui-inline">
		      <!-- <div class="layui-input-inline">
		        <input class="layui-input" name="gongysmcheng" id="gongysmcheng" autocomplete="off"  >
		      </div> -->
       		<button class="layui-btn  layui-btn-sm " id="xzgongys">选择供应商</button>
    	</div>
    	<div class="layui-inline">
    	   <button class="layui-btn" data-type="reload" id="sousuoann">搜索</button>
		     <button  id="resetcz" class="layui-btn layui-btn-primary">重置</button>
		     </div>
    </div>
 

 
</div>
<!-- 结束 -->
 
<table class="layui-hide" id="LAY_table_user" lay-filter="druglist"></table> 

<!--  <div   >
 <div style="float: left;">
 <button class="layui-btn" data-type="reload" id="shengcwenjian">生成excel</button>
 </div>
 
 <div  style="float: left;" >
  <form  action="exdownload"  method="post"  >
   <input type="hidden" name="ycdxzdz" id="ycdxzdz"  >   
  <button class="layui-btn" data-type="reload" id="xiazaiwenjian"  disabled="disabled"  style="margin-left: 20px;">下载文件</button>
 </form >
 </div>
 </div> -->
          
<script src="static/js/layui.js" charset="utf-8"></script>

 <script type="text/html" id="deltaocan">
   <a class="layui-btn layui-btn-danger layui-btn-xs"  lay-event="dell">删除</a>
<a class="layui-btn layui-btn-danger layui-btn-xs"  lay-event="modify">修改</a>
</script>  

<script>
layui.use(   ['table', 'laydate'], function(){
  var table = layui.table; 
  var laydate = layui.laydate;
  
  
  //日期
  laydate.render({
    elem: '#date'
    ,value: new Date( )
  });
  laydate.render({
    elem: '#date1'
  	,value: new Date( ) 
  });
  
  //方法级渲染
  table.render({
    elem: '#LAY_table_user'
    ,url: 'selectLotnoQureyLists'
    ,cellMinWidth: 120
    ,cols: [[
      /* ,{field:'id', title:'序号',width:80, sort: true, style:'color:#000;',fixed: true,templet: '<div><a href="/detail/{{d.id}}" class="layui-table-link">{{d.LAY_TABLE_INDEX+1}}</a></div>'} */
       {type:'radio',fixed: true}
      /*  ,{field:'id', title: '1', sort: true } */
      ,{field:'compid', title: '所有者代码' }
      ,{field:'ownerid', title: '所有者名称'}
      ,{field:'ownercode', title: '仓库代码'}
      ,{field:'ownername', title: '仓库名称'}
      ,{field:'deptid', title: ' 逻辑库'}
      ,{field:'deptcode', title: '商品代码'}
      ,{field:'deptname', title: '市场码'}
      ,{field:'lotid',minWidth:280, title: '品名'}
      ,{field:'batchid', title: '规格'}
      ,{field:'status', title: '包装'}
      ,{field:'qltstatus', title: '厂牌'}
      ,{field:'goods',   minWidth:280, title: '数量' }
      ,{field:'name',  minWidth:280,  title: '含税单价'}
      ,{field:'producer', title: '含税金额'}
      ,{field:'packnum', title: '税率'}
      ,{field:'msunitno',minWidth:280, title: '发票日期'}
      ,{field:'unipurchase', title: '发票号'}
      ,{field:'lotno', title: '销售部门'}
      ,{field:'prddate', title: '订单批号'}
      ,{field:'enddate', title: '业务类型'}
      ,{field:'goodid', title: '商品通用名'}
      ,{field:'allo_qty', title: '责任采购员ID'}
      ,{field:'unallo_qty', title: '责任采购员'}
      ,{field:'scmlocked_qty', title: '退货/差价原因'}
      ,{field:'logiclocked_qty', title: '原单销售时间'}
      ,{field:'difflockedqty', title: '当前业务员'}
      ,{field:'packpiece', title: '原订单号'}
      ,{field:'ratifier', title: '批次联系人ID'}
      ,{field:'agree_code', title: '批次联系人'}
      ,{field:'checkno', title: '批次供应商ID'}
      ,{field:'rtnflag', title: '批次供应商'}
      ,{field:'allo_in_date', title: '批次进仓日期'}
      ,{field:'allo_out_date', title: '采购员ID'}
      ,{field:'unallo_in_date', title: '采购员'}
      ,{field:'unallo_out_date', title: '批次进货含税单价'}
      ,{field:'AVGPRICE', title: '批次号'}
      ,{field:'memo1', title: '票数'}
      ,{field:'memo2', title: '部门名称'}
      ,{field:'germlotno', title: '核算采购员'}
      ,{field:'sumprice1', title: '核算采购员'}
      ,{field:'sumprice2', title: '核算采购员'}
      ,{field:'depositflag', title: '核算采购员'}
      ,{field:'deposittype', title: '核算采购员'}
      ,{field:'marketno', title: '核算采购员'}
      ,{field:'spdrug', title: '核算采购员'}
      ,{field:'cordialflag', title: '核算采购员'}
      ,{field:'empcode', title: '核算采购员'}
      ,{field:'empname', title: '核算采购员'}
      ,{field:'cstcode', title: '核算采购员'}
      ,{field:'cstname', title: '核算采购员'}
      ,{field:'lastpurdate', title: '核算采购员'}
      ,{field:'batchno', title: '核算采购员'}
      ,{field:'lastavgprc', title: '核算采购员'}
      ,{field:'avgsum', title: '核算采购员'}
      ,{field:'linkcode', title: '核算采购员'}
       ,{field:'linkname', title: '核算采购员'}
       ,{field:'warebrand', title: '核算采购员'}
       ,{field:'deptlogicname', title: '核算采购员'}
       ,{field:'gys_code', title: '核算采购员'}
       ,{field:'ys_name', title: '核算采购员'}
       ,{field:'indate', title: '核算采购员'}
       ,{field:'inprc', title: '核算采购员'}
       ,{field:'inprice', title: '核算采购员'}
       ,{field:'jjr', title: '核算采购员'}
        
      
      /* ,{field:'purchaseprice', title: '采购价格', event: 'setSigns'}
      ,{field:'salesprice', title: '销售价格', event: 'setsalesprice'}
      ,{field:'supplier', title: '供应商'} */
       /* ,{field:'right', title: '修改品种',fixed: 'right', toolbar:"#deltaocan",width:150,align:'center' }    */
    ]]
    ,id: 'druglistid'
    ,page: true
    ,limit: 7 
    ,limits: [3,5,7,10,20,30]
    , done: function(res, curr, count){
    	layer.close(endload);
		  }
		 
  });
  
  
  
//监听单元格事件
  table.on('tool(druglist)', function(obj){
    var data = obj.data;
    var goodid=data.goodid;
    var name=data.name;
    var linkid=data.linkid;
    var ownerid=data.ownerid;
    var  buyerid=data.buyerid; 
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
		    	if(state.state==200){
		    		 layer.alert("数据保存成功！" , function(index){
		    					  layer.close(index);
		    					  table.reload('druglistid', {
		    						  /* page: {
		    					          curr: 1 //重新从第 1 页开始
		    					        } */
		    					  });
		    					});
		    	}
		    	if(state.state==100){
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
	      layer.confirm('您确定要将【'+name+'】从药品库中删除吗？',  {
			  btn: ['确定','取消'] //按钮
			}, function(){
				$.ajax({  
				    url: "DelLinkbuyer",  
				    data: {goodid:goodid,ownerid:ownerid,linkid:linkid,buyerid:buyerid},  
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
  
  
  var $ = layui.$, active = {
		    reload: function(){
		      
		      var changpai = $('#changpai').val();
		      var lianxiren=$("#lianxirenlxr").val();
		      var ksriqi=$("#date").val();
		      console.log(ksriqi+"开始日期");
		      var jsriqi=$("#date1").val();
		      var  huozhu=$("#huozhuhz").val();
		      var gongyshangid=$("#gongysid").val();
		      var shangpbianmid=$("#shangpbianmid").val();
		      
		      //执行重载
		      table.reload('druglistid', {
		        page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
		        	changpai: changpai
		        	,lianxiren:lianxiren
		        	,ksriqi:ksriqi
		        	,jsriqi:jsriqi
		        	,huozhu:huozhu
		        	,gongyshangid:gongyshangid
		        	,shangpbianmid:shangpbianmid
		        }
		      });
		    }
		  };
  $("#sousuoann").on('click', function(){
	    var type = $(this).data('type');
	    console.log("点击触发"+type)
	    active[type] ? active[type].call(this) : '';
	  });
  
  $("#resetcz").click(function(){
	     var ypmchen=$("#changpai").val("");
	     var ypgge=$("#lianxirenlxr").val("") ;
	     var ypflei=$("#date").val("") ;
	     var ypjchen=$("#date1").val("") ;
	     var tiadoxm=$("#huozhuhz").val("");
	     var tiadsoxm=$("#gongysid").val("");
	     var tiaodssxm=$("#gongysname").val("");
  });
  
});
</script>
 <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="static/js/lay/modules/layer.js"></script>
<script>
//弹出一个页面层
$('#xzgongys').on('click', function(){
	 //弹出一个iframe层
	    layer.open({
	      type: 2,
	      title: '选择供应商',
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
	  
 
 $("#shengcwenjian").click(function(){
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
	 
 })
 
</script>
</body>
</html>