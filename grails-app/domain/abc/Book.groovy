package abc

class Book {

    String title

    static belongsTo = [person: Person]

    static constraints = {
        title(blank:false,maxSize: 20)
    }

    String toString(){
    "$title"
    }
}
