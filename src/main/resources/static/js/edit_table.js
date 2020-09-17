function edit(element){




    var goals = {};
	var tr = jQuery(element).parent().parent();
	if(!tr.hasClass("editing")) {


		tr.addClass("editing");
		tr.find("DIV.td").each(function(){
			if(!jQuery(this).hasClass("action")){

			var value = jQuery(this).text();


				jQuery(this).text("");

				jQuery(this).append('<input type="text" value="'+value+'" />');




			} else {
				jQuery(this).find("BUTTON").text("save");
			}
		});
	} else {
		tr.removeClass("editing");

		var goal = {
            id: null,
            title: null,
            cost: null,
            amountSaved: null,
            completed: null,
            public: null
        };

        var goalLength = Object.keys(goal).length - 1;

		tr.find("DIV.td").each(function(){



			if(!jQuery(this).hasClass("action")){




				var value = jQuery(this).find("INPUT").val();


				if(goal["id"] === null) {
                			        goal["id"] = $(this).attr("id");
                			    }

                			    for (item in goal) {
                			        if(goal[item] === null ) {
                			            goal[item] = value;
                			            if(!(goal[Object.keys(goal)[goalLength]] === null)) {

                                        var jsonGoal = JSON.stringify(goal);



                                                $.ajax({
                                                       type: "POST",
                                                       contentType : 'application/json; charset=utf-8',
                                                       dataType : 'json',
                                                       url: "/goal/saveGoal.html",
                                                       data: JSON.stringify(goal),
                                                       success :function(result) {
                                                       alert(JSON.stringify(goal));
                                                       }
                                                   });

                			            }else{
                			            break
                			            }
                			        }
                			    }
				jQuery(this).text(value);
				jQuery(this).find("INPUT").remove();

			} else {
				jQuery(this).find("BUTTON").text("edit");
			}
		});
	}
}
