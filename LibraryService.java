import java.util.ArrayList;
import java.util.List;
public class LibraryService {
    private final List<Book> catalog = new ArrayList<>();
    public void addBook(Book book) {
        catalog.add(book);
    }
    public List<Book> getCatalog() {
        return catalog;
    }
    public Book findById(String id) {
        for (Book b : catalog) {
            if (b.getId().equalsIgnoreCase(id)) {
                return b;
            }
        }
        return null;
    }
    public boolean checkOut(String id) {
        Book book = findById(id);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }
    public boolean checkIn(String id) {
        Book book = findById(id);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }
}