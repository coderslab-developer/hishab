var Script = function() {
	$(function() {
		$.get("/wallet/findAll", function(data) {

//			var filtereddata = [];
//			var totalBalance = 0;
//			data.forEach(function(item, index){
//				totalBalance += item.currentBalance;
//				filtereddata.push({label : item.walletName, value : item.currentBalance});
//			});
//
//			Morris.Donut({
//				element : 'hero-donut',
//				data : filtereddata,
//				colors : [ '#41cac0', '#49e2d7', '#34a39b' ],
//				formatter : function(y) {
//					return y + ' TK';
//				}
//			});
//			
//			$('.total-balance').html(totalBalance + ' TK');
		});
	});
}();