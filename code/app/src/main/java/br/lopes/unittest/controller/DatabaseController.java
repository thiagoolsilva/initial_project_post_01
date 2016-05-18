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
package br.lopes.unittest.controller;

import android.content.Context;
import android.support.annotation.NonNull;

import br.lopes.unittest.database.ContactDAO;
import br.lopes.unittest.model.Contact;

/**
 * The type Database controller.
 */
public class DatabaseController {

    private ContactDAO contactDAO;

    /**
     * Instantiates a new Database controller.
     *
     * @param context the context
     */
    public DatabaseController(@NonNull Context context) {
        contactDAO = new ContactDAO(context);
    }

    /**
     * Insert contact
     *
     * @param contact the contact
     * @return the boolean
     */
    public boolean insertContact(@NonNull Contact contact) {
        return contactDAO.insertContact(contact);
    }

    /**
     * Remove contact by rg
     *
     * @param rg the rg
     * @return the boolean
     */
    public boolean removeContactByRg(@NonNull String rg) {
        return contactDAO.removeContactByRg(rg);
    }

    /**
     * Update contact by rg
     *
     * @param newData the new data
     * @param rg      the rg
     * @return the boolean
     */
    public boolean updateContactByRg(@NonNull Contact newData, @NonNull String rg) {
        return contactDAO.updateContactByRg(newData, rg);
    }

    /**
     * Delete contact by rg
     *
     * @param rg the rg
     * @return the boolean
     */
    public boolean deleteContactByRg(@NonNull String rg) {
        return contactDAO.deleteContactByRg(rg);
    }

    /**
     * Gets contact by rg.
     *
     * @param rg the rg
     * @return the contact by rg
     */
    public Contact getContactByRg(@NonNull String rg) {
        return contactDAO.getContactByRg(rg);
    }
}
