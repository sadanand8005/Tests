package abc

import grails.transaction.Transactional

@Transactional
class GuttenbergService {

  static transactional = true

  Book createThesis(Long personId) {
    Person personInstance = Person.get(personId)
    Book bookInstance = new Book(title: "My copied thesis", person: personInstance).save()
    log.debug("Created thesis $bookInstance")
    return bookInstance
  }
}
