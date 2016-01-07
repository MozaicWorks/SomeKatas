package todolist



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ListController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond List.list(params), model:[listInstanceCount: List.count()]
    }

    def show(List listInstance) {
        respond listInstance
    }

    def create() {
        respond new List(params)
    }

    @Transactional
    def save(List listInstance) {
        if (listInstance == null) {
            notFound()
            return
        }

        if (listInstance.hasErrors()) {
            respond listInstance.errors, view:'create'
            return
        }

        listInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'list.label', default: 'List'), listInstance.id])
                redirect listInstance
            }
            '*' { respond listInstance, [status: CREATED] }
        }
    }

    def edit(List listInstance) {
        respond listInstance
    }

    @Transactional
    def update(List listInstance) {
        if (listInstance == null) {
            notFound()
            return
        }

        if (listInstance.hasErrors()) {
            respond listInstance.errors, view:'edit'
            return
        }

        listInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'List.label', default: 'List'), listInstance.id])
                redirect listInstance
            }
            '*'{ respond listInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(List listInstance) {

        if (listInstance == null) {
            notFound()
            return
        }

        listInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'List.label', default: 'List'), listInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'list.label', default: 'List'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
