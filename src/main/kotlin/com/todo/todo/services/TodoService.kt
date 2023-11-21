package com.todo.todo.services

import com.todo.todo.exceptions.DataNotFoundException
import com.todo.todo.modals.TodoModal
import com.todo.todo.repository.TodoRepository
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TodoService {

    @Autowired
    lateinit var todoRepo: TodoRepository

    fun createTodo(todoEntity: TodoModal) : TodoModal {
        return todoRepo.save(todoEntity)
    }

    fun updateTodo(todoEntity: TodoModal, todoId: Long) : TodoModal {
        if (todoEntity.id == todoId) {
            return try {
                val newTodo: TodoModal = todoRepo.getReferenceById(todoId)
                newTodo.title = todoEntity.title
                newTodo.description = todoEntity.description
                newTodo.progress = todoEntity.progress
                todoRepo.save(newTodo)
            } catch (e: Exception) {
                throw Exception("Unable to update data with id $todoId")
            }
        }
        throw DataNotFoundException("Used ID is not valid.")
    }


    fun getAllTodo(): List<TodoModal>? {
        return todoRepo.findAll()
    }

    fun deleteTodoById(todoId : Long) : ResponseEntity<Map<String, String>> {
        return try {
            todoRepo.deleteById(todoId)
            val dataMessage: MutableMap<String, String> = HashMap()
            dataMessage["data"] = "Properly Removed"
            ResponseEntity.ok(dataMessage)
        } catch (e: EmptyResultDataAccessException) {
            throw DataNotFoundException("Unable to delete item, id not found")
        } catch (e: Exception) {
            throw e
        }
    }
}