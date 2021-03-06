package se.lexicon.GroupProject.hoteljpamvcthymleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.data.MyDataSource;

import java.sql.SQLException;

@SpringBootApplication
public class HotelJpaMvcThymeleafApplication {

	public static void main(String[] args) throws SQLException {
		MyDataSource.getConnection();

		SpringApplication.run(HotelJpaMvcThymeleafApplication.class, args);
	}

}
