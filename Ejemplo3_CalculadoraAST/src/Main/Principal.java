package Main;

/**
 *
 * @author joaquin
 */
public class Principal
{

    public static void main(String[] args)
    {
        // TODO code application logic here
        //Este for esta de mas pero sirve para darle un tema de windows al form
        //desde el main:
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    //UIManager.setLookAndFeel(info.getClassName());
                    break;
                }                
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                
        Home v = new Home();
        v.setVisible(true);
    }
    
}
