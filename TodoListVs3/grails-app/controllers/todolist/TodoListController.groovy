package todolist

class TodoListController {

    def index() {
	    def task = Task.findByName("task3")
	    def todoList = TodoList.findByName("todolist1")
	    def tasks = Task.findAllByTodoList(todoList)

	    //get users with tasks done and deadline not expired
	    def finishedBeforeScheduleTasks = Task.findAllByDeadlineLessThanAndDone(new Date(), true)
	    def users = finishedBeforeScheduleTasks.user.unique()

		//get todolist with tasks done and userName = "user2"
	    def user2 = User.findByName("user2")
	    def finishedTasksWithUser1 = Task.findAllByDoneAndUser(true, user2)
	    def todolistsWithFinishedTasksAndUser2 = finishedTasksWithUser1.todoList



	    return [name: task.name, done: task.done, deadline: task.deadline, user: task.user.name,\
	            tasks:tasks,finishedBeforeScheduleTasks: finishedBeforeScheduleTasks.name, users:users.name,\
	            todolistsWithFinishedTasksAndUser2: todolistsWithFinishedTasksAndUser2.name]
    }
}
