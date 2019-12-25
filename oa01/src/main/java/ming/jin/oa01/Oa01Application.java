package ming.jin.oa01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ming.jin.oa01.mapper")
public class Oa01Application {

    public static void main(String[] args) {
        SpringApplication.run(Oa01Application.class, args);
    }

}
