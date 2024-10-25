<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>manage</title>
<!-- link online -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<!-- THƯ VIỆN datepicker -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<!-- link request -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/bootstrap-4.6.2-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/fontawesome-free-5.15.4-web/css/all.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/z-css/style.css">
</head>

<body>
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col">
				<div class="border border-dark p-2 bg-secondary">
					<div class="row">
						<div class="col-6">
							<h3 style="margin: 0px; color: white;">QUAN LY HOC SINH</h3>
						</div>
						<div class="col-6 d-flex justify-content-end align-items-center">
							<a href="/springmvc/home" class="close-btn pr-3"><i class="fas fa-window-close"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div class="border border-dark bg-light">
					<nav>
						<div class="nav nav-tabs bg-light border-bottom border-dark" style="padding-left: 50px;" id="nav-tab" role="tablist">
							<button
								class="nav-link active border-bottom-0 border-dark btn-outline-light"
								id="nav-home-tab" data-toggle="tab" data-target="#nav-home"
								type="button" role="tab" aria-controls="nav-home"
								aria-selected="true">
								<b>Danh sach hoc sinh</b>
							</button>
							<button
								class="nav-link border-bottom-0 border-dark btn-outline-light"
								id="nav-profile-tab" data-toggle="tab"
								data-target="#nav-profile" type="button" role="tab"
								aria-controls="nav-profile" aria-selected="false">
								<b>Quan ly hoc sinh</b>
							</button>
						</div>
					</nav>
					<div class="tab-content" id="nav-tabContent">
						<div class="tab-pane fade show active" id="nav-home"
							role="tabpanel" aria-labelledby="nav-home-tab">
							<div class="row p-3 mt-4">
								<!-- ***NGĂN DANH SÁCH VÀ TÌM KIẾM -->
								<div class="col-3">
									<!-- ***DANH SÁCH -->
									<div class="row">
										<div class="col">
											<div class="border border-dark p-3">
												<p class="text-title bg-light">
													<b class="text-danger">Danh sach</b>
												</p>
												<div id="lists" class="border border-success p-3" style="background-color: white;">
													<!-- DANH SÁCH -->
												</div>
											</div>
										</div>
									</div>
									<!-- ***TÌM KIẾM -->
									<div class="row mt-3">
										<div class="col">
											<div class="border border-dark p-3" id="nganTimKiem">
												<!-- CĂN ĐỀU BÊN PHẢI -->
												<div class="pr-4 pl-3">
													<!-- CHỌN NĂM HỌC -->
													<div class="row form-inline">
														<label for="namHocSearch" class="col-5 d-flex justify-content-start">
															<b>Nam hoc</b>
														</label>
														<select id="namHocSearch" class="col-6 form-control">
															<!-- LẤY DỮ LIỆU search TỪ server -->
														</select>
													</div>
													<p id="error_namHocSearch" class="error_html"></p>
													<!-- CHỌN LỚP HỌC -->
													<div class="row form-inline mt-3">
														<label for="lopHocSrarch" class="col-5 d-flex justify-content-start">
															<b>Lop hoc</b>
														</label>
														<select id="lopHocSrarch" class="col-6 form-control">
															<!-- LẤY DỮ LIỆU search TỪ server -->
														</select>
													</div>
													<p id="error_lopHocSrarch" class="error_html"></p>
													<!-- THEO id -->
													<div class="row form-inline mt-3">
														<div class="col-5 d-flex justify-content-start">
															<input id="theoId" name="theoId" value="theoId" type="checkbox">
															<label for="theoId" class="ml-2">
																<b>Theo id</b>
															</label>
														</div>
														<input id="theoIdSearch" type="text" class="col-6 form-control">
													</div>
													<p id="error_theoIdSearch" class="error_html"></p>
													<!-- THEO TEN -->
													<div class="row form-inline mt-3">
														<div class="col-5 d-flex justify-content-start">
															<input id="theoTen" name="theoTen" value="theoTen" type="checkbox">
															<label for="theoTen" class="ml-2">
																<b>Theo ten</b>
															</label>
														</div>
														<input id="theoTenSearch" type="text" class="col-6 form-control">
													</div>
													<p id="error_theoTenSearch" class="error_html"></p>
													<!-- XÁC MINH search -->
													<input id="xacMinhTheoId" type="hidden">
													<input id="xacMinhTheoTen" type="hidden">

													<!-- submit TÌM KIẾM -->
													<button id="submitSearch" type="button" class="btn btn-outline-dark btnCssWhite mt-3 col-8">
														<i class="fas fa-search mr-2"></i>
														<b>Tim kiem</b>
													</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- ***NGĂN THÔNG TIN VÀ THÊM SỬA XOÁ -->
								<div class="col-9">
									<!-- ***row THÔNG TIN -->
									<div class="row">
										<div class="col-8">
											<!-- ***DIV THÔNG TIN HỌC SINH -->
											<div class="border border-dark p-3" id="nganThongTinHocSinh">
												<p class="text-title bg-light">
													<b class="text-danger">Thong tin hoc sinh</b>
												</p>
												<!-- CĂN ĐỀU BÊN PHẢI -->
												<div class="pr-4">
													<!-- HO TEN -->
                                                    <div class="row">
                                                        <div class="col-2"></div>
                                                        <div class="col-4"></div>
                                                        <div class="col-4 d-flex justify-content-center">
                                                            <label>
                                                                <b>Ten than mat</b>
                                                            </label>
                                                        </div>
                                                        <div class="col-2"></div>
                                                    </div>
                                                    <div class="row form-inline">
                                                        <label class="col-2 d-flex justify-content-end">
                                                            <b>Ho ten</b>
                                                        </label>
                                                        <input id="hoTen" type="text"  maxlength="25" class="form-control col-4">
                                                        <div class="col-4">
                                                            <div class="row d-flex justify-content-center">
                                                                <input id="tenThanMat" type="text"  maxlength="25" class="form-control col-10">
                                                            </div>
                                                        </div>
                                                        <button id="goiTinhButton" type="button" class="btn btn-outline-dark btnCssWhite">
                                                            <i class="fas fa-male mr-3"></i><b>Nam</b>
                                                        </button>
                                                        <input id="gioiTinh" type="hidden">
                                                    </div>
                                                    <!-- error -->
													<div class="row">
														<div class="col-2"></div>
														<p id="error_hoTen" class="error_html"></p>
													</div>
													<!-- NGAY SINH -->
                                                    <div class="row form-inline mt-3">
                                                        <label class="col-2 d-flex justify-content-end">
                                                            <b>Ngay sinh</b>
                                                        </label>
                                                        <input id="ngaySinh" type="date" class="col-3 form-control">

                                                        <label class="col-3  d-flex justify-content-end">
                                                            <b>Doi tuong uu tien</b>
                                                        </label>
                                                        <select id="doiTuong" class="col-4 form-control">
                                                            <option selected></option>
                                                            <option value="Doi tuong 1">Doi tuong 1</option>
                                                            <option value="Doi tuong 2">Doi tuong 2</option>
                                                            <option value="Doi tuong 3">Doi tuong 3</option>
                                                        </select>
                                                    </div>
                                                    <!-- error -->
                                                    <div class="row">
														<div class="col-2"></div>
                                                        <div class="col-3 p-0">
                                                            <p id="error_ngaySinh" class="error_html"></p>
                                                        </div>
														<div class="col-3"></div>
                                                        <div class="col-4 p-0">
                                                            <p id="error_doiTuong" class="error_html"></p>
                                                        </div>
                                                    </div>
													<!-- ĐỊA CHỈ -->
													<div class="row form-inline mt-3">
														<label class="col-2 d-flex justify-content-end">
															<b>Dia chi</b>
														</label>
														<input id="diaChi" type="text"  maxlength="45" class="col-10 form-control">
													</div>
													<!-- error -->
                                                    <div class="row">
														<div class="col-2"></div>
														<p id="error_diaChi" class="error_html"></p>
                                                    </div>
													<!-- DÂN TỘC - LỚP HIỆN TẠI -->
													<div class="row mt-3">
														<div class="col-6">
															<!-- DÂN TỘC -->
															<div class="row form-inline">
																<label class="col-4 d-flex justify-content-end">
																	<b>Dan toc</b>
																</label>
																<select	id="danToc" class="col-8 form-control">
																	<option selected></option>
																	<option value="Kinh">Kinh</option>
																	<option value="Tay">Tay</option>
																	<option value="Thai">Thai</option>
																	<option value="Muong">Muong</option>
																	<option value="Khmer">Khmer</option>
																	<option value="Hoa">Hoa</option>
																</select>
															</div>
														</div>
														<!-- LỚP HIỆN TẠI -->
														<div class="col-6">
															<div class="row form-inline">
																<label class="col-5 d-flex justify-content-end">
																	<b>Lop hien tai</b>
																</label>
																<select id="lopHienTai" class="col-7 form-control">
																	<option selected></option>
																	<option value="Mam 1">Mam 1</option>
																	<option value="Mam 2">Mam 2</option>
																	<option value="Mam 3">Mam 3</option>
																</select>
															</div>
														</div>
													</div>
													<!-- error -->
                                                    <div class="row">
														<div class="col-6">
															<div class="row">
																<div class="col-4"></div>
																<div class="col-8 p-0">
																	<p id="error_danToc" class="error_html"></p>
																</div>
															</div>
														</div>
                                                        <div class="col-6">
                                                        	<div class="row">
																<div class="col-5"></div>
																<div class="col-7 p-0">
																	<p id="error_lopHienTai" class="error_html"></p>
																</div>
															</div>
                                                        </div>
                                                    </div>
													<!-- TÔN GIÁO - NĂM HỌC -->
													<div class="row mt-3">
														<!-- TÔN GIÁO -->
														<div class="col-6">
															<div class="row form-inline">
																<label class="col-4 d-flex justify-content-end">
																	<b>Ton giao</b>
																</label>
																<select id="tonGiao" class="col-8 form-control">
																	<option selected></option>
																	<option value="Phat giao">Phat giao</option>
																	<option value="Dao giao">Dao giao</option>
																</select>
															</div>
														</div>
														<!-- NĂM HỌC -->
														<div class="col-6">
															<div class="row form-inline">
																<label class="col-5 d-flex justify-content-end">
																	<b>Nam hoc</b>
																</label>
																<select	id="namHoc" class="col-7 form-control">
																	<option selected></option>
																	<option value="2021-2022">2021-2022</option>
																	<option value="2022-2023">2022-2023</option>
																	<option value="2023-2024">2023-2024</option>
																</select>
															</div>
														</div>
													</div>
													<!-- error -->
                                                    <div class="row">
														<div class="col-6"></div>
                                                        <div class="col-6">
                                                        	<div class="row">
                                                        		<div class="col-5"></div>
																<div class="col-7 p-0">
																	<p id="error_namHoc" class="error_html"></p>
																</div>
                                                        	</div>
                                                        </div>
                                                    </div>
													<!-- TÍNH CÁCH THÓI QUEN -->
													<div class="row form-inline mt-3">
														<label class="col-2 d-flex justify-content-end">
															<b>Tinh cach,<br>Thoi quen</b>
														</label>
														<!-- THUỘC TÍNH rows HIỂN THỊ SỐ DÒNG BAN ĐẦU -->
														<textarea id="tinhCachThoiQuen"	class="inputTexts form-control col-10" rows="2"></textarea>
													</div>
													<!-- error -->
                                                    <div class="row">
														<div class="col-2"></div>
                                                        <div class="col-10">
                                                            <p id="error_tinhCachThoiQuen" class="error_html"></p>
                                                        </div>
                                                    </div>
												</div>
											</div>
											<!-- ***DIV THÔNG TIN PHỤ HUYNH -->
											<div class="border border-dark p-3 mt-5" id="nganThongTinPhuHuynh">
												<p class="text-title bg-light">
													<b class="text-danger">Thong tin phu huynh</b>
												</p>
												<!-- CĂN ĐỀU BÊN PHẢI -->
												<div class="pr-4">
													<!-- HO TEN CHA -->
                                                    <div class="row form-inline mt-3">
                                                        <label class="col-3 d-flex justify-content-end">
                                                            <b class="mr-3">Ho ten cha</b>
                                                        </label>
                                                        <input id="hoTenCha" type="text" maxlength="25" class="col-5 form-control">
                                                        <label class="col-2 d-flex justify-content-end">
                                                            <b>Nam sinh</b>
                                                        </label>
                                                        <input id="namSinhCha" type="text" class="col-2 form-control datepicker">
                                                    </div>
                                                    <!-- error -->
                                                    <div class="row">
														<div class="col-3"></div>
                                                        <div class="col-5  p-0">
                                                            <p id="error_hoTenCha" class="error_html"></p>
                                                        </div>
														<div class="col-2"></div>
                                                        <div class="col-2  p-0">
                                                            <p id="error_namSinhCha" class="error_html"></p>
                                                        </div>
                                                    </div>
													<!-- NGHỀ NGHIỆP CHA -->
													<div class="row form-inline mt-3">
														<label class="col-3 d-flex justify-content-end">
															<b class="mr-3">Nghe nghiep</b>
														</label>
														<input id="ngheNghiepCha" type="text" maxlength="25" class="col-9 form-control">
													</div>
													<!-- error -->
                                                    <div class="row">
														<div class="col-3"></div>
                                                        <div class="col-9  p-0">
                                                            <p id="error_ngheNghiepCha" class="error_html"></p>
                                                        </div>
                                                    </div>
													<!-- HO TEN ME -->
                                                    <div class="row form-inline mt-3">
                                                        <label class="col-3 d-flex justify-content-end">
                                                            <b class="mr-3">Ho ten me</b>
                                                        </label>
                                                        <input id="hoTenMe" type="text" maxlength="25" class="col-5 form-control">

                                                        <label class="col-2 d-flex justify-content-end">
                                                            <b>Nam sinh</b>
                                                        </label>
                                                        <input id="namSinhMe" type="text" class="col-2 form-control datepicker">
                                                    </div>
													<!-- error -->
                                                    <div class="row">
														<div class="col-3"></div>
                                                        <div class="col-5  p-0">
                                                            <p id="error_hoTenMe" class="error_html"></p>
                                                        </div>
														<div class="col-2"></div>
                                                        <div class="col-2  p-0">
                                                            <p id="error_namSinhMe" class="error_html"></p>
                                                        </div>
                                                    </div>
													<!-- NGHỀ NGHIỆP MẸ -->
													<div class="row form-inline mt-3">
														<label class="col-3 d-flex justify-content-end">
															<b class="mr-3">Nghe nghiep</b>
														</label>
														<input id="ngheNghiepMe" type="text" maxlength="25" class="col-9 form-control">
													</div>
													<!-- error -->
                                                    <div class="row">
														<div class="col-3"></div>
                                                        <div class="col-9  p-0">
                                                            <p id="error_ngheNghiepMe" class="error_html"></p>
                                                        </div>
                                                    </div>
													<!-- ĐIỆN THOẠI -->
													<div class="row form-inline mt-3">
														<label class="col-3 d-flex justify-content-end">
															<b class="mr-3">Dien thoai</b>
														</label>
														<input id="dienThoai" type="text" maxlength="15" class="col-9 form-control">
													</div>
													<!-- error -->
                                                    <div class="row">
														<div class="col-3"></div>
                                                        <div class="col-9  p-0">
                                                            <p id="error_dienThoai" class="error_html"></p>
                                                        </div>
                                                    </div>
													<!-- Email -->
													<div class="row form-inline mt-3">
														<label class="col-3 d-flex justify-content-end">
															<b class="mr-3">Email</b>
														</label>
														<input id="email" type="text" maxlength="50" class="col-9 form-control">
													</div>
													<!-- error -->
                                                    <div class="row">
														<div class="col-3"></div>
                                                        <div class="col-9  p-0">
                                                            <p id="error_email" class="error_html"></p>
                                                        </div>
                                                    </div>
													<!-- GHI CHÚ CỦA PHỤ HUYNH -->
													<div class="row form-inline mt-3">
														<label class="col-3 d-flex justify-content-end">
															<b class="mr-3">Ghi chu cua<br>phu huynh</b>
														</label>
														<!-- THUỘC TÍNH rows HIỂN THỊ SỐ DÒNG BAN ĐẦU -->
														<textarea id="ghiChuPhuHuynh" class="inputTexts form-control col-9" rows="2"></textarea>
													</div>
												</div>
											</div>
										</div>
										<div class="col-4">
											<!-- ***DIV HÌNH ẢNH -->
											<div class="border border-dark p-3" id="nganHinhAnh">
												<p class="text-title bg-light">
													<b class="text-danger">Hinh anh</b>
												</p>
												<!-- HIỂN THỊ ẢNH -->
												<div class="row">
													<div class="col d-flex justify-content-start">
														<button id="buttonImg" type="button" style="background-color: transparent; border: none; padding: 0;">
															<div id="image-container">
																<img id="imageTaiTrang" src="" alt="">
															</div>
														</button>
													</div>
												</div>
												<!-- MÃ maHocSinh -->
												<div class="form-inline mt-3 ml-4">
													<label class="mr-2">
														<b>Ma so(ID):</b>
													</label>
													<label ><b id="maSoId"></b></label>
												</div>
												<!-- TÊN ẢNH -->
												<input id="tenHinhAnh" type="hidden">
												<!-- CHỌN ẢNH -->
												<input type="file" id="image-input" accept="image/*">
												<label for="image-input" class="imagesl border border-dark rounded btn-outline-dark btnCssWhite p-2 mt-3 ml-3 col-5">
													<i class="fas fa-folder-open pr-2 pl-1"></i>
													<b>Chọn ảnh</b>
												</label>
												<p id="error_image" class="error_html ml-3"></p>
											</div>
											<!-- ***DIV TRẠNG THÁI HỌC SINH -->
											<div class="border border-dark pt-3 pl-3 pr-3 mt-5" id="nganTrangThaiHocSinh">
												<p class="text-title bg-light">
													<b class="text-danger">Trang thai hoc sinh</b>
												</p>
												<div class="pt-3 pl-3 pr-3">
													<!-- NGÀY VÀO HỌC -->
													<div class="form-group">
														<label>
															<b>Ngay vao hoc</b>
														</label>
														<input id="ngayVaoHoc" type="date" class="form-control">
														<p id="error_ngayVaoHoc" class="error_html"></p>
													</div>
													<!-- NGHI HỌC -->
													<div class="form-group">
														<!-- ĐÃ NGHI HỌC -->
														<input id="daNghiHoc" name="daNghiHoc" type="checkbox" style="width: 14px; height: 14px;">
														<label for="daNghiHoc" class="ml-2 mr-2">
															<b>Da nghi hoc</b>
														</label>
														<br>
														<!-- NGÀY NGHỈ HỌC -->
														<label><b>Ngay nghi hoc</b></label>
														<input id="ngayNghiHoc" type="date" class="form-control">
														<p id="error_ngayNghiHoc" class="error_html"></p>
													</div>
													<!-- BAO LƯU HỌC TẬP -->
													<div class="form-group">
														<input id="baoLuuHocTap" name="baoLuuHocTap" type="checkbox" style="width: 14px; height: 14px;">
														<label for="baoLuuHocTap" class="ml-2 mr-2">
															<b>Bao luu hoc tap</b>
														</label>
														<br>
														<!-- NGÀY BẢO LƯU -->
														<label><b>Ngay bao luu</b></label>
														<input id="ngayBaoLuu" type="date" class="form-control">
														<p id="error_ngayBaoLuu" class="error_html"></p>
														<!-- THỰC HIỆN BẢO LƯU -->
														<button id="submitBaoLuu" type="button" class="btn btn-outline-dark btnCssWhite mt-3">
															<b>Thuc hien bao luu</b>
														</button>
													</div>
													<!-- GHI CHÚ TRẠNG THÁI -->
													<div class="form-group mt-3">
														<label><b>Ghi chu trang thai</b></label>
														<!-- THUỘC TÍNH rows HIỂN THỊ SỐ DÒNG BAN ĐẦU -->
														<textarea id="ghiChuTrangThai" class="inputTexts form-control" rows="3"></textarea>
													</div>
													<p id="error_ghiChuTrangThai" class="error_html"></p>
												</div>
											</div>
										</div>
									</div>
									<!-- ***row Actions  -->
									<div class="row mt-3">
										<div class="col">
											<div class="border border-dark p-3 d-flex justify-content-end">
												<form action="" method="GET">
													<!-- Reset GIAO DIỆN - TỰ ĐỘNG TẠO ID -->
													<button formaction="/springmvc/home/manage" type="submit" class="btn btn-outline-dark btnCssWhite mr-5">
														<i class="fas fa-id-card mr-2"></i>
														<b>Dang ky nhap hoc</b>
													</button>
													<!-- insert - edit -->
													<button id="capNhap" type="button" class="btn btn-outline-dark btnCssWhite mr-5">
														<i class="fas fa-save mr-2"></i>
														<b>Cap nhap</b>
													</button>
													<!-- delete -->
													<button id="deleteModel" type="button" class="btn btn-outline-dark btnCssWhite mr-5">
														<i class="fas fa-calendar-times mr-2"></i>
														<b>Xoa</b>
													</button>
													<!-- close -->
													<button formaction="/springmvc/home" type="submit" class="btn btn-outline-dark btnCssWhite mr-5">
														<i class="fas fa-window-close mr-2"></i>
														<b>Dong lai</b>
													</button>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- HTML Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<!-- TIÊU ĐỀ modal -->
						<h5 id="headerModal" class="modal-title"></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<!-- NỘI DUNG modal -->
					<div id="bodyModal" class="modal-body d-flex justify-content-center"></div>
					<!-- LỰA CHỌN CHO NGƯỜI DÙNG -->
					<div id="footerModal" class="modal-footer d-flex justify-content-between"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- link online -->
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
	<!-- THƯ VIỆN moment.js online -->
	<!-- var date = new Date($("#ngayVaoHoc").val());
	var formattedDate = moment(date).format('YYYY-MM-DD'); -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
	
	<!-- link request -->
	<script src="<%=request.getContextPath()%>/styles/jquery/jquery-3.5.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/styles/jquery/popper.min.js"></script>
	<script src="<%=request.getContextPath()%>/styles/bootstrap-4.6.2-dist/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/styles/bootstrap-4.6.2-dist/js/bootstrap.bundle.min.js"></script>
	<!-- THƯ VIỆN datepicker -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <!-- getContextPath -->
	<script src="<%=request.getContextPath()%>/styles/z-js/datepicker.js"></script>
	<script src="<%=request.getContextPath()%>/styles/z-js/variables.js"></script>
	<script src="<%=request.getContextPath()%>/styles/z-js/model.js"></script>
	<script src="<%=request.getContextPath()%>/styles/z-js/modal.js"></script>
	<script src="<%=request.getContextPath()%>/styles/z-js/events.js"></script>
	<script src="<%=request.getContextPath()%>/styles/z-js/validateCapnhap.js"></script>
	<script src="<%=request.getContextPath()%>/styles/z-js/baoluu.js"></script>
	<script src="<%=request.getContextPath()%>/styles/z-js/search.js"></script>
	<script src="<%=request.getContextPath()%>/styles/z-js/ajax.js"></script>
	<script src="<%=request.getContextPath()%>/styles/z-js/interfaceManage.js"></script>

</body>
</html>