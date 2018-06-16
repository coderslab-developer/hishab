$(document).ready(function() {
	/**
	 * Alert message
	 */
	showMessage = function(type, message) {
		$(".myAlert-top").addClass(type);
		$('.alert-message').text(message);
		$(".myAlert-top").show();
		setTimeout(function() {
			$(".myAlert-top").hide();
			$(".myAlert-top").removeClass(type);
		}, 4000);
	}

	/**
	 * Form validation
	 */
	ValidateForm = function(formname){
		var formData = $('.' + formname).serializeArray();
		var validateSuccess = true;
		$.each(formData, function(index, item){
			var attr = $('#' + item.name).attr('required');
			if(typeof attr !== typeof undefined){
				if(attr !== false){
					if(item.value == ''){
						$('#' + item.name).addClass('required');
						validateSuccess = false;
					} else {
						$('#' + item.name).removeClass('required');
					}
				}
			}
		});

		return validateSuccess;
	}

	/**
	 * Reset form
	 */
	resetForm = function (formName){
		$('.' + formName).find('input:hidden, input:text, input:password, select, textarea').val('');
		$('.' + formName).find('input:radio, input:checkbox').prop('checked', false);
	}
});