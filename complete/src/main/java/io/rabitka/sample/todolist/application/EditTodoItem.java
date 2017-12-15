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
import io.rabitka.sample.todolist.domain.TodoItemRepository;

import static io.rabitka.sample.todolist.domain.TodoItemPredicates.completedIsEqualsTo;
import static io.rabitka.sample.todolist.domain.TodoItemPredicates.idIsEqualsTo;

/**
 * @author Wassim ABID wassim.abid@rabitka.io
 */
@ApplicationService
public class EditTodoItem {

    private TodoItemRepository todoItemRepository;

    public EditTodoItem(
            io.rabitka.sample.todolist.domain.TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public void markAsCompleted(TodoItem.Id id){
         this.todoItemRepository.findBy(idIsEqualsTo(id)).updateEach(
                 TodoItem::markAsCompleted
         );
    }

    public void markAsNotCompleted(TodoItem.Id id){
        this.todoItemRepository.findBy(idIsEqualsTo(id))
            .updateEach(
                TodoItem::markAsNotCompleted
        );
    }

    public void changeTitle(TodoItem.Id id, String title){
        this.todoItemRepository.findBy(idIsEqualsTo(id))
            .updateEach(
                todoItem -> todoItem.updateTitle(title)
        );
    }

}
