
// convert kiểu date khi chuyền từ server tới client
function convDateSever(dateServer) {
	if (dateServer === null) {
		return "";
	}
	var year = parseInt(dateServer[0]);
	var month = parseInt(dateServer[1]) - 1; // Tháng trong JavaScript bắt đầu từ 0
	var day = parseInt(dateServer[2] + 1);
	var date = new Date(year, month, day);
	var formattedDate = date.toISOString().split("T")[0]; // Định dạng "yyyy-MM-dd"
	return formattedDate;
}

function clickModelOnLists(i) {
	valueInsertUpdate = i;

	$("#maSoId").text(listServer[i].maHocSinh);//1
	$("#hoTen").val(listServer[i].hoTen);//2
	$("#tenThanMat").val(listServer[i].tenThanMat);//3
	$("#gioiTinh").val(listServer[i].gioiTinh);//4
	if ($("#gioiTinh").val() === "true") {
		// xoá các phần tử html con trước đó
		$("#goiTinhButton").empty();
		// set lại màu cho button
		$("#goiTinhButton").attr("class", "col-2  btn btn-outline-dark btnCssWhite");
		// thêm mới các phần tử html con
		$("#goiTinhButton").html("<i class='fas fa-male mr-3'></i><b>Nam</b>");
	} else if ($("#gioiTinh").val() === "false") {
		$("#goiTinhButton").empty();
		$("#goiTinhButton").attr("class", "col-2 btn btn-outline-dark btnCssWhite");
		$("#goiTinhButton").html("<i class='fas fa-female mr-3'></i><b>Nu</b>");
	}
	$("#ngaySinh").val(convDateSever(listServer[i].ngaySinh));//5
	$("#doiTuong").val(listServer[i].doiTuong);//6
	$("#diaChi").val(listServer[i].diaChi);//7
	$("#danToc").val(listServer[i].danToc);//8
	$("#lopHienTai").val(listServer[i].lopHienTai);//9
	$("#tonGiao").val(listServer[i].tonGiao);//10
	$("#namHoc").val(listServer[i].namHoc);//11
	$("#tinhCachThoiQuen").val(listServer[i].tinhCachThoiQuen);//12

	// Phụ huynh
	$("#hoTenCha").val(listServer[i].hoTenCha);//2
	const namSinhCha = listServer[i].namSinhCha[2] + "-" + listServer[i].namSinhCha[1] + "-" + listServer[i].namSinhCha[0];
	$("#namSinhCha").val(namSinhCha);//3
	$("#ngheNghiepCha").val(listServer[i].ngheNghiepCha);//4
	$("#hoTenMe").val(listServer[i].hoTenMe);//5
	const namSinhMe = listServer[i].namSinhMe[2] + "-" + listServer[i].namSinhMe[1] + "-" + listServer[i].namSinhMe[0];
	$("#namSinhMe").val(namSinhMe);//6
	$("#ngheNghiepMe").val(listServer[i].ngheNghiepMe);//7
	$("#dienThoai").val(listServer[i].dienThoai);//8
	$("#email").val(listServer[i].email);//9
	$("#ghiChuPhuHuynh").val(listServer[i].ghiChuPhuHuynh);//10

	// ***Hình ảnh
	const tenHinhAnh = listServer[i].tenHinhAnh;
	$("#tenHinhAnh").val(tenHinhAnh);//2
	const stringg = "<img id='imageTaiTrang' src='" + "/springmvc/image/" + tenHinhAnh + "' alt='" + tenHinhAnh + "'>"
	const img = $(stringg);
	const imageContainer = $("#image-container");
	imageContainer.empty();	// xoá các HTML phần tử chứa trong nó
	imageContainer.append(img);// thêm phần tử HTML vào trong nó
	imageSelectLists = img;// ***set lại cho biến let imageSelectLists ở variables.js
	tenHinhAnhSelectLists = tenHinhAnh;// ***set lại cho biến let tenHinhAnhSelectLists ở variables.js

	// Trạng thái
	$("#ngayVaoHoc").val(convDateSever(listServer[i].ngayVaoHoc));//2
	const ngayNghiHoc = convDateSever(listServer[i].ngayNghiHoc);//3
	const ngayBaoLuu = convDateSever(listServer[i].ngayBaoLuu);//4
	ngayNghiHocSelectLists = ngayNghiHoc;// ***set lại cho biến let ngayNghiHocSelectLists ở variables.js
	ngayBaoLuuSelectLists = ngayBaoLuu;// ***set lại cho biến let ngayBaoLuuSelectLists ở variables.js

	if (ngayNghiHoc != "") {
		$("#daNghiHoc").prop("checked", true);
		$("#ngayNghiHoc").val(ngayNghiHoc);
	}
	if (ngayBaoLuu != "") {
		$("#baoLuuHocTap").prop("checked", true);
		$("#ngayBaoLuu").val(ngayBaoLuu);
	}
	$("#ghiChuTrangThai").val(listServer[i].ghiChuTrangThai);//5
}

