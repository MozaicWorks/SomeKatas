import todolist.Task
import todolist.TodoList
import todolist.User

class BootStrap {

    def init = { servletContext ->
		def user1 = new User(name: "user 1").save(failOnError: true)
		def user2 = new User(name: "user 2").save(failOnError: true)

        def todoList1 = new TodoList(name: "List 1")
        def todoList2 = new TodoList(name: "List 2")
        def task1 = new Task(name: "task1", deadline: new Date(), done: false, user: user1)
        def task2 = new Task(name: "task2", deadline: new Date().plus(3), done: false, user: user2)
        def task3 = new Task(name: "task3", deadline: new Date().minus(4), done: true, user: user2)



	    todoList1.addToTasks(task1)
        todoList1.addToTasks(task2)
	    todoList1.save(failOnError: true)


	    todoList2.addToTasks(task3)
	    todoList2.save(failOnError: true)

	    user1.addToTasks(task1)
	    user1.addToTasks(task2)
	    user2.addToTasks(task3)
	    user1.save(failOnError: true)
	    user2.save(failOnError: true)
    }
    def destroy = {
    }
}
