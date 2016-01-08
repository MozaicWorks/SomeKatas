package todolist

class TodoListController {

    def index() {
	    def items = Task.list()
        def users = User.list()
        return [items: items, nr: items.size(), users: users, nrUsers: users.size()]
    }
}
