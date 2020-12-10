import com.controller.BookController;
import com.dto.BookWithAuthorName;
import com.dto.DataResponse;
import com.entity.Book;
import com.mysql.jdbc.Driver;
import com.service.BookService;
import com.service_impl.BookServiceImpl;
import com.view.ViewMain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        new ViewMain();
    }
}
