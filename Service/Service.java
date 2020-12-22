package Service;

import Containers.ApartmentsRepository;
import Containers.PeopleRepository;
import Domain.Person;
import Domain.Apartment;
import Validator.ModelValidator;

public class Service {
    private PeopleRepository peopleRepository;
    private ApartmentsRepository apartmentsRepository;
    private ModelValidator modelValidator;

    public Service(PeopleRepository peopleRepository, ApartmentsRepository apartmentsRepository,
            ModelValidator modelValidator) {
        this.peopleRepository = peopleRepository;
        this.apartmentsRepository = apartmentsRepository;
        this.modelValidator = modelValidator;
    }

    public void createPerson(String forename, String surname, int noApartment, String birthdate, String job) {
        Person person = new Person(generatePersonID(), forename, surname, noApartment, birthdate, job);

        this.modelValidator.validate(person);
        this.peopleRepository.create(person);
    }

    public void createApartment(int noApartment, String owner, int noResidents, int surface) {
        Apartment apartment = new Apartment(generateApartmentID(), noApartment, owner, noResidents, surface);

        this.modelValidator.validate(apartment);
        this.apartmentsRepository.create(apartment);
    }

    public Person getPerson(int ID) {
        return this.peopleRepository.get(ID);
    }

    public Apartment getNoApartment(int ID) {
        return this.apartmentsRepository.get(ID);
    }

    public void updatePerson(int ID, String newForename, String newSurname, int newNoApartment, String newBirthdate,
            String newJob) {
        Person person = new Person(ID, newForename, newSurname, newNoApartment, newBirthdate, newJob);

        this.modelValidator.validate(person);
        this.peopleRepository.update(ID, person);
    }

    public void updateApartment(int ID, int newNoApartment, String newOwner, int newNoResidents, int newSurface) {
        Apartment apartment = new Apartment(ID, newNoApartment, newOwner, newNoResidents, newSurface);

        this.modelValidator.validate(apartment);
        this.apartmentsRepository.update(ID, apartment);
    }

    public void deletePerson(int ID) {
        this.peopleRepository.delete(ID);
    }

    public void deleteApartment(int ID) {
        this.apartmentsRepository.delete(ID);
    }

    private int generatePersonID() {
        int ID = 0;
        while (peopleRepository.get(ID) != null) {
            ID++;
        }
        return ID;
    }

    private int generateApartmentID() {
        int ID = 0;
        while (apartmentsRepository.get(ID) != null) {
            ID++;
        }
        return ID;
    }

}
