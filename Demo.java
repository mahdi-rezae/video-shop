import java.util.*;
import static java.lang.System.exit;


class demo {

    /**
     * To show the menu in the console,
     * a function "{@link package.demo#printMenu(String[])}" is <br> defined
     * that asks the user for the desired option
     * and communicates with the options
     * in <br> the "{@link package.demo#main(String[])}" function.
     **/

    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    /**
     * In the "{@link package.demo#main(String[])}" function,
     * the options are defined and <br> when user enter the option,
     * scanner give this option in console
     * and use it in <br> the while loop.
     * switch case choose witch case run the method
     * toward options <br> that give from console with scanner
     **/

    public static void main(String[] args) {
        String[] options = {
                "1- Add User (Customer)",
                "2- Add Customer & Movie (VRS Manager)",
                "3- Add Movie (VRS Manager)",
                "4- Search",
                "5- Exit"
        };

        Scanner scanner = new Scanner(System.in);
        int option = 1;

        while (true){
            printMenu(options);

            option = scanner.nextInt();
            switch (option) {
                case 1 : Customer.customer();
                        break;
                case 2 : vrsManager.vrs_manager();
                        break;
                case 3 : Film.film();
                        break;
                case 4 : Search.search();
                        break;
                case 5 : exit(0);
            }
        }
    }
}


class Search {

    /**
     * In the "{@link package.Search#search()}" function,
     * several values have been added to the list.<br>
     * When user wrote something in the console,
     * scanner give it and contains method check<br>
     * if it is in the list or not.
     * In condition state show the message to user.
     **/

    public static void search() {

        List<String> movieList = new ArrayList<>();
        movieList.add("red notice");
        movieList.add("venom");

        Scanner movieInput = new Scanner(System.in);

        System.out.println("Enter your movie name :");
        String movieOutput = movieInput.next();


        if (movieList.contains(movieOutput)) {
            System.out.println("The movie you searched is available!\n");
        } else {
            System.out.println("The movie you searched is NOT available!\n");
        }


        List<String> customerList = new ArrayList<>();
        customerList.add("mohammad");
        customerList.add("sadegh");

        Scanner customerInput = new Scanner(System.in);

        System.out.println("Enter your name :");
        String customerOutput = customerInput.next();


        if (customerList.contains(customerOutput)) {
            System.out.println("The Name you searched is in the list!\n");
        } else {
            System.out.println("The Name you searched is NOT in the list!\n");
        }
    }
}


class Human {

    /**
     * In this class several variables
     * are defined in String type <br>
     * and protected to only use them
     * in this package but in <br> different classes
     * with super method.
     * the constructor <br> and setter & getter methods
     * are defined for each variables.
     **/

    protected String firstName;
    protected String lastName;
    protected String ID;
    protected String phoneNumber;

    public Human(String firstName, String lastName, String ID, String phoneNumber) {
        setFirstname(firstName);
        setLastname(lastName);
        setPhonenumber(phoneNumber);
        setID(ID);
    }

    /**
     * In the "{@link package.Human#valideName(String)}" and <br> "{@link package.Human#validePhonenumber(String)}" function, <br>
     * check the user name and phone number with regex. <br>
     * And in the setter method show the message to user <br>
     * if the name or phone number is true or not.
     **/

    public static boolean valideName(String name) {
        if (name != null)
            return name.matches("[a-zA-Z]+");
        return false;
    }

    private static boolean validePhonenumber(String phonenumber) {
        return phonenumber.matches("^[0-9]{10}$");
    }


    public void setFirstname(String firstName) {
        if (valideName(firstName)) {
            this.firstName = firstName;
        } else {
            System.out.println(" Your First Name is incorrect!!!\n ## PLEASE CHECK YOUR FIRST NAME ## \n");
        }
    }
    public String getFirstname() {
        return firstName;
    }


    public void setLastname(String lastName) {
        if (valideName(lastName)) {
            this.lastName = lastName;
        } else {
            System.out.println(" Your Last Name is incorrect!!!\n ## PLEASE CHECK YOUR LAST NAME ## \n");
        }
    }
    public String getLastname() {
        return lastName;
    }


