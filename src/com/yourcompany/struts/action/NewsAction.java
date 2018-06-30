package com.yourcompany.struts.action;

import com.yourcompany.struts.form.NewsForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.commons.beanUtil.BeanUtil;
import org.apache.commons.codec.bo.INewsManager;
import org.apache.commons.codec.po.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class NewsAction extends DispatchAction {
	private INewsManager newsManager;

	public INewsManager getNewsManager() {
		return this.newsManager;
	}

	public void setNewsManager(INewsManager newsManager) {
		this.newsManager = newsManager;
	}

	public ActionForward newsSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		NewsForm newsForm = (NewsForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			News news = this.newsManager.getJsonOrObjet(users, newsForm);
			String flag = this.newsManager.save(news);
			out.write(flag);
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward newsUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		NewsForm newsForm = (NewsForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			News news = this.newsManager.getJsonOrObjet(users, newsForm);
			String flag = this.newsManager.update(news);
			out.write(flag);
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward newsDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		NewsForm newsForm = (NewsForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			News news = this.newsManager.getJsonOrObjet(users, newsForm);
			String flag = "failure";
			if (news.getNewsId() != null) {
				flag = this.newsManager.delete(news.getNewsId());
			}
			out.write(flag);
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	@SuppressWarnings("unchecked")
	public ActionForward newsList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		List list = this.newsManager.findByAll();
		PrintWriter writer = response.getWriter();
		JSONArray jsonArray = JSONArray.fromObject(list);
		writer.write(jsonArray.toString());
		writer.close();
		return null;
	}

	public ActionForward getNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		NewsForm newsForm = (NewsForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			News news = this.newsManager.getJsonOrObjet(users, newsForm);
			News ns = (News) this.newsManager.findOne(news.getNewsId());
			out.write(BeanUtil.writer(ns));
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward findNewsTitleByEq(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		setCharSet(request, response);
		NewsForm newsForm = (NewsForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			News news = this.newsManager.getJsonOrObjet(users, newsForm);
			List list = this.newsManager.findByName("newsTitle", news
					.getNewsTitle(), false);
			JSONArray jsonArray = JSONArray.fromObject(list);
			out.write(jsonArray.toString());
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward findNewsTitleByLike(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		setCharSet(request, response);
		NewsForm newsForm = (NewsForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			News news = this.newsManager.getJsonOrObjet(users, newsForm);
			List list = this.newsManager.findByName("newsTitle", news
					.getNewsTitle(), true);
			JSONArray jsonArray = JSONArray.fromObject(list);
			out.write(jsonArray.toString());
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward findNewsTypeByNews(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		setCharSet(request, response);
		NewsForm newsForm = (NewsForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			News news = this.newsManager.getJsonOrObjet(users, newsForm);
			List list = this.newsManager.findByName("newsType", news
					.getNewsType(), false);
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
