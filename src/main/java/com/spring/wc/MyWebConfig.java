package com.spring.wc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.wc")
@PropertySource(value = "classpath:application.properties")
public class MyWebConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private Environment env;

    @Value("${jdbc.driverClassName}")
    private String jdbcDriver;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String jdbcUser;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${view.prefix}")
    private String viewPrefix;

    @Value("${view.suffix}")
    private String viewSuffix;

    @Bean
    public InternalResourceViewResolver getViewResolver(){
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setViewClass(JstlView.class);
        vr.setPrefix(viewPrefix);
        vr.setSuffix(viewSuffix);
        return vr;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public DataSource getSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        return  dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate template = new JdbcTemplate(getSource());
        return  template;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource((getSource()));
        bean.setPackagesToScan("com.spring.wc.model");
        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.hbm2ddl.auto","update");
//      properties.put("javax.persistence.schema-generation.database.action","drop-and-create");
        bean.setHibernateProperties(properties);
        return  bean;
    }
}


