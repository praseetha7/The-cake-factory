import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class registerf extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException
{
response.setContentType("text/html");
PrintWriter out=response.getWriter();

String cususern= request.getParameter("uname");
String cuspass= request.getParameter("psw");
String cusname= request.getParameter("fname");
String cusph= request.getParameter("phn");

try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo","root","9840");
PreparedStatement ps=conn.prepareStatement("insert into shopdetail values(?,?,?,?)");
ps.setString(1,cususern);
ps.setString(2,cuspass);
ps.setString(3,cusname);
ps.setString(4,cusph);
ps.executeUpdate();
out.println("Record inserted successfully");
ps.close();
conn.close();
}catch(Exception e)
{
out.println(e);
}
}
}
