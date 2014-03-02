package abc

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(GuttenbergService)
@Mock([Person,Book])
class GuttenbergServiceSpec extends Specification {

    def "when creating thesis a new book is created"() {

    when:
    personInstance.save()
    service.createThesis(personInstance.id)

    then:
    Book.count() == 1

    where:
    personInstance = new Person(firstname: "Ranjit", lastname: "Sahoo")
  }
  
  def "when creating thesis person is assigned to thesis"() {

    //3. Call the method to test
    when:
    personInstance.save()
    def thesis = service.createThesis(personInstance.id)

    then:
    //4. Make asserts on the result
    thesis != null
    thesis.person.id == personInstance.id

    //1. Create a dummy person instance used for the test. This instance has NO id yet
    where:
    personInstance = new Person(firstname: "Ranjit", lastname: "Sahoo")
  }

  def "when creating guttenberg thesis title is set"() {

    when:
    personInstance.save()
    def thesis = service.createThesis(personInstance.id)

    then:
    thesis != null
    thesis.title == "My copied thesis"

    where:
    personInstance = new Person(firstname: "Ranjit", lastname: "Sahoo")
  }
}