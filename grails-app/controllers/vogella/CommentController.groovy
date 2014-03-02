package vogella

class CommentController {

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
