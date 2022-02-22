package TesT.test.booktest;

public class BookService {
    BookDao bookDao;
    public void save(){
        System.out.println("调用Dao层");
        bookDao.save();
    }
}
