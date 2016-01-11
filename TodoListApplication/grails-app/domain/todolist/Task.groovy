package todolist

class Task {

    String name
	Date deadline
	boolean done

	static belongsTo = [todoList:TodoList]



    static constraints = {
	    todoList unique: true
    }
}
