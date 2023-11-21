package com.todo.todo.repository

import com.todo.todo.modals.TodoModal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository: JpaRepository<TodoModal, Long> {
}