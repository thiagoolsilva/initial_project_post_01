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

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import br.lopes.unittest.model.Contact;

/**
 * The type Contact dao.
 */
public class ContactDAO {

    private SQLiteDatabase database;

    /**
     * Instantiates a new Contact dao.
     *
     * @param context the context
     */
    public ContactDAO(@NonNull Context context) {
        final DatabaseHelper databaseHelper = new DatabaseHelper(context);
        //Get a database with write permission
        database = databaseHelper.getWritableDatabase();
    }

    /**
     * Insert contact
     *
     * @param contact the contact
     * @return the boolean
     */
    public boolean insertContact(@NonNull Contact contact) {
        ContentValues values = new ContentValues();
        values.put(DatabaseConstants.Contact.FIELD_AGE, contact.getAge());
        values.put(DatabaseConstants.Contact.FIELD_EMAIL, contact.getEmail());
        values.put(DatabaseConstants.Contact.FIELD_NAME, contact.getName());
        values.put(DatabaseConstants.Contact.FIELD_RG, contact.getRg());

        //insert the object into the database
        long rowInserted = database.insert(DatabaseConstants.Contact.TABLE_NAME, null, values);
        final int invalidRow = -1;
        return rowInserted != invalidRow;
    }

    /**
     * Remove contact by rg
     *
     * @param rg the rg
     * @return the boolean
     */
    public boolean removeContactByRg(@NonNull String rg) {
        String where = DatabaseConstants.Contact.FIELD_RG+" = ? ";
        String [] whereArgs = {rg};

        int rowAffected = database.delete(DatabaseConstants.Contact.TABLE_NAME,where, whereArgs);
        return rowAffected > 0;
    }

    /**
     * Update contact by rg
     *
     * @param newData the new data
     * @param rg      the rg
     * @return the boolean
     */
    public boolean updateContactByRg(@NonNull Contact newData, @NonNull String rg) {
        //Build the row to be inserted
        ContentValues newValue = new ContentValues();
        newValue.put(DatabaseConstants.Contact.FIELD_EMAIL, newData.getEmail());
        newValue.put(DatabaseConstants.Contact.FIELD_NAME, newData.getName());
        newValue.put(DatabaseConstants.Contact.FIELD_AGE, newData.getAge());

        //Create the sql
        String where = DatabaseConstants.Contact.FIELD_RG+" = ?";
        String [] whereArgs = {rg};

        //execute the query
        int rowAffected = database.update(DatabaseConstants.Contact.TABLE_NAME, newValue, where, whereArgs);
        return rowAffected > 0;
    }

    /**
     * Delete contact by rg
     *
     * @param rg the rg
     * @return the boolean
     */
    public boolean deleteContactByRg(@NonNull String rg) {
        //Create the sql
        String where = DatabaseConstants.Contact.FIELD_RG+" = ?";
        String [] whereArgs = {rg};

        //execute the query
        int rowAffected = database.delete(DatabaseConstants.Contact.TABLE_NAME, where, whereArgs);
        return rowAffected > 0;
    }

    /**
     * Gets contact by rg.
     *
     * @param rg the rg
     * @return the contact by rg
     */
    public Contact getContactByRg(@NonNull String rg) {
        Contact result = null;

        //Build the query
        String where = DatabaseConstants.Contact.FIELD_RG+" = ?";
        String [] whereArgs = {rg};

        //Do the query
        Cursor query = database.query(DatabaseConstants.Contact.TABLE_NAME, null, where, whereArgs, null, null, null);

        //Build the object
        if(query.moveToNext()) {
            result = buildContactByCursor(query);
        }

        //Close the cursor
        if(!query.isClosed()){
            query.close();
        }

        return result;
    }

    private Contact buildContactByCursor(@NonNull Cursor cursor) {
        Contact contact = null;

        //Index of column of table contact
        int indexAge = cursor.getColumnIndex(DatabaseConstants.Contact.FIELD_AGE);
        int indexEmail = cursor.getColumnIndex(DatabaseConstants.Contact.FIELD_EMAIL);
        int indexRg = cursor.getColumnIndex(DatabaseConstants.Contact.FIELD_RG);
        int indexName = cursor.getColumnIndex(DatabaseConstants.Contact.FIELD_NAME);

        //Fetch all values
        String name = cursor.getString(indexName);
        int age = cursor.getInt(indexAge);
        String email = cursor.getString(indexEmail);
        String rg = cursor.getString(indexRg);

        //Build the object
        contact = new Contact(rg);
        contact.setAge(age);
        contact.setName(name);
        contact.setEmail(email);

        return contact;
    }
}