function defaultValueWeb() {
	// Đưa thông tin học sinh về giá trị mặc định
	$("#hoTen, #tenThanMat, #ngaySinh, #diaChi, #tinhCachThoiQuen").val("");
	$("#doiTuong").val("");
	$("#danToc").val("");
	$("#lopHienTai").val("");
	$("#tonGiao").val("");
	$("#namHoc").val("");
	// Đưa giới tính về lại mặc định
	$("#gioiTinh").val("true");
	$("#goiTinhButton").empty();
	$("#goiTinhButton").attr("class", "col-2  btn btn-outline-dark btnCssWhite");
	$("#goiTinhButton").html("<i class='fas fa-male mr-3'></i><b>Nam</b>");

	// Đưa thông tin Phụ huynh về giá trị mặc định
	$("#hoTenCha, #namSinhCha, #ngheNghiepCha, #hoTenMe, #namSinhMe, #ngheNghiepMe, #dienThoai, #email, #ghiChuPhuHuynh").val("");

	// ***Đưa thông tin Hình ảnh về giá trị mặc định
	$("#image-input, #tenHinhAnh").val("");
	const imageContainer = $("#image-container");
	imageContainer.empty();	// xoá các HTML phần tử chứa trong nó
	const diagonal_1 = "<div class='diagonal-line diagonal-1'>";
	const diagonal_2 = "<div class='diagonal-line diagonal-2'>";
	imageContainer.append($(diagonal_1));// thêm phần tử HTML vào trong nó
	imageContainer.append($(diagonal_2));// thêm phần tử HTML vào trong nó

	// Đưa thông tin Trạng thái về giá trị mặc định
	$("#ngayVaoHoc, #ngayNghiHoc, #ngayBaoLuu, #ghiChuTrangThai").val("");
	$("#daNghiHoc").prop("checked", false);
	$("#baoLuuHocTap").prop("checked", false);

	// set lại cờ insert - update
	valueInsertUpdate = -1;

	// set lại mặc định các phần tử HTML error
	$(".error_html").text("");

	// chưa có thông tin thì disabled button [Xoa]
	$("#deleteModel").prop("disabled", true);
}

function renderLists(listServerAjax) {
	const lists = $("#lists");
	lists.empty();

	for (let i = 0; i < listServerAjax.length; i++) {
		const element = listServerAjax[i];
		const selectItem = $("<button type='button' class='col-12 btn btn-outline-dark outline_dark_lists chonThongTinModel'>")
			.html('<i class="fas fa-trash-alt mr-2"></i>')
			.data("index", i);
		selectItem.text(element.hoTen);
		lists.append(selectItem);
	}

	// Tạo sự kiện khi kích button cùng lúc với renderLists
	$(".chonThongTinModel").click(function() {
		defaultValueWeb();
		// enabled button [Xoa] khi đã chọn thông tin học sinh
		$("#deleteModel").prop("disabled", false);
		const index = $(this).data("index");
		clickModelOnLists(index);
	});
}

function renderNamHocSearch(listServerAjax) {
	const lists = $("#namHocSearch");
	lists.empty();

	if (listServerAjax.length == 0) {
		const selectItem = $("<option>");
		selectItem.text("");
		lists.append(selectItem);
		return;
	}

	for (let i = 0; i < listServerAjax.length; i++) {
		const element = listServerAjax[i];
		const selectItem = $("<option>");
		selectItem.text(element);
		lists.append(selectItem);
	}
}

function renderLopHocSearch(listServerAjax) {
	const lists = $("#lopHocSrarch");
	lists.empty();

	if (listServerAjax.length == 0) {
		const selectItem = $("<option>");
		selectItem.text("");
		lists.append(selectItem);
		return;
	}

	for (let i = 0; i < listServerAjax.length; i++) {
		const element = listServerAjax[i];
		const selectItem = $("<option>");
		selectItem.text(element);
		lists.append(selectItem);
	}
}


defaultValueWeb();
ajaxNewIdObject();// function xử lý maSoId bằng id hiện có lớn nhất + 1
ajaxListObject();
ajaxNamHocSearch();
ajaxLopHocSearch();
