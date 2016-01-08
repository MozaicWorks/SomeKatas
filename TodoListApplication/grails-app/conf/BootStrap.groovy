import todolist.Task
import todolist.TodoList

class BootStrap {

    def init = { servletContext ->
        def todoList = new TodoList(name: "List 1")
        def task1 = new Task(name: "task1", assigneeName: "Dan", deadline: new Date(), done: false)
        todoList.addToTasks(task1)
        todoList.save(failOnError: true)
    }
    def destroy = {
    }
}
