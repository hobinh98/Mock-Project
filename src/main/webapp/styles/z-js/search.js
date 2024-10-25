
// xử lý input: box Theo id
$("input[name='theoId']").click(
	function() {
		const trueBox = $("input[name='theoId']:checked").val();
		if (trueBox) {
			$("#xacMinhTheoId").val(true);
			console.log($("#xacMinhTheoId").val());
		} else {
			$("#xacMinhTheoId").val("");
			console.log($("#xacMinhTheoId").val());
		}
	}
);

// xử lý input: box Theo ten
$("input[name='theoTen']").click(
	function() {
		const trueBox = $("input[name='theoTen']:checked").val();
		if (trueBox) {
			$("#xacMinhTheoTen").val(true);
			console.log($("#xacMinhTheoTen").val());
		} else {
			$("#xacMinhTheoTen").val("");
			console.log($("#xacMinhTheoTen").val());
		}
	}
);

function defaultValueSearch() {
	// đưa các input tìm kiếm về lại mặc định
	// xử lý theoIdSearch
	$("#theoIdSearch").val("");
	$("#theoId").prop("checked", false);
	// xử lý theoTenSearch
	$("#theoTenSearch").val("");
	$("#theoTen").prop("checked", false);
	// set lại xác minh search
	$("#xacMinhTheoId").val("");
	$("#xacMinhTheoTen").val("");
}