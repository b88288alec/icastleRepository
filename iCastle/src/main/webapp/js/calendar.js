window.onload = function(){

//	新增年
	for(i = 2018; i >= 2010; i--){
		var opt = document.createElement('option');
		opt.setAttribute('value', i);
		opt.innerHTML = i;
		
		document.getElementById('idSelectYear').appendChild(opt);
	}
	
//	新增月
	var opt = document.createElement('option');
	opt.innerHTML = '--';
	document.getElementById('idSelectMonth').appendChild(opt);
	for(i = 1; i <= 12; i++){
		var opt = document.createElement('option');
		opt.setAttribute('value', i);
		opt.innerHTML = i;
		
		document.getElementById('idSelectMonth').appendChild(opt);
	}
	
//	新增日
	var opt = document.createElement('option');
	opt.innerHTML = '--';
	document.getElementById('idSelectDate').appendChild(opt);
	
	document.getElementById('idSelectMonth').onchange = dayChange;
	
	function dayChange(){
		document.getElementById('idSelectDate').innerHTML = "";
		var opt = document.createElement('option');
		opt.innerHTML = "--";
		document.getElementById('idSelectDate').appendChild(opt);

		var m = document.getElementById('idSelectMonth').value;

		if(m != null){
			var y = document.getElementById('idSelectYear').value;
			var d = (new Date(y, m, 0)).getDate();
			
			for(i = 1; i <= d; i++){
				var opt = document.createElement('option');
				opt.setAttribute('value', i);
				opt.innerHTML = i;
				
				document.getElementById('idSelectDate').appendChild(opt);
			}
		}
	}

}