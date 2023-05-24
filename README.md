# Wstęp do testowania w Javie

Hej! Cwiczenia z tego repozytorium pozwolą Ci w prosty i szybki sposób wejsc w swiat testów.
Będziemy omawaiac ich dwa rodzaje - unit i integration testy, ale jesli chciałbys dowiedziec sie
więcej o testowaniu nowoczesnych aplikacji, na końcu readme znajdziesz podlinkowane dodatkowe
źródła.

## Jak korzystac z tego repozytorium?

Najpierw zbuduj projekt wpisując w konsoli `mvn clean install` ;)

Repozytorium jest rozbite na 2 podprojekty - jeden w katalogu `intro`, a drugi w `src`.
Projekt w `intro` ma za pokazac Ci podstawy, a w `src` znajdziesz projekt, który należy otestowac

Poniżej znajdziesz listę kroków - powinienes po prostu za nią podążac.

## Kroki

(kliknij, żeby przeniesc się do pliku)

1. [Tu](intro/test/java/com/rainer/pawel/intro/_1_/IntroTest.java) dowiesz się czym są testy
2. [Tu](intro/test/java/com/rainer/pawel/intro/_2_/__1__/ArrayListTest.java) dowiesz się czym są unit testy
    - [Tu](intro/test/java/com/rainer/pawel/intro/_2_/__2__/ArrayList_Improved_Test.java) znajdziesz poprawione testy z tego kroku
3. [Tu](intro/test/java/com/rainer/pawel/intro/_3_/IntUtilsTest.java) napiszesz unit testy klasy `IntUtils`
4. [Tu](intro/test/java/com/rainer/pawel/intro/_4_/CalculatorTest.java) napiszesz implementację kalkulatora, która przejdzie napisane wczesniej testy
5. [Tu](intro/test/java/com/rainer/pawel/intro/_5_/__1__/StringSplittingRepositoryTest.java) znajdziesz bardziej skomplikowane unit testy
6. [Tu](intro/test/java/com/rainer/pawel/intro/_5_/__2__/StringFileWriterTest.java) znajdziesz testy w których skorzystasz z tymczasowych plików
7. [Tu](intro/test/java/com/rainer/pawel/intro/_5_/__3__/StringSplittingRepositoryIntegrationTest.java) dowiesz się czym są testy integracyjne

Teraz masz już podstawową wiedzę na temat testów i możesz przejsc do projektu (katalog `src`)
Możesz najpierw pobawic się aplikacją i zobaczyc jak działa ;) - jej zadaniem jest przechowywanie informacji o zwierzętach

**Twoim zadaniem jest:**

W katalogu `src/test` napisac unit testy klas:

- `AnimalService`
- `Name`
- `PriceRange`
- `Price`
- `AnimalDeserializer`
- `AnimalSerializer`

W katalogu `src/integration-test` napisac unit testy klas:

- `FileUtils`
- `AnimalFileRepository`

Gotowe testy - do porównania z Twoimi - znajdziesz w katalogu `src/solution`

## Do poczytania

Biblioteki do testowania:
- [JUnit](https://www.baeldung.com/junit-5)
- [Mockito](https://www.baeldung.com/mockito-series)

Metodologie wytwarzania oprogramowania:
- [Test Driven Development (TDD, cos takiego robilimy w kroku 4)](https://en.wikipedia.org/wiki/Test-driven_development)
- [Architektura nowoczesnych aplikacji w "pigułce" (testy też tam są ;)](https://github.com/piotrsoltysiak/todo-list-clean-arch)