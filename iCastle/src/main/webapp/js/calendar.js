$(function(){
//	新增年
	for(i = 2017; i >= 2010; i--){
		$('#idSelectYear').append("<option value='" + i + "'>" + i +"</option>");
	}
	
//	新增月
	var opt = document.createElement('option');
	opt.innerHTML = '--';
	$('#idSelectMonth').append("<option>--</option>");
	for(i = 1; i <= 12; i++){
		$('#idSelectMonth').append("<option value='" + i + "'>" + i +"</option>");
	}
	
//	新增日
	$('#idSelectDate').append("<option>--</option>");
	
	$('#idSelectMonth').change(dayChange);

	function dayChange(){
		$('#idSelectDate').empty().append("<option>--</option>");
		if($('#idSelectMonth').attr('value') != null){
			var d = (new Date($('#idSelectYear').attr('value'),$('#idSelectMonth').attr('value'),0)).getDate();
		}
		
		for(i = 1; i <= d; i++){
			$('#idSelectDate').append("<option value='" + i + "'>" + i +"</option>");
		}
		
	}	
});
