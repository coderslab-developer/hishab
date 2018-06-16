/**
 * Global namespace 'cl' for CodersLab Bangladesh Ltd
 */
var cl = cl || {};
/**
 * Hishab namespace
 */
cl.hishab = cl.hishab || {};
/**
 * Wallet name space
 */
cl.hishab.wallet = cl.hishab.wallet || {};

cl.hishab.wallet.resetModal = function(){
	resetForm('wallet-form');
	$('.wallet-save').html("Save");
	$('.wallet-modal-title').html("Add Your Wallet");
}

$(document).ready(function() {

	cl.hishab.wallet.findAllUrl = $('#findAllUrl').attr('href');
	cl.hishab.wallet.deleteUrl = $('#deleteUrl').attr('href');

	/*
	 * Find All Wallets
	 */
	var initWallets = function(){
		$.get(cl.hishab.wallet.findAllUrl, function(data) {
			var wallets = data;
			var walletsPanel = $('.wallets-panel');
			wallets.forEach(function(item, index){
				var walletString = '';
				var walletName = item.walletName == null ? '' : item.walletName;
				var balance = item.currentBalance == null ? '' : item.currentBalance;
				var notes = item.notes == null ? '' : item.notes;
				walletString += '<div class="col-md-12 wallet-item" style="background: white; padding: 20px; border-radius: 5px; margin-bottom: 10px;">' +
									'<b>' + walletName + '</b> | ' +
									'Balance :'+ balance +'' +
									'<div class="btn-group pull-right">' +
										'<button wallet-id="'+ item.walletId +'" data-toggle="modal" data-target="#walletModal" title="Update wallet" class="btn btn-primary btn-sm update-wallet"><i class="fa fa-edit"></i></button>' +
										'<button wallet-id="'+ item.walletId +'" data-toggle="modal" data-target="#deleteModal" title="Delete wallet" class="btn btn-danger btn-sm delete-wallet"><i class="fa fa-trash-o"></i></button>' +
									'</div>' +
								'</div>';

				if(notes !== ''){
					walletString += '<div class="col-md-12" style="background: #000; color: #fff; margin-top: -10px; margin-bottom: 10px; border-radius: 5px;">'+
										'Notes: ' + notes +
									'</div>';
				}

				walletsPanel.append(walletString);
			});

			/**
			 * Update Wallets
			 */
			$('.update-wallet').on('click', function() {
				var walletId = $(this).attr('wallet-id');
				var walletName = '';
				var balance = '';
				var notes = '';
				wallets.forEach(function(item, index){
					if(walletId == item.walletId){
						walletName = item.walletName == undefined ? '' : item.walletName;
						balance = item.currentBalance == undefined ? '' : item.currentBalance;
						notes = item.notes == undefined ? '' : item.notes;
					}
				});

				$('#walletId').val(walletId);
				$('#walletName').val(walletName);
				$('#currentBalance').val(balance);
				$('#notes').val(notes);
				$('.wallet-save').html("Update");
				$('.wallet-modal-title').html("Update Your Wallet");
			});

			/**
			 * Delete Wallets
			 */
			$('.delete-wallet').on('click', function() {
				var walletId = $(this).attr('wallet-id');
				$('#deleteId').val(walletId);
				$('#deleteUrl').val(cl.hishab.wallet.deleteUrl);
			});

			/**
			 * Chart
			 */
			var filtereddata = [];
			var totalBalance = 0;
			data.forEach(function(item, index){
				totalBalance += item.currentBalance;
				filtereddata.push({label : item.walletName, value : item.currentBalance});
			});
			Morris.Donut({
				element : 'hero-donut',
				data : filtereddata,
				colors : ['#ff00ff', '#00a0a0', '#535154', '#6B4C9A', '#922228', '#94A93D', '#FF0000', '#8C7546', '#B6F2B6', '#234D8C', '#8C0083', '#F20000', '#FFEABF', '#79F279', '#0061F2', '#F279DA', '#FF8080', '#7F5500', '#269954', '#0D1C33', '#FF00AA', '#7F0000', '#FFCC00', '#1A664D', '#0022FF', '#59003C', '#8C4F46', '#E5CF73', '#00FFCC', '#696E8C'],
				formatter : function(y) {
					return y + ' TK';
				}
			});
			$('.total-balance').html(totalBalance + ' TK');
		})
	}
	initWallets();

	$('.wallet-save').on('click', function(){
		var formName = 'wallet-form';
		var formData = $('.' + formName).serializeArray();
		var status = ValidateForm(formName);
		var submitUrl = $('.' + formName).attr('action');

		if(status == true){
			$.post(submitUrl, formData, function(data, status){
				if(status == 'success'){
					showMessage('alert-success', data);
					$('#walletModal .close').click();
					$('.wallets-panel').html('');
					initWallets();
					cl.hishab.wallet.resetModal();
				}
			});
		}
	});

	$('.wallet-btn').on('click', function() {
		cl.hishab.wallet.resetModal();
	});

	$('.delete-confirm-btn').on('click', function() {
		var id = $('#deleteId').val();
		var url = $('#deleteUrl').val();

		$.get(url + id, function(data) {
			showMessage('alert-success', data);
			$('#deleteModal .btn-discard').click();
			$('.wallets-panel').html('');
			initWallets();
			cl.hishab.wallet.resetModal();
		});
	});

});