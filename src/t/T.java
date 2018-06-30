package t;

import org.apache.commons.codec.bo.INewsCommentManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class T {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"WebRoot/WEB-INF/applicationContext.xml");

		INewsCommentManager manage = (INewsCommentManager) context
				.getBean("newsCommentManager");
	}
}