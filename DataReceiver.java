import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "MyServlet")
public class DataReceiver extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String input = "";
        String temp;
        while(true) {
            temp = reader.readLine();
            if(temp == null){
                break;
            }
            input += temp;
        }

        JsonParser parser = new JsonParser();
        JsonObject json = (JsonObject) parser.parse(input);
        JsonArray array = json.getAsJsonArray("result");

        String username="";
        int time = 0;
        String[] words = new String[0];

        for(int i=0; i<array.size(); i++){
            JsonObject tempObj = array.get(i).getAsJsonObject();
            if(tempObj.has("message")) {
                if (tempObj.getAsJsonObject("message").has("text")) {
                    String message = tempObj.getAsJsonObject("message").get("text").getAsString();

                    words = message.split("\\s+");
                    for (int j = 0; j < words.length; j++) {
                        words[j] = words[j].replaceAll("[^\\wĈĉĜĝĤĥĴĵŜŝŬŭ]", "").toLowerCase();
                    }
                }
                if(tempObj.getAsJsonObject("message").has("from")){
                    JsonObject user = tempObj.getAsJsonObject("message").getAsJsonObject("from");
                    if(user.has("usernamer")){
                        username = user.get("username").getAsString();
                    }
                }
                time = tempObj.getAsJsonObject("message").get("date").getAsInt();
            }
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test", "root", "warcraft");
                Statement stmt = connection.createStatement();

                ResultSet set = stmt.executeQuery("SELECT id FROM WordStat ORDER BY id DESC LIMIT 1;");
                set.first();
                int id = set.getInt(1) + 1;
                if(time != 0) {
                    for (int k = 0; k < words.length; k++) {
                        if(words[k].length() > 1) {
                            stmt.executeUpdate("INSERT INTO WordStat VALUES(" + id + ", \"" + words[k] + "\", \"" + username + "\"," + time + ")");
                        }
                        id++;
                    }
                }
                stmt.close();
                connection.close();
                }catch (Exception e){e.printStackTrace();}
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {

            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>DataReceiver.java:doGet(): Servlet code!</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1>This is a simple java servlet.</h1>");

            writer.println("</body>");
            writer.println("</html>");
        }*/
    }
}

