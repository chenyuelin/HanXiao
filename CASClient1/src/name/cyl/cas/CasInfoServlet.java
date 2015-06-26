package name.cyl.cas;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.authentication.AttributePrincipal;

/**
 * Servlet implementation class CasInfoServlet
 */
@WebServlet("/CasInfoServlet")
public class CasInfoServlet extends HttpServlet {
	private static final long serialVersionUID = -3743441451848166731L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Principal principal=request.getUserPrincipal();
		AttributePrincipal attributePrincipal=(AttributePrincipal)principal;
		System.out.println(principal.getName());
		System.out.println(attributePrincipal.getAttributes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
