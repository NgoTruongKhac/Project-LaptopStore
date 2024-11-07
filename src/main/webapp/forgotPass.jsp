<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<%@ include file="styleCSS/allCss.jsp"%>
</head>
<body>

	<div class="container mt-5 d-flex justify-content-center">

		<div class="row">
			<div class="col-md-12"
				style="border: solid; padding: 25px; border-radius: 10px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">

				<form action="forgotPass" method="post">
					<div class="d-flex justify-content-center mb-2">
						<h3>Đặt lại mật khẩu</h3>
					</div>
					<div>
						<label class="form-label">Email/Số điện thoại:</label> <input
							class="form-control" type="email" name="emailOrPhone"
							required="required" size="26"
							value="${param.emailOrPhone != null ? param.emailOrPhone : ''}" />
					</div>
					<div>
						<label class="form-label">Mật khẩu mới:</label> <input
							class="form-control" type="password" name="newPass" />
					</div>
					<div>
						<label class="form-label">Xác nhận mật khẩu mới:</label> <input
							class="form-control" type="password" name="ConfirmNewPass"
							required="required" />
					</div>
					<div class="mt-3 d-flex justify-content-center">
						<button class="btn btn-primary" type="submit">Tạo mới</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="components/alert.jsp"></jsp:include>

</body>
</html>