$(document).ready(function() {
	showMessage = function(type, message) {
		$(".myAlert-top").addClass(type);
		$('.alert-message').text(message);
		$(".myAlert-top").show();
		setTimeout(function() {
			$(".myAlert-top").hide();
			$(".myAlert-top").removeClass(type);
		}, 4000);
	}
});