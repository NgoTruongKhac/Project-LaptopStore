package servlet;

import java.io.IOException;

import dao.ForgotPassDAO;
import email.EmailUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/forgotPass")
public class ForgotPassServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String emailOrPhone = req.getParameter("emailOrPhone");
			String newPass = req.getParameter("newPass");
			String ConfirmNewPass = req.getParameter("ConfirmNewPass");

			ForgotPassDAO forgotPass = new ForgotPassDAO();
			
			String verificationCode = String.valueOf((int) (Math.random() * 900000) + 100000);

			boolean isforgotPass = forgotPass.isForgotPass(emailOrPhone);
			
			if (!newPass.equals(ConfirmNewPass)) {

				req.getSession().setAttribute("message", "Mật khẩu không trùng khớp!");
				req.getSession().setAttribute("type", "error");
				req.getSession().setAttribute("error", "register");
				req.getRequestDispatcher("forgotPass.jsp").include(req, resp);
				return;

			}
			

			if (isforgotPass) {

				String subject = "Mã xác nhận đổi mật khẩu";

				EmailUtil.sendEmail(emailOrPhone, subject, verificationCode);

				req.getSession().setAttribute("emailOrPhone", emailOrPhone);
				req.getSession().setAttribute("newPass", newPass);
				req.getSession().setAttribute("verificationCode", verificationCode);
				req.getSession().setAttribute("verificationTime",System.currentTimeMillis());

				req.getRequestDispatcher("verifyForgotPass.jsp").forward(req, resp);
			} else {
				req.setAttribute("message", "email không tồn tại!");
				req.setAttribute("type", "error");
				req.getRequestDispatcher("forgotPass.jsp").forward(req, resp);
			}
			System.out.println(isforgotPass);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
