package lr.books.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


@RestController
@RequestMapping("/api")
class MyController {
	
	@RequestMapping("/hello")
	public String someMethod() {
		return "Hello cute Leena ...";
	}
	
	static int IDENTIFICATION = 0;
	
	static Map<Integer, Book> store = new HashMap<Integer, Book>();
	
	static {
		Book book = new Book();
		book.setId("1");
		book.setName("default");
		store.put(0, book);
		IDENTIFICATION++;
	}
	
	@RequestMapping("/books")
	public @ResponseBody Map<Integer, Book> jsonMethod() {
		return store;
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public @ResponseBody Book jsonPostMethod(@RequestBody Book book) {
		System.out.println(book.toString());
		store.put(IDENTIFICATION, book);
		IDENTIFICATION++;
		return book;
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Book jsonGetMethod(@PathVariable Integer id) {
		if(!store.containsKey(id)) {
			Book book = new Book();
			book.setId("-1");
			book.setName("not found");
			return book;
		}
		return store.get(id);
	}
	
}

class Book {
	
	private String id;
	private String name;
	
	public Book() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [ id = " +id+ ", name=" + name + "]";
	}
	
	

}