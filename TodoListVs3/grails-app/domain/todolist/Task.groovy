package todolist

class Task {

    String name
    Date deadline
    boolean done
	User user

    static belongsTo = [todoList:TodoList]



    static constraints = {
	    user nullable: true
    }
}
