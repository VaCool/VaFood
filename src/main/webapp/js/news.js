var i = 0;
var timerId;
$(document).ready(function() {
$(".slider-point-1").attr("checked", true);
var massName = new Array();
var radio = $(".slider-point-1, .slider-point-2, .slider-point-3, .slider-point-4, .slider-point-5");
$('input[type=radio]').each(function (i) {
	massName.push($(this).attr('class'));
});

 radio.click(function(event){  
 	clearInterval(timerId);

  	for(var j = 0; j < massName.length; j++){
 		if(massName[j] == $(this).attr('class')){
 
 			repeat(j);	
 		}
 	 }
 });

repeat(i);


function repeat(i){
	 timerId = setInterval(function() {
i++;
if(i == massName.length){
	i = 0;
}
$("." + massName[i]).trigger('click');
}, 3000);
}



});



