package abc

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Person)
class PersonSpec extends Specification {

    void "find author by firstname and lastname"() {
        setup:
        mockDomain(Person)

        when:
        new Person(firstname: firstname, lastname: lastname).save()
        //Creating an object with firstname and lastname using the below attributes.

        then:
        Person.findByFirstnameAndLastname(firstname, lastname) != null
        //Trying find that an Object or an entry in the data base is made with the below properties.
        //Ideally it should return an Object(Thanks to hibernate)

        where:
        firstname = "Ranjith"
        lastname = "Sahoo"
    }
    
    void "firstname constraints"(){
        setup:
        mockDomain(Person)
        
        when:
        def person = new Person(lastname: "Mahajan")
        person.firstname = firstname
        person.validate()
        
        then:
        person.hasErrors() == !valid //For each of the given test cases below this line will be executed.
        
        /*
            Consider the first example,
            first name is more than 20 characters so it is not valid and hence the valid attribute is defined false.
            when the above code is executed it will have errors and hence checking with the !valid which is true.
        */
        
        where:
        firstname | valid
        "123456789012345678901" | false //Firstname must not have more than 20 characters 
        "12345678901234567890" | true   //valid.
        "" | false //Firstname must not be blank
    }
    
    void "lastname constraints"(){
        setup:
        mockDomain(Person)
        
        when:
        def person = new Person(firstname: "Akshit")
        person.lastname = lastname
        person.validate()
        
        then:
        person.hasErrors() == !valid //For each of the given test cases below this line will be executed.
        
        /*
            Consider the last example,
            last name is null so it is not valid and hence the valid attribute is defined false.
            when the above code is executed it will have errors and hence checking with the !valid which is true.
        */
        
        where:
        lastname | valid
        "123456789012345678901" | false //Lastname must not have more than 20 characters 
        "12345678901234567890" | true   //valid.
        "" | false //Lastname must not be blank
    }
}
