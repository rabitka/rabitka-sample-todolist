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

package io.rabitka.sample.todolist.domain;

import io.rabitka.core.ddd.*;
import io.rabitka.core.metatype.IntegerMetatype;
import io.rabitka.core.metatype.StringMetatype;

import java.time.LocalDate;

@AggregateRoot
public class TodoItem implements IEntity<TodoItem.Id> {

    private Id id = new Id();
    @StringMetatype(blank = false, maxLenth = 100)
    private String title;
    private Boolean completed = Boolean.FALSE;
    @IntegerMetatype(minValue = 0, maxValue = 5)
    private Integer priority = 0;
    private LocalDate creationDate;

    @Factory
    public TodoItem(Id id, String title, Boolean completed, Integer priority, LocalDate creationDate) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.priority = priority;
        this.creationDate = creationDate;
        this.validate();
    }

    public void markAsCompleted() {
        this.completed = Boolean.TRUE;
    }

    public void markAsNotCompleted() {
        this.completed = Boolean.FALSE;
    }

    public void updateTitle(String title) {
        TodoItemValidator.validateTitle(title).throwIfInvalid();
        this.title = title;
    }

    @Override
    public TodoItem.Id getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Integer getPriority() {
        return priority;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public void validate() {
        TodoItemValidator.validate(this);
    }

    @Override
    public boolean equals(Object o) {
        return TodoItemBase.equals(this, o);
    }

    @Override
    public int hashCode() {
        return TodoItemBase.hashCode(this);
    }

    @IdentityAnnotation
    public static class Id extends UniqueValueIdentity {
        public Id(String value) {super(value);}
        public Id() {}
    }
}
