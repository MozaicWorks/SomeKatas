package todolist

class User {

	String name

	static hasMany = [tasks:Task]

	static constraints = {

	}
}
