
// Biến lưu phần tử HTML img tại thời điểm khi chọn học sinh trên danh sách
let imageSelectLists;

// Biến lưu tên hình ảnh tại thời điểm khi chọn học sinh trên danh sách
let tenHinhAnhSelectLists;

// Biến để kiểm tra nếu đang ở trạng thái Nghĩ học
// mà muốn cập nhập ngày Bảo lưu thì cần kiểm tra giữa ngày Vào học và ngày Nghĩ học
let ngayNghiHocSelectLists = "";

// Biến để kiểm tra nếu đang ở trạng thái Bảo lưu
// mà muốn cập nhập ngày Nghĩ hoc thì cần kiểm tra giữa ngày Vào học và ngày Bảo lưu
let ngayBaoLuuSelectLists = "";

// Mãng lưu thông tin danh sách học sinh
let listServer = [];

// Cờ xác định trạng thái button [Cap nhap] đang là insert hay update (-1 là insert)
let valueInsertUpdate = -1;