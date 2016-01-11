package todolist

class TodoListController {

    def index() {
	    def items = Task.list()
        return [items: items, nr: items.size()]
    }
}
