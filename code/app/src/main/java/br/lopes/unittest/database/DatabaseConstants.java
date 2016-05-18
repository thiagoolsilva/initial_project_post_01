/*
 *   Licensed to the Apache Software Foundation (ASF) under one
 *   or more contributor license agreements.  See the NOTICE file
 *   distributed with this work for additional information
 *   regarding copyright ownership.  The ASF licenses this file
 *   to you under the Apache License, Version 2.0 (the
 *   "License"); you may not use this file except in compliance
 *   with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 */
package br.lopes.unittest.database;

/**
 * The type Database constants.
 */
public class DatabaseConstants {

    /**
     * The Sql create.
     */
    public static String [] SQL_CREATE = {
        Contact.SQL_TABLE
    };


    /**
     * The type Contact.
     */
    public static class Contact {

        /**
         * The constant SQL_TABLE.
         */
        protected static final String SQL_TABLE = "CREATE TABLE contact (_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , " +
                "name TEXT, " +
                "age INTEGER, " +
                "email TEXT, " +
                "rg TEXT)";

        /**
         * The constant TABLE_NAME.
         */
        public static final String TABLE_NAME = "contact";

        /**
         * The constant FIELD_NAME.
         */
        public static final String FIELD_NAME = "name";

        /**
         * The constant FIELD_AGE.
         */
        public static final String FIELD_AGE = "age";

        /**
         * The constant FIELD_EMAIL.
         */
        public static final String FIELD_EMAIL = "email";

        /**
         * The constant FIELD_RG.
         */
        public static final String FIELD_RG = "rg";
    }
}
