package src.Presenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import src.Model.Human.Gender;
import src.Model.Human.Human;
import src.Model.Service.Service;
import src.View.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) throws SecurityException, IOException {
        this.view = view;
        service = new Service();
    }

    public Gender setGender(String gender) {
        Gender genMale = Gender.Male;
        Gender genFemale = Gender.Female;
        if (gender == "male") {
            return genMale;
        }
        if (gender == "female") {
            return genFemale;
        }
        return null;
    }

    public Human addHuman(String name, LocalDate dateofbirth, String gender) {
        Gender gen = setGender(gender);
        Human human = service.addToTreeShort(name, dateofbirth, gen);
        return human;
    }

    public void createTree() {
        service.createTree();
    }

    public void getInfo() {
        String info = service.printTreeInfo();
        view.printMessage(info);
    }

    public Human findMember(String name) {
        Human member = service.getMember(name);
        return member;
    }

    public void getMember(String name) {
        Human member = service.getMember(name);
        view.printMessage(member.toString());
    }

    public void addParentOrChild(String childName, String parentName) {
        if (service.getMember(childName) == null) {
            service.addToTreeShort(childName, null, null);
        }
        if (service.getMember(parentName) == null) {
            service.addToTreeShort(parentName, null, null);
        }
        Human child = service.getMember(childName);
        Human parent = service.getMember(parentName);
        service.addParentOrChild(child, parent);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByBirthday() {
        service.sortByBirthday();
    }

    public void sortByChildren() {
        service.sortByChildren();
    }

    public void load() throws ClassNotFoundException, IOException {
        service.load();
    }

    public void save() throws FileNotFoundException, IOException {
        service.save();
    }
}
