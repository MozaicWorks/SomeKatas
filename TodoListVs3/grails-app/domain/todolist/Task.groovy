package todolist

class Task {

    String name
    Date deadline
    boolean done
	User user

    static belongsTo = [todoList:TodoList]



    static constraints = {
        todoList unique: true
	    user nullable: true
    }
}
