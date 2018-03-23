package work.tools;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.h2.tools.Server;

public class H2DBServerStartListener implements ServletContextListener {
    
    private Server server;

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        try {
            server = Server.createTcpServer().start();
            System.out.println("H2DB Start Successed!");
        } catch (SQLException e) {
            System.out.println("Warining! H2DB Start Error!");
            e.printStackTrace();
        }
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        if(this.server != null) {
            this.server.stop();
            this.server = null;
        }
    }
}
