function edit(element){




    var goals = {};
	var tr = jQuery(element).parent().parent();
	if(!tr.hasClass("editing")) {
	    let goal = {
                id: null,
                title: null,
                cost: null,
                amountSaved: null,
                completed: null,
                public: null
            };

		tr.addClass("editing");
		tr.find("DIV.td").each(function(){
			if(!jQuery(this).hasClass("action")){

			var value = jQuery(this).text();

			    if(goal["id"] === null) {
			        goal["id"] = $(this).attr("id");
			    }

			    for (item in goal) {
			        if(goal[item] === null ) {
			            goal[item] = value;
			            break
			        }
			    }


				//find the id in value and pull


				jQuery(this).text("");

				jQuery(this).append('<input type="text" value="'+value+'" />');
//				$(document).on("click","#saveData", function(){
//                      var myData = $("#myData").text();
//                      $.ajax({
//                          url: 'save/',
//                          type: 'POST',
//                          dataType: 'json',
//                          data: { 'myData': value, jQuery(this) },
//                          success: function(data){
//                             alert('Save');
//                          }
//                      });

//               });

            for (item in goal) {
            alert(item + " " + goal[item]);
            }


			} else {
				jQuery(this).find("BUTTON").text("save");
			}
		});
	} else {
		tr.removeClass("editing");
		tr.find("DIV.td").each(function(){
			if(!jQuery(this).hasClass("action")){



				var value = jQuery(this).find("INPUT").val();

				jQuery(this).text(value);
				jQuery(this).find("INPUT").remove();

			} else {
				jQuery(this).find("BUTTON").text("edit");
			}
		});
	}
}


//give unique id

// make javascript object for goal?
// json.stringify? convert object to string
//json.parse? goes back to javascript