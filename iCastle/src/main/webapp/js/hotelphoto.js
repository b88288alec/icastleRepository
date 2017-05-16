
var index = 0;
var page = 0;

$(function() {
	
	index = parseInt($('#index').val(), 10);
	page = index-1;
	console.log('page1= '+page);
	
	$("#list").css("width", page*100+"px");
	
	// 按下向左按鈕
	$('#left').click(function() {
		var lef = parseInt($('#list').css("left"));
		console.log("lef= "+ lef);
		if (lef < 0)
			$('#list').css("left", lef + 100 + "px");
	})

	// 按下向右按鈕
	$('#right').click(function() {
		var lef = parseInt($('#list').css("left"));
		console.log("lef= "+ lef);
		if (lef > -100*(page-5))
			$('#list').css("left", lef - 100 + "px");
	})

	//按下刪除
	$('#delete').click(function(){
		page--;
		$("#"+$('.bigImage').attr('data-img')).parent().css('display', 'none'); 
		$("#"+$('.bigImage').attr('data-img')).parent().children('input:eq(0)').attr('name', 'delete');
		console.log( $('#list').css("left") );
		
		$('.bigImage').css('display', 'none');
		
		if ( 100*page + parseInt($('#list').css("left")) < 500)
			$('#list').css("left", (page - 5) * (-100) + "px");
		
		if ( parseInt($('#list').css("left")) > 0 ){
			$('#list').css("left", "0px");
		}
		
		$("#list").css("width", page*100+"px");
	})
	
	//初始化roomTypeId
	var initroomTypeId = $('#roomTypeIdimg1').val().trim();
	if (initroomTypeId == '無'){
		$('#roomTypeId>option[value = "無"]').prop('selected', 'true');
		console.log('無');
	}else{
		$('#roomTypeId>option[value = "' + initroomTypeId + '"]').prop('selected', 'true');
		console.log('有');
	}
	
	//點擊圖片
	$("#list").on('click', '.imgs', function (){
		//秀出大圖
		$('.bigImage').css('display', 'initial');
		$('.bigImage').attr('src', $(this).attr('src'));
		//秀出description
		var des = $(this).parent().children('input:eq(1)').val();
		console.log( des );
		$('#description').val(des);
		//秀出roomTypeId
		var roomTypeId = $(this).parent().children('input:eq(2)').val().trim();
		console.log( 'roomTypeId= ' + roomTypeId );
		if (roomTypeId == '無'){
			$('#roomTypeId>option[value = "無"]').prop('selected', 'true');
			console.log('無');
		}else{
			$('#roomTypeId>option[value = "' + roomTypeId + '"]').prop('selected', 'true');
			console.log('有');
		}
		//用data-img記住是哪一張圖
		$('.bigImage').attr('data-img', $(this).attr('id'));
	});
	
	//修改description
	$("#description").blur(function(){
		console.log( $(this).val() );
		$('#inp' + $('.bigImage').attr('data-img')).val( $(this).val() );
		
	});
	
	//修改roomTypeId
	$("#roomTypeId").change(function(){
		console.log( $(this).val() );
		$('#roomTypeId' + $('.bigImage').attr('data-img')).val( $(this).val() );
		
	});
	
	//讓圖片可排序
	$(function() {
		$("#list").sortable();
		$("#list").disableSelection();
	});
});

