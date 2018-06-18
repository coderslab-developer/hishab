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
cl.hishab.ext.allExpenseTypes;

cl.hishab.ext.resetModal = function(formName){
	resetForm('expensetype-form');
	$('.expensetype-save').html("Save");
	$('.expensetype-modal-title').html("Add Your Expense Type");
}

$(document).ready(function(){
	$('.addExpenseTypeButton').on('click', function(){
		$('#transactionModal').css('display', 'none');
	});
	$('.expensetype-discard, #expensetype-modal2-close').on('click', function(){
		$('#transactionModal').css('display', 'block');
	});

	/**
	 * Get all expense type
	 */
	cl.hishab.ext.getAllExpenseType = function(){
		var url = '/expensetype/findAll';
		$.get(url, function(data) {
			cl.hishab.ext.allExpenseTypes = data;
			cl.hishab.ext.updateExpenseTypeDropdown();
		});
	}

	/**
	 * Save expense type
	 */
	$('.expensetype-save').on('click', function() {
		var formName = 'expensetype-form';
		var formData = $('.' + formName).serializeArray();
		var status = ValidateForm(formName);
		var submitUrl = $('.' + formName).attr('action');
		if(status == true){
			$.post(submitUrl, formData, function(data, status) {
				if(status == 'success'){
					showMessage('alert-success', data);
					$('#expensetypeModal .close').click();
					$('#transactionModal').css('display', 'block');
					cl.hishab.ext.resetModal();
					cl.hishab.ext.getAllExpenseType();
				}
			})
		}
	});

	cl.hishab.ext.updateExpenseTypeDropdown = function(){
		$('.transaction-form #expenseTypeId option').remove();
		var expenseTypeDropdown = $('.transaction-form #expenseTypeId');
		cl.hishab.ext.allExpenseTypes.forEach(function(item, index){
			expenseTypeDropdown.append('<option value="' + item.expenseTypeId + '">'+ item.expenseTypeName +'</option>');
		});
	}

});