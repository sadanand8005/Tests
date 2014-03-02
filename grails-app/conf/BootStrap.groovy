//import vogella.*

//This class is used to add some default data into the data base.
//In other words this class will be executed every time the application is started/restarted.

class BootStrap {

   /* def init = { servletContext ->
        User user = new User(name:'lars', email:'muster@muster.com', webpage:'http://www.vogella.com')
        User otherUser = new User(name:'jim', email:'jim@muster.com', webpage:'http://www.vogella.com')
        if (!user.save()){
            log.error "Could not save user!!"
            log.error "${user.errors}"
        }
        if (!otherUser.save()){
            log.error "Could not save otherUser!!"
        }


  
        Feedback feedback = new Feedback(title:'First feedback', feedback:'This is my first feedback', user:user)
        feedback.save()

        Comment comment = new Comment(comment:'Hello, my name is Jim', user:otherUser)
        comment.feedback = feedback
        comment.save(); 

    }
    def destroy = {
    }*/
    
    //Uncomment the above lines only for first time running of the app.
    //So that it will create the entries in the data base only for the first time.
    
    def init = { servletContext ->
    }
    def destroy = {
    }
}
