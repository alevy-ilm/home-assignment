package com.assignment.aggregation;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.integration.CompletionListener;
import javax.cache.processor.EntryProcessor;
import javax.cache.processor.EntryProcessorException;
import javax.cache.processor.EntryProcessorResult;
import javax.sql.DataSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Configuration
@EntityScan(basePackages = "com.assignment.aggregation")
public class JpaConfig {
    // JPA configuration code here
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean Cache<String, Object> cache () {
        return new Cache<String, Object>() {
            @Override
            public Object get(String s) {
                return null;
            }

            @Override
            public Map<String, Object> getAll(Set<? extends String> set) {
                return null;
            }

            @Override
            public boolean containsKey(String s) {
                return false;
            }

            @Override
            public void loadAll(Set<? extends String> set, boolean b, CompletionListener completionListener) {

            }

            @Override
            public void put(String s, Object o) {

            }

            @Override
            public Object getAndPut(String s, Object o) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ?> map) {

            }

            @Override
            public boolean putIfAbsent(String s, Object o) {
                return false;
            }

            @Override
            public boolean remove(String s) {
                return false;
            }

            @Override
            public boolean remove(String s, Object o) {
                return false;
            }

            @Override
            public Object getAndRemove(String s) {
                return null;
            }

            @Override
            public boolean replace(String s, Object o, Object v1) {
                return false;
            }

            @Override
            public boolean replace(String s, Object o) {
                return false;
            }

            @Override
            public Object getAndReplace(String s, Object o) {
                return null;
            }

            @Override
            public void removeAll(Set<? extends String> set) {

            }

            @Override
            public void removeAll() {

            }

            @Override
            public void clear() {

            }

            @Override
            public <C extends javax.cache.configuration.Configuration<String, Object>> C getConfiguration(Class<C> aClass) {
                return null;
            }

            @Override
            public <T> T invoke(String s, EntryProcessor<String, Object, T> entryProcessor, Object... objects) throws EntryProcessorException {
                return null;
            }

            @Override
            public <T> Map<String, EntryProcessorResult<T>> invokeAll(Set<? extends String> set, EntryProcessor<String, Object, T> entryProcessor, Object... objects) {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public CacheManager getCacheManager() {
                return null;
            }

            @Override
            public void close() {

            }

            @Override
            public boolean isClosed() {
                return false;
            }

            @Override
            public <T> T unwrap(Class<T> aClass) {
                return null;
            }

            @Override
            public void registerCacheEntryListener(CacheEntryListenerConfiguration<String, Object> cacheEntryListenerConfiguration) {

            }

            @Override
            public void deregisterCacheEntryListener(CacheEntryListenerConfiguration<String, Object> cacheEntryListenerConfiguration) {

            }

            @Override
            public Iterator<Entry<String, Object>> iterator() {
                return null;
            }
        };
    }

/*    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("com.assignment.aggregation.entity");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        emf.setJpaProperties(properties);

        return emf;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:C:/Users/asafl/test;DB_CLOSE_ON_EXIT=FALSE;AUTO_RECONNECT=TRUE");
        dataSource.setUsername("sa");
        dataSource.setPassword("pwd");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }*/
}

