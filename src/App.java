import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(final String[] args) {
        // Initial unsorted list of people
        final List<Person> people = new ArrayList<>();
        people.add(new Person("Addison", 1));
        people.add(new Person("Joey", 2));
        people.add(new Person("Rory", 1));
        people.add(new Person("Ryan", 60));
        people.add(new Person("Royce", 4));
        people.add(new Person("Leslie", 50));

        // Sort the list of people and print it
        System.out.println("Sorted people: " + quicksort(people));
    }

    private static List<Person> quicksort(final List<Person> people) {
        // Return if the input list is empty or only has 1 entry, since it's already sorted
        if (people.size() <= 1) {
            return people;
        }

        // Pick a pivot
        final Person chosenItem = people.get(people.size() / 2);

        // Partition items in three sets (younger, sameAge and older)
        final List<Person> younger = new ArrayList<>();
        final List<Person> sameAge = new ArrayList<>();
        final List<Person> older = new ArrayList<>();
        for (final Person i : people) {
            if (i.getAge() < chosenItem.getAge()) {
                younger.add(i);
            } else if (i.getAge() > chosenItem.getAge()) {
                older.add(i);
            } else {
                sameAge.add(i);
            }
        }

        // Combine results and return
        final List<Person> sortedPeople = new ArrayList<>();
        sortedPeople.addAll(quicksort(younger)); // Recursive call
        sortedPeople.addAll(sameAge);
        sortedPeople.addAll(quicksort(older)); // Recursive call
        return sortedPeople;
    }
}
