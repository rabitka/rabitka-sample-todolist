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


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.rabitka.repository.provider.memory.InMemoryProvider;
import io.rabitka.validator.core.InvalidDomainObjectException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AddTodoItemStepsDef {
/*
    private TodoItemRepository todoItemRepository = new TodoItemRepository(new InMemoryProvider<>());
    private AddTodoItem addTodoItem = new AddTodoItem(todoItemRepository);
    private InvalidDomainObjectException invalidDomainObjectException;

    @Given("^an empty Todo list$")
    public void an_empty_Todo_list() throws Throwable {
        todoItemRepository.clear();
    }

    @When("^I add a Todo Item with title \"([^\"]*)\"$")
    public void i_add_a_Todo_Item_with_title(String title) throws Throwable {
        try {
            addTodoItem.title(title);
        }catch (InvalidDomainObjectException invalidDomainObjectException){
            this.invalidDomainObjectException = invalidDomainObjectException;
        }
    }

    @Then("^Todo list contains only Todo Item with title \"([^\"]*)\" not completed$")
    public void todo_list_contains_only_Todo_Item_with_title_not_completed(String title) throws Throwable {
        List<TodoItem> all = todoItemRepository.getAllInList();
        assertThat(all).asList().hasSize(1);
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).isCompleted()).isFalse();

    }

    @Then("^An error is thrown$")
    public void an_error_is_thrown() throws Throwable {
        assertThat(this.invalidDomainObjectException).isNotNull();
    }
*/
}
