
// lấy phần tử input type = file để xử lý sự kiện về ảnh
const imageInput = document.getElementById('image-input');
// xự kiện kích phần tử input để chọn ảnh
imageInput.addEventListener('change', handleImageUpload);
function handleImageUpload() {
	// lấy phần tử HTML đã tồn tại cần render phần tử HTML img vào
	const imageContainer = document.getElementById('image-container');

	// Lấy file ảnh được chọn với this là phần tử HTML đang kích
	const file = this.files[0];

	// Kiểm tra xem file có phải là ảnh hay không
	if (file && file.type.startsWith('image/')) {
		// tạo phần tử HTML img để chứa ảnh cần render
		const img = document.createElement('img');

		// chuyền dữ liệu file cho HTML img
		img.src = URL.createObjectURL(file);
		img.alt = file.name;
		img.classList.add('img-fluid'); // Thêm class để ảnh responsive

		// chuyền tên hình ảnh cho model
		$("#tenHinhAnh").val(file.name);

		// Xóa nội dung cũ trong imageContainer
		imageContainer.innerHTML = '';
		imageContainer.appendChild(img);
	}
	// Nếu file không phải ảnh
	else {

		// nếu vừa tải trang không có ảnh --> insert: thông báo lỗi nếu không chọn ảnh
		if (valueInsertUpdate === -1) {
			// xoá ảnh cũ trong imageContainer khi nhấn cancel
			const imageContainerJquery = $("#image-container");
			imageContainerJquery.empty();	// xoá các HTML phần tử chứa trong nó
			const diagonal_1 = "<div class='diagonal-line diagonal-1'>";
			const diagonal_2 = "<div class='diagonal-line diagonal-2'>";
			imageContainerJquery.append($(diagonal_1));// thêm phần tử HTML vào trong nó
			imageContainerJquery.append($(diagonal_2));// thêm phần tử HTML vào trong nó
			// chuyền tên hình ảnh cho model
			$("#tenHinhAnh").val("");
		}

		// nếu vừa tải trang có ảnh --> update: chuyển về lại ảnh ban đầu
		if (valueInsertUpdate != -1) {
			// imageClickFile và tenHinhAnhClickFile nhận giá trị từ phần tử jQuery nên phải nhận theo jQuery
			const imageContainer = $("#image-container");
			imageContainer.empty();	// xoá các HTML phần tử chứa trong nó
			imageContainer.append(imageSelectLists);// thêm phần tử HTML vào trong nó
			// chuyền tên hình ảnh cho model
			$("#tenHinhAnh").val(tenHinhAnhSelectLists);
		}
	}
}

// logic: khi tích vào thì chuyển sang giới tính khác
$("#goiTinhButton").click(
	function() {
		// lấy giá trị giới tính ở thời điểm hiện tại để kiểm tra logic
		const gioiTinh = $("#gioiTinh").val();

		// nếu hiện tại là Nam --> kích vào chuyển qua Nu
		if (gioiTinh === "true") {
			// set lại giá trị mới cho ô input hidden
			$("#gioiTinh").val("false");

			// xoá các phần tử html con trước đó
			$("#goiTinhButton").empty();

			// set lại màu cho button
			$("#goiTinhButton").attr("class", "col-2  btn btn-outline-dark btnCssWhite");

			// thêm mới các phần tử html con
			$("#goiTinhButton").html("<i class='fas fa-female mr-3'></i><b>Nu</b>");

			// console.log giá trị ô input hidden ở thời điểm hiện tại sau khi tích để chuyển giới tính
			console.log($("#gioiTinh").val());
		}

		// nếu hiện tại là Nu --> kích vào chuyển qua Nam
		if (gioiTinh === "false") {
			$("#gioiTinh").val("true");
			$("#goiTinhButton").empty();
			$("#goiTinhButton").attr("class", "col-2  btn btn-outline-dark btnCssWhite");
			$("#goiTinhButton").html("<i class='fas fa-male mr-3'></i><b>Nam</b>");
			console.log($("#gioiTinh").val());
		}

	}
);