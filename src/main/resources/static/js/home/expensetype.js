/**
 * Global namespace 'cl' for CodersLab Bangladesh Ltd
 */
var cl = cl || {};
/**
 * Hishab namespace
 */
cl.hishab = cl.hishab || {};
/**
 * expense-type name space
 */
cl.hishab.ext = cl.hishab.ext || {};

cl.hishab.ext.resetModal = function(formName){
	resetForm('expensetype-form');
	$('.expensetype-save').html("Save");
	$('.expensetype-modal-title').html("Add Your Expense Type");
}

$(document).ready(function(){
	$('.addExpenseTypeButton').on('click', function(){
		console.log("add new button clicked");
		$('#expenseModal').css('display', 'none');
	});

	/**
	 * Save expense type
	 */
	$('.expensetype-save').on('click', function() {
		console.log("save button clicked");
		var formName = 'expensetype-form';
		var formData = $('.' + formName).serializeArray();
		var status = ValidateForm(formName);
		var submitUrl = $('.' + formName).attr('action');
		console.log(status);
		if(status == true){
			$.post(submitUrl, formData, function(data, status) {
				if(status == 'success'){
					showMessage('alert-success', data);
					$('#expensetypeModal .close').click();
					$('#expenseModal').css('display', 'block');
					cl.hishab.ext.resetModal();
				}
			})
		}
	});
	
});