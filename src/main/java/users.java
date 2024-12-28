
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dunrik
 */
public class users {
    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    public void update_user(String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8)
    {
        
                  try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","mohamed");
                        String sql3="update user set email=? ,password=? ,name=? ,address=? ,phonenumber=? ,ssn=? ,credit_num=? where username=? "; 
                        pst=con.prepareStatement(sql3);
                        
                         pst.setString(1,t1);
                        pst.setString(2,t2);
                        pst.setString(3,t3);
                        pst.setString(4,t4);
                        pst.setString(5,t5);
                        pst.setString(6,t6);
                        pst.setString(7,t7);
                        pst.setString(8,t8);
                        pst.executeUpdate();
                    } 
                    catch (Exception e) 
                    {
                       JOptionPane.showMessageDialog(null, e);
                    }

    }
    
    
    public void insert_user(String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8,String t9)
    {
         try 
            {
              Class.forName("com.mysql.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","mohamed");
              String sql="insert into user(username,email,password,name,address,phonenumber,ssn,credit_num,type) values (?,?,?,?,?,?,?,?,?)";
              pst=con.prepareStatement(sql);
              pst.setString(1,t1);
                  pst.setString(2,t2);
                  pst.setString(3,t3);
                  pst.setString(4,t4);
                  pst.setString(5,t5);
                  pst.setString(6,t6);
                  pst.setString(7,t7);
                  pst.setString(8,t8);
                  pst.setString(9,t9);
                  pst.executeUpdate();
                    
                  } 
                  catch (Exception e) 
                  {
                    JOptionPane.showMessageDialog(null,e);
                  }
    
    }
    
    
    public void browse_product(DefaultTableModel tab)
    {
        try {
             Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","mohamed");
           String sql="select * from product";
           pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           while(rs.next())
           {
               String tbdata[]={String.valueOf(rs.getString("idproduct")),String.valueOf(rs.getString("name"))
               ,rs.getString("price"),rs.getString("category"),rs.getString("sellerid"),rs.getString("amount"),rs.getString("sale"),rs.getString("rate")};
              // DefaultTableModel tblModel=(DefaultTableModel)jTable1.getModel();
               tab.addRow(tbdata);
               
                       
               
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     public void Search( DefaultTableModel tab,String t1)
    {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","mohamed");
            String sql="select * from product where category=?";
            pst=con.prepareStatement(sql);
            pst.setString(1, t1);
            rs=pst.executeQuery();
            while(rs.next())
            {
                String tbdata[]={String.valueOf(rs.getString("idproduct")),String.valueOf(rs.getString("name"))
                    ,rs.getString("price"),rs.getString("category"),rs.getString("sellerid"),rs.getString("amount"),rs.getString("sale"),rs.getString("rate")};
               // DefaultTableModel tblModel=(DefaultTableModel)jTable1.getModel();

                tab.addRow(tbdata);

            }
           
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
