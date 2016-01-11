import todolist.Task
import todolist.TodoList
import todolist.User

class BootStrap {

    def init = { servletContext ->
	    Task task1 = new Task(name:"task1", done: false, deadline: new Date())
	    TodoList todoList1 = new TodoList(name: "todoList1")
	    todoList1.addToTasks(task1)
	    todoList1.save(failOnError: true)

	    User user1 = new User(name: "user")
	    user1.addToTasks(task1)
	    user1.save(failOnError: true)
	    task1.user = user1
	    task1.save(failOnError: true)



    }
    def destroy = {
    }
}
