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

cl.hishab.income.resetModal = function(formName){
	resetForm('income-form');
	$('.income-save').html("Save");
	$('.income-modal-title').html("Add Your Income Source");
}

$(document).ready(function() {
	cl.hishab.income.findAllUrl = $('#findAllUrl').attr('href');
	cl.hishab.income.deleteUrl = $('#deleteUrl').attr('href');
	
	/**
	 * Find all income sources
	 */
	var initIncomeSources = function(){
		$.get(cl.hishab.income.findAllUrl, function(data) {
			var incomeSources = data;
			var incomeSourcePanel = $('.income-panel');
			incomeSources.forEach(function(item, index){
				var incomeString = '';
				var incomeSourceName = item.incomeSourceName == null ? '' : item.incomeSourceName;
				var notes = item.notes == null ? '' : item.notes;
				incomeString += '<div class="col-md-12 income-item" style="background: white; padding: 20px; border-radius: 5px; margin-bottom: 10px;">' +
									'<b>' + incomeSourceName + '</b>' +
									'<div class="btn-group pull-right">' +
										'<button income-source-id="'+ item.incomeSourceId +'" data-toggle="modal" data-target="#incomeModal" title="Update income source" class="btn btn-primary btn-sm update-income"><i class="fa fa-edit"></i></button>' +
										'<button income-source-id="'+ item.incomeSourceId +'" data-toggle="modal" data-target="#deleteModal" title="Delete income source" class="btn btn-danger btn-sm delete-income"><i class="fa fa-trash-o"></i></button>' +
									'</div>' + 
								'</div>';
				if(notes !== ''){
					incomeString += '<div class="col-md-12" style="background: #000; color: #fff; margin-top: -10px; margin-bottom: 10px; border-radius: 5px;">'+
										'Notes: ' + notes +
									'</div>';
				}

				incomeSourcePanel.append(incomeString);
			});
			
			
			/**
			 * Update Income Source
			 */
			$('.update-income').on('click', function() {
				var incomeSourceId = $(this).attr('income-source-id');
				var incomeSourceName = '';
				var notes = '';
				incomeSources.forEach(function(item, index){
					if(incomeSourceId == item.incomeSourceId){
						incomeSourceName = item.incomeSourceName == undefined ? '' : item.incomeSourceName;
						notes = item.notes == undefined ? '' : item.notes;
					}
				});

				$('#incomeSourceId').val(incomeSourceId);
				$('#incomeSourceName').val(incomeSourceName);
				$('#notes').val(notes);
				$('.income-save').html("Update");
				$('.income-modal-title').html("Update Your Income Source");
			});

			/**
			 * Delete Income Source
			 */
			$('.delete-income').on('click', function() {
				var incomeSourceId = $(this).attr('income-source-id');
				$('#deleteId').val(incomeSourceId);
				$('#deleteUrl').val(cl.hishab.income.deleteUrl);
			});
		});
	}
	initIncomeSources();

	/**
	 * Save income source
	 */
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
					$('.income-panel').html('');
					initIncomeSources();
					cl.hishab.income.resetModal();
				}
			})
		}
	});

	$('.income-btn').on('click', function() {
		cl.hishab.income.resetModal();
	});

	$('.delete-confirm-btn').on('click', function() {
		var id = $('#deleteId').val();
		var url = $('#deleteUrl').val();

		$.get(url + id, function(data) {
			showMessage('alert-success', data);
			$('#deleteModal .btn-discard').click();
			$('.income-panel').html('');
			initIncomeSources();
			cl.hishab.income.resetModal();
		});
	});

});