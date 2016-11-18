import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by blackwidow on 18/11/16.
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileManagment file = new FileManagment();
        file.setPath("/tmp");
        file.setName("xisco");
        if(!file.isExist()) {
            file.createDirectory();
        }
        List<File> files =  file.directoryTree();
        req.setAttribute("files",files);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/files.jsp");
        rd.forward(req,resp);
    }
}
