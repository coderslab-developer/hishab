var Script = function() {

	//morris chart

	$(function() {
		Morris.Donut({
			element : 'hero-donut',
			data : [
				{
					label : 'Jam',
					value : 25
				},
				{
					label : 'Frosted',
					value : 40
				},
				{
					label : 'Custard',
					value : 25
				},
				{
					label : 'Sugar',
					value : 10
				}
			],
			colors : [ '#41cac0', '#49e2d7', '#34a39b' ],
			formatter : function(y) {
				return y + "%"
			}
		});
	});
}();