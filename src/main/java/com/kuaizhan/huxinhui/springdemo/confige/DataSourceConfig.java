package com.kuaizhan.huxinhui.springdemo.confige;

import com.kuaizhan.huxinhui.springdemo.models.CustomerEntity;
import com.kuaizhan.huxinhui.springdemo.repository.CustomerRepository;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by xinhui on 16/2/19.
 */
@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "demoEntityManagerFactory",
    transactionManagerRef = "demoTransactionManager",
    basePackageClasses = {CustomerRepository.class}
)
public class DataSourceConfig {
    @Autowired
    Environment env;

    @Bean(name = "xinhui_schema")
    @Primary
    public DataSource demoDataSource() {
            return getDataSource("jdbc.xinhui_schema");
    }

    @Bean(name = "xinhuiJdbc")
    public JdbcTemplate demoJdbcTemplate() {
            return new JdbcTemplate(demoDataSource());
    }

    @Bean(name = "demoTransactionManager")
    public PlatformTransactionManager transactionManager() {
        EntityManagerFactory factory = entityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean(name = "demoEntityManager")
    public EntityManager entityManager() {
            return entityManagerFactory().getObject().createEntityManager();
    }

    @Bean(name = "demoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);

        factory.setDataSource(demoDataSource());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.kuaizhan.huxinhui.springdemo.models");
        factory.setPersistenceUnitName("springDemo");

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        jpaProperties.put("hibernate.jdbc.batch_size", env.getProperty("hibernate.jdbc.batch_size"));
        jpaProperties.put("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
        factory.setJpaProperties(jpaProperties);

        System.out.println("JPAProperties is =======>" +jpaProperties);
        System.out.println("hibernate.hbm2ddl.auto is =======>" + env.getProperty("hibernate.hbm2ddl.auto"));

                factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factory;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }


    private DataSource getDataSource(String prefix) {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        PoolProperties p = getPoolProperties();
        p.setUrl(env.getProperty(prefix + ".url"));
        p.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        p.setUsername(env.getProperty(prefix + ".username"));
        p.setPassword(env.getProperty(prefix + ".password"));

        System.out.println("The p is =====>" + p);
        System.out.println("The url is =====>" + env.getProperty(prefix + ".url"));

        dataSource.setPoolProperties(p);
        return dataSource;
    }

    private PoolProperties getPoolProperties() {
        PoolProperties p = new PoolProperties();
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(300000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setRemoveAbandonedTimeout(200);
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer;"
                        + "org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer");
        return p;
    }
}
