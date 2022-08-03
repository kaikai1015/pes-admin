package sinexcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author pes
 */

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class pesApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(pesApplication.class, args);
        System.out.println("=============== 计划执行系统启动成功 ===============");
    }
}
