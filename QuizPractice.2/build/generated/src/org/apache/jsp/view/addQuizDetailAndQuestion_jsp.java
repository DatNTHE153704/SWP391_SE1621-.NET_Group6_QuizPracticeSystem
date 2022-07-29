package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addQuizDetailAndQuestion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Roboto&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/quizDetailAndQuestion.css\">\r\n");
      out.write("\r\n");
      out.write("        <title>Document</title>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <h2>Subject Details</h2>\r\n");
      out.write("                <form action=\"AdminSubjectController\" method=\"post\">\r\n");
      out.write("                    <div class=\"mainSection\">\r\n");
      out.write("                        <div class=\"firstSection\">\r\n");
      out.write("                            <div class=\"subjectNameContet\" style=\"margin-top:20px\">\r\n");
      out.write("                                Subject name section\r\n");
      out.write("                                <label for=\"subjectName\">Subject Name</label>\r\n");
      out.write("                                <input type=\"text\" name=\"name\" id=\"subjectName\" placeholder=\"Please input your subject name here.\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            end of subject section\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"secondSection\">\r\n");
      out.write("                            <div class=\"imageSection\">\r\n");
      out.write("                                <input name=\"image\" type=\"file\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"description\">\r\n");
      out.write("                        <label for=\"descriptionSection\">Description:</label><br>\r\n");
      out.write("\r\n");
      out.write("                        <textarea id=\"descriptionSection\" name=\"description\" rows=\"6\" cols=\"135\">\r\n");
      out.write("                    \r\n");
      out.write("                        </textarea>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"buttonSection\">\r\n");
      out.write("                        <button type=\"submit\">Submit</button>\r\n");
      out.write("                        <button type=\"button\">Cancel</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("                <div class=\"tab\">\r\n");
      out.write("                    <button class=\"tablinks\" onclick=\"openCity(event, 'Overview')\" id=\"openDefault\">Overview</button>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Tab content -->\r\n");
      out.write("                <div id=\"Overview\" class=\"tabcontent\">\r\n");
      out.write("                    <form action=\"AddQuizExpertController\" method=\"post\">\r\n");
      out.write("                        <div class=\"mainSection\">\r\n");
      out.write("                            <div class=\"firstSection\">\r\n");
      out.write("                                <div class=\"subjectNameContet\">\r\n");
      out.write("                                    <!--Subject name section-->\r\n");
      out.write("                                    <label for=\"subjectName\">Quiz Name</label>\r\n");
      out.write("                                    <input type=\"text\" name=\"quizName\" id=\"quizName\" placeholder=\"Please input your quiz name here.\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <!--end of subject section-->\r\n");
      out.write("                                <!--Category section-->\r\n");
      out.write("                                <div class=\"subjectContent\">\r\n");
      out.write("                                    <label for=\"Subject\">Subject</label>\r\n");
      out.write("                                    <select name=\"subject\" id=\"subject\">\r\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"levelContent\">\r\n");
      out.write("                                <label for=\"level\">Level</label>\r\n");
      out.write("                                <select name=\"level\" id=\"level\">\r\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"quizDurationContent\">\r\n");
      out.write("                                <label for=\"quizDuration\">Quiz Duration</label>\r\n");
      out.write("                                <input name=\"hour\" type=\"number\" class=\"hour\"> :\r\n");
      out.write("                                <input name=\"minus\" type=\"number\" class=\"minus\"> :\r\n");
      out.write("                                <input name=\"second\" type=\"number\" class=\"second\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"numberQuestionContent\">\r\n");
      out.write("                                <label for=\"numberQuestion\">Number Question: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numberQuestion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</label>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"secondSection\">\r\n");
      out.write("                            <div class=\"imageSection\">\r\n");
      out.write("                                <img src=\"img/asp-mvc.jpg\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"description\">\r\n");
      out.write("                        <label for=\"descriptionSection\">Description:</label><br>\r\n");
      out.write("\r\n");
      out.write("                        <textarea id=\"descriptionSection\" name=\"description\" rows=\"6\" cols=\"133\">\r\n");
      out.write("\r\n");
      out.write("                        </textarea>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"buttonSection\">\r\n");
      out.write("                        <button type=\"submit\">Submit</button>\r\n");
      out.write("                        <button type=\"button\">Cancel</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <script>\r\n");
      out.write("                function openCity(evt, tabname) {\r\n");
      out.write("                    var i, tabcontent, tablinks;\r\n");
      out.write("                    tabcontent = document.getElementsByClassName(\"tabcontent\");\r\n");
      out.write("                    for (i = 0; i < tabcontent.length; i++) {\r\n");
      out.write("                        tabcontent[i].style.display = \"none\";\r\n");
      out.write("                    }\r\n");
      out.write("                    tablinks = document.getElementsByClassName(\"tablinks\");\r\n");
      out.write("                    for (i = 0; i < tablinks.length; i++) {\r\n");
      out.write("                        tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\r\n");
      out.write("                    }\r\n");
      out.write("                    document.getElementById(tabname).style.display = \"block\";\r\n");
      out.write("                    evt.currentTarget.className += \" active\";\r\n");
      out.write("                }\r\n");
      out.write("                document.getElementById(\"openDefault\").click();\r\n");
      out.write("            </script>\r\n");
      out.write("    </body>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listSubject}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("ls");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                        <option name =\"subjectChoose\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ls.subjectId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" >");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ls.subjectName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\r\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listQuizLevel}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("ll");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                        <option name=\"quizLevelChoose\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ll.quizLevelId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" >");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ll.quizLevelName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\r\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
