package com.yourcompany.struts.action;

import com.yourcompany.struts.form.NewsTypeForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.commons.beanUtil.BeanUtil;
import org.apache.commons.codec.bo.INewsTypeManager;
import org.apache.commons.codec.po.Newstype;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class NewsTypeAction extends DispatchAction {
	private INewsTypeManager newsTypeManager;

	public INewsTypeManager getNewsTypeManager() {
		return this.newsTypeManager;
	}

	public void setNewsTypeManager(INewsTypeManager newsTypeManager) {
		this.newsTypeManager = newsTypeManager;
	}

	public ActionForward newsTypeSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		NewsTypeForm newsForm = (NewsTypeForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Newstype newstype = this.newsTypeManager.getJsonOrObjet(users,
					newsForm);
			String flag = this.newsTypeManager.save(newstype);
			out.write(flag);
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward newsTypeUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		NewsTypeForm newsForm = (NewsTypeForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Newstype newstype = this.newsTypeManager.getJsonOrObjet(users,
					newsForm);
			String flag = this.newsTypeManager.update(newstype);
			out.write(flag);
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward newsTypeDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		NewsTypeForm newsForm = (NewsTypeForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Newstype newstype = this.newsTypeManager.getJsonOrObjet(users,
					newsForm);
			String flag = "failure";
			if (newstype.getNewsTypeId() != null) {
				flag = this.newsTypeManager.delete(newstype.getNewsTypeId());
			}
			out.write(flag);
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward newsTypeList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		List list = this.newsTypeManager.findByAll();
		PrintWriter writer = response.getWriter();
		JSONArray jsonArray = JSONArray.fromObject(list);
		writer.write(jsonArray.toString());
		writer.close();
		return null;
	}

	public ActionForward getNewsType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		NewsTypeForm newsForm = (NewsTypeForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Newstype newstype = this.newsTypeManager.getJsonOrObjet(users,
					newsForm);
			Newstype nt = (Newstype) this.newsTypeManager.findOne(newstype
					.getNewsTypeId());
			out.write(BeanUtil.writer(nt));
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward findNewTypeByEq(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		setCharSet(request, response);
		NewsTypeForm newsForm = (NewsTypeForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Newstype newstype = this.newsTypeManager.getJsonOrObjet(users,
					newsForm);
			List list = this.newsTypeManager.findByName("newsTypeName",
					newstype.getNewsTypeName(), false);
			JSONArray jsonArray = JSONArray.fromObject(list);
			out.write(jsonArray.toString());
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward findNewTypeByLike(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		setCharSet(request, response);
		NewsTypeForm newsForm = (NewsTypeForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Newstype newstype = this.newsTypeManager.getJsonOrObjet(users,
					newsForm);
			List list = this.newsTypeManager.findByName("newsTypeName",
					newstype.getNewsTypeName(), true);
			JSONArray jsonArray = JSONArray.fromObject(list);
			out.write(jsonArray.toString());
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	private void setCharSet(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0L);
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	}
}