    /**
     * In the "{@link package.Human#setID(String)}" function, <br>
     * check the user ID and show the message to user <br> if it is not correct.
     **/


    public void setID(String ID) {
        if (ID.length() != 10) {
            System.out.println(" Your ID is incorrect!!!\n ## PLEASE CHECK YOUR ID ## \n ** ID SHOULD BE 10 DIGITS ** \n");
        } else {
            this.ID = ID;
        }
    }
    public String getID() {
        return ID;
    }


    public void setPhonenumber(String phoneNumber) {
        if (validePhonenumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println(" Your Phone Number is incorrect!!!\n ## PLEASE CHECK YOUR PHONE NUMBER ## \n ** PHONE NUMBER SHOULD BE 10 DIGITS WITHOUT '0' ** \n");
        }
    }
    public String getPhonenumber() {
        return phoneNumber;
    }
}



class Customer extends Human {

    /**
     * This class is extended Human class
     * and with super method <br>
     * use the parent variables.
     **/

    public Customer(String firstName, String lastName, String ID, String phoneNumber) {
        super(firstName, lastName, ID, phoneNumber);
    }

    /**
     * With "{@link package.Customer#toString()}" function <br>
     * create suitable message and
     * in <br> "{@link package.Customer#customer()}" function <br>
     * print it in console.
     **/

    public String toString() {
        return String.format
                ("New User : %s %s | %s | %s \n",
                        firstName, lastName, ID, phoneNumber);
    }

    public static void customer() {
        Customer user = new Customer("Ali", "Ahmadi", "1283741566", "9369369364");
        System.out.println(user);
    }
}



class vrsManager extends Human {

    /**
     * This class is extended Human class
     * and with super method <br>
     * use the parent variables.
     **/

    public vrsManager(
            String firstName, String lastName, String ID, String phoneNumber
    ) {
        super(firstName, lastName, ID, phoneNumber);
    }

    /**
     * With "{@link package.vrsManager#toString()}" function <br>
     * create suitable message and
     * in <br> "{@link package.vrsManager#vrs_manager()}" function <br>
     * print it in console.
     **/

    public String toString() {
        return String.format
                ("New Customer : %s %s | %s | %s \n",
                        firstName, lastName, ID, phoneNumber);
    }

    public static void vrs_manager() {
        vrsManager customer = new vrsManager("Mahdi", "Rezaei", "1273741544", "9367576504");
        System.out.println(customer);

        Film movie = new Film("Inception", "Leonardo DiCaprio", "Cillian Murphy", "Tom Hardy",
                    "Emma Thomas", "Christopher Nolan", 2010, 5);
        movie.setStatus(Status.Rented);
        movie.setGenre(Genre.Sci_Fi);
        System.out.println(movie);
    }
}



enum Status {
    Added_To_List, Rented, Purchased
}

enum Genre {
    Drama, Action, Sci_Fi, War, Crime, Romance, Horror, Adventure, Comedy, Animation
}

class Film {

    /**
     * In this class several variables
     * are defined in String and <br> int type
     * and protected to only use them
     * in this package <br> but in different classes.
     * the constructor and <br> setter & getter methods
     * are defined for each variables.
     **/

    protected Status status;
    protected Genre genre;
    protected String movieName;
    protected String firstActor;
    protected String secondActor;
    protected String thirdActor;
    protected int imdb;
    protected String producer;
    protected String director;
    protected int productionYear;


    public Film(String movieName, String firstActor, String secondActor, String thirdActor, String producer,
                String director, int productionYear, int imdb) {
        setMoviename(movieName);
        setFirstactor(firstActor);
        setSecondactor(secondActor);
        setThirdactor(thirdActor);
        setProducer(producer);
        setDirector(director);
        setProductionyear(productionYear);
        setIMDB(imdb);
    }

    /**
     * In the "{@link package.Film#valideName(String)}" function, <br>
     * check the movie, actor, producer and actor name <br> with regex.
     * And in the setter method show <br> the message to user
     * if the name or phone number <br> is true or not.
     **/

    public static boolean valideName(String name) {
        if (name != null)
            return name.matches("^[a-zA-Z ]*$");
        return false;
    }

    /**
     * In these function,
     * check the movie info and <br> show the message to user if it is not correct.
     **/

