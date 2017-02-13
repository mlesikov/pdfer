package com.mlesikov.pdfer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class ApiGatewayServlet extends HttpServlet {


  private static final Logger log = Logger.getLogger(ApiGatewayServlet.class.getName());


  public ApiGatewayServlet() {
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) {


  }
}
