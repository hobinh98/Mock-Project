
// viledate bao luu
function validBaoLuu() {

	// lấy giá trị boolean hiện tại
	const trueBoxBaoLuu = $("input[name='baoLuuHocTap']:checked").val();
	// lấy giá trị Ngay bao luu
	const ngayBaoLuuString = $("#ngayBaoLuu").val().trim();
	const ngayBaoLuuDate = new Date(ngayBaoLuuString);

	// Lấy ngày tháng năm hiện tại
	const currentDate = new Date();
	const currentLocaleDateString = currentDate.toLocaleDateString();
	const currentDateArray = currentLocaleDateString.split("/");

	// Ngày tháng năm cách hiện tại 3 năm - Min
	const yearMin = Number(currentDateArray[2]) - 3;
	const minDateString = yearMin.toString() + "/" + currentDateArray[1] + "/" + currentDateArray[0];
	const minDate = new Date(minDateString);

	// Lấy ngày vào học
	const ngayVaoHocString = $("#ngayVaoHoc").val();
	const ngayVaoHocDate = new Date(ngayVaoHocString);

	// Lấy ngày nghi hoc
	const ngayNghiHocString = ngayNghiHocSelectLists;
	const ngayNghiHocDate = new Date(ngayNghiHocString);

	if (valueInsertUpdate === -1) {
		$("#error_ngayBaoLuu").text("Bạn chưa chọn thông tin học sinh cần Bảo lưu học tập.");
		return true;
	}
	if (ngayVaoHocString === "") {
		$("#error_ngayVaoHoc").text("Ngay vao hoc không được để trống.");
		return true;
	}
	if (ngayNghiHocString != "") {
		$("#ngayNghiHoc").val(ngayNghiHocString);
		$("#daNghiHoc").prop("checked", true);
	}
	if (ngayNghiHocString != "" && ngayVaoHocDate > ngayNghiHocDate) {
		$("#error_ngayVaoHoc").text("Ngay vao hoc đang bé hơn ngày nghi học.");
		return true;
	}
	if (ngayNghiHocString != "" && ngayNghiHocString === ngayVaoHocString) {
		$("#error_ngayVaoHoc").text("Ngay vao hoc đang bằng ngày nghi học.");
		return true;
	}
	if (trueBoxBaoLuu && !(ngayVaoHocDate > minDate && ngayVaoHocDate < currentDate)) {
		$("#error_ngayVaoHoc").text("Ngay vao hoc phải nằm trong khoảng lớn hơn ngày cách đây 3 năm đến ngày hiện tại.");
		return true;
	}
	if (trueBoxBaoLuu && ngayVaoHocDate.toLocaleDateString() === minDate.toLocaleDateString()) {
		$("#error_ngayVaoHoc").text("Ngay vao hoc phải nằm trong khoảng lớn hơn ngày cách đây 3 năm đến ngày hiện tại.");
		return true;
	}
	// Nếu nhập đúng thì xoá error
	$("#error_ngayVaoHoc").text("");


	if (!trueBoxBaoLuu && ngayBaoLuuString != "") {
		$("#error_ngayBaoLuu").text("Yêu cầu xác nhận Bao luu hoc tap.");
		return true;
	}
	if (trueBoxBaoLuu && ngayBaoLuuString === "") {
		$("#error_ngayBaoLuu").text("Yêu cầu nhập ngày Bao luu.");
		return true;
	}
	if (trueBoxBaoLuu && !(ngayBaoLuuDate > ngayVaoHocDate && ngayBaoLuuDate < currentDate)) {
		$("#error_ngayBaoLuu").text("Ngay bao luu phải lớn hơn ngày vào học đến ngày hiện tại.");
		return true;
	}
	if (trueBoxBaoLuu && ngayBaoLuuDate.toLocaleDateString() === ngayVaoHocDate.toLocaleDateString()) {
		$("#error_ngayBaoLuu").text("Ngay bao luu phải lớn hơn ngày vào học đến ngày hiện tại.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_ngayBaoLuu").text("");
	return false;
}