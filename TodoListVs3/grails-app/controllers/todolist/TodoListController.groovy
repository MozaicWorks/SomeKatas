package todolist

class TodoListController {

    def index() {
	    def task = Task.findByName("task1")
	    def user = User.get(1)
	    return [name: task.name, done: task.done, deadline: task.deadline,user: user.name]
    }
}
