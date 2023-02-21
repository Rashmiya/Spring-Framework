package lk.ijse.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
public class JPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter jpaVendor){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();

        /*add Entity class location*/
        bean.setPackagesToScan("lk.ijse.spring.entity");
        /*add DataSource*/
        bean.setDataSource(ds);
        /*add VendorAdapt*/
        bean.setJpaVendorAdapter(jpaVendor);
        return bean;
    }

    @Bean
    public DataSource dataSource(){
        // DriverManager dataSource only for testing
        // for production level , we use DBC pool / Inbuilt pool

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql//localhost:3306/springjpa?createDatabaseIfNotExist=true");  /*in here database name is "springjpa"*/
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){

    }
}
