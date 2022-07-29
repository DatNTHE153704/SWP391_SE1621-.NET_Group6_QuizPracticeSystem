package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminSubject_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <title>Admin Page</title>\n");
      out.write("        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css\"\n");
      out.write("            />\n");
      out.write("        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\n");
      out.write("            integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\n");
      out.write("            crossorigin=\"anonymous\"\n");
      out.write("            />\n");
      out.write("        <script src=\"https://kit.fontawesome.com/64bb7a6643.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/adminSubject.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"sidebar\">\n");
      out.write("            <div class=\"sidebar-brand\">\n");
      out.write("                <h2><span class=\"las la-accusoft\"></span>Admin Page</h2>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"sidebar-menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"admin.html\" \n");
      out.write("                           ><i class=\"fas fa-user-circle\"></i> <span>User</span></a\n");
      out.write("                        >\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"admin_course.html\"\n");
      out.write("                           ><i class=\"fas fa-book-open\"></i><span>Course</span></a\n");
      out.write("                        >\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\"\n");
      out.write("                           ><i class=\"fas fa-graduation-cap\"></i><span>Expert</span></a\n");
      out.write("                        >\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"admin_subject.html\" class=\"active\"\n");
      out.write("                           ><i class=\"fas fa-laptop\"></i>\n");
      out.write("                            <span>Subject</span></a\n");
      out.write("                        >\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"main-content\">\n");
      out.write("            <header>\n");
      out.write("                <h2>\n");
      out.write("                    <label for=\"\">\n");
      out.write("                        <span class=\"las la-bars\"></span>\n");
      out.write("                    </label>\n");
      out.write("                    Dashboard\n");
      out.write("                </h2>\n");
      out.write("                <div class=\"search-wrapper\">\n");
      out.write("                    <span class=\"class las la-search\"></span>\n");
      out.write("                    <input type=\"search\" placeholder=\"Search here\" />\n");
      out.write("                </div>\n");
      out.write("                <div class=\"user-wrapper\">\n");
      out.write("                    <img\n");
      out.write("                        src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEAoTadQ4n5Oe-rLqJz9j_UCkUhtcLoZlacA&usqp=CAU\"\n");
      out.write("                        width=\"40px\"\n");
      out.write("                        height=\"40px\"\n");
      out.write("                        alt=\"Error\"\n");
      out.write("                        />\n");
      out.write("                    <div>\n");
      out.write("                        <h4>Eminem</h4>\n");
      out.write("                        <small>Slim Shady</small>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </header>\n");
      out.write("\n");
      out.write("            <main>\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"row justify-content-between subject-section\">\n");
      out.write("                        <h2 class=\"mt-3\">Subject Management</h2>\n");
      out.write("                        <a href=\"AdminAddSubjectController\" style=\"height:30px !important;margin-right: 20px;margin-top: 10px \" class=\"btn btn-primary btn-sm float-right\">Add subject</a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <table class=\"table table-bordered\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Name</th>     \n");
      out.write("                                <th>Thumbnail</th>     \n");
      out.write("                                <th>Description</th>    \n");
      out.write("                                <th>Delete</th>\n");
      out.write("                                <th>Update</th>    \n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </main>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--Script for modal active-->\n");
      out.write("        <script>\n");
      out.write("            $(\"#myModal\").on(\"shown.bs.modal\", function () {\n");
      out.write("                $(\"#myInput\").trigger(\"focus\");\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <script\n");
      out.write("            src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"\n");
      out.write("            integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\"\n");
      out.write("            crossorigin=\"anonymous\"\n");
      out.write("        ></script>\n");
      out.write("        <script\n");
      out.write("            src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"\n");
      out.write("            integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\"\n");
      out.write("            crossorigin=\"anonymous\"\n");
      out.write("        ></script>\n");
      out.write("        <script\n");
      out.write("            src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"\n");
      out.write("            integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\"\n");
      out.write("            crossorigin=\"anonymous\"\n");
      out.write("        ></script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${adminSubject}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("as");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <tr>               \n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${as.subjectName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${as.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${as.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td><button type=\"button\" class=\"btn btn-primary\">Delete</button></td>\n");
          out.write("                                    <td><a href=\"\" class=\"btn btn-primary\">Update</a></td>                                 \n");
          out.write("                                </tr>\n");
          out.write("                            ");
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
}
