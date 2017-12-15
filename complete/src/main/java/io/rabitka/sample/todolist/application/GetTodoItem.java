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

import java.time.LocalDate;
import java.util.List;

import static io.rabitka.sample.todolist.domain.TodoItemPredicates.*;

/**
 * @author Wassim ABID wassim.abid@rabitka.io
 */
@ApplicationService
public class GetTodoItem {

    private TodoItemRepository todoItemRepository;

    public GetTodoItem(
            io.rabitka.sample.todolist.domain.TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public List<TodoItem> all(){
        return this.todoItemRepository.getAllInList();
    }

    public List<TodoItem> completed(){
        return this.todoItemRepository.findBy(
                    completedIsEqualsTo(Boolean.TRUE))
                .getInList();
    }

    public List<TodoItem> notCompleted(){
        return
            this.todoItemRepository
                .findBy(
                    completedIsEqualsTo(Boolean.FALSE)
                ).getInList();
    }

    public List<TodoItem> byTitle(String title){
        return
            this.todoItemRepository.findBy(
                titleIsEqualsTo(title)
            ).getInList();
    }

    public List<TodoItem> byPriority(Integer priority){
        return
            this.todoItemRepository.findBy(
                priorityIsEqualsTo(priority)
            ).getInList();
    }

    public List<TodoItem> createdToday(){
        return
            this.todoItemRepository
                .findBy(
                creationDateIsEqualsTo(LocalDate.now())
                ).getInList();
    }

}
