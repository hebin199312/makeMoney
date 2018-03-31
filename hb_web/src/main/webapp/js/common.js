//通用ajax 方法
var HrManager={
		sendAjaxPut:function(url,pdata,callback){
			//pdata._method="put";
			 $.ajax({
	             url:url,
	             data:pdata,
	             dataType:'json',
	             method:'PUT',
	             success:callback
	         })
		},
		sendAjaxDelete:function(url,callback){
			// pdata._method='delete';
			 $.ajax({
	            url:url,
	            dataType:'json',
	            method:'DELETE',
	            success:callback
	        })
		},
		sendAjaxPost:function(url,pdata,callback){
			 $.ajax({
	            url:url,
	            data:pdata,
	            dataType:'json',
	            method:'POST',
	            success:callback
	        })
		},
		sendAjaxGet:function(url,pdata,callback){
			 $.ajax({
	            url:url,
	            data:pdata,
	            dataType:'json',
	            method:'GET',
	            success:callback
	        })
		},
		
		//array 转json对象
		//[{id:1},{name:zoukx}]-
		arrToJson:function($ff){
			var data = $ff.serializeArray();
			var obj = {};
			$.each(data,function(i,v){
				
				obj[v.name] = v.value;
			});
			return obj;
		}
		
}