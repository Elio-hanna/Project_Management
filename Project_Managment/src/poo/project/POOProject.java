
package poo.project;

import Forms.Login;
import Helpers.ConnectionManager;
import Repositories.RepoUser;
import java.sql.Connection;

public class POOProject {


    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        System.out.println(cm.IsConnectionOpened());
        cm.Close();
        System.out.println(cm.IsConnectionOpened());
        
   /*     RepoUser repoUser = new RepoUser();
        System.out.println(repoUser.Get(3).toString());
        repoUser.Destroy();
        */
        Login Start = new Login();
        Start.setVisible(true);

    }
    
}
