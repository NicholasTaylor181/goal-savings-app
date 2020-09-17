function edit(element){
    var data = "";
	var tr = jQuery(element).parent().parent();
	if(!tr.hasClass("editing")) {
		tr.addClass("editing");
		tr.find("DIV.td").each(function(){
			if(!jQuery(this).hasClass("action")){

			    var tempId = jQuery(this).html();
				var value = jQuery(this).text();
				//find the id in value and pull

                alert($(this).attr("id"));

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