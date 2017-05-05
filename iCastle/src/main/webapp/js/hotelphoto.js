$(function() {
	// 按下向左按鈕
	$('#left').click(function() {
		console.log("left");
		var lef = parseInt($('#selectable').css("left"));
		console.log(lef);
		if (lef < 0)
			$('#selectable').css("left", lef + 100 + "px");
	})

	// 按下向右按鈕
	$('#right').click(function() {
		console.log("right");
		var lef = parseInt($('#selectable').css("left"));
		console.log(lef);
//		if (lef > -300)
		$('#selectable').css("left", lef - 100 + "px");
	})

//	// selectable
//	$("#selectable img").click(function (){
//		console.log($(this).attr('src'));
//		$('.bigImage').attr('src', $(this).attr('src'));
//	});

	// selectable
	$("#selectable").on('click', '.imgs', function (){
		console.log($(this).attr('src'));
		$('.bigImage').attr('src', $(this).attr('src'));
	});
	
	//on的模板
	$('#simpleTable').on('click', '.btn-danger', function(){
		$(this).parent().parent().remove();
	});
	
});

//javascript不可放在$(function(){})裡面
//點下右鍵
function dragoverHandler(e) {
    e.preventDefault();
}

var index = 1;

//提起右鍵
function dropHandler(e) {
    e.preventDefault();
    
    var theFiles = e.dataTransfer.files//檔案的DOM(?)物件
    
    for (var i = 0; i < theFiles.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(theFiles[i]);//開始讀取檔案
		
        reader.onload = function (e) {//完成檔案讀取
            var fileContent = e.target.result;
        	console.log(fileContent);
        	
        	//建立一張圖
            var imgObj = document.createElement("img");  //<img>
            imgObj.classList.add("imgs");
            imgObj.setAttribute("src", fileContent);  //<img src=...
//            imgObj.setAttribute("class", "thumb");  //<img src=... class="....
            
            //建立input標籤
            var inpObj = document.createElement("input");
            inpObj.setAttribute("name", "img" + index++);
            inpObj.setAttribute("value", fileContent);
            inpObj.setAttribute("type", "hidden");
            
            
            //建立一個li
            var liObj = document.createElement("li");
            liObj.appendChild(imgObj);
            liObj.appendChild(inpObj);
            
            
            //將li放到selectable內
            document.getElementById("selectable").appendChild(liObj);
        }
    }
}

