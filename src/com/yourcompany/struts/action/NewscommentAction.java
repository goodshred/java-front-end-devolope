package com.yourcompany.struts.action;

import com.yourcompany.struts.form.NewscommentForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.commons.beanUtil.BeanUtil;
import org.apache.commons.codec.bo.INewsCommentManager;
import org.apache.commons.codec.po.Newscomment;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class NewscommentAction extends DispatchAction
{
  private INewsCommentManager commentManager;

  public INewsCommentManager getCommentManager()
  {
    return this.commentManager;
  }

  public void setCommentManager(INewsCommentManager commentManager) {
    this.commentManager = commentManager;
  }

  public ActionForward newsCommentSave(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    setCharSet(request, response);
    NewscommentForm newsForm = (NewscommentForm)form;
    PrintWriter out = response.getWriter();
    String users = request.getParameter("user");
    try {
      Newscomment nc = this.commentManager.getJsonOrObjet(users, newsForm);
      String flag = this.commentManager.save(nc);
      out.write(flag);
    } catch (Exception e) {
      out.write("传入参数不正确！请检查参数名称或url格式!");
    }
    out.close();
    return null;
  }

  public ActionForward newsCommentUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    setCharSet(request, response);
    NewscommentForm newsForm = (NewscommentForm)form;
    PrintWriter out = response.getWriter();
    String users = request.getParameter("user");
    try {
      Newscomment nc = this.commentManager.getJsonOrObjet(users, newsForm);
      String flag = this.commentManager.update(nc);
      out.write(flag);
    } catch (Exception e) {
      out.write("传入参数不正确！请检查参数名称或url格式!");
    }
    out.close();
    return null;
  }

  public ActionForward newsCommentDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    setCharSet(request, response);
    NewscommentForm newsForm = (NewscommentForm)form;
    PrintWriter out = response.getWriter();
    String users = request.getParameter("user");
    try {
      Newscomment nc = this.commentManager.getJsonOrObjet(users, newsForm);
      String flag = "failure";
      if (nc.getCommentId() != null) {
        flag = this.commentManager.delete(nc.getCommentId());
      }
      out.write(flag);
    } catch (Exception e) {
      out.write("传入参数不正确！请检查参数名称或url格式!");
    }
    out.close();
    return null;
  }

  public ActionForward newsCommentList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    setCharSet(request, response);
    List list = this.commentManager.findByAll();
    PrintWriter writer = response.getWriter();
    JSONArray jsonArray = JSONArray.fromObject(list);
    writer.write(jsonArray.toString());
    writer.close();
    return null;
  }

  public ActionForward getNewsComment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    setCharSet(request, response);
    NewscommentForm newsForm = (NewscommentForm)form;
    PrintWriter out = response.getWriter();
    String users = request.getParameter("user");
    try {
      Newscomment nc = this.commentManager.getJsonOrObjet(users, newsForm);
      Newscomment nsc = (Newscomment)this.commentManager.findOne(nc.getCommentId());
      out.write(BeanUtil.writer(nsc));
    } catch (Exception e) {
      out.write("传入参数不正确！请检查参数名称或url格式!");
    }
    out.close();
    return null;
  }

  public ActionForward findNewsCommentByLike(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    setCharSet(request, response);
    NewscommentForm newsForm = (NewscommentForm)form;
    PrintWriter out = response.getWriter();
    String users = request.getParameter("user");
    try {
      Newscomment nc = this.commentManager.getJsonOrObjet(users, newsForm);
      List list = this.commentManager.findByName("commentTitle", nc.getCommentTitle(), true);
      JSONArray jsonArray = JSONArray.fromObject(list);
      out.write(jsonArray.toString());
    } catch (Exception e) {
      out.write("传入参数不正确！请检查参数名称或url格式!");
    }
    out.close();
    return null;
  }

  public ActionForward findNewsCommentByEq(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    setCharSet(request, response);
    NewscommentForm newsForm = (NewscommentForm)form;
    PrintWriter out = response.getWriter();
    String users = request.getParameter("user");
    try {
      Newscomment nc = this.commentManager.getJsonOrObjet(users, newsForm);
      List list = this.commentManager.findByName("commentTitle", nc.getCommentTitle(), false);
      JSONArray jsonArray = JSONArray.fromObject(list);
      out.write(jsonArray.toString());
    } catch (Exception e) {
      out.write("传入参数不正确！请检查参数名称或url格式!");
    }
    out.close();
    return null;
  }

  public ActionForward findNewsCommentByUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    setCharSet(request, response);
    setCharSet(request, response);
    NewscommentForm newsForm = (NewscommentForm)form;
    PrintWriter out = response.getWriter();
    String users = request.getParameter("user");
    try {
      Newscomment nc = this.commentManager.getJsonOrObjet(users, newsForm);
      List list = this.commentManager.findByName("username", nc.getUsername(), false);
      JSONArray jsonArray = JSONArray.fromObject(list);
      out.write(jsonArray.toString());
    } catch (Exception e) {
      out.write("传入参数不正确！请检查参数名称或url格式!");
    }
    out.close();
    return null;
  }

  private void setCharSet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
	  response.setHeader("Access-Control-Allow-Origin", "*");
	  response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0L);
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
  }
}