/**
 * Global namespace 'cl' for CodersLab Bangladesh Ltd
 */
var cl = cl || {};
/**
 * Hishab namespace
 */
cl.hishab = cl.hishab || {};
/**
 * Income name space
 */
cl.hishab.income = cl.hishab.income || {};
cl.hishab.income.allIncomes;

cl.hishab.income.resetModal = function(formName){
	resetForm('income-form');
	$('.income-save').html("Save");
	$('.income-modal-title').html("Add Your Income Source");
}

$(document).ready(function() {
	$('.addIncomeSourceButton').on('click', function() {
		$('#transactionModal').css('display', 'none');
	});
	$('.income-discard, #income-modal2-close').on('click', function(){
		$('#transactionModal').css('display', 'block');
	});

	cl.hishab.income.getAllIncomes = function(){
		var url = '/income/findAll';
		$.get(url, function(data) {
			cl.hishab.income.allIncomes = data;
			cl.hishab.income.updateIncomeSourceDropdown();
		});
	}

	$('.income-save').on('click', function() {
		var formName = 'income-form';
		var formData = $('.' + formName).serializeArray();
		var status = ValidateForm(formName);
		var submitUrl = $('.' + formName).attr('action');
		
		if(status == true){
			$.post(submitUrl, formData, function(data, status) {
				if(status == 'success'){
					showMessage('alert-success', data);
					$('#incomeModal .close').click();
					$('#transactionModal').css('display', 'block');
					cl.hishab.income.resetModal();
					cl.hishab.income.getAllIncomes();
				}
			})
		}
	});

	cl.hishab.income.updateIncomeSourceDropdown = function(){
		$('.transaction-form #incomeSourceId option').remove();
		var incomeDropdown = $('.transaction-form #incomeSourceId');
		cl.hishab.income.allIncomes.forEach(function(item, index){
			incomeDropdown.append('<option value="' + item.incomeSourceId + '">'+ item.incomeSourceName +'</option>');
		});
	}
});