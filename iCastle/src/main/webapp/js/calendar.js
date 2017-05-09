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
		monthchange();
	})
	
//	改變月份改變日期
	$('#idSelectMonth').on("change", monthchange);
	
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
