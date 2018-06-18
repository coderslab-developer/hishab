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

$(document).ready(function(){
	//do some initialization with modal buttons
	$('#addExpenseModalButton, #addTransferModalButton , #addIncomeModalButton').on('click', function(){
		var buttonId = $(this).attr('id');
		switch(buttonId){
			case "addExpenseModalButton": 
				console.log(buttonId);
				$('.' + cl.hishab.tr.formName + ' #transactionType').val('EXPENSE');
				$('.' + cl.hishab.tr.formName + ' .expenseAmountDiv').removeClass('nodisplay');
				$('.' + cl.hishab.tr.formName + ' .transferAmountDiv').addClass('nodisplay');
				$('.' + cl.hishab.tr.formName + ' .incomeAmountDiv').addClass('nodisplay');
				break;
			case "addTransferModalButton": 
				console.log(buttonId);
				$('.' + cl.hishab.tr.formName + ' #transactionType').val('MONEY_TRANSFER');
				$('.' + cl.hishab.tr.formName + ' .expenseAmountDiv').addClass('nodisplay');
				$('.' + cl.hishab.tr.formName + ' .transferAmountDiv').removeClass('nodisplay');
				$('.' + cl.hishab.tr.formName + ' .incomeAmountDiv').addClass('nodisplay');
				break;
			case "addIncomeModalButton": 
				console.log(buttonId);
				$('.' + cl.hishab.tr.formName + ' #transactionType').val('INCOME');
				$('.' + cl.hishab.tr.formName + ' .expenseAmountDiv').addClass('nodisplay');
				$('.' + cl.hishab.tr.formName + ' .transferAmountDiv').addClass('nodisplay');
				$('.' + cl.hishab.tr.formName + ' .incomeAmountDiv').removeClass('nodisplay');
				break;
		}
	});
});