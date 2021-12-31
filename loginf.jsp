<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%
try{
String cususern= request.getParameter("uname");
String cuspass= request.getParameter("psw");
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo","root","9840");
PreparedStatement ps=conn.prepareStatement("select cusername,cpassword from shopdetail where cusername=? and cpassword=?");
ps.setString(1,cususern);
ps.setString(2,cuspass);
ResultSet rs=ps.executeQuery();

try{
    if(rs.next()){
response.sendRedirect("home.html");
    }
else{
    response.sendRedirect("register.html");
}
}

catch(Exception e)
{
    out.println(e);
}

ps.close();
conn.close();
}
catch(Exception e)
{
    out.println(e);
}
%>	