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

package io.rabitka.sample.todolist.application;

import io.rabitka.core.ddd.ApplicationService;
import io.rabitka.sample.todolist.domain.TodoItem;
import io.rabitka.sample.todolist.domain.TodoItemFactory;
import io.rabitka.sample.todolist.domain.TodoItemRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Wassim ABID wassim.abid@rabitka.io
 */
@ApplicationService
public class AddTodoItem {

    private TodoItemRepository todoItemRepository;

    public AddTodoItem(
        io.rabitka.sample.todolist.domain.TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public TodoItem.Id one(String title, Integer priority) {
        TodoItem todoItem = TodoItemFactory.defaultBuilder()
            .setId(new TodoItem.Id())
            .setTitle(title)
            .setPriority(priority)
            .setCompleted(Boolean.FALSE)
            .setCreationDate(LocalDate.now())
            .build();
        this.todoItemRepository.put(
            todoItem
        );
        return todoItem.getId();
    }

    public void many(List<String> titles, Integer priority) {
        for (String title : titles) {
            this.one(title, priority);
        }
    }

}
