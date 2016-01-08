package todolist

class TodoList {

    String name
    static hasMany = [tasks: Task]

    static constraints = {
    }

}
