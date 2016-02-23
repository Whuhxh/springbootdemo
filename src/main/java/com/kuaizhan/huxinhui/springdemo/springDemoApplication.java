package com.kuaizhan.huxinhui.springdemo;

import com.kuaizhan.huxinhui.springdemo.models.CustomerEntity;
import com.kuaizhan.huxinhui.springdemo.models.Quote;
import com.kuaizhan.huxinhui.springdemo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xinhui on 16/1/30.
 */
@SpringBootApplication
@EnableScheduling
@Slf4j
public class springDemoApplication implements CommandLineRunner{

    public static void main(String[] args) {
        ApplicationContext ctx =SpringApplication.run(springDemoApplication.class, args);

//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }

//    @Autowired
//    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info("quote ==========>" + quote.toString());

//        log.info("Creating tables --------->");
//        jdbcTemplate.execute("DROP TABLE customer IF EXISTS");
//        jdbcTemplate.execute("CREATE TABLE customer(" +
//                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
//
//        // Split up the array of whole names into an array of first/last names
//        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
//                .map(name -> name.split(" "))
//                .collect(Collectors.toList());
//
//        // Use a Java 8 stream to print out each tuple of the list
//        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
//
//        // Uses JdbcTemplate's batchUpdate operation to bulk load data
//        jdbcTemplate.batchUpdate("INSERT INTO customer(first_name, last_name) VALUES (?,?)", splitUpNames);
//
//        log.info("Querying for customer records where first_name = 'Josh':");
//        jdbcTemplate.query(
//                "SELECT id, first_name, last_name FROM customer WHERE first_name = ?", new Object[] { "Josh" },
//                (rs, rowNum) -> new CustomerEntity(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
//        ).forEach(customer -> log.info(customer.toString()));
    }

//    @Bean
//    public CommandLineRunner kzDemo(CustomerRepository repository) {
//        return (args) -> {
//            // save a couple of customers
//            repository.save(new CustomerEntity("Jack", "Bauer"));
//            repository.save(new CustomerEntity("Chloe", "O'Brian"));
//            repository.save(new CustomerEntity("Kim", "Bauer"));
//            repository.save(new CustomerEntity("David", "Palmer"));
//            repository.save(new CustomerEntity("Michelle", "Dessler"));
//
//            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (CustomerEntity customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            CustomerEntity customer = repository.findOne(1L);
//            log.info("Customer found with findOne(1L):");
//            log.info("--------------------------------");
//            log.info(customer.toString());
//            log.info("");
//
//            // fetch customers by last name
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            for (CustomerEntity bauer : repository.findByLastName("Bauer")) {
//                log.info(bauer.toString());
//            }
//            log.info("");
//        };
//    }
}
