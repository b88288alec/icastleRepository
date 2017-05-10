$(function(){
//	新增年
	for(i = 2017; i >= 2010; i--){
		$('#idSelectYear').append("<option value='" + i + "'>" + i +"</option>");
	}
	
//	新增月
	var opt = document.createElement('option');
	opt.innerHTML = '--';
	$('#idSelectMonth').append("<option value='null'>--</option>");
	for(i = 1; i <= 12; i++){
		$('#idSelectMonth').append("<option value='" + i + "'>" + i +"</option>");
	}
	
//	新增日
	$('#idSelectDate').append("<option value='null'>--</option>");
	
//	改變年份改變月份
	$('#idSelectYear').on("change", function(){
//		$('#idSelectMonth:selected').prop("selected",false);
		$('#idSelectMonth>option[value="null"]').prop("selected",true);
		if(control == 1){
			monthchange();
		}
	})
	
//	button控制器
	var control = 1;

//	改變月份改變日期
	if(control == 1){
		$('#idSelectMonth').on("change", monthchange);
	}
	
//	點按鈕切換圖表列表模式
	$('#idButton').on("click", allchange);
	
	function allchange(){
		if(control == 1){
			$('#idSelectDate').empty().append("<option value='null'>--</option>");
			$('#idSelectMonth>option[value="null"]').prop("selected",true);
			$('#idSelectYear').empty().append("<option value='null'>--</option>");
			for(i = 2017; i >= 2010; i--){
				$('#idSelectYear').append("<option value='" + i + "'>" + i +"</option>");
			}
			$('#idButton').val('列表');
			
			control = 0;
		}else{
			$('#idSelectMonth>option[value="null"]').prop("selected",true);
			$('#idSelectYear').empty();
			for(i = 2017; i >= 2010; i--){
				$('#idSelectYear').append("<option value='" + i + "'>" + i +"</option>");
			}
			$('#idButton').val('圖表');
			
			control = 1;
		}
	}
	
	function monthchange(){
		$('#idSelectDate').empty().append("<option value='null'>--</option>");
		var d = 0;
		if($('#idSelectMonth').val() != 0){
			var y = $('#idSelectYear').val();
			var m = $('#idSelectMonth').val();
			d = (new Date(y, m, 0)).getDate();
		}
		
		for(i = 1; i <= d; i++){
			$('#idSelectDate').append("<option value='" + i + "'>" + i +"</option>");
		}
	}
});
