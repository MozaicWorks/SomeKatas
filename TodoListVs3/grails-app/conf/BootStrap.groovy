import todolist.Task
import todolist.TodoList
import todolist.User

class BootStrap {

	    def init = { servletContext ->
		    Task task1 = new Task(name:"task1", done: false, deadline: new Date())
		    Task task2 = new Task(name:"task2", done: false, deadline: new Date().minus(5))
		    Task task3 = new Task(name:"task3", done: true, deadline: new Date().minus(7))
		    Task task4 = new Task(name:"task4", done: true, deadline: new Date().plus(3))
		    Task task5 = new Task(name:"task5", done: false, deadline: new Date().plus(1))
		    Task task6 = new Task(name:"task6", done: true, deadline: new Date().plus(2))

		    TodoList todoList1 = new TodoList(name: "todoList1")
		    todoList1.addToTasks(task1)
		    todoList1.addToTasks(task2)
		    todoList1.addToTasks(task3)
		    todoList1.save(failOnError: true)

		    TodoList todoList2 = new TodoList(name: "todolist2")
		    todoList2.addToTasks(task4)
		    todoList2.save(failOnError: true)

		    TodoList todoList3 = new TodoList(name: "todolist3")
		    todoList3.addToTasks(task5)
		    todoList3.addToTasks(task6)
		    todoList3.save(failOnError: true)

		    User user1 = new User(name: "user1")
		    user1.addToTasks(task1)
		    user1.addToTasks(task2)
		    user1.save(failOnError: true)
		    task1.user = user1
		    task1.save(failOnError: true)
		    task2.user = user1
		    task2.save(failOnError: true)


		    User user2 = new User(name: "user2")
		    user2.addToTasks(task3)
		    user2.addToTasks(task5)
		    user2.save(failOnError: true)
		    task3.user = user2
		    task3.save(failOnError: true)
		    task5.user = user2
		    task5.save()

		    User user3 = new User(name: "user3")
		    user3.addToTasks(task4)
		    user3.save(failOnError: true)
		    task4.user = user3
		    task4.save(failOnError: true)

    }

	def destroy = {
    }
}
