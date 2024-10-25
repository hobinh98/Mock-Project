
// Ajax Insert
function ajaxInsertObject() {
	var hocSinh = objectHocSinh();
	var phuHuynhHS = objectPhuHuynhHS();
	var hinhAnhHS = objectHinhAnhHS();
	var trangThaiHS = objectTrangThaiHS();

	$.ajax({
		url: 'http://localhost:8080/springmvc/manage/insert',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify({ hocSinh, phuHuynhHS, hinhAnhHS, trangThaiHS }),
		success: function(response) {
			if (response.success) {
				// Thông báo Insert không thành công
				modalInsertSuccess();
				// Tải lại Danh sach
				ajaxListObject();
				ajaxNewIdObject();// function xử lý maSoId bằng id hiện có lớn nhất + 1
				defaultValueWeb();
				ajaxNamHocSearch();
				ajaxLopHocSearch();
			} else {
				// Thông báo và Hiển thị lỗi
				modalExistsImage();
				$("#error_image").text(response.message);
			}
		},
		error: function(xhr, status, error) {
			// Thông báo nếu Error
			alert('Error saving object: ' + error);
		}
	});
}

// Ajax Update
function ajaxUpdateObject() {
	var hocSinh = objectHocSinh();
	var phuHuynhHS = objectPhuHuynhHS();
	var hinhAnhHS = objectHinhAnhHS();
	var trangThaiHS = objectTrangThaiHS();

	$.ajax({
		url: 'http://localhost:8080/springmvc/manage/update',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify({ hocSinh, phuHuynhHS, hinhAnhHS, trangThaiHS }),
		success: function(response) {
			if (response.success) {
				// Thông báo Update không thành công
				modalUpdateSuccess();
				// Tải lại Danh sach
				ajaxListObject();
				ajaxNewIdObject();// function xử lý maSoId bằng id hiện có lớn nhất + 1
				defaultValueWeb();
				ajaxNamHocSearch();
				ajaxLopHocSearch();
			} else {
				// Thông báo và Hiển thị lỗi
				modalExistsImage();
				$("#error_image").text(response.message);
			}
		},
		error: function(xhr, status, error) {
			// Thông báo nếu Error
			alert('Error saving object: ' + error);
		}
	});
}

// Ajax Bảo lưu
function ajaxBaoLuuObject() {
	const maHocSinh = $("#maSoId").text();
	const trangThaiHS = objectTrangThaiHS();
	$.ajax({
		url: `http://localhost:8080/springmvc/manage/baoluu?maHocSinh=${maHocSinh}`,
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(trangThaiHS),
		success: function(response) {
			// Thông báo Bảo lưu không thành công
			if (response) {
				modalBaoLuuSuccess();
				ajaxListObject();// Tải lại Danh sach
				$(".error_html").text("");
			}
		},
		error: function(xhr, status, error) {
			// Thông báo nếu Error
			alert('Error saving object: ' + error);
		}
	});
}

// Ajax Xoá
function ajaxDeleteObject() {
	const maHocSinh = $("#maSoId").text();
	$.ajax({
		url: `http://localhost:8080/springmvc/manage/delete`,
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(maHocSinh),
		success: function(response) {
			// Thông báo Xoá thành công
			if (response) {
				modalDeleteSuccess();
				// Tải lại Danh sach
				ajaxListObject();
				ajaxNewIdObject();// function xử lý maSoId bằng id hiện có lớn nhất + 1
				defaultValueWeb();
				ajaxNamHocSearch();
				ajaxLopHocSearch();
			} else {
				modalDeleteError();
			}
		},
		error: function(xhr, status, error) {
			// Thông báo nếu Error
			alert('Error saving object: ' + error);
		}
	});
}

// Ajax selectNewId
function ajaxNewIdObject() {
	$.ajax({
		url: 'http://localhost:8080/springmvc/manage/selectnewid',
		type: 'GET',
		success: function(response) {
			// xử lý maSoId bằng id hiện có lớn nhất + 1
			$("#maSoId").text(response);
		},
		error: function(xhr, status, error) {
			// Thông báo nếu Error
			alert('Error retrieving objects: ' + error);
		}
	});
}

