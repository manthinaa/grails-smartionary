/*
 * Copyright 2013 Aaron Brown
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package me.sudofu.smartionary.domain

import me.sudofu.smartionary.domain.SmartionaryEntry

/**
 * Emulates a {@link java.util.Map Map}.
 *
 * @author  Aaron Brown
 */
class Smartionary {
    /**
     * The name of the Smartionary, which is a mnemonic for what the
     * collection represents.
     */
    String name

    /**
     * A description for the <code>Smartionary</code> object, and what
     * data it might pertain to.
     */
    String description

    /**
     * Specify the <code>Entry</code> Objects as a
     * <code>SortedSet</code>
     */
    SortedSet entries

    static hasMany = [ entries: SmartionaryEntry ]

    static constraints = {
        name        (blank: false, unique: true)
        description (nullable: true, size: 1..8000)
    }

    static mapping = {
        description type: "text"
    }

    String toString() {
        return name
    }

    Map toMap() {
        Map m = [:]

        entries.each {
            m[it.key] = it.value
        }

        return m
    }
}
