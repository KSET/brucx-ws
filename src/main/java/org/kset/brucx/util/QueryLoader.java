package org.kset.brucx.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by marin on 14.12.2016..
 */
@Component
public class QueryLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryLoader.class);

    private Properties queries;

    @PostConstruct
    private void init() throws IOException {
        Resource resource = new ClassPathResource("/queries.properties");
        this.queries = PropertiesLoaderUtils.loadProperties(resource);
    }

    public String getQuery(String name) {
        if(!this.queries.containsKey(name)) {
            LOGGER.error("Failed to find query with name {}", name);
        }
        return this.queries.getProperty(name);
    }

    public String getQuery(Query query) {
        return getQuery(query.name());
    }

}