    public void setMoviename(String movieName) {
        if (valideName(movieName)) {
            this.movieName = movieName;
        } else {
            System.out.println(" The Movie Name is incorrect!!!\n ## PLEASE CHECK THE MOVIE NAME ## \n");
        }
    }

    public String getMoviename() {
        return movieName;
    }


    public void setFirstactor(String Firstactor) {
        if (valideName(Firstactor)) {
            this.firstActor = Firstactor;
        } else {
            System.out.println(" The Actor Name is incorrect!!!\n ## PLEASE CHECK THE ACTOR NAME ## \n");
        }
    }
    public String getFirstactor() {
        return firstActor;
    }


    public void setSecondactor(String Secondactor) {
        if (valideName(Secondactor)) {
            this.secondActor = Secondactor;
        } else {
            System.out.println(" The Actor Name is incorrect!!!\n ## PLEASE CHECK THE ACTOR NAME ## \n");
        }
    }
    public String getSecondactor() {
        return secondActor;
    }


    public void setThirdactor(String Thirdactor) {
        if (valideName(Thirdactor)) {
            this.thirdActor = Thirdactor;
        } else {
            System.out.println(" The Actor Name is incorrect!!!\n ## PLEASE CHECK THE ACTOR NAME ## \n");
        }
    }
    public String getThirdactor() {
        return thirdActor;
    }


    public void setProducer(String Producer) {
        if (valideName(Producer)) {
            this.producer = Producer;
        } else {
            System.out.println(" The Producer Name is incorrect!!!\n ## PLEASE CHECK THE PRODUCER NAME ## \n");
        }
    }
    public String getProducer() {
        return producer;
    }


    public void setDirector(String Director) {
        if (valideName(Director)) {
            this.director = Director;
        } else {
            System.out.println(" The Director Name is incorrect!!!\n ## PLEASE CHECK THE DIRECTOR NAME ## \n");
        }
    }
    public String getDirector() {
        return director;
    }

    /**
     * In the "{@link package.Film#setProductionyear(int)}" function, <br>
     * check the movie production year and show the <br> message to user if it is not correct.
     **/

    public void setProductionyear(int ProductionYear) {
        if (ProductionYear < 1900 || ProductionYear > 2022) {
            System.out.println(" The Production Year is incorrect!!!\n ## PLEASE CHECK THE IMDB SCORE ## \n ** IMDB SCORE SHOULD BE BETWEEN '0 & 10' ** \n");
        } else {
            this.productionYear = ProductionYear;
        }
    }
    public int getProductionyear() {
        return productionYear;
    }

    /**
     * In the "{@link package.Film#setIMDB(int)}" function, <br>
     * check the movie imdb score and show the <br> message to user if it is not correct.
     **/

    public void setIMDB(int imdb) {
        if (imdb < 0 || imdb > 10) {
            System.out.println(" The IMDB score is incorrect!!!\n ## PLEASE CHECK THE IMDB SCORE ## \n ** IMDB SCORE SHOULD BE BETWEEN '0 & 10' ** \n");
        } else {
            this.imdb = imdb;
        }
    }

    public int getIMDB() {
        return imdb;
    }

    /**
     * These setter & getter method are <br>
     * use for enum to put several options <br> for
     * user to choose.
     **/

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }


    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    /**
     * With "{@link package.Film#toString()}" function <br>
     * create suitable message and
     * in <br> "{@link package.Film#film()}" function <br>
     * print it in console.
     **/

    public String toString() {
        return String.format
                ("New Movie : Name: %s | Production Year: %d | Genre: %s | IMDB: %d | Actors: %s - %s - %s | Producer & Director: %s & %s => %s!\n"
                        , movieName, productionYear, genre, imdb, firstActor, secondActor, thirdActor, producer, director, status);
    }

    public static void film() {
        Film movie = new Film("Hotel Transylvania Transformania", "Adam Sandler", "Selena Gomez", "Andy Samberg",
                "Alice Dewey", "Jennifer Kluska", 2022, 6);
        movie.setStatus(Status.Added_To_List);
        movie.setGenre(Genre.Animation);
        System.out.println(movie);
    }
}






// sources that I search in for coding menu:
// stackoverflow.com
// geekforgeeks.org