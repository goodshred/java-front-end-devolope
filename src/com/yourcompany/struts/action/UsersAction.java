package com.yourcompany.struts.action;

import com.yourcompany.struts.form.UsersForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.commons.beanUtil.BeanUtil;
import org.apache.commons.codec.bo.IUserManager;
import org.apache.commons.codec.po.Users;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class UsersAction extends DispatchAction {
	private IUserManager userManager;

	public IUserManager getUserManager() {
		return this.userManager;
	}

	public void setUserManager(IUserManager userManager) {
		this.userManager = userManager;
	}

	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);

		UsersForm usersForm = (UsersForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Users user = this.userManager.getJsonOrObjet(users, usersForm);
			String flag = this.userManager.login(user);
			out.write(flag);
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward userSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		UsersForm usersForm = (UsersForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Users user = this.userManager.getJsonOrObjet(users, usersForm);
			String flag = this.userManager.save(user);
			out.write(flag);
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward userUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		UsersForm usersForm = (UsersForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Users user = this.userManager.getJsonOrObjet(users, usersForm);
			String flag = this.userManager.update(user);
			out.write(flag);
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

	public ActionForward userDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		setCharSet(request, response);
		UsersForm usersForm = (UsersForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Users user = this.userManager.getJsonOrObjet(users, usersForm);
			String flag = "failure";
			if (user.getUsersId() != null) {
				flag = this.userManager.delete(user.getUsersId());
			}
			out.write(flag);
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward userList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		List list = this.userManager.findByAll();
		PrintWriter writer = response.getWriter();
		JSONArray jsonArray = JSONArray.fromObject(list);
		writer.write(jsonArray.toString());
		writer.close();
		return null;
	}

	public ActionForward getUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		UsersForm usersForm = (UsersForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Users user = this.userManager.getJsonOrObjet(users, usersForm);
			Users user1 = (Users) this.userManager.findOne(user.getUsersId());
			out.write(BeanUtil.writer(user1));
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward findUserByLike(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		UsersForm usersForm = (UsersForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Users user = this.userManager.getJsonOrObjet(users, usersForm);
			List list = this.userManager.findByName("username", user
					.getUsername(), true);
			JSONArray jsonArray = JSONArray.fromObject(list);
			out.write(jsonArray.toString());
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}

	public ActionForward findUserByEq(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setCharSet(request, response);
		UsersForm usersForm = (UsersForm) form;
		PrintWriter out = response.getWriter();
		String users = request.getParameter("user");
		try {
			Users user = this.userManager.getJsonOrObjet(users, usersForm);
			List list = this.userManager.findByName("username", user
					.getUsername(), false);
			JSONArray jsonArray = JSONArray.fromObject(list);
			out.write(jsonArray.toString());
		} catch (Exception e) {
			out.write("传入参数不正确！请检查参数名称或url格式!");
		}
		out.close();
		return null;
	}
}