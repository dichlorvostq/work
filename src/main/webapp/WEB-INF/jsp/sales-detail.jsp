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
 <div class="drugfid">
  请输入商品编码：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="drugsearchid" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" id="qiguai">搜索</button>
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
   <a class="layui-btn layui-btn-danger layui-btn-xs"  lay-event="dell">删除</a>
<a class="layui-btn layui-btn-danger layui-btn-xs"  lay-event="modify">修改</a>
</script>  

<script>
layui.use('table', function(){
  var table = layui.table; 
  
  //方法级渲染
  table.render({
    elem: '#LAY_table_user'
    ,url: 'selectSalesDetailList'
    ,cellMinWidth: 120
    ,cols: [[
      /* ,{field:'id', title:'序号',width:80, sort: true, style:'color:#000;',fixed: true,templet: '<div><a href="/detail/{{d.id}}" class="layui-table-link">{{d.LAY_TABLE_INDEX+1}}</a></div>'} */
       {type:'radio',fixed: true}
       ,{field:'id', title: '1', sort: true }
      ,{field:'billno', title: '2' }
      ,{field:'createdate', title: '货主名称'}
      ,{field:'empname', title: '联系人id'}
      ,{field:'cstcode', title: '联系人编码'}
      ,{field:'dname', title: '联系人名称'}
      ,{field:'goods', title: '商品id'}
      ,{field:'marketno', title: '商品编码'}
      ,{field:'name',minWidth:280, title: '商品名称'}
      ,{field:'spec', title: '商品规格'}
      ,{field:'packnum', title: '商品单位'}
      ,{field:'warebrand', title: '商品数量'}
      ,{field:'billqty',   minWidth:280, title: '厂家' }
      ,{field:'prc',  minWidth:280,  title: '商品厂家名'}
      ,{field:'sumvalue', title: '采购员id'}
      ,{field:'taxrate', title: '采购员名称'}
      ,{field:'invoicedate',minWidth:280, title: '厂牌'}
      ,{field:'invoiceno', title: '创建时间'}
      ,{field:'deptname', title: '创建人id'}
      ,{field:'bthdesc', title: '创建人名字'}
      ,{field:'flowname', title: '创建人名字'}
      ,{field:'gname', title: '创建人名字'}
      ,{field:'woempcode', title: '创建人名字'}
      ,{field:'woempname', title: '创建人名字'}
      ,{field:'backreasonname', title: '创建人名字'}
      ,{field:'yddate', title: '创建人名字'}
      ,{field:'curempname', title: '创建人名字'}
      ,{field:'osbillno', title: '创建人名字'}
      ,{field:'linkcode_bth', title: '创建人名字'}
      ,{field:'linkname_bth', title: '创建人名字'}
      ,{field:'supcode_bth', title: '创建人名字'}
      ,{field:'supname_bth', title: '创建人名字'}
      ,{field:'indate', title: '创建人名字'}
      ,{field:'buyercode', title: '创建人名字'}
      ,{field:'buyername', title: '创建人名字'}
      ,{field:'inprc', title: '创建人名字'}
      ,{field:'batchid', title: '创建人名字'}
      ,{field:'invcnt', title: '创建人名字'}
      ,{field:'ddeptname', title: '创建人名字'}
      /* ,{field:'purchaseprice', title: '采购价格', event: 'setSigns'}
      ,{field:'salesprice', title: '销售价格', event: 'setsalesprice'}
      ,{field:'supplier', title: '供应商'} */
       /* ,{field:'right', title: '修改品种',fixed: 'right', toolbar:"#deltaocan",width:150,align:'center' }    */
    ]]
    ,id: 'druglistid'
    ,page: true
    ,limit: 5 
    ,limits: [3,5,10,20,30]
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
  $("#qiguai").on('click', function(){
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