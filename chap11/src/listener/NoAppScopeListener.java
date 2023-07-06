package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class NoAppScopeListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	System.out.println("警告：APPスコープの利用禁止だよ！");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
 
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 

    }
	
}