// Ajax Danh sách tìm kiếm
function ajaxListSearchObject() {
	const search = objectSearch();
	$.ajax({
		url: 'http://localhost:8080/springmvc/manage/listsearch',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(search),
		success: function(response) {
			// Nếu không có kết quả trong danh sách
			if (response.length == 0) {
				const lists = $("#lists");
				lists.empty();
				const b = $("<b  style='color: red'>");
				b.text("Hiện không có học sinh nào cho kết quả tìm kiếm");
				lists.append(b);
			} else {
				// Nếu có kết quả trong danh sách
				renderLists(response);
			}
			listServer = response;
		},
		error: function(xhr, status, error) {
			// Thông báo nếu Error
			alert('Error retrieving objects: ' + error);
		}
	});
}

// Ajax Tất cả danh sách hiện có
function ajaxListObject() {
	$.ajax({
		url: 'http://localhost:8080/springmvc/manage/list',
		type: 'GET',
		success: function(response) {
			// Nếu không có kết quả trong danh sách
			if (response.length == 0) {
				const lists = $("#lists");
				lists.empty();
				const b = $("<b  style='color: red'>");
				b.text("Hiện trong hệ thống không có học sinh nào");
				lists.append(b);
			} else {
				// Nếu có kết quả trong danh sách
				renderLists(response);
			}
			listServer = response;
		},
		error: function(xhr, status, error) {
			// Thông báo nếu Error
			alert('Error retrieving objects: ' + error);
		}
	});
}

// Ajax Tất cả giá trị năm học hiện có trong database để tìm kiếm
function ajaxNamHocSearch() {
	$.ajax({
		url: 'http://localhost:8080/springmvc/manage/namhocsearch',
		type: 'GET',
		success: function(response) {
			renderNamHocSearch(response);
		},
		error: function(xhr, status, error) {
			// Thông báo nếu Error
			alert('Error retrieving objects: ' + error);
		}
	});
}

// Ajax Tất cả giá trị lớp học hiện có trong database để tìm kiếm
function ajaxLopHocSearch() {
	$.ajax({
		url: 'http://localhost:8080/springmvc/manage/lophocsearch',
		type: 'GET',
		success: function(response) {
			renderLopHocSearch(response);
		},
		error: function(xhr, status, error) {
			// Thông báo nếu Error
			alert('Error retrieving objects: ' + error);
		}
	});
}

// click Cập nhập
$('#capNhap').click(function() {

	let isValid = false;

	if (submitValidateCapNhap()) {
		isValid = true;
	}

	// Cờ
	if (isValid) {
		return;
	}

	if (valueInsertUpdate === -1) {
		ajaxInsertObject();
	} else {
		ajaxUpdateObject()
	}
});

// click Bảo lưu
$('#submitBaoLuu').click(function() {

	let isValid = false;

	if (validBaoLuu()) {
		isValid = true;
	}

	// Cờ
	if (isValid) {
		return;
	}

	ajaxBaoLuuObject();
});

// click Tìm kiếm
$('#submitSearch').click(function() {
	ajaxListSearchObject();
});
const scrollToTopSearch = document.getElementById('submitSearch');
// Thêm sự kiện click vào nút button
scrollToTopSearch.addEventListener('click', function() {
	// Cuộn màn hình lên trên đầu trang
	window.scrollTo({
		top: 0,
		behavior: 'smooth'
	});
});

// click Xoá
$('#deleteModel').click(function() {
	if (valueInsertUpdate === -1) {
		modalDeleteNotSelect();
		return;
	}
	ajaxDeleteObject();
});
const scrollToTopDelete = document.getElementById('deleteModel');
// Thêm sự kiện click vào nút button
scrollToTopDelete.addEventListener('click', function() {
	// Cuộn màn hình lên trên đầu trang
	window.scrollTo({
		top: 0,
		behavior: 'smooth'
	});
});

