	
	const dataRow = document.querySelectorAll('.dataRow');
	const groupBox = document.querySelector('.groupBox');
	const groupStore= [];

	for(const dataRowItem of dataRow)
		{
		 dataRowItem.addEventListener('dragend',dragEnd);
		 dataRowItem.addEventListener('dragstart',dragStart);
		}
	
	
	groupBox.addEventListener('dragover',dragOver);
	groupBox.addEventListener('drop',dragDrop);
	groupBox.addEventListener('dragenter',dragEnter);
	groupBox.addEventListener('dragleave',dragLeave);

	
	function dragStart(e){
		
		e.dataTransfer.setData("text/plain",e.target.id);
		
		console.log(e.target.id);
		
		var target = e.srcElement || e.target;
		
		
		var data = [];
		
	       var cells = target.getElementsByTagName("td");
	        for (var i = 0; i < cells.length; i++) {
	            data.push(cells[i].innerHTML);
	        }
		
		
		console.log(data);
		

		
	    var j = JSON.stringify(data);
	    e.dataTransfer.setData("foo", j);
		
	   // console.log(data[0]);
		

		
	}
	
	function dragEnd(e){

	}
	
	// groupBox
	
	function dragOver(e){
		e.preventDefault();
	}
	
	function dragDrop(e){
		 e.preventDefault();
		this.className ='groupBox';
	}
	
	
	function drop(e) {
	    e.preventDefault();
	    var data = JSON.parse(e.dataTransfer.getData("foo"));
	     
	    console.log("foo is:", data);
	    


	    
	    groupStore.push({emp_no: data[0], birth_date: data[3], first_name: data[1], last_name: data[2], hire_date: data[4]});
	    
	    
	  $("#groupBox").prepend("<p>"+data[0]+" "+data[1]+" "+data[2]+"</p>");
	    
	    console.log("GroupStore has stringify:"+ JSON.stringify(groupStore));
	    console.log("GroupStore object" + (groupStore));
	    
	    
	    
	    this.className ='groupBox';
	}
	
	
	function dragEnter(e){
		e.preventDefault();
		this.className+=' hover';
	}
	
	function dragLeave(){
		this.className ='groupBox';
	}
	
	function createGroup()
	{
		
	var groupName = $('#groupName').val();
	
	console.log("groupName: "+groupName);

		$.ajax({
		       url: "/group",
		       type: 'POST',
		       contentType:'application/json',
		       data: JSON.stringify(
		    		   {
		    			 groupName: groupName,
		    			 group:  groupStore
		    		   })
		    		,
		       dataType:'json'
		});

	}
	
function groupPageSwitch(){
	window.location.href = '/getGroups';
	}

