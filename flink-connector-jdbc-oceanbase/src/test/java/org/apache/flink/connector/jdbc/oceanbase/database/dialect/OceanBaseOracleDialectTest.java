/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.connector.jdbc.oceanbase.database.dialect;

import org.apache.flink.connector.jdbc.core.database.dialect.JdbcDialectTest;
import org.apache.flink.connector.jdbc.oceanbase.OceanBaseOracleTestBase;

import java.util.Arrays;
import java.util.List;

/** The OceanBase Oracle mode params for {@link JdbcDialectTest}. */
class OceanBaseOracleDialectTest extends JdbcDialectTest implements OceanBaseOracleTestBase {

    public OceanBaseOracleDialectTest() {
        ddlFormat =
                "CREATE TABLE T (f0 %s)"
                        + " WITH ("
                        + "  'connector'='jdbc',"
                        + "  'url'='%s',"
                        + "  'table-name'='myTable',"
                        + "  'compatible-mode'='oracle'"
                        + ")";
    }

    @Override
    protected List<TestItem> testData() {
        return Arrays.asList(
                createTestItem("CHAR"),
                createTestItem("VARCHAR"),
                createTestItem("BOOLEAN"),
                createTestItem("TINYINT"),
                createTestItem("SMALLINT"),
                createTestItem("INTEGER"),
                createTestItem("BIGINT"),
                createTestItem("FLOAT"),
                createTestItem("DOUBLE"),
                createTestItem("DECIMAL(10, 4)"),
                createTestItem("DECIMAL(38, 18)"),
                createTestItem("DATE"),
                createTestItem("TIME"),
                createTestItem("TIMESTAMP(3)"),
                createTestItem("TIMESTAMP WITHOUT TIME ZONE"),
                createTestItem("VARBINARY"),

                // Not valid data
                createTestItem("BINARY", "The OceanBase dialect doesn't support type: BINARY(1)."),
                createTestItem(
                        "VARBINARY(10)",
                        "The OceanBase dialect doesn't support type: VARBINARY(10)."));
    }
}