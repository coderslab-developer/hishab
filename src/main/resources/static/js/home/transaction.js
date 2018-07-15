/**
 * Global namespace 'cl' for CodersLab Bangladesh Ltd
 */
var cl = cl || {};
/**
 * Hishab namespace
 */
cl.hishab = cl.hishab || {};
/**
 * Transaction name space
 */
cl.hishab.tr = cl.hishab.tr || {};
cl.hishab.tr.formName = 'transaction-form';
cl.hishab.tr.expense = function(){
	$('.modal-header').css('background-color', '#ff6c60');
	$('.transaction-modal-title').html('<i class="fa fa-minus"></i> Add your expense');
	$('.' + cl.hishab.tr.formName + ' #transactionType').val('EXPENSE');
	$('.' + cl.hishab.tr.formName + ' .expenseAmountDiv').removeClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .transferAmountDiv').addClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .incomeAmountDiv').addClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .transactionChargeDiv').removeClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .fromWalletIdDiv').removeClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .toWalletIdDiv').addClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .incomeSourceIdDiv').addClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .expenseTypeIdDiv').removeClass('nodisplay');
}
cl.hishab.tr.moneyTransfer = function(){
	$('.modal-header').css('background-color', '#41cac0');
	$('.transaction-modal-title').html('<i class="fa fa-retweet"></i> Add your transfer');
	$('.' + cl.hishab.tr.formName + ' #transactionType').val('MONEY_TRANSFER');
	$('.' + cl.hishab.tr.formName + ' .expenseAmountDiv').addClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .transferAmountDiv').removeClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .incomeAmountDiv').addClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .transactionChargeDiv').removeClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .fromWalletIdDiv').removeClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .toWalletIdDiv').removeClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .incomeSourceIdDiv').addClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .expenseTypeIdDiv').addClass('nodisplay');
}
cl.hishab.tr.income = function(){
	$('.modal-header').css('background-color', '#78cd51');
	$('.transaction-modal-title').html('<i class="fa fa-plus"></i> Add your income');
	$('.' + cl.hishab.tr.formName + ' #transactionType').val('INCOME');
	$('.' + cl.hishab.tr.formName + ' .expenseAmountDiv').addClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .transferAmountDiv').addClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .incomeAmountDiv').removeClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .transactionChargeDiv').removeClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .fromWalletIdDiv').addClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .toWalletIdDiv').removeClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .incomeSourceIdDiv').removeClass('nodisplay');
	$('.' + cl.hishab.tr.formName + ' .expenseTypeIdDiv').addClass('nodisplay');
}
cl.hishab.tr.resetModal = function(){
	$('#transactionId').val('');
	$('#expenseAmount').val('');
	$('#transferAmount').val('');
	$('#incomeAmount').val('');
	$('#transactionCharge').val('');
	$('#note').val('');
}

$(document).ready(function(){
	//do some initialization with modal buttons
	$('#addExpenseModalButton, #addTransferModalButton , #addIncomeModalButton').on('click', function(){
		cl.hishab.tr.resetModal();
		var buttonId = $(this).attr('id');
		switch(buttonId){
			case "addExpenseModalButton": 
				cl.hishab.tr.expense();
				break;
			case "addTransferModalButton": 
				cl.hishab.tr.moneyTransfer();
				break;
			case "addIncomeModalButton": 
				cl.hishab.tr.income();
				break;
		}
	});

	$('#transactionType').on('change', function(){
		cl.hishab.tr.resetModal();
		var value = $(this).val();
		switch(value){
			case "EXPENSE":
				cl.hishab.tr.expense();
				break;
			case "MONEY_TRANSFER":
				cl.hishab.tr.moneyTransfer();
				break;
			case "INCOME":
				cl.hishab.tr.income();
				break;
		}
	});

	$('.transaction-save').on("click", function(e) {
		e.preventDefault();
		var formName = cl.hishab.tr.formName;
		var formData = $('.' + formName).serializeArray();
		var status = ValidateForm(formName);
		var submitUrl = $('.' + formName).attr('action');

		if(status == true){
			$.post(submitUrl, formData, function(data, status){
				if(status == 'success'){
					showMessage('alert-success', data);
					$('#transactionModal .close').click();
					cl.hishab.tr.resetModal();
				}
			});
		}
	});

	setInterval(function(){
		var dt = new Date();
		var hour = dt.getHours() < 10 ? '0' + dt.getHours() : dt.getHours();
		var minute = dt.getMinutes() < 10 ? '0' + dt.getMinutes() : dt.getMinutes();
		var second = dt.getSeconds() < 10 ? '0' + dt.getSeconds() : dt.getSeconds();
		$('#transactionTime').val(hour + ":" + minute + ":" + second);
	}, 1000);

});