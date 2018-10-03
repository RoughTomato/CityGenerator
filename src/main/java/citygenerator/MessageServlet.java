package citygenerator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Message")
public class MessageServlet extends HttpServlet {

    static String HEADER = "<html><head><title>Message</title></head><body>";
    static String FOOTER = "</body></html>";

    @Inject
    MessageService messageService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(HEADER);
        writer.println("<h1>" + messageService.createMessage("Finally working!") + "</h1>");
        writer.println(FOOTER);
        writer.close();
    }

}
