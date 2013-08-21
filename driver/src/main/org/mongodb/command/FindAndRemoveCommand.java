/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mongodb.command;

import org.mongodb.Document;
import org.mongodb.operation.FindAndModify;

import static org.mongodb.command.CommandDocumentTemplates.getFindAndModify;

public final class FindAndRemoveCommand extends Command {

    public FindAndRemoveCommand(final FindAndModify findAndModify, final String collectionName) {
        super(asDocument(findAndModify, collectionName));
    }

    private static Document asDocument(final FindAndModify findAndModify,
                                       final String collectionName) {
        final Document cmd = getFindAndModify(findAndModify, collectionName);
        cmd.put("remove", true);
        return cmd;
    }
}