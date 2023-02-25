package lk.ijse.spring.config;

import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.ItemRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement  // this is an aspect - manage all transactions automatically using TransactionManager
@EnableJpaRepositories(basePackageClasses = {CustomerRepo.class})  // link dao classes
/*@EnableJpaRepositories(basePackages = "lk.ijse.spring")*/  /*repo classes one by one import krnna wena nisa package ek dunna methnata*/
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

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring_jpa?createDatabaseIfNotExist=true");  /*in here database name is "springjpa"*/
        ds.setUsername("root");
        ds.setPassword("1234");

        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        va.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
        va.setDatabase(Database.MYSQL);
        va.setGenerateDdl(true);
        va.setShowSql(true);
        return va;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
