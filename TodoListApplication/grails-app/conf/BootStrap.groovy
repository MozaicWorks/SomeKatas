import todolist.Task
import todolist.TodoList

class BootStrap {

    def init = { servletContext ->
        def todoList1 = new TodoList(name: "List 1")
        def todoList2 = new TodoList(name: "List 2")
        def task1 = new Task(name: "task1", deadline: new Date(), done: false)
        def task2 = new Task(name: "task2", deadline: new Date().plus(3), done: false)
        def task3 = new Task(name: "task3", deadline: new Date().minus(4), done: true)



	    todoList1.addToTasks(task1)
        todoList1.addToTasks(task2)
	    todoList1.save(failOnError: true)


	    todoList2.addToTasks(task3)
	    todoList2.save(failOnError: true)

    }
    def destroy = {
    }
}
