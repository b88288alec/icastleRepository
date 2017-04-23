$(function(){
	$('#onekey').preventDefault();
	alert('hi');
	$('#onekey').click(function(){
		$('input[name = "type"]').val('高雄');
		$('input[name = "start"]').val('01/02/2017');
		$('input[name = "end"]').val('01/04/2017');
		$('input[name = "peopleNum"]').val(4);
	});
})