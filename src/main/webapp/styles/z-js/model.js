
function objectSearch() {
	var theoIdSearch = $("#theoIdSearch").val();
	const regexNumber = /^[0-9]+$/;
	if (!regexNumber.test(theoIdSearch)) {
		theoIdSearch = "";
	}
	var search = {
		namHocSearch: $("#namHocSearch").val(),//2
		lopHocSrarch: $("#lopHocSrarch").val(),//3
		theoId: $("#xacMinhTheoId").val(),//4
		theoIdSearch: theoIdSearch,//5
		theoTen: $("#xacMinhTheoTen").val(),//6
		theoTenSearch: $("#theoTenSearch").val(),//7
	};
	console.log("namHocSearch  " + $("#namHocSearch").val());
	console.log("lopHocSrarch  " + $("#lopHocSrarch").val());
	console.log("xacMinhTheoId  " + $("#xacMinhTheoId").val());
	console.log("theoIdSearch  " + theoIdSearch);
	console.log("xacMinhTheoTen  " + $("#xacMinhTheoTen").val());
	console.log("theoTenSearch  " + $("#theoTenSearch").val());
	return search;
}

function objectHocSinh() {
	var hocSinh = {
		maHocSinh: $("#maSoId").text(),
		hoTen: $("#hoTen").val().trim(),//2
		tenThanMat: $("#tenThanMat").val().trim(),//3
		gioiTinh: $("#gioiTinh").val(),//4
		ngaySinh: $("#ngaySinh").val(),//5
		doiTuong: $("#doiTuong").val(),//6
		diaChi: $("#diaChi").val().trim(),//7
		danToc: $("#danToc").val(),//8
		lopHienTai: $("#lopHienTai").val(),//9
		tonGiao: $("#tonGiao").val(),//10
		namHoc: $("#namHoc").val(),//11
		tinhCachThoiQuen: $("#tinhCachThoiQuen").val().trim(),//12
	};
	return hocSinh;
}

function objectPhuHuynhHS() {
	const namSinhChaArray = $("#namSinhCha").val().trim().split("-");
	const namSinhCha = namSinhChaArray[2] + "-" + namSinhChaArray[1] + "-" + namSinhChaArray[0];
	const namSinhMeArray = $("#namSinhCha").val().trim().split("-");
	const namSinhMe = namSinhMeArray[2] + "-" + namSinhMeArray[1] + "-" + namSinhMeArray[0];
	var phuHuynhHS = {
		hoTenCha: $("#hoTenCha").val().trim(),//2
		namSinhCha: namSinhCha,//3
		ngheNghiepCha: $("#ngheNghiepCha").val().trim(),//4
		hoTenMe: $("#hoTenMe").val().trim(),//5
		namSinhMe: namSinhMe,//6
		ngheNghiepMe: $("#ngheNghiepMe").val().trim(),//7
		dienThoai: $("#dienThoai").val(),//8
		email: $("#email").val().trim(),//9
		ghiChuPhuHuynh: $("#ghiChuPhuHuynh").val().trim(),//10
	};
	return phuHuynhHS;
}

function objectHinhAnhHS() {
	var hinhAnh = {
		tenHinhAnh: $("#tenHinhAnh").val(),//2
	};
	return hinhAnh;
}

function objectTrangThaiHS() {
	var trangThai = {
		ngayVaoHoc: $("#ngayVaoHoc").val(),//2
		ngayNghiHoc: $("#ngayNghiHoc").val(),//3
		ngayBaoLuu: $("#ngayBaoLuu").val(),//4
		ghiChuTrangThai: $("#ghiChuTrangThai").val().trim(),//5
	}
	return trangThai;
}