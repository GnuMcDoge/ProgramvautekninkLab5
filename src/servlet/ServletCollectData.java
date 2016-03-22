package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataHandler.DataSourceFactory_OLD;
import dataHandler.DataSourcesToJsonConverter;
import dataHandler.PrettyJsonFormatter;
import dataSources.DataSource;

/**
 * Servlet implementation class ServletColectData
 */

@WebServlet("/ServletCollectData")
public class ServletCollectData extends HttpServlet {
	PrettyJsonFormatter formatter = new PrettyJsonFormatter();
	DataSourcesToJsonConverter jsonGetter;
	private static final long serialVersionUID = 1L;
	private String ds1;
	private String ds2;
	private String result;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCollectData() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		try{
			ds1 = request.getParameter("ds1");
			ds2 = request.getParameter("ds2");
			jsonGetter = new DataSourcesToJsonConverter(ds1,ds2);
			result = jsonGetter.getString();
		}
		catch(NullPointerException e){
			
			result = "<h1 align=center>Error 404</h1><h2 align=center>You killed (the) Link.<br> Ganadorf won.</h2>";
		}

		if ("true".equalsIgnoreCase(request.getParameter("pretty"))) {

			result = formatter.format(result);
		}

		response.getWriter().append(result);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
