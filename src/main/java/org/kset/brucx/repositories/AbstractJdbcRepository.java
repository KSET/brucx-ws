package org.kset.brucx.repositories;

import org.kset.brucx.util.QueryLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Created by marin on 17.12.2016..
 */
public abstract class AbstractJdbcRepository {


    @Autowired
    protected QueryLoader queryLoader;

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

}
