package com.example.core.config;


import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
@ComponentScan("com.example.dao")
@Configuration
public class SpringOrmConfig {


    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
        var sessionFactoryBean = new LocalSessionFactoryBean();

        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("com.example.domain");

        Properties properties = new Properties();
//        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        properties.put("hibernate.show_sql", "true");

        sessionFactoryBean.setHibernateProperties(properties);

        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        var transactionManager = new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactory);

        return transactionManager;
    }


//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        var entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//
//        entityManagerFactory.setDataSource(dataSource);
//        entityManagerFactory.setPackagesToScan("com.example.domain");
//
//        Properties properties = new Properties();
////        properties.put("hibernate.hbm2ddl.auto", "create");
//        properties.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
//        properties.put("hibernate.show_sql", "true");
//
//        entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
//
//        return entityManagerFactory;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        var transactionManager = new JpaTransactionManager();
//
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//
//        return transactionManager;
//    }
}