//點擊多張圖片上傳
var fileObj = document.getElementById("file");
fileObj.onchange = function (){
    var theFiles = document.getElementById("file").files;
    
    for (var i = 0; i < theFiles.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(theFiles[i]);
        
        //產生img標籤
        //將img貼到div
        
        reader.onload = (function(theFile){
            var fileName = theFile.name;
            return function(e){
            	 var fileContent = e.target.result;
                 console.log(e.target.name);
                 
                 //得到img src
                 
                 //產生img
                 var imgObj = document.createElement("img");  //<img>
                 imgObj.setAttribute("src", fileContent);  //<img src=...
                 imgObj.setAttribute("id", "img" + index);
                 imgObj.classList.add("imgs");
                 
                 //產生藏type的input
                 var typeObj = document.createElement("input");
                 typeObj.setAttribute("name", "insert");
                 typeObj.setAttribute("type", "hidden");
                 
                 //產生藏description的input
                 var descriptionObj = document.createElement("input");
                 descriptionObj.setAttribute("name", "imgdescription" + index);
                 descriptionObj.setAttribute("id", "inpimg" + index);
                 descriptionObj.setAttribute("type", "hidden");
                 
                 //產生藏roomTypeId的input
                 var roomTypeIdObj = document.createElement("input");
                 roomTypeIdObj.setAttribute("name", "imgroomTypeId" + index);
                 roomTypeIdObj.setAttribute("id", "roomTypeIdimg" + index++);
                 roomTypeIdObj.setAttribute("value", "無");
                 roomTypeIdObj.setAttribute("type", "hidden");
                 
                 //產生li
                 var liObj = document.createElement("li");
                 liObj.appendChild(imgObj);
                 liObj.appendChild(typeObj);
                 liObj.appendChild(descriptionObj);
                 liObj.appendChild(roomTypeIdObj);
                 
                 //將li放到list內
                 document.getElementById("list").appendChild(liObj);
                 page++;
                 $("#list").css("width", page*100+"px");
                 console.log('page= '+page);
            };
        })(theFiles[i]);   
        
        
        
//        reader.onload = function (e) {         
//            var fileContent = e.target.result;
//            
//            //得到img src
//            
//
//            //產生img
//            var imgObj = document.createElement("img");  //<img>
//            imgObj.setAttribute("src", fileContent);  //<img src=...
//            imgObj.setAttribute("id", "img" + index);
//            imgObj.classList.add("imgs");
//            
//            //產生藏type的input
//            var typeObj = document.createElement("input");
//            typeObj.setAttribute("name", "insert");
//            typeObj.setAttribute("type", "hidden");
//            
//            //產生藏description的input
//            var descriptionObj = document.createElement("input");
//            descriptionObj.setAttribute("name", "imgdescription" + index);
//            descriptionObj.setAttribute("id", "inpimg" + index);
//            descriptionObj.setAttribute("type", "hidden");
//            
//            //產生藏roomTypeId的input
//            var roomTypeIdObj = document.createElement("input");
//            roomTypeIdObj.setAttribute("name", "imgroomTypeId" + index);
//            roomTypeIdObj.setAttribute("id", "roomTypeIdimg" + index++);
//            roomTypeIdObj.setAttribute("value", "無");
//            roomTypeIdObj.setAttribute("type", "hidden");
//            
//            //產生li
//            var liObj = document.createElement("li");
//            liObj.appendChild(imgObj);
//            liObj.appendChild(typeObj);
//            liObj.appendChild(descriptionObj);
//            liObj.appendChild(roomTypeIdObj);
//            
//            //將li放到list內
//            document.getElementById("list").appendChild(liObj);
//            page++;
//            console.log('page= '+page);
//        }
    }
}













//javascript不可放在$(function(){})裡面
//點下右鍵
function dragoverHandler(e) {
    e.preventDefault();
}



//提起右鍵
function dropHandler(e) {
    e.preventDefault();
    
    var theFiles = e.dataTransfer.files//檔案的DOM(?)物件
    
    for (var i = 0; i < theFiles.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(theFiles[i]);//開始讀取檔案
		
        reader.onload = function (e) {//完成檔案讀取
            var fileContent = e.target.result;
        	console.log("toString "+fileContent.toString());
        	
        	//建立一張圖
            var imgObj = document.createElement("img");  //<img>
            imgObj.classList.add("imgs");
            imgObj.setAttribute("src", fileContent);  //<img src=...
//            imgObj.setAttribute("class", "thumb");  //<img src=... class="....
            
            //建立input標籤
            var inpObj = document.createElement("input");
            inpObj.setAttribute("name", "img" + index++);
            inpObj.setAttribute("value", fileContent.toString());
            inpObj.setAttribute("type", "hidden");
            
            
            //建立一個li
            var liObj = document.createElement("li");
            liObj.appendChild(imgObj);
            liObj.appendChild(inpObj);
            
            
            //將li放到list內
            document.getElementById("list").appendChild(liObj);
        }
    }
}

