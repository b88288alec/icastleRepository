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
		if($('#idButton').val() == '0'){
			$('#idSelectMonth>option[value="null"]').prop("selected",true);
			monthchange();
		}else{
			$('#idSelectMonth').empty().append("<option value='null'>--</option>");
			if($('#idButton').val() == '2'){
				if($('#idSelectYear').val() != 'null'){
					for(i = 1; i <= 12; i++){
						$('#idSelectMonth').append("<option value='" + i + "'>" + i +"</option>");
					}
				}
			}else{
				for(i = 1; i <= 12; i++){
					$('#idSelectMonth').append("<option value='" + i + "'>" + i +"</option>");
				}
			}
		}
	})

//	改變月份改變日期
	$('#idSelectMonth').on("change", monthchange);
	
//	點按鈕切換圖表列表模式
	$('#idButton').on("change", allchange);
	
	function allchange(){
		if($('#idButton').val() == '1' || $('#idButton').val() == '2' || $('#idButton').val() == '3'){
			
//			更改選擇器項目
			$('#idSelectDate').empty().append("<option value='null'>--</option>");
//			$('#idSelectMonth>option[value="null"]').prop("selected",true);
			$('#idSelectMonth').empty().append("<option value='null'>--</option>");
			$('#idSelectRoomTypeName').prop("disabled", false);
			$('#showdatapic').remove();
			
//			根據長條圖、折線圖、圓餅圖來改變"年份"和"月份"
			if($('#idButton').val() == '1'){
				$('#idSelectYear').empty().append("<option value='null'>--</option>");
				for(i = 2017; i >= 2010; i--){
					$('#idSelectYear').append("<option value='" + i + "'>" + i +"</option>");
				}
			}else{
				if($('#idButton').val() == '2'){
					$('#idSelectYear').empty().append("<option value='null'>--</option>");
					for(i = 1; i <= 12; i++){
						$('#idSelectMonth').append("<option value='" + i + "'>" + i +"</option>");
					}
				}else{
					$('#idSelectYear').empty().append("<option value='null'>--</option>");
					for(i = 2017; i >= 2010; i--){
						$('#idSelectYear').append("<option value='" + i + "'>" + i +"</option>");
					}
					
					$('#idSelectRoomTypeName>option[value="null"]').prop("selected",true);
					$('#idSelectRoomTypeName').prop("disabled", true);
				}
			}
				
			
//			把表格換成長條圖模式
			$('#showData').empty();
		}else{
			
//			更改選擇器項目
//			$('#idSelectMonth>option[value="null"]').prop("selected",true);
			$('#idSelectMonth').empty().append("<option value='null'>--</option>");
			for(i = 1; i <= 12; i++){
				$('#idSelectMonth').append("<option value='" + i + "'>" + i +"</option>");
			}
			$('#idSelectYear').empty();
			for(i = 2017; i >= 2010; i--){
				$('#idSelectYear').append("<option value='" + i + "'>" + i +"</option>");
			}
			
//			把長條圖模式換成表格
			$('#showData').empty().append('<table class="table"><thead><tr><th>訂單編號</th><th>下訂日期</th><th>房型名稱</th><th>入住日期</th><th>退房日期</th><th>訂房數量</th><th>入住人數</th><th>入住人姓名</th><th>加床</th><th>總金額</th><th>旅客備註</th><th>備忘錄</th><th>訂單狀態</th></tr></thead><tbody id="idtbody"></tbody></table>');
		}
	}
	
	function monthchange(){
		$('#idSelectDate').empty().append("<option value='null'>--</option>");
		if($('#idButton').val() == '0'){
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
	}
});