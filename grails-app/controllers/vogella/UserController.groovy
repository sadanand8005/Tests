package vogella

class UserController {

    //def scaffold = true
    /*
    This will give you a default view to do CRUD operation on the relevent domain classes.
    The above method is for dynamic generation of the view.
    If you want to have a static view and then play around with it.
    Use this, > grails generate-views vogella.guestbook.User
     */
    def index = {
        render(view: "index")
    }
    
    def create = {
        render(view: "create")
    }
    
    def edit = {
        render(view: "edit")     
    }
    
    def show = {
        render(view: "show")
    }    
}
