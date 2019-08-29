package com.willowtree.exam.todos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.ZonedDateTime;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "todo", path = "todos")
public interface TodoItemRepository extends PagingAndSortingRepository<TodoItem, Long> {
    List<TodoItem> findByCompleted(@Param("completedOn") ZonedDateTime completedOn);
}
