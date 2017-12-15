/*
 *
 * Copyright (c) 2017 Rabitka Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.rabitka.sample.todolist.infra;

import io.rabitka.core.ddd.IEntity;
import io.rabitka.repository.core.provider.Provider;
import io.rabitka.repository.core.provider.ProviderFactory;
import io.rabitka.repository.provider.sql.SqlProvider;
import io.rabitka.sample.todolist.RabitkaSpringApplication;
import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.RunScript;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Wassim ABID wassim.abid@rabitka.io
 */
@Component
@Profile("SqlProvider")
public class SqlProviderFactory implements ProviderFactory {

    private DataSource dataSource;

    @Override
    public <AR extends IEntity<ID>, ID extends Serializable> Provider<AR, ID> byAggregateRoot(Class<AR> aggregateRoot){
        return new SqlProvider<>(aggregateRoot, dataSource);
    }

    @PostConstruct
    public void dataSource() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword(null);
        dataSource.setUrl("jdbc:h2:mem:test;DATABASE_TO_UPPER=FALSE");
        dataSource.setMaxTotal(1);
        dataSource.setMinIdle(1);
        dataSource.setMaxIdle(1);
        dataSource.setMaxOpenPreparedStatements(1);

        final Connection connection = dataSource.getConnection();
        RunScript.execute(connection,
                new InputStreamReader(
                        RabitkaSpringApplication.class.getResourceAsStream("/db.sql")));
        connection.close();

        this.dataSource = dataSource;
    }
}
