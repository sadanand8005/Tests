package abc

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
class BookSpec extends Specification {

    def "find book by title"() {
          setup:
          mockDomain(Book)
          mockDomain(Person)

          when:
          new Book(title: title,person:new Person(firstname:"Ranjith",lastname:"Sahoo").save()).save()
          //Create a book with following and Properties and check whether that book has been saved to the database or not.

          then:
          Book.findByTitle(title) != null

          where:
           title = "Killer IE"
   }
   
    def "title not longer than 20 characters"() {
          setup:
          mockForConstraintsTests(Book)
          mockDomain(Person)

          when:
          def book = new Book(title: title,person:new Person(firstname:"Ranjith",lastname:"Sahoo").save())
          book.validate()
          //Create a book with following and Properties and check whether that book has been saved to the database or not.

          then:
          book.errors.hasFieldErrors("title")

          where:
           title = "Mywipro World wipro's own Nightmare"
   }
   
    def "title not blank"() {
          setup:
          mockForConstraintsTests(Book)
          mockDomain(Person)

          when:
          def book =new Book(title:title, person:new Person(firstname:"Akshit",lastname:"Mahajan").save())
          book.validate()

          then:
          book.errors.hasFieldErrors("title")

          where:
          title=""
   }

  def "author not blank"() {
          setup:
          mockForConstraintsTests(Book)
          mockDomain(Person)

          when:
          def book =new Book(title:"Sharepoint", person:null)
          book.validate()

          then:
          book.errors.hasFieldErrors("person")

   }

}
