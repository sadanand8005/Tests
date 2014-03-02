package abc

import spock.lang.*
import grails.test.spock.IntegrationSpec

class GuttenbergSpec extends IntegrationSpec {

  def guttenbergService

  def "Create thesis for first author in DB"() {

    when:
    def thesis = guttenbergService.createThesis(personId)

    then:
    thesis != null
    Book.countByPerson(person) == 1

    where:
    //personId = 1L
    personInstance = new Person(firstname: "Ranjit", lastname: "Sahoo").save()
    person = Person.findById(personInstance.id)
    personId = person.id
  }
}
