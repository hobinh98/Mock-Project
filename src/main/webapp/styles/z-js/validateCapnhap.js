
// Ho ten
function validHoTen() {
	const error = $("#hoTen").val().trim();
	const regexName = /^[a-zA-ZÀ-ỹ\s]+$/;
	if (error === "") {
		$("#error_hoTen").text("Ho ten không được để trống.");
		return true;
	}
	if (!regexName.test(error)) {
		$("#error_hoTen").text("Ho ten không đúng định dạng.");
		return true;
	}
	if (error.length < 4 || error.length > 25) {
		$("#error_hoTen").text("Ho ten từ 4--25 ký tự.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_hoTen").text("");
	return false;
}

// Ngay sinh
function validNgaySinh() {
	// Lấy ngày tháng năm hiện tại
	const currentDate = new Date();
	const currentLocaleDateString = currentDate.toLocaleDateString();
	const currentDateArray = currentLocaleDateString.split("/");
	// Năm cách hiện tại 6 năm - Min
	const yearMin = Number(currentDateArray[2]) - 6;
	// Năm cách hiện tại 3 năm - Max
	const yearMax = Number(currentDateArray[2]) - 3;

	// Lấy ngày sinh
	const ngaySinhString = $("#ngaySinh").val();
	const ngaySinhDate = new Date(ngaySinhString);
	const ngaySinhDateString = ngaySinhDate.toLocaleDateString();
	const ngaySinhDateArray = ngaySinhDateString.split("/");
	const yearNgaySinh = Number(ngaySinhDateArray[2]);


	if (ngaySinhString === "") {
		$("#error_ngaySinh").text("Ngay sinh không được để trống.");
		return true;
	}
	if (!(yearNgaySinh >= yearMin && yearNgaySinh <= yearMax)) {
		$("#error_ngaySinh").text("Ngay sinh phải nằm trong khoảng năm nhỏ hơn năm hiện tại từ 3 đến 6 năm.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_ngaySinh").text("");
	return false;
}

// select option: Doi tuong
function validDoiTuong() {
	const error = $("#doiTuong").val();
	if (error === "") {
		$("#error_doiTuong").text("Doi tuong chưa được chọn.");
		return true;
	}

	// Nếu Chọn đúng thì xoá error
	$("#error_doiTuong").text("");
	return false;
}

// Dia chi
function validDiaChi() {
	const error = $("#diaChi").val().trim();
	const regexName = /^[0-9a-zA-ZÀ-ỹ\s]+$/;
	if (error === "") {
		$("#error_diaChi").text("Dia chi không được để trống.");
		return true;
	}
	if (!regexName.test(error)) {
		$("#error_diaChi").text("Dia chi không đúng định dạng.");
		return true;
	}
	if (error.length < 4 || error.length > 45) {
		$("#error_diaChi").text("Dia chi từ 4--45 ký tự.");
		return true;
	}

	//
	$("#error_diaChi").text("");
	return false;
}

// select option: Dan toc
function validDanToc() {
	const error = $("#danToc").val();
	if (error === "") {
		$("#error_danToc").text("Dan toc chưa được chọn.");
		return true;
	}

	// Nếu Chọn đúng thì xoá error
	$("#error_danToc").text("");
	return false;
}

// select option: Lop hien tai
function validLopHienTai() {
	const error = $("#lopHienTai").val();
	if (error === "") {
		$("#error_lopHienTai").text("Lop hien tai chưa được chọn.");
		return true;
	}

	// Nếu Chọn đúng thì xoá error
	$("#error_lopHienTai").text("");
	return false;
}

// select option: Nam hoc
function validNamHoc() {
	const error = $("#namHoc").val();
	if (error === "") {
		$("#error_namHoc").text("Nam hoc chưa được chọn.");
		return true;
	}

	// Nếu Chọn đúng thì xoá error
	$("#error_namHoc").text("");
	return false;
}

// Ho ten cha
function validHoTenCha() {
	const error = $("#hoTenCha").val().trim();
	const regexName = /^[a-zA-ZÀ-ỹ\s]+$/;
	if (error === "") {
		$("#error_hoTenCha").text("Ho ten cha không được để trống.");
		return true;
	}
	if (!regexName.test(error)) {
		$("#error_hoTenCha").text("Ho ten cha không đúng định dạng.");
		return true;
	}
	if (error.length < 4 || error.length > 25) {
		$("#error_hoTenCha").text("Ho ten cha từ 4--25 ký tự.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_hoTenCha").text("");
	return false;
}

// Nam sinh cha
function validNamSinhCha() {
	const error = $("#namSinhCha").val().trim();
	const errorArray = error.split("-");
	const namSinhChaNumber = new Date(errorArray[2], errorArray[1], errorArray[0]);
	const datePattern = /^\d{2}-\d{2}-\d{4}$/;
	if (error === "") {
		$("#error_namSinhCha").text("Nam sinh cha không được để trống.");
		return true;
	}
	if (!datePattern.test(error)) {
		$("#error_namSinhCha").text("Nam sinh cha không đúng Định dạng dạng dd-mm-yyyy.");
		return true;
	}
	const year = namSinhChaNumber.getFullYear();
	if (!(year >= 1960 && year <= 2003)) {
		$("#error_namSinhCha").text("Nam sinh cha nằm trong khoảng 1960-2003.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_namSinhCha").text("");
	return false;
}

// Nghe nghiep cha
function validNgheNghiepCha() {
	const error = $("#ngheNghiepCha").val().trim();
	const regexName = /^[a-zA-ZÀ-ỹ\s]+$/;
	if (error === "") {
		$("#error_ngheNghiepCha").text("Nghe nghiep cha không được để trống.");
		return true;
	}
	if (!regexName.test(error)) {
		$("#error_ngheNghiepCha").text("Nghe nghiep cha không đúng định dạng.");
		return true;
	}
	if (error.length < 4 || error.length > 25) {
		$("#error_ngheNghiepCha").text("Nghe nghiep cha từ 4--25 ký tự.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_ngheNghiepCha").text("");
	return false;
}

// Ho ten me
function validHoTenMe() {
	const error = $("#hoTenMe").val().trim();
	const regexName = /^[a-zA-ZÀ-ỹ\s]+$/;
	if (error === "") {
		$("#error_hoTenMe").text("Ho ten me không được để trống.");
		return true;
	}
	if (!regexName.test(error)) {
		$("#error_hoTenMe").text("Ho ten me không đúng định dạng.");
		return true;
	}
	if (error.length < 4 || error.length > 25) {
		$("#error_hoTenMe").text("Ho ten me từ 4--25 ký tự.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_hoTenMe").text("");
	return false;
}

// Nam sinh me
function validNamSinhMe() {
	const error = $("#namSinhMe").val().trim();
	const errorArray = error.split("-");
	const namSinhChaNumber = new Date(errorArray[2], errorArray[1], errorArray[0]);
	const datePattern = /^\d{2}-\d{2}-\d{4}$/;
	if (error === "") {
		$("#error_namSinhMe").text("Nam sinh me không được để trống.");
		return true;
	}

	if (!datePattern.test(error)) {
		$("#error_namSinhMe").text("Nam sinh me không đúng Định dạng dạng dd-mm-yyyy.");
		return true;
	}
	const year = namSinhChaNumber.getFullYear();
	if (!(year >= 1960 && year <= 2003)) {
		$("#error_namSinhMe").text("Nam sinh me nằm trong khoảng 1960-2003.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_namSinhMe").text("");
	return false;
}

// Nghe nghiep me
function validNgheNghiepMe() {
	const error = $("#ngheNghiepMe").val().trim();
	const regexName = /^[a-zA-ZÀ-ỹ\s]+$/;
	if (error === "") {
		$("#error_ngheNghiepMe").text("Nghe nghiep me không được để trống.");
		return true;
	}
	if (!regexName.test(error)) {
		$("#error_ngheNghiepMe").text("Nghe nghiep me không đúng định dạng.");
		return true;
	}
	if (error.length < 4 || error.length > 25) {
		$("#error_ngheNghiepMe").text("Nghe nghiep me từ 4--25 ký tự.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_ngheNghiepMe").text("");
	return false;
}

// Dien thoai
function validDienThoai() {
	const error = $("#dienThoai").val().trim();
	const regexPhone = /^0[0-9]+$/;
	if (error === "") {
		$("#error_dienThoai").text("Dien thoai không được để trống.");
		return true;
	}
	if (!error.startsWith('0')) {
		$("#error_dienThoai").text("Ký tự đầu tiên của Dien thoai phải là số 0.");
		return true;
	}
	if (error.length < 10 || error.length > 15) {
		$("#error_dienThoai").text("Dien thoai 10--15 ký tự.");
		return true;
	}
	if (!regexPhone.test(error)) {
		$("#error_dienThoai").text("Dien thoai không đúng Định dạng, chuỗi là ký tự số.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_dienThoai").text("");
	return false;
}

// email
function validEmail() {
	const error = $("#email").val().trim();
	console.log(error);
	if (error === "") {
		$("#error_email").text("");
		return false;
	}
	if (!error.endsWith('@gmail.com')) {
		$("#error_email").text("E-mail không đúng định dạng. Đuôi E-mail phải là @gmail.com");
		return true;
	}
	if (error.length < 16 || error.length > 50) {
		$("#error_email").text("Phần đầu E-mail (phía trước @) phải từ 6-40 ký tự.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_email").text("");
	return false;
}

// Chon anh
function validChonAnh() {
	const imageContainer = document.getElementById("image-container");
	/*if (imageContainer.children.length == 0) {
		$("#error_image").text("Vui lòng chọn ảnh.");
		return true;
	}*/
	if (imageContainer.querySelector('img') == null) {
		$("#error_image").text("Vui lòng chọn ảnh.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_image").text("");
	return false;
}

// Ngay vao hoc
function validNgayVaoHoc() {
	// Lấy ngày tháng năm hiện tại
	const currentDate = new Date();

	// Lấy ngày Sinh
	const ngaySinh = $("#ngaySinh").val();
	const ngaySinhDate = new Date(ngaySinh);
	// Nam sinh - Min
	const yearMin = ngaySinhDate.getFullYear();

	// Lấy ngày vao hoc
	const ngayVaoHoc = $("#ngayVaoHoc").val();
	const ngayVaoHocDate = new Date(ngayVaoHoc);
	// Nam vào học
	const yearNgayVaoHoc = ngayVaoHocDate.getFullYear() - 3;

	// lấy giá trị Ngay bao luu
	const ngayBaoLuuString = ngayBaoLuuSelectLists;
	const ngayBaoLuuDate = new Date(ngayBaoLuuString);

	if (ngayVaoHoc === "") {
		$("#error_ngayVaoHoc").text("Ngay vao hoc không được để trống.");
		return true;
	}
	if (ngayBaoLuuString != "") {
		$("#ngayBaoLuu").val(ngayBaoLuuString);
		$("#baoLuuHocTap").prop("checked", true);
	}
	if (ngayBaoLuuString != "" && ngayVaoHocDate > ngayBaoLuuDate) {
		$("#error_ngayVaoHoc").text("Ngay vao hoc đang bé hơn ngày bao buu.");
		return true;
	}
	if (ngayBaoLuuString != "" && ngayBaoLuuString === ngayVaoHoc) {
		$("#error_ngayVaoHoc").text("Ngay vao hoc đang bằng ngày bao buu.");
		return true;
	}
	if (!(yearNgayVaoHoc >= yearMin && ngayVaoHocDate < currentDate)) {
		$("#error_ngayVaoHoc").text("Ngay vao hoc phải nằm trong khoảng năm lớn hơn năm sinh từ 3 năm đến ngày hiện tại.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_ngayVaoHoc").text("");
	return false;
}

// Ngay nghi hoc
function validNgayNghiHoc() {
	// lấy giá trị boolean hiện tại
	const trueBoxNghiHoc = $("input[name='daNghiHoc']:checked").val();
	// lấy giá trị Ngay nghi hoc
	const ngayVaoHoc = $("#ngayVaoHoc").val();
	// lấy giá trị Ngay bao luu
	const ngayNghiHoc = $("#ngayNghiHoc").val().trim();

	// Lấy ngày tháng năm hiện tại
	const currentDate = new Date();
	// lấy Ngay vao hoc
	const minDate = new Date(ngayVaoHoc);
	// lấy Ngay nghi hoc
	const ngayNghiHocDate = new Date(ngayNghiHoc);

	if (trueBoxNghiHoc && valueInsertUpdate === -1 || ngayNghiHoc != "" && valueInsertUpdate === -1) {
		$("#error_ngayNghiHoc").text("Bạn chưa chọn thông tin học sinh cần Cập nhập nghỉ học.");
		return true;
	}

	if (!trueBoxNghiHoc && ngayNghiHoc != "") {
		$("#error_ngayNghiHoc").text("Yêu cầu xác nhận đã nghi hoc.");
		return true;
	}
	if (trueBoxNghiHoc && ngayNghiHoc === "") {
		$("#error_ngayNghiHoc").text("Yêu cầu nhập ngày nghi hoc.");
		return true;
	}
	if (trueBoxNghiHoc && ngayVaoHoc === "") {
		$("#error_ngayNghiHoc").text("Yêu cầu nhập ngày vào hoc trước.");
		return true;
	}
	if (trueBoxNghiHoc && !(ngayNghiHocDate > minDate && ngayNghiHocDate < currentDate)) {
		$("#error_ngayNghiHoc").text("Ngay nghi hoc phải lớn hơn ngày vào học đến ngày hiện tại.");
		return true;
	}
	if (trueBoxNghiHoc && ngayNghiHocDate.toLocaleDateString() === minDate.toLocaleDateString()) {
		$("#error_ngayNghiHoc").text("Ngay nghi hoc phải lớn hơn ngày vào học đến ngày hiện tại.");
		return true;
	}

	// Nếu nhập đúng thì xoá error
	$("#error_ngayNghiHoc").text("");
	return false;
}

function submitValidateCapNhap() {

	let isValid = false;

	if (validHoTen()) {
		isValid = true;
	}
	if (validNgaySinh()) {
		isValid = true;
	}
	if (validDoiTuong()) {
		isValid = true;
	}
	if (validDiaChi()) {
		isValid = true;
	}
	if (validDanToc()) {
		isValid = true;
	}
	if (validLopHienTai()) {
		isValid = true;
	}
	if (validNamHoc()) {
		isValid = true;
	}
	if (validHoTenCha()) {
		isValid = true;
	}
	if (validNamSinhCha()) {
		isValid = true;
	}
	if (validNgheNghiepCha()) {
		isValid = true;
	}
	if (validHoTenMe()) {
		isValid = true;
	}
	if (validNamSinhMe()) {
		isValid = true;
	}
	if (validNgheNghiepMe()) {
		isValid = true;
	}
	if (validDienThoai()) {
		isValid = true;
	}
	if (validEmail()) {
		isValid = true;
	}
	if (validChonAnh()) {
		isValid = true;
	}
	if (validNgayVaoHoc()) {
		isValid = true;
	}
	if (validNgayNghiHoc()) {
		isValid = true;
	}

	// Cờ
	if (isValid) {
		modalCapNhapThatBai();
		return true;
	}
	return isValid;
}
