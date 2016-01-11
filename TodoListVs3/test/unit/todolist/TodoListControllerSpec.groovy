package todolist

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TodoListController)
@Mock([Task, TodoList, User])
class TodoListControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test method find by name"() {
	    given:
	    Task task1 = new Task(name:"task1", done: false, deadline: new Date())
	    Task task2 = new Task(name:"task2", done: false, deadline: new Date().minus(5))
	    TodoList todoList1 = new TodoList(name: "todoList1")
	    todoList1.addToTasks(task1)
	    todoList1.addToTasks(task2)
	    todoList1.save(failOnError: true)

	    when:
	    Task result = Task.findByName("task1")

	    then:
	    assert task1, result
    }
}
