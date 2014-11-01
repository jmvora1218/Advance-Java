
package image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Image extends JFrame {
    
    public static void main(String[] args) {
    Connection con;
    PreparedStatement pstmt;
    File f;
    Statement stmt=null;
    ResultSet rs;
    BufferedImage bim;
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Created...");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Micro2012");
                System.out.println("Conected...");
        pstmt=con.prepareStatement("insert into image value(?,?)");
        pstmt.setInt(1,10);
        
        f=new File("C:/Users/Public/Pictures/Sample Pictures/Tulips.jpg");
        FileInputStream fis=new FileInputStream(f);
        pstmt.setBinaryStream(2,(InputStream)fis,(int)f.length());
        int i1=pstmt.executeUpdate();
        System.out.println(i1);
         stmt =con.createStatement();
        rs=stmt.executeQuery("select * from image");
        while(rs.next())
                {
                    int i=rs.getInt(1);
                    Blob obj=rs.getBlob(2);
                    byte[] b=obj.getBytes(1,(int) obj.length());
                    InputStream is=new ByteArrayInputStream(b);
                    bim=ImageIO.read(is);
                    
                    JFrame jf=new JFrame();
                    JButton jbtn=new JButton(new ImageIcon(bim));
                    jf.add(jbtn);
                    jf.setVisible(true);
                    
                    
                }
    }catch(Exception e)
    {
        System.out.println("Exception :"+e.getMessage());
    }
    }
}
