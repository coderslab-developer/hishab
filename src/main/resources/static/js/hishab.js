$(document).ready(function() {
	$('.expense-btn, .save-btn, .transfer-btn, .wallet-btn').on('mouseover', function(){
		$(this).animate({'margin-bottom': '20px'}, 200);
	}).on('mouseout', function() {
		$(this).animate({'margin-bottom': '0px'}, 200);
	});
});