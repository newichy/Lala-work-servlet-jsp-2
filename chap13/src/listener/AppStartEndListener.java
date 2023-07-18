package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppStartEndListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }

    public void contextInitialized(ServletContextEvent sce)  { 
//    	ServletContext context = sce.getServletContext();
    	
//    	context.setAttribute("Const",new Const());
    }
	
}
