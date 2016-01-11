package todolist

class TodoListController {

    def index() {
	    def task = Task.findByName("task1")
	    def todoList = TodoList.findByName("todolist1")
	    def tasks = Task.findAllByTodoList(todoList)


	    return [name: task.name, done: task.done, deadline: task.deadline,user: task.user.name,\
	            tasks:tasks]
    }
}
