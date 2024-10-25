
var dayNowHB = new Date();
var textDayNowHB = `<b>${"Ho Binh -- " + dayNowHB.getFullYear() + "/" + (dayNowHB.getMonth() + 1) + "/" + dayNowHB.getDate()}</b>`;

function modalInsertSuccess() {
	// tiêu đề
	$("#headerModal").text("Thông báo về Cập nhập");
	// nội dung
	$("#bodyModal").text("Thêm thành công thông tin học sinh");
	// lựa chọn cho người dùng
	const closeModal = `<button type="button" class="btn btn-outline-dark" data-dismiss="modal"><b>Đóng</b></button>`;
	$("#footerModal").html(textDayNowHB + closeModal);
	$('#myModal').modal('show');
}

function modalUpdateSuccess() {
	// tiêu đề
	$("#headerModal").text("Thông báo về Cập nhập");
	// nội dung
	$("#bodyModal").text("Thay đổi thành công thông tin học sinh");
	// lựa chọn cho người dùng
	const closeModal = `<button type="button" class="btn btn-outline-dark" data-dismiss="modal"><b>Đóng</b></button>`;
	$("#footerModal").html(textDayNowHB + closeModal);
	$('#myModal').modal('show');
}

function modalCapNhapThatBai() {
	// tiêu đề
	$("#headerModal").text("Thông báo về Cập nhập");
	// nội dung
	$("#bodyModal").text("Thiếu dữ liệu hoặc sai dữ liệu");
	// lựa chọn cho người dùng
	const closeModal = `<button type="button" class="btn btn-outline-dark" data-dismiss="modal"><b>Đóng</b></button>`;
	$("#footerModal").html(textDayNowHB + closeModal);
	$('#myModal').modal('show');
}

function modalBaoLuuSuccess() {
	// tiêu đề
	$("#headerModal").text("Thông báo về Bảo lưu");
	// nội dung
	$("#bodyModal").text("Bảo lưu thành công thông tin học sinh");
	// lựa chọn cho người dùng
	const closeModal = `<button type="button" class="btn btn-outline-dark" data-dismiss="modal"><b>Đóng</b></button>`;
	$("#footerModal").html(textDayNowHB + closeModal);
	$('#myModal').modal('show');
}

function modalExistsImage() {
	// tiêu đề
	$("#headerModal").text("Thông báo về File ảnh");
	// nội dung
	const bodyModal = $("#bodyModal");
	const p1 = $("<p>");
	p1.text("Không tìm thấy file ảnh trong thư mục cần yêu cầu");
	const p2 = $("<p>");
	p2.text("Hãy chuyển ảnh hoặc chọn ảnh trong thư mục:");
	const p3 = $("<p>");
	p3.text("C:\\Users\\ADMIN\\Desktop\\MVC_WEB\\springmvc-mock-ajax\\src\\main\\webapp\\image\\");
	const div = $("<div>");
	div.append(p1, p2, p3);
	bodyModal.empty();
	bodyModal.append(div);

	// lựa chọn cho người dùng
	const closeModal = `<button type="button" class="btn btn-outline-dark" data-dismiss="modal"><b>Đóng</b></button>`;
	$("#footerModal").html(textDayNowHB + closeModal);
	$('#myModal').modal('show');
}

function modalDeleteNotSelect() {
	// tiêu đề
	$("#headerModal").text("Thông báo về Xoá thông tin học sinh");
	// nội dung
	$("#bodyModal").text("Bạn chưa chọn thông tin học sinh cần xoá");
	// lựa chọn cho người dùng
	const closeModal = `<button type="button" class="btn btn-outline-dark" data-dismiss="modal"><b>Đóng</b></button>`;
	$("#footerModal").html(textDayNowHB + closeModal);
	$('#myModal').modal('show');
}

function modalDeleteSuccess() {
	// tiêu đề
	$("#headerModal").text("Thông báo về Xoá thông tin học sinh");
	// nội dung
	$("#bodyModal").text("Xoá Thành công thông tin học sinh");
	// lựa chọn cho người dùng
	const closeModal = `<button type="button" class="btn btn-outline-dark" data-dismiss="modal"><b>Đóng</b></button>`;
	$("#footerModal").html(textDayNowHB + closeModal);
	$('#myModal').modal('show');
}

function modalDeleteError() {
	// tiêu đề
	$("#headerModal").text("Thông báo về Xoá thông tin học sinh");
	// nội dung
	$("#bodyModal").text("Xoá thất bại, sinh viên bạn muốn xoá vẫn còn thiếu tiền");
	// lựa chọn cho người dùng
	const closeModal = `<button type="button" class="btn btn-outline-dark" data-dismiss="modal"><b>Đóng</b></button>`;
	$("#footerModal").html(textDayNowHB + closeModal);
	$('#myModal').modal('show');
}

// Sự kiện kích vào ảnh
$("#buttonImg").on("click",
	function() {
		// lấy phần tử ảnh khi kích vào button
		const img = $("#buttonImg").find("div").eq(0).find("img").eq(0);

		// Tạo bản sao của ảnh
		// Vì khi sử dụng method .html() thì có nghĩa là chuyền luôn cả phần tử HTML đó vào
		const imgClone = img.clone();

		// tiêu đề
		$("#headerModal").text("Thông tin ảnh");
		// nội dung
		const imageContainer = document.getElementById("image-container");
		if (imageContainer.querySelector('img') != null) {
			$("#bodyModal").attr("style", "max-width: 100%;max-height: 100%; display: flex;align-items: center;justify-content: center;");
			imgClone.attr("style", "max-width: 100%;max-height: 100%;")
			$("#bodyModal").html(imgClone);
		} else {
			$("#bodyModal").text("Hiện không có ảnh nào");
		}
		// Xoá nội dung đuôi
		$("#footerModal").empty();
		$("#footerModal").html(textDayNowHB);

		$('#myModal').modal('show');
	}
);
