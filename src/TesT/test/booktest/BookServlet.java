package TesT.test.booktest;

public class BookServlet {
    BookService bookService;
    public void doGet(){
        System.out.println("调用了Service层");
        bookService.save();
    }

    public static void main(String[] args) {
        BookServlet bookServlet=new BookServlet();
        bookServlet.doGet();
    }
}
