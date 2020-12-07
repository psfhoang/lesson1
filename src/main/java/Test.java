import com.controller.BookController;
import com.dto.BookWithAuthorName;
import com.dto.DataResponse;
import com.entity.Book;
import com.mysql.jdbc.Driver;
import com.service.BookService;
import com.service_impl.BookServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        BookController bookController = new BookController();
        while (true){
            System.out.println("1.Show All Book");
            System.out.println("2.Show All Book with Book author name");
            System.out.println("3.Insert book");
            System.out.println("4.Update book");
            System.out.println("5.Delete book");
            int luaChon = scanner.nextInt();
            switch (luaChon){
                case 1 :
                    DataResponse<List<Book>> allBooks = bookController.getAllBooks();
                    System.out.println(allBooks);
                    break;
                case 2:
                    DataResponse<List<BookWithAuthorName>> response =bookController.bookWithAuthorNameDataResponse();
                    System.out.println(response);
                    break;
                case 3:
                    Book book = new Book();
                    System.out.println("nhap ten sách");
                    String name = scanner.next();
                    book.setName(name);
                    scanner.nextLine();
                    System.out.println("nhap id author");
                    int id = scanner.nextInt();
                    book.setAuthor_Id(id);
                    try {
                        System.out.println(bookController.insertBook(book));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 4 :
                    System.out.println("nhap id sách");
                    int id1 = scanner.nextInt();
                    System.out.println("nhap ten sách mới");
                    String name1= scanner.next();
                    scanner.nextLine();
                    System.out.println("nhap id author mới");
                    int id2=scanner.nextInt();
                    Book book1 = new Book(id1,name1,id2);
                    try {
                        System.out.println(bookController.updateBook(book1));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("nhạp vào id muốn xóa");
                    int id3 =scanner.nextInt();
                    try {
                        System.out.println(bookController.deleteBook(id3));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }

    }
}
